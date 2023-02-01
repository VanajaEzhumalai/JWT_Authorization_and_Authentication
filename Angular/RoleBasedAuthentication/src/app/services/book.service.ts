import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookService {


  PATH_OF_API = "http://localhost:9090";

  constructor(private httpClient:HttpClient) { }

  public findAll(): Observable<object> { 
    return this.httpClient.get<object[]>(this.PATH_OF_API+"/getAllBooks") }

  public newBook(bookData:any): Observable<object>{
    console.log(bookData);
    return this.httpClient.post(this.PATH_OF_API+"/newBook",bookData);
  }

  public deleteBook(bookId:any):Observable<any>{
    console.log(bookId);
    return this.httpClient.delete(this.PATH_OF_API+"/deleteBook/"+bookId);
  }

  public getBookByID(bookId:any):Observable<any>{
    return this.httpClient.get<object[]>(this.PATH_OF_API+"/getBookById/"+bookId);
  }
  public updateBook(bookId: any,bookData:object):Observable<any>{
    return this.httpClient.put<object[]>(this.PATH_OF_API+"/editBookById/"+bookId,bookData);
  }
  public sendRequest(bookId:any,bookData:object):Observable<any>{
    console.log(bookId);
    return this.httpClient.put<object[]>(this.PATH_OF_API+"/sendRequest/"+bookId,bookData);
  }

}