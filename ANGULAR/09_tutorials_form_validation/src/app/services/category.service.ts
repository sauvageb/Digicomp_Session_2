import {inject, Injectable} from '@angular/core';
import {Category} from '../models/category';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {CreateCategory} from '../models/create-category';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private baseUrl = environment.baseUrl;
  private httpClient = inject(HttpClient);

  getCategories(): Observable<Category[]> {
    return this.httpClient.get<Category[]>(`${this.baseUrl}/api/categories`);
  }

  createCategory(newCategory: CreateCategory): Observable<void> {
    return this.httpClient.post<void>(`${this.baseUrl}/api/categories`, newCategory);
  }
}
