import {Pipe, PipeTransform} from '@angular/core';
import {Tutorial} from '../models/tutorial';

@Pipe({
  standalone: true,
  name: 'sortTutorialByDate'
})
export class SortTutorialByDatePipe implements PipeTransform {

  transform(tutorials: Tutorial[], order: string): Tutorial[] {
    if (!tutorials || tutorials.length === 0) return [];

    if (order === 'ASC') {
      return tutorials.sort((t1, t2) => new Date(t1.createdAt).getTime() - new Date(t2.createdAt).getTime());
    } else {
      return tutorials.sort((t1, t2) => new Date(t2.createdAt).getTime() - new Date(t1.createdAt).getTime());
    }
  }

}
