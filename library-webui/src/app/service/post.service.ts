import { Injectable } from '@angular/core';
import {Http} from "@angular/http";
import {Observable} from "rxjs";


@Injectable()
export class PostService {

  constructor(private http: Http) {
  }

  sendPostRequest(url: string, data: any): Observable<any> {
    const body = data ? JSON.stringify(data) : {};

    return this.http.post(url, body).map(result => result.json()).catch(error => error);
  }

}
