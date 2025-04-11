import {Component, Input} from '@angular/core';
import {NgClass, UpperCasePipe} from '@angular/common';
import {Comment} from '../../models/comment';

@Component({
  selector: 'app-comments',
  imports: [
    UpperCasePipe,
    NgClass
  ],
  templateUrl: './comments.component.html',
  styleUrl: './comments.component.css'
})
export class CommentsComponent {

  @Input() parentEntityId!: string;
  @Input() comments: Comment[] = [];

}
