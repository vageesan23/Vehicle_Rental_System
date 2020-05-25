import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {DataserviceService} from '../app/dataservice.service';
import { HomeComponent } from './home/home.component';
import { BookCarComponent } from './book-car/book-car.component';
import { BookBikeComponent } from './book-bike/book-bike.component';
import { ViewListComponent } from './view-list/view-list.component';
import { LogInComponent } from './log-in/log-in.component';
import { TryComponent } from './try/try.component';
import {ReactiveFormsModule, FormsModule} from'@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    BookCarComponent,
    BookBikeComponent,
    ViewListComponent,
    LogInComponent,
    TryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule 
  ],
  providers: [DataserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { 
  
}
