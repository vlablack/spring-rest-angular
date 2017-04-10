import {Injectable} from "@angular/core";
import {Http, Headers} from "@angular/http";
import {Observable} from "rxjs";
import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";


@Injectable()
export class PostService {

  headers = new Headers({
    'Content-Type': 'application/json'
  });

  constructor(private http: Http) {
  }

  sendPostRequest(url: string, data: any): Observable<any> {
    const body = data ? JSON.stringify(data) : {};

    return this.http.post(url, body, {headers: this.headers})
      .map(res => res.json())
      .catch(err => err);
  }

}
