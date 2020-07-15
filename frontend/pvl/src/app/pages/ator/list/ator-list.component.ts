import { Ator } from './../models/ator';
import { Component, OnInit, ViewChild } from '@angular/core';
import { AlertService } from 'src/app/components/alert/alert.service';
import { AtorService } from '../service/ator.service';
import { ConfirmationService, Table } from 'primeng';
import { LoadingService } from 'src/app/components/loading/loading.service';
import { AtorComponent } from '../form/ator.component';

@Component({
  selector: 'app-ator-list',
  templateUrl: './ator-list.component.html',
  styleUrls: ['./ator-list.component.css']
})
export class AtorListComponent implements OnInit {

  @ViewChild('DialogCadastrar') dialogAtor: AtorComponent;

  @ViewChild('dt') table: Table;

  atores: Ator;
  atorSecionado: Ator;
  
  constructor(
    private alertService: AlertService,
    public atorService: AtorService,
    public confirmation: ConfirmationService,
    public loadingService: LoadingService,
  ) { }


  ngOnInit() {
  }
  
  listarAtores() {
    this.atorService.index().subscribe(
      (response) => {
        this.atores = response;
        this.loadingService.deactivate();
      },
      () => {
        this.loadingService.deactivate();
        this.alertService.montarAlerta('error', 'Erro', 'Erro ao listar as Atores');
      }
    );
  }

  excluir(id: number): void {
    this.loadingService.activate();
    this.atorService
      .destroy(id)
      .subscribe(
        () => {
          this.loadingService.deactivate();
          this.alertService.montarAlerta('success', 'Sucesso', 'Ator excluida com sucesso');
          this.listarAtores();
        },
        () => {
          this.loadingService.deactivate();
          this.alertService.montarAlerta('error', 'Erro', 'Erro ao excluir Ator');
        }
      );
    this.atorSecionado = null;
  }

  confirmarExclusao(id: number) {
    this.confirmation.confirm({
      message: 'Deseja realmente excluir?',
      header: 'Excluir Ator',
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
