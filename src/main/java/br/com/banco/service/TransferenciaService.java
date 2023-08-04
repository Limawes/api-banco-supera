package br.com.banco.service;

import br.com.banco.model.Conta;
import br.com.banco.model.Transferencia;
import br.com.banco.repository.ContaRepository;
import br.com.banco.repository.TransferenciaRepository;
import br.com.banco.request.TransferenciaRequest;
import br.com.banco.response.TransferenciaResponse;
import br.com.banco.util.GeneralUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TransferenciaService {

    private final TransferenciaRepository transferenciaRepository;
    private final ContaRepository contaRepository;

  public TransferenciaService(TransferenciaRepository transferenciaRepository,
                              ContaRepository contaRepository) {
        this.transferenciaRepository = transferenciaRepository;
    this.contaRepository = contaRepository;
  }

    public List<Transferencia> findAll() {
        return transferenciaRepository.findAll();
    }

    public List<Transferencia> findByDataTransferenciaBetween(Date dataInicio, Date dataFim) {
        return transferenciaRepository.findByDataTransferenciaBetween(dataInicio, dataFim);
    }

    public List<Transferencia> findByOperador(TransferenciaResponse transferenciaResponse) {
        return transferenciaRepository.findAll((Specification<Transferencia>)
                (root, query, criteriaBuilder) -> {
                    List<Predicate> predicates = new ArrayList<>();
                    if (!GeneralUtils.isNullOrEmpty(transferenciaResponse.getNomeOperadorTransacao())){
                        predicates.add(criteriaBuilder.and(criteriaBuilder.like(
                                criteriaBuilder.upper(root.get("nomeOperadorTransacao")), "%" +
                                        transferenciaResponse.getNomeOperadorTransacao().toUpperCase() + "%")));
                    }
                    return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
                });
    }

    public List<Conta> findByContaId(Long id){
      return contaRepository.findByContaId(id);
    }
    

}
