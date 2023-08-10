package br.com.banco.controller;

import br.com.banco.model.ContaModel;
import br.com.banco.service.TransferenciaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conta")
public class ContaController {

  private final TransferenciaService transferenciaService;

  public ContaController(TransferenciaService transferenciaService) {
    this.transferenciaService = transferenciaService;
  }

  private static final Logger log = LoggerFactory.getLogger(ContaController.class);

  @GetMapping("/id/{id}")
  @ResponseStatus(HttpStatus.OK)
  public List<ContaModel> findByContaId(@PathVariable("id") Long id) {
    log.info("login by conta: {}", id);
    return transferenciaService.findByContaId(id);
  }
}
