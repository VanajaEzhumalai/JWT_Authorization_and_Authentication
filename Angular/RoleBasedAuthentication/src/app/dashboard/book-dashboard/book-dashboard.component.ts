import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { BookService } from 'src/app/services/book.service';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-book-dashboard',
  templateUrl: './book-dashboard.component.html',
  styleUrls: ['./book-dashboard.component.css']
})
export class BookDashboardComponent implements OnInit {

  searchText:any;
  booksList:any;

  constructor(private bookService: BookService, private router:Router,public userService:UserService) { }
  
  ngOnInit(): void {
    this.bookService.findAll().subscribe(data =>{
      this.booksList=data;
      console.log(this.booksList);
    },error=>{
      console.log(error.message);
  });
}

sendRequest(id:any,books:any){
 books.bookAvailable=books.bookAvailable-1;
 console.log(books);
 this.bookService.updateBook(id,books).subscribe(data =>{
  this.bookService.findAll().subscribe(res =>{
    this.booksList=res;
    Swal.fire({
      position:'top',
      title:'Congradulations..:) Your request has been send to our EV Library',
      width: '500px',
      color:'darkblue',
      timer:50000,
      confirmButtonColor:'darkblue',
      confirmButtonText:'OK'
    })
  })
 })
}
editBook(product:any){
  console.log(product);
  this.router.navigate(['/bookedit',product]);
}

  deleteBook(id:any){
    console.log(id);
    Swal.fire({
      title:'Are you sure to delete this Book ?',
      width: '500px',
      showCancelButton:true,
      confirmButtonColor:'#3085d6 ',
      confirmButtonText:'Yes',
      cancelButtonText:'No',
      cancelButtonColor:'#d33',
      color:'darkblue',
      timer:50000,
    }) 
        this.bookService.deleteBook(id).subscribe(data =>{
          console.log("deleted successfully.");
          this.ngOnInit();
          
        }, error=>{console.log("Can not delete it.");
        this.ngOnInit();})
        
      }
viewBook(id:number){
        console.log("Details are shown as per id");
        this.router.navigate(['/viewBookDeatails',id]);
        
      }
  }
