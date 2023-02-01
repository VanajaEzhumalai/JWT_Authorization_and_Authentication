import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { BookService } from '../services/book.service';
import { Books } from './books';


@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit{
  book:object[]|any;
  constructor(private bookService:BookService,private router:Router) { }

  errorStatus:any;
  errorDescription:any;

  ngOnInit(): void {
  }

  onsubmit(BookForm:NgForm){
    BookForm.value.user=null;
    console.log(BookForm);
    if (
      BookForm.value.bookName === '' ||
      BookForm.value.bookRate === '' ||
      BookForm.value.bookAvailable === '' ||
      BookForm.value.bookImage===''
    ) {
      this.errorStatus = true;
      this.errorDescription = 'Please enter data fully.';
    } else {
      console.log(BookForm.value);
      this.bookService.newBook(BookForm.value).subscribe(
        (data) => {
          Swal.fire({
            position: 'top',
            width: '700px',
            icon: 'success',
            color:'darkblue',
            iconColor: 'darkblue',
            html:
            BookForm.value.bookName +
              '<br>' +
              'Added Successfully!!!',
            showConfirmButton: false,
            timer: 2150,
          }) 
           this.router.navigate(['/books']);
        },
        (error) => alert('Something went worng')
      );
    }
  }

  // // book(productForm:NgForm){
  // //   if(productForm.value.bookName === "" && productForm.value.bookRate === "" && productForm.value.bookAvailable === ""){
  // //     this.errorStatus=true;
  // //     this.errorDescription="Please enter data fully!";
  // //   }else if(productForm.value.bookName === ""){
  // //     this.errorStatus=true;
  // //     this.errorDescription="Book name can not be null.";
  // //   }else if(productForm.value.bookRate === ""){
  // //     this.errorStatus=true;
  // //     this.errorDescription="Book  rate can not be null.";
  // //   }else if(productForm.value.bookAvailable === ""){
  // //     this.errorStatus=true;
  // //     this.errorDescription="Book name can not be null.";
  // //   }else{
  // //     productForm.value.user=null;
  // //     this.bookService.newBook(productForm.value).subscribe(date =>
  // //       {
  // //         console.log("product Added");
  // //       }, error => {
  // //         this.errorStatus=true;
  // //         this.errorDescription="Something went wrong. Try again later...";
  // //       });
  // //     this.router.navigate(['/admin']);
  // //   }
  // // }
  // saveEmployee(BookForm:NgForm){
  //   this.bookService.newBook(this.book).subscribe( data =>{
  //     console.log(data);
  //     Swal.fire({
  //       position: 'top',
  //       width: '700px',
  //       icon: 'success',
  //       html:
  //         BookForm.value.bookName +
  //         '<br>' +
  //         'Added Successfully!!!',
  //       showConfirmButton: false,
  //       timer: 2150,
  //     }) 
  //     this.goToBookList();
  //   },
  //   (error) => alert('Something went worng')
  // );
  // }

  // goToBookList(){
  //   this.router.navigate(['/books']);
  // }
  
  // onsubmit(BookForm : NgForm){
  //   console.log(this.book);
  //   this.saveEmployee(BookForm);
  // }

}

 
