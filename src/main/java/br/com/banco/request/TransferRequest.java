package br.com.banco.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class TransferRequest {
    private String numeroConta;
    private LocalDate dataTransferencia;
    private BigDecimal valor;
    private String operador;
}
