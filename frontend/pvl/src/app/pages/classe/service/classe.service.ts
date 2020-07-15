import { Injectable } from '@angular/core';
import { ResourceService } from 'src/app/services/resource.service';
import { HttpClient } from '@angular/common/http';
import { Classe } from '../models/classe';

@Injectable({
  providedIn: 'root'
})
export class ClasseService extends ResourceService<Classe>{

  constructor(private http: HttpClient) {
    super(http, '/api/classes');
  }

}
