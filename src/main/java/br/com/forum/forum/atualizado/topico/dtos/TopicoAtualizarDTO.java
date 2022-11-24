package br.com.forum.forum.atualizado.topico.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;

import br.com.forum.forum.atualizado.topico.TopicoEntity;
import org.hibernate.validator.constraints.Length;

public class TopicoAtualizarDTO {

    @NotNull @NotEmpty @Length(min = 5)
    private String title;

    @NotNull @NotEmpty @NotEmpty @Length(min = 5)
    private String message;

    public TopicoAtualizarDTO() { }

    public TopicoAtualizarDTO(TopicoEntity topicoEntity) {
        this.title = topicoEntity.getTitle();
        this.message = topicoEntity.getMessage();
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
}
