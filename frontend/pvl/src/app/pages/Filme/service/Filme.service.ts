import { Injectable } from '@angular/core';
import { ResourceService } from 'src/app/services/resource.service';
import { HttpClient } from '@angular/common/http';
import { Filme } from '../models/Filme';

@Injectable({
  providedIn: 'root'
})
export class FilmeService extends ResourceService<Filme>{

  constructor(private http: HttpClient) {
    super(http, '/api/Filmes');
  }

}
