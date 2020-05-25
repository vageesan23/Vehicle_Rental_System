import { TryComponent } from './try/try.component';
import { LogInComponent } from './log-in/log-in.component';
import { ViewListComponent } from './view-list/view-list.component';
import { BookBikeComponent } from './book-bike/book-bike.component';
import { BookCarComponent } from './book-car/book-car.component';
import { HomeComponent } from './home/home.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {path:'home',component:HomeComponent},
  {path:'bookcar',component:BookCarComponent},
  {path:'bookbike',component:BookBikeComponent},
  {path:'viewlist',component:ViewListComponent},
  {path:'login',component:LogInComponent},
  {path:'try',component:TryComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
  