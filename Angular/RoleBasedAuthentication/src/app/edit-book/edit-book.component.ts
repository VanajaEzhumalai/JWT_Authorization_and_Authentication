import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { BookService } from 'src/app/services/book.service';
import { Books } from '../books/books';

@Component({
  selector: 'app-edit-book',
  templateUrl: './edit-book.component.html',
  styleUrls: ['./edit-book.component.css']
})
export class EditBookComponent implements OnInit {
  bookDetail:any=[];
  errorStatus: any;
  errorDescription: any;
  constructor(private routerActivated: ActivatedRoute, private bookService: BookService,private router:Router) {}
  books = this.routerActivated.snapshot.params['book'];

  ngOnInit(): void {
    this.errorStatus=false;
    console.log(this.books);
    this.bookService.getBookByID(this.books).subscribe((data) => {
        this.bookDetail = data;
        console.log(this.bookDetail);
      },(error) => {
        console.log('error');
      });
  }

  BookNew(UpdateBookForm:NgForm){
    console.log(UpdateBookForm.value);
    this.bookService.newBook(this.bookDetail).subscribe((data)=>{
      console.log(data);
    });
    this.router.navigate(['/books']);

  }
  

}