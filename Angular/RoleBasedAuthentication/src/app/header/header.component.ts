import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { UserAuthService } from '../services/user-auth.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent implements OnInit {
  constructor(
    private userAuthService: UserAuthService,
    private router: Router,
    public userService: UserService
  ) {}

  ngOnInit(): void {}

  public isLoggedIn() {
    return this.userAuthService.isLoggedIn();
  }

  public logout() {
    Swal.fire({
      title:'Are you sure to logout your Account ?',
      width: '500px',
      showCancelButton:true,
      confirmButtonColor:'#3085d6 ',
      confirmButtonText:'Yes',
      cancelButtonText:'No',
      cancelButtonColor:'#d33',
      color:'darkblue',
      timer:50000,
    }) 
    this.userAuthService.clear();
    this.router.navigate(['/home']);
  }
  public toHome(){
    this.router.navigate(['/home']);
  }
  public navToAdmin(){
    this.router.navigate(['/admindashboard']);
  }
  public navToBooks(){
    this.router.navigate(['/books']);
  }
  public sign(){
    console.log("hi");
  }

}