package br.com.banco.service;

import br.com.banco.model.ContaModel;
import br.com.banco.model.TransferenciaModel;
import br.com.banco.repository.ContaRepository;
import br.com.banco.repository.TransferenciaRepository;
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

    public List<TransferenciaModel> findAll() {
        return transferenciaRepository.findAll();
    }

    public List<TransferenciaModel> findByDataTransferenciaBetween(Date dataInicio, Date dataFim) {
        return transferenciaRepository.findByDataTransferenciaBetween(dataInicio, dataFim);
    }

    public List<TransferenciaModel> findByOperador(TransferenciaResponse transferenciaResponse) {
        return transferenciaRepository.findAll((Specification<TransferenciaModel>)
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

    public List<ContaModel> findByContaId(Long id){
      return contaRepository.findByContaId(id);
    }

    public List<TransferenciaModel> findByIdConta(Long id) {
      return transferenciaRepository.findByIdConta(id);
    }

}
