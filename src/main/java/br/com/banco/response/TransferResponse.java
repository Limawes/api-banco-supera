package br.com.banco.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransferResponse {
    private Long id;
    private String numeroConta;
    private LocalDate dataTransferencia;
    private BigDecimal valor;
    private String operador;
}
