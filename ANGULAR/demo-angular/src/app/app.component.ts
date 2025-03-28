import {Component, inject, OnInit} from '@angular/core';
import {Accommodation} from './models/accommodation.model';
import {AccommodationService} from './services/accommodation.service';
import {HeaderComponent} from './components/header/header.component';

@Component({
  selector: 'app-root',
  imports: [
    HeaderComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {

  accommodations: Accommodation[] = [];

  private accommodationService = inject(AccommodationService);

  ngOnInit(): void {
    this.accommodationService
      .fetchAll()
      .subscribe(data => {
        this.accommodations = data;
      });
  }

  search(e: any) {
    e.preventDefault();
    this.accommodationService
      .fetchAll("Lausanne")
      .subscribe(data => {
        this.accommodations = data;
      });
  }
}
