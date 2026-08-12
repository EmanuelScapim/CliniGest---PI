package io.github.projetopi.pi.controller.dto;

import org.springframework.http.HttpStatus;

import java.util.List;

public record RespostaDeErroDTO(int status, String mensagem, List<CampoDeErroDTO> erros) {

    public static RespostaDeErroDTO respostaPadrao(String mensagem){
        return new RespostaDeErroDTO(HttpStatus.BAD_REQUEST.value(), mensagem, List.of());
    }

    public static RespostaDeErroDTO conflito(String mensagem){
        return new RespostaDeErroDTO(HttpStatus.CONFLICT.value(), mensagem, List.of());
    }
}
