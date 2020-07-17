import { Injectable } from '@angular/core';
import { ResourceService } from 'src/app/services/resource.service';
import { HttpClient } from '@angular/common/http';
import { Item } from '../models/Item';

@Injectable({
  providedIn: 'root'
})
export class ItemService extends ResourceService<Item>{

  constructor(private http: HttpClient) {
    super(http, '/api/classes');
  }

}
