import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { AnnouncementCollocation } from "../entity/AnnouncementCollocation";

@Injectable({
  providedIn: 'root'
})
export class FavorisService {

  constructor(private http: HttpClient) { }

  getFavoris(): Observable<AnnouncementCollocation[]> {
    return this.http.get<AnnouncementCollocation[]>('/api/getFavoris')
      .pipe(
        catchError((error) => {
          console.error('Error fetching favoris:', error);
          return throwError(error); // Return an observable error
        })
      );
  }

  addAnnouncementToFavoris(userId: number, annId: number): Observable<any> {
    return this.http.post<any>(`/addAnnoceCollToFAVORIS/${userId}/${annId}`, {});
  }

  removeAnnouncementFromFavoris(userId: number, annId: number): Observable<any> {
    return this.http.delete<any>(`/removeAnnoceCollFromFAVORIS/${userId}/${annId}`);
  }

  updateFavorisStatus(userId: number, annId: number, favoris: boolean): Observable<any> {
    return this.http.put<any>(`/updateFavorisStatus/${userId}/${annId}?favoris=${favoris}`, {});
  }

  removeFavoris(announcementId: number): Observable<any> {
    return this.http.delete(`/api/favoris/${announcementId}`).pipe(
      catchError((error) => {
        console.error('Error removing favoris:', error);
        return throwError(error); // Return an observable error
      })
    );
  }
}
