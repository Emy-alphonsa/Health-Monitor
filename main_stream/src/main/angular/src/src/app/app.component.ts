import { Component } from '@angular/core';
import { Model } from './model';
import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';
import { HttpClient} from '@angular/common/http';
 
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
 
export class AppComponent  {
 
  models: Model=new Model;                                               /** object of model class is instantiated */
  webSocketEndPoint: string = 'http://localhost:8080/start-streaming';  /** url of websocket end point  */
  startUrl:string="http://localhost:8080/start"                        /** url to start streaming */ 
  stopUrl:string="http://localhost:8080/stop"                         /** url to stop streaming */
  topic: string = "/msg";                                            /** path to subscribe to websocket to get data */
  stompClient: any;                                                 /** to use stomp protocol */
  startFlag:boolean=false;                                         /** used to disable the start streaming button after click and enables it after clicking stop streaming */
  stopFlag:boolean=false;                                         /** used to disable the stop streaming button after click and enables it after clicking start streaming */
  title: any;
 
  ngOnInit(){                                                   /** websocket gets connected while hitting the webSocketEndPoint url */
   this.connect();
  }
 
  ngOnDestroy(){                                              /** websocket gets disconnected while closing the url */
    this.disconnect();
  }
 
  constructor(private httpClient: HttpClient) {  }
 
  connect(){                                                /** connect() is used to connect to websocket using stomp protocol */
    console.log("Initialize WebSocket Connection");
    let ws = new SockJS(this.webSocketEndPoint);
    this.stompClient=Stomp.over(ws);
    const _this = this;
    _this.stompClient.connect({}, function (_frame: any) {
        _this.stompClient.subscribe(_this.topic, function (sdkEvent: any) {
         _this.models=JSON.parse(sdkEvent.body);
        });
    }, this.errorCallBack);
  }
 
  disconnect(){                                                /** disconnect() is used to disconnect the websocket */
    if (this.stompClient != null) {
      this.stompClient.disconnect();
    }
  console.log("Disconnected");
  }
 
  errorCallBack(error: string) {                             /** on error, schedule a reconnection attempt */
    console.log("errorCallBack -> " + error)
    setTimeout(() => {
        this.connect();
    }, 5000);
  }
 
  start(){                                              /** start() is used to get start streaming url and to set startFlag and stopFlag flags */
      this.startFlag=true;
      this.stopFlag=false;
      this.httpClient.get(this.startUrl).subscribe();
  }
 
  stop(){                                             /** stop() is used to get stop streaming url and to set startFlag and stopFlag flags */
      this.stopFlag=true;
      this.startFlag=false;
      this.httpClient.get(this.stopUrl).subscribe();
  }
}
