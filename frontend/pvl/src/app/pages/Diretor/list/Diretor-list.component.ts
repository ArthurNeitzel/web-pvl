import { Diretor } from './../models/Diretor';
import { Component, OnInit, ViewChild } from '@angular/core';
import { AlertService } from 'src/app/components/alert/alert.service';
import { DiretorService } from '../service/Diretor.service';
import { ConfirmationService, Table } from 'primeng';
import { LoadingService } from 'src/app/components/loading/loading.service';
import { DiretorComponent } from '../form/Diretor.component';

@Component({
  selector: 'app-Diretor-list',
  templateUrl: './Diretor-list.component.html',
  styleUrls: ['./Diretor-list.component.css']
})
export class DiretorListComponent implements OnInit {

  @ViewChild('DialogCadastrar') dialogDiretor: DiretorComponent;

  @ViewChild('dt') table: Table;

  Diretores: Diretor;
  DiretorSecionado: Diretor;
  
  constructor(
    private alertService: AlertService,
    public DiretorService: DiretorService,
    public confirmation: ConfirmationService,
    public loadingService: LoadingService,
  ) { }


  ngOnInit() {
  }
  
  listarDiretores() {
    this.DiretorService.index().subscribe(
      (response) => {
        this.Diretores = response;
        this.loadingService.deactivate();
      },
      () => {
        this.loadingService.deactivate();
        this.alertService.montarAlerta('error', 'Erro', 'Erro ao listar as Diretores');
      }
    );
  }

  excluir(id: number): void {
    this.loadingService.activate();
    this.DiretorService
      .destroy(id)
      .subscribe(
        () => {
          this.loadingService.deactivate();
          this.alertService.montarAlerta('success', 'Sucesso', 'Diretor excluido com sucesso');
          this.listarDiretores();
        },
        () => {
          this.loadingService.deactivate();
          this.alertService.montarAlerta('error', 'Erro', 'Erro ao excluir Diretor');
        }
      );
    this.DiretorSecionado = null;
  }

  confirmarExclusao(id: number) {
    this.confirmation.confirm({
      message: 'Deseja realmente excluir?',
      header: 'Excluir Diretor',
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
