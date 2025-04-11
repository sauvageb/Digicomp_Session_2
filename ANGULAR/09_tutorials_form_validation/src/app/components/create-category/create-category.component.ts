import {Component, inject} from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {CategoryService} from '../../services/category.service';
import {CreateCategory} from '../../models/create-category';
import {Router} from '@angular/router';
import {NgClass} from '@angular/common';

@Component({
  selector: 'app-create-category',
  imports: [
    ReactiveFormsModule,
    NgClass
  ],
  templateUrl: './create-category.component.html',
  standalone: true,
  styleUrl: './create-category.component.css'
})
export class CreateCategoryComponent {

  categoryForm: FormGroup = inject(FormBuilder).group(
    {
      categoryName: ['', [Validators.required, Validators.minLength(2)]]
    }
  );
  private categoryService = inject(CategoryService);
  private router = inject(Router);

  get f() {
    return this.categoryForm.controls;
  }

  onCreate() {
    if (this.categoryForm.valid) {

      const newCategory: CreateCategory = {
        name: this.categoryForm.value.categoryName
      };

      this.categoryService.createCategory(newCategory).subscribe(ok => {
        this.router.navigate(["/categories"]);
      });
    }
  }
}
