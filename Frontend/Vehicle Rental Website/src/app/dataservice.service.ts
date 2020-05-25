import { bikeCustomer } from './book-bike/bikeCustomer';
import { carCustomer } from './book-car/carCustomer';
import { Motorbike } from './Motorbike';
import { Car } from './Car';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const options = {
  headers: new HttpHeaders({ 'content-type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class DataserviceService {
  hello:any;output: JSON;

  constructor(private http:HttpClient) { }
  
  getAllTheCars(): Observable<any>{
    return this.http.get('http://localhost:8080/vehicle');
  }

  getAllTheMotorBikes(){
    return this.http.get<Motorbike[]>('http://localhost:8080/vehicle1')
  }

  createVehicle(customer: carCustomer){
    console.log(customer);
 
    return this.http.post('http://localhost:8080/employh',customer);
  }
  
  createCustomerCar(customer: any){
    console.log(customer);
    return this.http.post('http://localhost:8080/carcustomer',customer);
  }

  createVehicle1(customer: bikeCustomer){
  
    console.log(customer);
    return this.http.post('http://localhost:8080/bikecustomer1',customer);
  }

  createCustomerBike(customer: any){
    console.log(customer);
    return this.http.post('http://localhost:8080/bikecustomer',customer);
  }
}
