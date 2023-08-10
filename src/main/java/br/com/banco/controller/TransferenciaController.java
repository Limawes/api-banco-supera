package br.com.banco.controller;

import br.com.banco.model.TransferenciaModel;
import br.com.banco.response.TransferenciaResponse;
import br.com.banco.service.TransferenciaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/transferencias")
public class TransferenciaController {

    private final TransferenciaService transferenciaService;

    public TransferenciaController(TransferenciaService transferenciaService){
        this.transferenciaService = transferenciaService;
    }

    private static final Logger log = LoggerFactory.getLogger(TransferenciaController.class);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TransferenciaModel> findAll(){
        log.info("Get all transfers");
        return transferenciaService.findAll();
    }

    @GetMapping("/inicio/{inicio}/fim/{fim}")
    @ResponseStatus(HttpStatus.OK)
    public List<TransferenciaModel> dataTransferenciaBetween(@PathVariable("inicio") @DateTimeFormat(pattern = "yyyy-MM-dd") Date inicio,
                                                             @PathVariable("fim") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fim){
        log.info("Get transfers by start date and end date");
        return transferenciaService.findByDataTransferenciaBetween(inicio, fim);
    }

    @PostMapping("/operador")
    @ResponseStatus(HttpStatus.OK)
    public List<TransferenciaModel> findByOperador(@RequestBody TransferenciaResponse transferenciaResponse) {
        log.info("get transfers by operator");
        return transferenciaService.findByOperador(transferenciaResponse);
    }

    @GetMapping("/id_conta/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<TransferenciaModel> findByIdConta(@PathVariable("id") Long id) {
        return transferenciaService.findByIdConta(id);
    }
}
