import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-foo-bar-quix-form',
  templateUrl: './foo-bar-quix-form.component.html'
})
export class FooBarQuixFormComponent implements OnInit {

  convertNumberForm : FormGroup;
  @Output() submitNumberOutput: EventEmitter<any> = new EventEmitter();

  constructor(private _formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.convertNumberForm = this._formBuilder.group({
        convertNumber: [null, Validators.required],
    });
  }

  submitNumber(): void {
    if (this.convertNumberForm.valid) {
      const inputNumber: number = this.convertNumberForm.get('convertNumber').value;
      this.submitNumberOutput.emit(inputNumber);
    } 
  }
}
