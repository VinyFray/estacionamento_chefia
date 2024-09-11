package com.estacionamento.chefia.controller;

import com.estacionamento.chefia.controller.dtos.CarroDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/estacionamento")
public class EstacionamentoController {

    private final List<CarroDTO> ESTACIONAMENTO = new ArrayList<>();

    @GetMapping
    public ResponseEntity<?> exibirEstacionamento(){
        return ResponseEntity.ok(ESTACIONAMENTO);
    }
}
