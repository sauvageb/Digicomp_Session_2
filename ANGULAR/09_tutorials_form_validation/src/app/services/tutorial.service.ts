import {Injectable} from '@angular/core';
import {Tutorial} from '../models/tutorial';

@Injectable({
  providedIn: 'root'
})
export class TutorialService {

  getTutorials(): Tutorial[] {
    return [
      {
        id: 'e8b9c8f0-56ed-40ff-93e0-c9f74200175b2',
        title: "Afficher une liste avec Material Angular",
        description: "Lorem ipsum dolor sit amet, consectetur adipisicing elit",
        content: "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Alias animi aperiam aspernatur cupiditate deserunt dignissimos dolor doloremque eligendi eos est excepturi expedita ipsam laboriosam laborum laudantium natus omnis quaerat quas, qui quibusdam ratione reiciendis tenetur ullam unde vel velit vitae voluptatum. Illum inventore ipsam odit perferendis ratione. At consequatur, ratione!",
        author: {
          id: 'e7b9c8f0-55ed-40ff-93e0-c9f7427175b2',
          email: "j.doe@tuto.fr",
          firstName: "John",
          lastName: "doe"
        },
        category: {id: 'e7b9c8f0-55ed-40ff-93e0-c9f74200175b2', name: "Angular"},
        createdAt: new Date(2055, 0, 30),
        comments: []
      },
      {
        id: 'e8b9c8f0-56ed-40ff-94e0-c9f74200175b2',
        title: "Initiation au langage Java",
        description: "Lorem ipsum dolor sit amet, consectetur adipisicing elit",
        content: "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Alias animi aperiam aspernatur cupiditate deserunt dignissimos dolor doloremque eligendi eos est excepturi expedita ipsam laboriosam laborum laudantium natus omnis quaerat quas, qui quibusdam ratione reiciendis tenetur ullam unde vel velit vitae voluptatum. Illum inventore ipsam odit perferendis ratione. At consequatur, ratione!",
        author: {
          id: 'e8b9c8f0-55ed-40ff-93e0-c9f74200175b2',
          email: "j.waaaa@tuto.fr",
          firstName: "Jane",
          lastName: "waaaa"
        },
        category: {id: 'e9b9c8f0-55ed-40ff-93e0-c9f74200175b2', name: "Java"},
        createdAt: new Date(2055, 11, 2),
        comments: [
          {
            id: 'e8b9c8f0-56ed-40ff-94e0-c9f74200175b3',
            content: "Super tuto ! Bravo Jane",
            author: {
              id: 'e1b9c8f0-55ed-40ff-93e0-c9f74200175b2',
              email: "j.waaaa@tuto.fr",
              firstName: "Jane",
              lastName: "waaaa"
            }
          },
          {
            id: 'e8b9c8f0-56ed-40ff-94e0-c9f74200175b5',
            content: "Très intéressant, merci pour le partage",
            author: {
              id: 'e2b9c8f0-55ed-40ff-93e0-c9f74200175b2',
              email: "j.doe@tuto.fr",
              firstName: "John",
              lastName: "doe"
            }
          },
        ]
      },
      {
        id: 'e8b9c8f0-56ed-40ff-94e0-c9f74201175b5',
        title: "Initiation au macro VBA",
        description: "Lorem ipsum dolor sit amet, consectetur adipisicing elit",
        content: "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Alias animi aperiam aspernatur cupiditate deserunt dignissimos dolor doloremque eligendi eos est excepturi expedita ipsam laboriosam laborum laudantium natus omnis quaerat quas, qui quibusdam ratione reiciendis tenetur ullam unde vel velit vitae voluptatum. Illum inventore ipsam odit perferendis ratione. At consequatur, ratione!",
        author: {
          id: 'e7b9c1f0-55ed-40ff-93e0-c9f74200175b2',
          email: "b.sau@tuto.fr",
          firstName: "Boris",
          lastName: "Sau"
        },
        category: {id: 'e7b9c1f0-55ed-40ff-93e0-c1f74200175b2', name: "VBA"},
        createdAt: new Date(2055, 8, 16),
        comments: [
          {
            id: 'e9b9c8f0-56ed-40ff-94e0-c9f74201175b5',
            content: "Excel est vraiment génial avec VBA",
            author: {
              id: 'e7b9c1f1-55ed-40ff-93e0-c9f74200175b2',
              email: "j.waaaa@tuto.fr",
              firstName: "Jane",
              lastName: "waaaa"
            }
          },
        ]
      }
    ];
  }
}
