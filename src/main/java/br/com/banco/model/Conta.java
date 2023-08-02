package br.com.banco.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Conta")
public class Conta {

    @Id
    @Column(name = "id_conta")
    private Long id_conta;

    @Column(name = "nome_responsavel")
    private String nome_responsavel;
}
