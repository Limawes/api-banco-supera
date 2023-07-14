package br.com.banco.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TransferModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name= "numeroConta")
    private String numeroConta;

    @Column(name= "dataTransferencia")
    private LocalDate dataTransferencia;

    @Column(name= "valor")
    private BigDecimal valor;

    @Column(name= "operador")
    private String operador;

}
