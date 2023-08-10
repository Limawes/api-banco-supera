package br.com.banco.repository;

import br.com.banco.model.ContaModel;
import br.com.banco.model.TransferenciaModel;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransferenciaRepository extends JpaRepository<TransferenciaModel, Long> {

    List<TransferenciaModel> findAll();

//    List<Transferencia> findByDataTransferenciaBetween(LocalDateTime dataInicio, LocalDateTime dataFim);

    @Query(value = "from TransferenciaModel where data_transferencia between :inicio and :fim")
    List<TransferenciaModel> findByDataTransferenciaBetween(Date inicio, Date fim);

    List<TransferenciaModel> findByNomeOperadorTransacao(String operador);

    List<TransferenciaModel> findAll(Specification<TransferenciaModel> nomeOperadorTransacao);

    @Query(value = "select * from transferencia where conta_id = :id", nativeQuery = true)
    List<TransferenciaModel> findByIdConta(Long id);
}
