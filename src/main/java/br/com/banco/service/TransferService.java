package br.com.banco.service;

import br.com.banco.exception.BancoNotFoundException;
import br.com.banco.model.TransferModel;
import br.com.banco.repository.TransferRepository;
import br.com.banco.request.TransferRequest;
import br.com.banco.response.TransferResponse;
import br.com.banco.service.business.message.GeneralBusinessMessages;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TransferService {

    private final TransferRepository transferRepository;

    public TransferService(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

   public TransferModel findById(final Long id) {
        Optional<TransferModel> transferModel = transferRepository.findById(id);
        if (transferModel.isEmpty()){
            throw new BancoNotFoundException(GeneralBusinessMessages.NOT_FOUND.getMessage("transfer"));
        }
        return transferModel.get();
   }

   public TransferResponse findByNumeroConta(final String numeroConta){
        return
   }

}
