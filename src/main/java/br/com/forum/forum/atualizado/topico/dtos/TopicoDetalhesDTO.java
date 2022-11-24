package br.com.forum.forum.atualizado.topico.dtos;

import br.com.forum.forum.atualizado.resposta.RespostaDTO;
import br.com.forum.forum.atualizado.statusTopico.StatusTopico;
import br.com.forum.forum.atualizado.topico.TopicoEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TopicoDetalhesDTO {
    private Long id;

    private String title;
    private String message;
    private LocalDateTime creationDate = LocalDateTime.now();
    private String nameUser;
    private StatusTopico statusTopico;
    private List<RespostaDTO> respostaDTOS;

    public TopicoDetalhesDTO() { }

    public TopicoDetalhesDTO(TopicoEntity topicoEntity) {
        this.id = topicoEntity.getId();
        this.title = topicoEntity.getTitle();
        this.message = topicoEntity.getMessage();
        this.creationDate = topicoEntity.getCreationDate();
        this.nameUser = topicoEntity.getUsuarioEntity().getName();
        this.statusTopico = topicoEntity.getStatusTopico();
        this.respostaDTOS = new ArrayList<>();
//        transforma de resposta para respostaDTO
        this.respostaDTOS.addAll(topicoEntity.getRespostaEntityList().stream().map(RespostaDTO::new).collect(Collectors.toList()));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public StatusTopico getStatusTopico() {
        return statusTopico;
    }

    public void setStatusTopico(StatusTopico statusTopico) {
        this.statusTopico = statusTopico;
    }

    public List<RespostaDTO> getRespostaDTOS() {
        return respostaDTOS;
    }

    public void setRespostaDTOS(List<RespostaDTO> respostaDTOS) {
        this.respostaDTOS = respostaDTOS;
    }
}
