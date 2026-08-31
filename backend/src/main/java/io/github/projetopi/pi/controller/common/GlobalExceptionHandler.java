package io.github.projetopi.pi.controller.common;


import io.github.projetopi.pi.controller.dto.CampoDeErroDTO;
import io.github.projetopi.pi.controller.dto.RespostaDeErroDTO;
import io.github.projetopi.pi.exceptions.RegistroDuplicadoException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public RespostaDeErroDTO handlerMethodArgumentNotValidException(MethodArgumentNotValidException e){
        List<FieldError> fieldErrors = e.getFieldErrors();

        List<CampoDeErroDTO> campoDeErroDTOList = fieldErrors.stream()
                .map(fe -> new CampoDeErroDTO(fe.getField(), fe.getDefaultMessage()))
                .collect(Collectors.toList());

        return new RespostaDeErroDTO(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Erro de validação", campoDeErroDTOList);
    }

    @ExceptionHandler(RegistroDuplicadoException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public RespostaDeErroDTO handlerRegistroDuplicadoException(RegistroDuplicadoException e){
        return RespostaDeErroDTO.conflito(e.getMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public RespostaDeErroDTO handlerDataIntegrityViolationException(DataIntegrityViolationException e){
        return RespostaDeErroDTO.conflito("Registro em conflito com dados já existentes");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RespostaDeErroDTO handlerIllegalArgumentException(IllegalArgumentException e){
        return RespostaDeErroDTO.respostaPadrao(e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public RespostaDeErroDTO handlerRuntimeException(RuntimeException e){
        return new RespostaDeErroDTO(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Ocorreu um problema inesperado, procure os administradores",
                List.of()
        );
    }
}
