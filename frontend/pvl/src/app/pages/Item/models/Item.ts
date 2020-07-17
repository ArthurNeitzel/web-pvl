import {Resource} from 'src/app/models/resource.model';

export class Item extends Resource {
    Id: number;
    NumSérie: number;
    Titulo: string;
    DataAquisicao: number;
    Tipo: string;
}