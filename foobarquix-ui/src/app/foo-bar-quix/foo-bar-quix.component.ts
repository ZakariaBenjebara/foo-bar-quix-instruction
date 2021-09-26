import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { FooBarQuixService } from '../foo-bar-quix.service';
import { NumberConverted } from '../model/number-converted';

@Component({
  selector: 'app-foo-bar-quix',
  templateUrl: './foo-bar-quix.component.html'
})
export class FooBarQuixComponent implements OnInit, OnDestroy {
  submitNumberSubscriber: Subscription;
  newConvertedNumber : NumberConverted;


  constructor(private fooBarQuixService: FooBarQuixService) { }

  ngOnInit(): void {
  }

  ngOnDestroy(): void {
    if (this.submitNumberSubscriber != null) {
      this.submitNumberSubscriber.unsubscribe()
    }
  }

  convertNumber(numberToConvert: number): void {
    this.submitNumberSubscriber = this.fooBarQuixService.getResult(numberToConvert)
      .subscribe(response =>  {
        const result = response.result
        this.newConvertedNumber = Object.assign( { numberToConvert, result}) as NumberConverted
        console.log('result '+ JSON.stringify(this.newConvertedNumber))
      });
  }
}