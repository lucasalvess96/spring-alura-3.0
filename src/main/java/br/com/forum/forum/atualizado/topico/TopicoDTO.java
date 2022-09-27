package br.com.forum.forum.atualizado.topico;

import java.time.LocalDateTime;

public class TopicoDTO {
    private String title;
    private String message;
    private LocalDateTime creationDate;

    public TopicoDTO() { }

    public TopicoDTO(TopicoEntity topicoEntity){
        this.title = topicoEntity.getTitle();
        this.message = topicoEntity.getMessage();
        this.creationDate = topicoEntity.getCreationDate();
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
}
