import {Component, inject, OnInit} from '@angular/core';
import {Category} from '../../models/category';
import {CategoryService} from '../../services/category.service';
import {AsyncPipe} from '@angular/common';

@Component({
  selector: 'app-categories',
  imports: [
    AsyncPipe
  ],
  templateUrl: './categories.component.html',
  styleUrl: './categories.component.css'
})
export class CategoriesComponent {

  private categoryService = inject(CategoryService);
  categories$ = this.categoryService.getCategories();

}
