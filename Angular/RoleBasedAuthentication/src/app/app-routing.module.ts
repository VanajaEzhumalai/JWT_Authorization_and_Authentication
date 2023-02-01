import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { UserComponent } from './user/user.component';
import { AuthGuard } from './auth/auth.guard';
import { RolesComponent } from './roles/roles.component';
import { BooksComponent } from './books/books.component';
import { AdminDashboardComponent } from './dashboard/admin-dashboard/admin-dashboard.component';
import { SignupComponent } from './signup/signup.component';
import { BookDashboardComponent } from './dashboard/book-dashboard/book-dashboard.component';
import { NEVER } from 'rxjs';
import { NewUserComponent } from './new-user/new-user.component';
import { EditBookComponent } from './edit-book/edit-book.component';
import { ViewBookComponent } from './view-book/view-book.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: '', component: HomeComponent },
  { path: 'admin', component: AdminComponent, canActivate:[AuthGuard], data:{roles:['Admin']} },
  { path: 'user', component: UserComponent ,  canActivate:[AuthGuard], data:{roles:['User']} },
  { path: 'login', component: LoginComponent },
  { path: 'forbidden', component: ForbiddenComponent },
  { path: 'role', component: RolesComponent, canActivate: [AuthGuard],data:{roles:["Admin"]}},
  { path: 'book', component: BooksComponent, canActivate: [AuthGuard],data:{roles:["Admin"]}},
  { path: 'books', component: BookDashboardComponent},
  { path: 'bookedit/:book', component:EditBookComponent, canActivate: [AuthGuard],data:{roles:["Admin"]}},
  { path: 'signup', component: SignupComponent },
  { path: 'admindashboard', component: AdminDashboardComponent },
  {path:'newuser',component:NewUserComponent},
  {path:'viewBookDeatails/:id',component:ViewBookComponent},
  {path: '**', component: ForbiddenComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}