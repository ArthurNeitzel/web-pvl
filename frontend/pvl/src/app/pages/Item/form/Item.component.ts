import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Item } from '../models/Item';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AlertService } from 'src/app/components/alert/alert.service';
import { LoadingService } from 'src/app/components/loading/loading.service';
import { ItemService } from '../service/item.service';

@Component({
  selector: 'app-item-form',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {
  @Output() alterar = new EventEmitter();

  public exibir: boolean;
  public header: string = "Cadastrar Item";
  public item: Item;
  public formItem: FormGroup;

  constructor(
    private alertService: AlertService,
    private formBuilder: FormBuilder,
    public loadingService: LoadingService,
    public itemService: ItemService
  ) { }

  ngOnInit() {
    this.exibir = false;
    this.header = '';
    this.item = new Item();
    this.construirForm();
  }

  construirForm() {
    this.formItem = this.formBuilder.group({
      id: [null],
      numSerie: [null],
      titulo: [
        null,
        [
          Validators.required,
          Validators.minLength(5),
          Validators.maxLength(40),
        ],
      ],
      dataAquisicao: [null, Validators.required],
      tipo: [
        null,
        [
          Validators.required,
          Validators.minLength(5),
          Validators.maxLength(40),
        ]
      ]});
  }

  salvar() {
    if (!this.formItem.invalid) {
      this.loadingService.activate();
      if (this.item.id) {
        // this.editar(this.item);
      } else {
        this.cadastar(this.item);
      }
    }
  }

  editar(item: Item) {
    this.itemService.update(item).subscribe(
      (response) => {
        this.alertService.montarAlerta('success', 'Sucesso', `Item ${response.id} editado com Sucesso`);
      },
      (error) => {
        this.alertService.montarAlerta('error', 'Erro', 'Erro ao editar Item' + error.defaultMessage);
      },
      () => {
        this.loadingService.deactivate();
        this.alterar.emit(null);
        this.exibir = false;
      }
    );
  }

  cadastar(item: Item) {
    this.itemService.create(item).subscribe(
      (response) => {
        this.alertService.montarAlerta('success', 'Sucesso', `Item ${response.id} cadastrado com Sucesso`);
      },
      (error) => {
        this.alertService.montarAlerta('error', 'Sucesso', 'Erro ao cadastrar Item' + error.defaultMessage);
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
    this.formItem.reset();
  }

}
