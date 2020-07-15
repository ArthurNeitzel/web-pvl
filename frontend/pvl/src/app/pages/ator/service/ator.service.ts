import { Injectable } from '@angular/core';
import { ResourceService } from 'src/app/services/resource.service';
import { HttpClient } from '@angular/common/http';
import { Ator } from '../models/ator';

@Injectable({
  providedIn: 'root'
})
export class AtorService extends ResourceService<Ator>{

  constructor(private http: HttpClient) {
    super(http, '/api/atores');
  }

}
