package com.estacionamento.chefia.controller;

import com.estacionamento.chefia.controller.dtos.CarroDTO;
import com.estacionamento.chefia.controller.dtos.PlacaDTO;
import com.estacionamento.chefia.services.EstacionamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/estacionamento")
public class EstacionamentoController {

    @Autowired
    private EstacionamentoService estacionamentoService;

    @GetMapping
    public ResponseEntity<?> exibirEstacionamento(){
        return ResponseEntity.ok(estacionamentoService.getESTACIONAMENTO());
    }

    @PostMapping
    public ResponseEntity<?> cadastrarCarro(@RequestBody @Valid PlacaDTO placa){
        try{
            CarroDTO carroDTO = estacionamentoService.salvarCarro(placa.getPlaca());
            return ResponseEntity.status(201).body(carroDTO);
        }catch (RuntimeException e){
            return ResponseEntity.status(400).body(Map.of("mensagem", e.getMessage()));
        }

    }
}
