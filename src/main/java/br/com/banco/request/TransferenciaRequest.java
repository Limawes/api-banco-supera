package br.com.banco.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class TransferenciaRequest {
    private Date dataTransferencia;
    private BigDecimal valor;
    private String tipo;
    private String nomeOperadorTransacao;

    public Date getDataTransferencia() {
        return dataTransferencia;
    }

    public void setDataTransferencia(Date dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNomeOperadorTransacao() {
        return nomeOperadorTransacao;
    }

    public void setNomeOperadorTransacao(String nomeOperadorTransacao) {
        this.nomeOperadorTransacao = nomeOperadorTransacao;
    }
}
