import { Injectable } from '@angular/core';
import { ResourceService } from 'src/app/services/resource.service';
import { HttpClient } from '@angular/common/http';
import { Diretor } from '../models/Diretor';

@Injectable({
  providedIn: 'root'
})
export class DiretorService extends ResourceService<Diretor>{

  constructor(private http: HttpClient) {
    super(http, '/api/Diretores');
  }

}
