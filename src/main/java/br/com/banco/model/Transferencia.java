package br.com.banco.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transferencia")
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "data_transferencia")
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataTransferencia;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "nome_operador_transacao")
    private String nomeOperadorTransacao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "conta_id", referencedColumnName = "id_conta")
    private Conta conta_id;

    public String getNomeOperadorTransacao() {
        return nomeOperadorTransacao;
    }

    public void setNomeOperadorTransacao(String nomeOperadorTransacao) {
        this.nomeOperadorTransacao = nomeOperadorTransacao;
    }
}
