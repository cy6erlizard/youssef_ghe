import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AnnouncementCollocation} from "../entity/AnnouncementCollocation";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AnnouncementCollocationService {
  readonly Get_Announcement = 'http://localhost:8000/COEXIST/Announce/get_all_AnnoncementCollocations';
  readonly ADD_Announcement = 'http://localhost:8000/COEXIST/Announce/add-AnnoncementCollocation';
  readonly DeleteAnnouncement_Announcement = 'http://localhost:8000/COEXIST/Announce/deleteAnnoncementCollocation/';


  constructor(private httpClient: HttpClient) {
  }
  getAllAnnouncements() {
    return this.httpClient.get<AnnouncementCollocation>(this.Get_Announcement);
  }
  public addAnnouncement(announcementCollocation: AnnouncementCollocation): Observable<AnnouncementCollocation> {
    return this.httpClient.post<AnnouncementCollocation>(this.ADD_Announcement, announcementCollocation);
  }
  public deleteAnnouncement(id: number){
    return this.httpClient.delete(this.DeleteAnnouncement_Announcement+id);
  }
}
