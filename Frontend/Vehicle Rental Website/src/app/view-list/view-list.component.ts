import { Motorbike } from './../Motorbike';
import { Car } from './../Car';
import { DataserviceService } from './../dataservice.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-view-list',
  templateUrl: './view-list.component.html',
  styleUrls: ['./view-list.component.scss']
})
export class ViewListComponent implements OnInit {
  allTheCars:Car[];
  allTheMotorbike:Motorbike[];

  constructor(private sevice:DataserviceService) { }

  ngOnInit() {
    this.sevice.getAllTheCars().subscribe(
      res=>{
        console.log(res);
        this.allTheCars = res;
      }
    );
    this.sevice.getAllTheMotorBikes().subscribe(
      res=>{
        console.log(res);
        this.allTheMotorbike = res;
      }
    )
  }

}
