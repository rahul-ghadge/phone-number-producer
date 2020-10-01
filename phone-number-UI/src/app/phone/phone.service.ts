import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};


@Injectable({
  providedIn: 'root'
})
export class PhoneService {

  HOST = 'http://localhost:8080';

  constructor(private http: HttpClient) { }



  saveAndGetNumbers(number, pageNo, size): any {
    return this.http.get<any>(this.HOST + "/number?number=" + number +  "&page=" + pageNo + "&size=" + size);
    // if (resp) {
    //   return this.getByPagination(number, 1, 10);
    // }
    // return "Something wrong happened"
  }


  getByPagination(number, pageNo, size) {
    // http://localhost:8080/phoneNumbers/search/find-by-number?number=989899125&page=5&size=5
    let endpoint = "/phoneNumbers/search/find-by-number?number=" + number
      + "&page=" + pageNo + "&size=" + size;

    return this.http.get<any>(this.HOST + endpoint);
  }


}
