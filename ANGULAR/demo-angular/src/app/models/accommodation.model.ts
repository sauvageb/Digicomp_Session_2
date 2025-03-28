import {City} from './city.model';

export interface Accommodation {
  id: number;
  title: string;
  description: string;
  address: string;
  price: number;
  rating: number;
  capacity: number;
  pictureUrl: string;
  city: City;
}
