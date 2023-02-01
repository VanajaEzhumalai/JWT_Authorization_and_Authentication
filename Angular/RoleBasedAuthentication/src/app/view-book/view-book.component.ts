import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Books } from '../books/books';
import { BookService } from '../services/book.service';

@Component({
  selector: 'app-view-book',
  templateUrl: './view-book.component.html',
  styleUrls: ['./view-book.component.css']
})
export class ViewBookComponent implements OnInit{
  id: any;
  book:any=[] ;
  constructor(private route: ActivatedRoute, private bookService: BookService) { }

  ngOnInit(): void {
      this.id = this.route.snapshot.params['id'];
      book :undefined;
      this.bookService.getBookByID(this.id).subscribe( data => {
      this.book= data;
    });
  }
}