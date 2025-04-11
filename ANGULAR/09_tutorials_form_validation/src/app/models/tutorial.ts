import {Category} from './category';
import {User} from './user';
import {Comment} from './comment';

export interface Tutorial {
  id: string;
  title: string;
  description: string;
  content: string;
  author: User;
  category: Category;
  createdAt: Date;
  comments: Comment[];
}
