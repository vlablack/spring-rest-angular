import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateAuthorsModalFormComponent } from './create-authors-modal-form.component';

describe('CreateAuthorsModalFormComponent', () => {
  let component: CreateAuthorsModalFormComponent;
  let fixture: ComponentFixture<CreateAuthorsModalFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateAuthorsModalFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateAuthorsModalFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
