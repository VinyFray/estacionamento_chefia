package com.estacionamento.chefia.controller.dtos;

import java.time.LocalDateTime;

public class CarroDTO {
    private String placa;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;

    // Padrão BEAN
    public CarroDTO() {
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalDateTime getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(LocalDateTime horaSaida) {
        this.horaSaida = horaSaida;
    }
}
