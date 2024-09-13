package com.estacionamento.chefia.controller.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PlacaDTO {
    @NotBlank(message = "Numero da placa não pode ser nulo")
    @NotNull(message = "Numero da Placa obrigatório")
    @Size(min = 7, max = 7, message = "Formato da placa invalido")
    private String placa;

    public PlacaDTO() {
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}