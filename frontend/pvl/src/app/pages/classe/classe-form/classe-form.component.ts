import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Classe } from '../models/classe';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AlertService } from 'src/app/components/alert/alert.service';
import { LoadingService } from 'src/app/components/loading/loading.service';
import { ClasseService } from '../service/classe.service';

@Component({
  selector: 'app-classe-form',
  templateUrl: './classe-form.component.html',
  styleUrls: ['./classe-form.component.css']
})
export class ClasseFormComponent implements OnInit {
  @Output() alterar = new EventEmitter();

  public exibir: boolean;
  public header: string = "Cadastrar Classe";
  public classe: Classe;
  public formClasse: FormGroup;

  constructor(
    private alertService: AlertService,
    private formBuilder: FormBuilder,
    public loadingService: LoadingService,
    public classeService: ClasseService
  ) { }

  ngOnInit() {
    this.exibir = false;
    this.header = '';
    this.classe = new Classe();
    this.construirForm();
  }

  construirForm() {
    this.formClasse = this.formBuilder.group({
      id: [null],
      nome: [
        null,
        [
          Validators.required,
          Validators.minLength(5),
          Validators.maxLength(40),
        ],
      ],
      valor: [null, Validators.required],
      prazo: [null, Validators.required]
    });
  }

  salvar() {
    if (!this.formClasse.invalid) {
      this.loadingService.activate();
      if (this.classe.id) {
        // this.editar(this.classe);
      } else {
        this.cadastar(this.classe);
      }
    }
  }

  editar(classe: Classe) {
    this.classeService.update(classe).subscribe(
      (response) => {
        this.alertService.montarAlerta('success', 'Sucesso', `Classe ${response.id} editado com Sucesso`);
      },
      (error) => {
        this.alertService.montarAlerta('error', 'Erro', 'Erro ao editar Classe' + error.defaultMessage);
      },
      () => {
        this.loadingService.deactivate();
        this.alterar.emit(null);
        this.exibir = false;
      }
    );
  }

  cadastar(classe: Classe) {
    this.classeService.create(classe).subscribe(
      (response) => {
        this.alertService.montarAlerta('success', 'Sucesso', `Classe ${response.id} cadastrado com Sucesso`);
      },
      (error) => {
        this.alertService.montarAlerta('error', 'Sucesso', 'Erro ao cadastrar Classe' + error.defaultMessage);
      },
      () => {
        this.loadingService.deactivate();
        this.alterar.emit(null);
        this.exibir = false;
      }
    );
  }

  cancelar() {
    this.exibir = false;
    this.formClasse.reset();
  }

}
