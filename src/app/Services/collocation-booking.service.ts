import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CollocationBooking} from "../entity/CollocationBooking";

@Injectable({
  providedIn: 'root'
})
export class CollocationBookingService {
  readonly Get_CollocationBooking = 'http://localhost:8000/COEXIST/AnnonceBooking/get_all_CollocationBookings';
  readonly ADD_CollocationBooking = 'http://localhost:8000/COEXIST/AnnonceBooking/add-CollocationBooking';
  readonly DeleteCollocationBooking_CollocationBooking = 'http://localhost:8000/COEXIST/AnnonceBooking/deleteCollocationBooking/';


  constructor(private httpClient: HttpClient) {
  }
  getAllCollocationBookings() {
    return this.httpClient.get<CollocationBooking>(this.Get_CollocationBooking);
  }
  public addCollocationBooking(collocationBooking: CollocationBooking): Observable<CollocationBooking> {
    return this.httpClient.post<CollocationBooking>(this.ADD_CollocationBooking, collocationBooking);
  }
  public deleteCollocationBooking(id: number){
    return this.httpClient.delete(this.DeleteCollocationBooking_CollocationBooking+id);
  }
}
