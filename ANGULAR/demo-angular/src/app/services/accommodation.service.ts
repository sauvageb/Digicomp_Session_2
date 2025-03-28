import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Accommodation} from '../models/accommodation.model';

@Injectable({
  providedIn: 'root'
})
export class AccommodationService {

  constructor(private httpClient: HttpClient) {
  }

  fetchAll(city?: string): Observable<Accommodation[]> {
    return this.httpClient.get<Accommodation[]>(`http://localhost:8080/api/accommodations?city=${city}`);
  }

}
