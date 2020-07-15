import { Component, OnInit, ViewChild } from '@angular/core';
import { Table, ConfirmationService } from 'primeng';
import { Classe } from '../models/classe';
import { AlertService } from 'src/app/components/alert/alert.service';
import { ClasseService } from '../service/classe.service';
import { LoadingService } from 'src/app/components/loading/loading.service';
import { ClasseFormComponent } from '../classe-form/classe-form.component';

@Component({
  selector: 'app-classe-list',
  templateUrl: './classe-list.component.html',
  styleUrls: ['./classe-list.component.css']
})
export class ClasseListComponent implements OnInit {

  @ViewChild('DialogCadastrar') dialogClasse: ClasseFormComponent;

  @ViewChild('dt') table: Table;

  classes: Classe;
  classeSecionado: Classe;
  
  constructor(
    private alertService: AlertService,
    public classeService: ClasseService,
    public confirmation: ConfirmationService,
    public loadingService: LoadingService,
  ) { }


  ngOnInit() {
  }
  
  listarClassees() {
    this.classeService.index().subscribe(
      (response) => {
        this.classes = response;
        this.loadingService.deactivate();
      },
      () => {
        this.loadingService.deactivate();
        this.alertService.montarAlerta('error', 'Erro', 'Erro ao listar as Classees');
      }
    );
  }

  excluir(id: number): void {
    this.loadingService.activate();
    this.classeService
      .destroy(id)
      .subscribe(
        () => {
          this.loadingService.deactivate();
          this.alertService.montarAlerta('success', 'Sucesso', 'Classe excluida com sucesso');
          this.listarClassees();
        },
        () => {
          this.loadingService.deactivate();
          this.alertService.montarAlerta('error', 'Erro', 'Erro ao excluir Classe');
        }
      );
    this.classeSecionado = null;
  }

  confirmarExclusao(id: number) {
    this.confirmation.confirm({
      message: 'Deseja realmente excluir?',
      header: 'Excluir Classe',
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
