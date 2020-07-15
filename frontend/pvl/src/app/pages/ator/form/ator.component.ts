import { AtorService } from './../service/ator.service';
import { Ator } from './../models/ator';
import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AlertService } from 'src/app/components/alert/alert.service';
import { LoadingService } from 'src/app/components/loading/loading.service';

@Component({
  selector: 'app-ator',
  templateUrl: './ator.component.html',
  styleUrls: ['./ator.component.css']
})
export class AtorComponent implements OnInit {

  @Output() alterar = new EventEmitter();

  public exibir: boolean;
  public header: string = "Cadastrar Ator";
  public ator: Ator;
  public formAtor: FormGroup;

  constructor(
    private alertService: AlertService,
    private formBuilder: FormBuilder,
    public loadingService: LoadingService,
    public atorService: AtorService
  ) { }

  ngOnInit() {
    this.exibir = false;
    this.header = '';
    this.ator = new Ator();
    this.construirForm();
  }

  construirForm() {
    this.formAtor = this.formBuilder.group({
      id: [null],
      nome: [
        null,
        [
          Validators.required,
          Validators.minLength(5),
          Validators.maxLength(40),
        ],
      ]
    });
  }

  salvar() {
    if (!this.formAtor.invalid) {
      this.loadingService.activate();
      if (this.ator.id) {
        // this.editar(this.ator);
      } else {
        this.cadastar(this.ator);
      }
    }
  }

  editar(ator: Ator) {
    this.atorService.update(ator).subscribe(
      (response) => {
        this.alertService.montarAlerta('success', 'Sucesso', `Ator ${response.id} editado com Sucesso`);
      },
      (error) => {
        this.alertService.montarAlerta('error', 'Erro', 'Erro ao editar Ator' + error.defaultMessage);
      },
      () => {
        this.loadingService.deactivate();
        this.alterar.emit(null);
        this.exibir = false;
      }
    );
  }

  cadastar(ator: Ator) {
    this.atorService.create(ator).subscribe(
      (response) => {
        this.alertService.montarAlerta('success', 'Sucesso', `Ator ${response.id} cadastrado com Sucesso`);
      },
      (error) => {
        this.alertService.montarAlerta('error', 'Sucesso', 'Erro ao cadastrar Ator' + error.defaultMessage);
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
    this.formAtor.reset();
  }

}
