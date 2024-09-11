package com.estacionamento.chefia.controller;

import com.estacionamento.chefia.controller.dtos.CarroDTO;
import com.estacionamento.chefia.controller.dtos.Placa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/estacionamento")
public class EstacionamentoController {

    private final List<CarroDTO> ESTACIONAMENTO = new ArrayList<>();

    @GetMapping
    public ResponseEntity<?> exibirEstacionamento(){
        return ResponseEntity.ok(ESTACIONAMENTO);
    }

    @PostMapping
    public ResponseEntity<?> cadastrarCarro(@RequestBody Placa placa){
       Optional<CarroDTO> carroDTOOptional = ESTACIONAMENTO.stream()
               .filter(carroDTO -> carroDTO.getPlaca().equalsIgnoreCase(placa.getPlaca())).findFirst();

       if(carroDTOOptional.isPresent()){
           return ResponseEntity.status(400).body(Map.of("mensagem", "Carro já cadastrado"));
       }

       CarroDTO carroDTO = new CarroDTO();
       carroDTO.setPlaca(placa.getPlaca());
       carroDTO.setHoraEntrada(LocalDateTime.now());

       ESTACIONAMENTO.add(carroDTO);
       return ResponseEntity.status(201).body(carroDTO);
    }
}
