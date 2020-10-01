import { Component, OnInit } from '@angular/core';
import { PhoneService } from './phone.service';

@Component({
  selector: 'app-phone',
  templateUrl: './phone.component.html',
  styleUrls: ['./phone.component.css'],
  providers: [PhoneService]
})
export class PhoneComponent implements OnInit {

  phoneNumers: any = [];
  number: any = "";
  totalNumbers = 0;
  requiredMsg = "";
  config: any;
  pageNo = 1
  size = 15

  constructor(private service: PhoneService) { }

  ngOnInit() { }



  getNumbers() {

    if (this.number.trim().length < 7 || this.number.trim().length > 10) {
      this.requiredMsg = "Minimum 7 and maximum 10 digits accepted";
    } else {
      this.populateData();
    }
  }




  pageChanged(event){
    this.config.currentPage = event;    
    this.pageNo = event;
    console.log("Page no :: " + this.pageNo);
    this.populateData();
  }


  populateData() {
    this.service.saveAndGetNumbers(this.number, this.pageNo, this.size).subscribe(resp => {

      console.log(resp);
      if (resp) {
        this.phoneNumers = resp.numbers;
        this.totalNumbers = resp.count;


        this.config = {
          itemsPerPage: this.size,
          currentPage: this.pageNo,
          totalItems: resp.count
        };


      } else {
        console.log('Error :: ' + resp);
        alert('Error :: ' + resp);
      }
    });
    this.requiredMsg = "";
  }


}
