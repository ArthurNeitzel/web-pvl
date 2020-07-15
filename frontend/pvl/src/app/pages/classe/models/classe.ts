import {Resource} from 'src/app/models/resource.model';

export class Classe extends Resource {
    id: number;
    nome: string;
    valor: number;
    prazo: number;
}