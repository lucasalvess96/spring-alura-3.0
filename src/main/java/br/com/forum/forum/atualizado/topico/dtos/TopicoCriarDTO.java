package br.com.forum.forum.atualizado.topico.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;

import br.com.forum.forum.atualizado.topico.TopicoEntity;
import org.hibernate.validator.constraints.Length;

public class TopicoCriarDTO {

    @NotNull @NotEmpty @Length(min = 5)
    private String title;

    @NotNull @NotEmpty @Length(min = 10)
    private String message;

    private String courseName;

    private String usuarioName;

    public TopicoCriarDTO() { }

    public TopicoCriarDTO(TopicoEntity topicoEntity) {
        this.title = topicoEntity.getTitle();
        this.message = topicoEntity.getMessage();
        this.courseName = topicoEntity.getCursoEntity().getName();
        this.usuarioName = topicoEntity.getUsuarioEntity().getName();
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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getUsuarioName() {
        return usuarioName;
    }

    public void setUsuarioName(String usuarioName) {
        this.usuarioName = usuarioName;
    }
}
