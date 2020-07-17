import { DiretorService } from './../service/Diretor.service';
import { Diretor } from './../models/Diretor';
import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AlertService } from 'src/app/components/alert/alert.service';
import { LoadingService } from 'src/app/components/loading/loading.service';

@Component({
  selector: 'app-Diretor',
  templateUrl: './Diretor.component.html',
  styleUrls: ['./Diretor.component.css']
})
export class DiretorComponent implements OnInit {

  @Output() alterar = new EventEmitter();

  public exibir: boolean;
  public header: string = "Cadastrar Diretor";
  public Diretor: Diretor;
  public formDiretor: FormGroup;

  constructor(
    private alertService: AlertService,
    private formBuilder: FormBuilder,
    public loadingService: LoadingService,
    public DiretorService: DiretorService
  ) { }

  ngOnInit() {
    this.exibir = false;
    this.header = '';
    this.Diretor = new Diretor();
    this.construirForm();
  }

  construirForm() {
    this.formDiretor = this.formBuilder.group({
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
    if (!this.formDiretor.invalid) {
      this.loadingService.activate();
      if (this.Diretor.id) {
        // this.editar(this.Diretor);
      } else {
        this.cadastar(this.Diretor);
      }
    }
  }

  editar(Diretor: Diretor) {
    this.DiretorService.update(Diretor).subscribe(
      (response) => {
        this.alertService.montarAlerta('success', 'Sucesso', `Diretor ${response.id} editado com Sucesso`);
      },
      (error) => {
        this.alertService.montarAlerta('error', 'Erro', 'Erro ao editar Diretor' + error.defaultMessage);
      },
      () => {
        this.loadingService.deactivate();
        this.alterar.emit(null);
        this.exibir = false;
      }
    );
  }

  cadastar(Diretor: Diretor) {
    this.DiretorService.create(Diretor).subscribe(
      (response) => {
        this.alertService.montarAlerta('success', 'Sucesso', `Diretor ${response.id} cadastrado com Sucesso`);
      },
      (error) => {
        this.alertService.montarAlerta('error', 'Sucesso', 'Erro ao cadastrar Diretor' + error.defaultMessage);
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
    this.formDiretor.reset();
  }

}
