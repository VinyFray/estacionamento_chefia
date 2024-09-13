package com.estacionamento.chefia.services;

import com.estacionamento.chefia.controller.dtos.CarroDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstacionamentoService {

    private final List<CarroDTO> ESTACIONAMENTO = new ArrayList<>();

    public Optional<CarroDTO> buscarVeiculo(String placa){
        return ESTACIONAMENTO.stream()
                .filter(carroDTO -> carroDTO.getPlaca().equalsIgnoreCase(placa)).findFirst();
    }

    public CarroDTO salvarCarro(String placa){
        Optional<CarroDTO> carroDTOOptional = buscarVeiculo(placa);

        if(carroDTOOptional.isPresent()){
             throw new RuntimeException("Carro já cadastrado");
        }

        CarroDTO carroDTO = new CarroDTO();
        carroDTO.setPlaca(placa);
        carroDTO.setHoraEntrada(LocalDateTime.now());
        ESTACIONAMENTO.add(carroDTO);

        return carroDTO;
    }

    public List<CarroDTO> getESTACIONAMENTO(){
        return ESTACIONAMENTO;
    }
}
