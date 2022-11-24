package br.com.forum.forum.atualizado.resposta;

import java.time.LocalDateTime;

public class RespostaDTO {
    private Long id;

    private String message;
    private LocalDateTime creationDate = LocalDateTime.now();
    private String nameUser;

    public RespostaDTO() { }

    public RespostaDTO(RespostaEntity respostaEntity) {
        this.id = respostaEntity.getId();
        this.message = respostaEntity.getMessage();
        this.creationDate = respostaEntity.getCreationDate();
        this.nameUser = respostaEntity.getUsuarioEntity().getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
