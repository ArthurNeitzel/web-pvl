import { Component, OnInit, ViewChild } from '@angular/core';
import { Table, ConfirmationService } from 'primeng';
import { Item } from '../models/Item';
import { AlertService } from 'src/app/components/alert/alert.service';
import { ItemService } from '../service/Item.service';
import { LoadingService } from 'src/app/components/loading/loading.service';
import { ItemComponent } from '../form/Item.component';

@Component({
  selector: 'app-classe-list',
  templateUrl: './Item-list.component.html',
  styleUrls: ['./Item-list.component.css']
})
export class ClasseListComponent implements OnInit {

  @ViewChild('DialogCadastrar') dialogItem: ItemComponent;

  @ViewChild('dt') table: Table;

  itens: Item;
  ItemSecionado: Item;
  
  constructor(
    private alertService: AlertService,
    public itemService: ItemService,
    public confirmation: ConfirmationService,
    public loadingService: LoadingService,
  ) { }


  ngOnInit() {
  }
  
  listarItens() {
    this.itemService.index().subscribe(
      (response) => {
        this.itens = response;
        this.loadingService.deactivate();
      },
      () => {
        this.loadingService.deactivate();
        this.alertService.montarAlerta('error', 'Erro', 'Erro ao listar as Itens');
      }
    );
  }

  excluir(id: number): void {
    this.loadingService.activate();
    this.itemService
      .destroy(id)
      .subscribe(
        () => {
          this.loadingService.deactivate();
          this.alertService.montarAlerta('success', 'Sucesso', 'Item excluido com sucesso');
          this.listarItens();
        },
        () => {
          this.loadingService.deactivate();
          this.alertService.montarAlerta('error', 'Erro', 'Erro ao excluir Item');
        }
      );
    this.ItemSecionado = null;
  }

  confirmarExclusao(id: number) {
    this.confirmation.confirm({
      message: 'Deseja realmente excluir?',
      header: 'Excluir Item',
      icon: 'pi pi-question-circle',
      acceptLabel: 'Sim',
      rejectLabel: 'Não',
      acceptButtonStyleClass: 'ui-button-success',
      rejectButtonStyleClass: 'ui-button-warning',
      accept: () => {
        this.excluir(id);
      }
    });
  }
}
