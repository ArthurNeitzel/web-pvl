import { FilmeService } from './../service/Filme.service';
import { Filme } from './../models/Filme';
import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AlertService } from 'src/app/components/alert/alert.service';
import { LoadingService } from 'src/app/components/loading/loading.service';

@Component({
  selector: 'app-Filme',
  templateUrl: './Filme.component.html',
  styleUrls: ['./Filme.component.css']
})
export class FilmeComponent implements OnInit {

  @Output() alterar = new EventEmitter();

  public exibir: boolean;
  public header: string = "Cadastrar Filme";
  public Filme: Filme;
  public formFilme: FormGroup;

  constructor(
    private alertService: AlertService,
    private formBuilder: FormBuilder,
    public loadingService: LoadingService,
    public FilmeService: FilmeService
  ) { }

  ngOnInit() {
    this.exibir = false;
    this.header = '';
    this.Filme = new Filme();
    this.construirForm();
  }

  construirForm() {
    this.formFilme = this.formBuilder.group({
      id: [null],
      Titulo: [
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
    if (!this.formFilme.invalid) {
      this.loadingService.activate();
      if (this.Filme.id) {
        // this.editar(this.Diretor);
      } else {
        this.cadastar(this.Filme);
      }
    }
  }

  editar(Filme: Filme) {
    this.FilmeService.update(Filme).subscribe(
      (response) => {
        this.alertService.montarAlerta('success', 'Sucesso', `Filme ${response.id} editado com Sucesso`);
      },
      (error) => {
        this.alertService.montarAlerta('error', 'Erro', 'Erro ao editar Filme' + error.defaultMessage);
      },
      () => {
        this.loadingService.deactivate();
        this.alterar.emit(null);
        this.exibir = false;
      }
    );
  }

  cadastar(Filme: Filme) {
    this.FilmeService.create(Filme).subscribe(
      (response) => {
        this.alertService.montarAlerta('success', 'Sucesso', `Filme ${response.id} cadastrado com Sucesso`);
      },
      (error) => {
        this.alertService.montarAlerta('error', 'Sucesso', 'Erro ao cadastrar Filme' + error.defaultMessage);
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
    this.formFilme.reset();
  }

}
