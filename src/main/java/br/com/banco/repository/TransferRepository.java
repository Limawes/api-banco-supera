package br.com.banco.repository;

import br.com.banco.model.TransferModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferRepository extends JpaRepository<TransferModel, Long> {

    List<TransferModel> findById();
    List<TransferModel> findAll();

    List<TransferModel> findByNumeroConta(String numeroConta);

    List<TransferModel> findByDataPeriodo(String dataTransferencia);

    List<TransferModel> findByOperador(String operador);

}
