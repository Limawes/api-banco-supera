package br.com.banco.repository;

import br.com.banco.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

  @Query(value = "from Conta where id_conta = :contaId")
  List<Conta> findByContaId(@Param("contaId") Long contaId);
}
