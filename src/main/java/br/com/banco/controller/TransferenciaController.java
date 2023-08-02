package br.com.banco.controller;

import br.com.banco.model.Transferencia;
import br.com.banco.request.TransferenciaRequest;
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
    public List<Transferencia> findAll(){
        log.info("Get all transfers");
        return transferenciaService.findAll();
    }

    @GetMapping("/inicio/{inicio}/fim/{fim}")
    @ResponseStatus(HttpStatus.OK)
    public List<Transferencia> dataTransferenciaBetween(@PathVariable("inicio") @DateTimeFormat(pattern = "yyyy-MM-dd") Date inicio,
                                                        @PathVariable("fim") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fim){
        log.info("Get transfers by start date and end date");
        return transferenciaService.findByDataTransferenciaBetween(inicio, fim);
    }

    @PostMapping("/operador")
    @ResponseStatus(HttpStatus.OK)
    public List<Transferencia> findByOperador(@RequestBody TransferenciaRequest transferencia) {
        log.info("get transfers by operator");
        return transferenciaService.findByOperador(transferencia);
    }
}
