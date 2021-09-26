import { Component, OnInit, OnDestroy, Input } from '@angular/core';
import { NumberConverted } from '../model/number-converted';

@Component({
  selector: 'app-foo-bar-quix-list',
  templateUrl: './foo-bar-quix-list.component.html'
})
export class FooBarQuixListComponent implements OnInit, OnDestroy {

  convertedNumbers : Array<NumberConverted>;

  private _convertedNumberInput: NumberConverted;
  
  constructor() { }

  ngOnInit(): void {
    this.convertedNumbers = [];
  }

  ngOnDestroy(): void {
    this.convertedNumbers = [];
  }

  @Input()
  set convertedNumberInput(val: any) {
    console.log('previous item = ', this._convertedNumberInput);
    console.log('currently selected item=', val);
    this._convertedNumberInput = val;
    this.pushNumber();
  }

  private pushNumber(): void {
    if(this._convertedNumberInput != null) {
      this.convertedNumbers.push(this._convertedNumberInput)
    }
  }
}
