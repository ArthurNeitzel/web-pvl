import { Filme } from '../models/Filme';
import { Component, OnInit, ViewChild } from '@angular/core';
import { AlertService } from 'src/app/components/alert/alert.service';
import { FilmeService } from '../service/Filme.service';
import { ConfirmationService, Table } from 'primeng';
import { LoadingService } from 'src/app/components/loading/loading.service';
import { FilmeComponent } from '../form/Filme.component';

@Component({
  selector: 'app-Filme-list',
  templateUrl: './Filme-list.component.html',
  styleUrls: ['./Filme-list.component.css']
})
export class FilmeListComponent implements OnInit {

  @ViewChild('DialogCadastrar') dialogDiretor: FilmeComponent;

  @ViewChild('dt') table: Table;

  Filmes: Filme;
  FilmeSecionado: Filme;
  
  constructor(
    private alertService: AlertService,
    public FilmeService: FilmeService,
    public confirmation: ConfirmationService,
    public loadingService: LoadingService,
  ) { }


  ngOnInit() {
  }
  
  listarDiretores() {
    this.FilmeService.index().subscribe(
      (response) => {
        this.Filmes = response;
        this.loadingService.deactivate();
      },
      () => {
        this.loadingService.deactivate();
        this.alertService.montarAlerta('error', 'Erro', 'Erro ao listar as Filmes');
      }
    );
  }

  excluir(id: number): void {
    this.loadingService.activate();
    this.FilmeService
      .destroy(id)
      .subscribe(
        () => {
          this.loadingService.deactivate();
          this.alertService.montarAlerta('success', 'Sucesso', 'Filme excluido com sucesso');
          this.listarDiretores();
        },
        () => {
          this.loadingService.deactivate();
          this.alertService.montarAlerta('error', 'Erro', 'Erro ao excluir Filme');
        }
      );
    this.FilmeSecionado = null;
  }

  confirmarExclusao(id: number) {
    this.confirmation.confirm({
      message: 'Deseja realmente excluir?',
      header: 'Excluir Filme',
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
