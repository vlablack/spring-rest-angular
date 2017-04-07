import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateBooksModalFormComponent } from './create-books-modal-form.component';

describe('CreateBooksModalFormComponent', () => {
  let component: CreateBooksModalFormComponent;
  let fixture: ComponentFixture<CreateBooksModalFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateBooksModalFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateBooksModalFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
