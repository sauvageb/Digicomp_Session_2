import {Routes} from '@angular/router';
import {CategoriesComponent} from './components/categories/categories.component';
import {TutorialsComponent} from './components/tutorials/tutorials.component';
import {HomeComponent} from './components/home/home.component';
import {NotFoundComponent} from './components/not-found/not-found.component';
import {CreateCategoryComponent} from './components/create-category/create-category.component';

export const routes: Routes = [
  {path: "home", component: HomeComponent},
  {path: "", redirectTo: "home", pathMatch: "full"},
  {path: "categories", component: CategoriesComponent},
  {path: "categories/add", component: CreateCategoryComponent},
  {path: "tutorials", component: TutorialsComponent},
  {path: "**", component: NotFoundComponent}
];
