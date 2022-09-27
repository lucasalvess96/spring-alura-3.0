package br.com.forum.forum.atualizado.resposta;

import java.time.LocalDateTime;

public class RespostaDTO {
    private String message;
    private LocalDateTime creationDate = LocalDateTime.now();
    private String nameUser;

    public RespostaDTO() { }

    public RespostaDTO(RespostaEntity respostaEntity) {
        this.message = respostaEntity.getMessage();
        this.creationDate = respostaEntity.getCreationDate();
        this.nameUser = respostaEntity.getUsuarioEntity().getName();
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
