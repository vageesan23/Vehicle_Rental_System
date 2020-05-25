import { Router } from '@angular/router';
import { DataserviceService } from './../dataservice.service';
import { carCustomer } from './carCustomer';
import { Car } from './../Car';
import { Component, OnInit, ɵConsole } from '@angular/core';

@Component({
  selector: 'app-book-car',
  templateUrl: './book-car.component.html',
  styleUrls: ['./book-car.component.scss']
})
export class BookCarComponent implements OnInit {
  [x: string]: any;
    FullName: String;
    NIC: String;
    ContactNo: String;
    EmailAddress: String;
    NumberPlate: String;
    pickUpDate: Date
    dropDate: Date;
    CarMake: String;
    CarModel: String;
    carCustomer : carCustomer;


customer: carCustomer = new carCustomer(this.FullName,
  this.NIC,
  this.ContactNo,
  this.EmailAddress);
submitted = false;

  constructor(private CarService: DataserviceService,
              private router:Router) { }

  allTheCars:Car[];
  
  ngOnInit() {
    this.CarService.getAllTheCars().subscribe(
      res=>{
        console.log(res);
        this.allTheCars = res;
      }
    );
  }

  newCustomer(data):void{
    this.CarService.createVehicle(data).subscribe( data => {
      alert('Your Booking has Created Successfully!!!');
  });
}
  save(){
    this.CarService.createVehicle(this.customer).subscribe(data => console.log(data), error => console.log(error));
  }

  onsubmit(){
    


      this.newCustomer({
        FullName: this.FullName,
        NIC: this.NIC,
        ContactNo: this.ContactNo,
        EmailAddress: this.EmailAddress,
        NumberPlate: this.NumberPlate,
        pickUpDate: this.pickUpDate,
        dropDate: this.dropDate,
        CarMake: this.CarMake,
        CarModel: this.CarModel,
      });

  }
}

