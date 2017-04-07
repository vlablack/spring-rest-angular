import { Component, OnInit } from '@angular/core';
import {AuthorModel} from "../model/author-model";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {PostService} from "../service/post.service";
import {API} from "../global";
import {Http} from "@angular/http";

@Component({
  selector: 'app-create-authors-modal-form',
  templateUrl: './create-authors-modal-form.component.html',
  styleUrls: ['./create-authors-modal-form.component.css']
})
export class CreateAuthorsModalFormComponent implements OnInit {

  authorForm: FormGroup;

  constructor(fb: FormBuilder, private postService: PostService) {
    this.authorForm = fb.group({
      'firstName' : [null, Validators.compose([
        Validators.required,
        Validators.maxLength(50)
      ])],
      'lastName': [null, Validators.compose([
        Validators.required,
        Validators.maxLength(50)
      ])],
    });
  }

  ngOnInit() {
  }

  submitForm(value: any) {
    if (this.authorForm.valid) {
      console.log('Reactive Form Data: ');
      const author: AuthorModel = new AuthorModel(value['firstName'], value['lastName']);
      this.postService.sendPostRequest(API.AUTHORS_INSERT, author).subscribe(data => {
          console.log(data);
        }
      );
    }
  }

  cleanForm() {
    this.authorForm.reset();
  }

}
