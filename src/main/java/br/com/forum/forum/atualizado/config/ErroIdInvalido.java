package br.com.forum.forum.atualizado.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ErroIdInvalido {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErroPadrao> entityNotFound(EntityNotFoundException e, HttpServletRequest httpServerErrorException){
        ErroPadrao standardError = new ErroPadrao();
        standardError.setTimestamp(Instant.now());
        standardError.setStatus(HttpStatus.NOT_FOUND.value());
        standardError.setError("Recurso não encontrado");
        standardError.setMessage(e.getMessage());
        standardError.setPath(httpServerErrorException.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }

}
