import { Injectable, Inject } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { Result } from './model/result';


@Injectable({
  providedIn: 'root',
})
export class FooBarQuixService {
  constructor(private http: HttpClient, @Inject('SERVER_URL') private baseUrl: string) { }

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  // HttpClient API get() method => Fetch employees list
  getResult(inputNumber: number): Observable<Result> {
    return this.http.get<Result>(this.baseUrl + '/foo-bar-quix/' + inputNumber)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )

  }

  // Error handling 
  handleError(error) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // Get client-side error
      errorMessage = error.error.message;
    } else {
      // Get server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    window.alert(errorMessage);
    return throwError(errorMessage);
  }

}
