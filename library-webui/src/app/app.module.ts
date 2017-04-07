import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { CreateBooksModalFormComponent } from './create-books-modal-form/create-books-modal-form.component';
import { CreateAuthorsModalFormComponent } from './create-authors-modal-form/create-authors-modal-form.component';
import {PostService} from "./service/post.service";

@NgModule({
  declarations: [
    AppComponent,
    CreateBooksModalFormComponent,
    CreateAuthorsModalFormComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule
  ],
  providers: [PostService],
  bootstrap: [AppComponent]
})
export class AppModule { }
