import {Component, inject, OnInit} from '@angular/core';
import {Tutorial} from '../../models/tutorial';
import {DatePipe, NgClass, UpperCasePipe} from '@angular/common';
import {SortTutorialByDatePipe} from '../../pipes/sort-tutorial-by-date.pipe';
import {FormsModule} from '@angular/forms';
import {HighlightDirective} from '../../directives/highlight.directive';
import {CommentsComponent} from '../comments/comments.component';
import {TutorialService} from '../../services/tutorial.service';

@Component({
  selector: 'app-tutorials',
  imports: [
    UpperCasePipe,
    DatePipe,
    SortTutorialByDatePipe,
    FormsModule,
    HighlightDirective,
    CommentsComponent
  ],
  templateUrl: './tutorials.component.html',
  styleUrl: './tutorials.component.css'
})
export class TutorialsComponent {

  sortOrder: string = "DESC";
  private tutorialService = inject(TutorialService);

  tutorials: Tutorial[] = this.tutorialService.getTutorials();

}
