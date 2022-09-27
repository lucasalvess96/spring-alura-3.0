package br.com.forum.forum.atualizado.resposta;

import br.com.forum.forum.atualizado.topico.TopicoEntity;
import br.com.forum.forum.atualizado.usuario.UsuarioEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RespostaEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private String category;
    private LocalDateTime creationDate = LocalDateTime.now();
    private boolean solution;

    @ManyToOne
    @JoinColumn(name = "topico_entity_id")
    private TopicoEntity topicoEntity;

    @ManyToOne
    @JoinColumn(name = "usuario_entity_id")
    private UsuarioEntity usuarioEntity;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isSolution() {
        return solution;
    }

    public void setSolution(boolean solution) {
        this.solution = solution;
    }

    public TopicoEntity getTopicoEntity() {
        return topicoEntity;
    }

    public void setTopicoEntity(TopicoEntity topicoEntity) {
        this.topicoEntity = topicoEntity;
    }

    public UsuarioEntity getUsuarioEntity() {
        return usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }
}
