import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, timeout } from 'rxjs';
import { ColdObservable } from 'rxjs/internal/testing/ColdObservable';
import { UserAuthService } from './user-auth.service';
@Injectable({
  providedIn: 'root',
})
export class UserService {
  PATH_OF_API = 'http://localhost:9090';

  requestHeader = new HttpHeaders({ 'No-Auth': 'True' });
  constructor(
    private httpclient: HttpClient,
    private userAuthService: UserAuthService
  ) {}

  public login(loginData:any) {
    return this.httpclient.post(this.PATH_OF_API + '/authenticate', loginData, {
      headers: this.requestHeader,
    });
  }

  public forUser() {
    return this.httpclient.get(this.PATH_OF_API + '/forUser', {
      responseType: 'text',
    });
  }


  public forAdmin() {
    return this.httpclient.get(this.PATH_OF_API + '/forAdmin', {
      responseType: 'text',
    });
  }
   
   
  public findAllUsers():Observable<object>{
    return this.httpclient.get<object[]>(this.PATH_OF_API+"/getusers")
    .pipe(
      timeout(10000000));
  }
  public signup(signupData:any):Observable<object>{
    console.log(signupData.value);
    return this.httpclient.post(this.PATH_OF_API+"/registerNewUser",signupData);
  }
  
  public roleMatch(allowedRoles:any):boolean{
    let isMatch=false;
    const userRoles:any = this.userAuthService.getRoles();
    if(userRoles !=null){
      for(let i=0;i<userRoles.length;i++){
        for(let j=0;j<allowedRoles.length;j++){
          let text=userRoles;
          const ss=text.split(":");
          const aa=ss[1].split(",");
          if(aa[0].replaceAll("\"","") === allowedRoles[j]){
            isMatch=true;
            return isMatch;
          }else{
            return isMatch;
          }
        }
      }
  } 
  return isMatch;
}
}