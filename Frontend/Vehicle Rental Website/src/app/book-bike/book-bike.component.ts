import { Motorbike } from './../Motorbike';
import { DataserviceService } from './../dataservice.service';
import { bikeCustomer } from './bikeCustomer';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-book-bike',
  templateUrl: './book-bike.component.html',
  styleUrls: ['./book-bike.component.scss']
})
export class BookBikeComponent implements OnInit {
  fullName: String;
  NIC: String;
  ContactNo: String;
  EmailAddress: String;
  NumberPlate: String;
  pickUpDate: Date
  dropDate: Date;
  bikeMake: String;
  bikeModel: String;

  customer: bikeCustomer = new bikeCustomer(this.fullName,
    this.NIC,
    this.ContactNo,
    this.EmailAddress,this.NumberPlate,this.pickUpDate,this.dropDate,this.bikeMake,this.bikeModel);
  submitted = false;
  sevice: any;

  constructor(private BikeService: DataserviceService,
              private router:Router) { }

  allTheMotorbike:Motorbike[];  

  ngOnInit() {
    this.BikeService.getAllTheMotorBikes().subscribe(
      res=>{
        console.log(res);
        this.allTheMotorbike = res;
      }
    )
  }

  newCustomer(data):void{
    console.log("jnewCustomer(data)");
    this.BikeService.createVehicle1(data).subscribe( data => {
   alert('Your Booking has Created Successfully!!!');
  });
}

save(){
  this.BikeService.createVehicle1(this.customer).subscribe(data => console.log(data), error => console.log(error));
}

onsubmit(){


  this.newCustomer({
    fullName: this.fullName,
    NIC: this.NIC,
    ContactNo: this.ContactNo,
    EmailAddress: this.EmailAddress,
    NumberPlate: this.NumberPlate,
    pickUpDate: this.pickUpDate,
    dropDate: this.dropDate,
    bikeMake: this.bikeMake,
    bikeModel: this.bikeModel,
  });
}

}
