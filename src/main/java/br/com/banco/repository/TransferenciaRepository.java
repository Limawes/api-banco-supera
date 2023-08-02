package br.com.banco.repository;

import br.com.banco.model.Transferencia;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

    List<Transferencia> findAll();

//    List<Transferencia> findByDataTransferenciaBetween(LocalDateTime dataInicio, LocalDateTime dataFim);

    @Query(value = "from Transferencia where data_transferencia between :inicio and :fim")
    List<Transferencia> findByDataTransferenciaBetween(Date inicio, Date fim);

    List<Transferencia> findByNomeOperadorTransacao(String operador);

    List<Transferencia> findAll(Specification<Transferencia> nomeOperadorTransacao);
}
