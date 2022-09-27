package br.com.forum.forum.atualizado.topico;

import br.com.forum.forum.atualizado.curso.CursoEntity;
import br.com.forum.forum.atualizado.resposta.RespostaEntity;
import br.com.forum.forum.atualizado.statusTopico.StatusTopico;
import br.com.forum.forum.atualizado.usuario.UsuarioEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TopicoEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private LocalDateTime creationDate = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private StatusTopico statusTopico = StatusTopico.NOT_ANSWERED;

    @ManyToOne
    @JoinColumn(name = "usuario_entity_id")
    private UsuarioEntity usuarioEntity;

    @ManyToOne
    @JoinColumn(name = "curso_entity_id")
    private CursoEntity cursoEntity;

    @OneToMany(mappedBy = "topicoEntity")
    private List<RespostaEntity> respostaEntityList = new ArrayList<>();

    public TopicoEntity() { }

    public TopicoEntity(String title, String message, CursoEntity cursoEntity) {
        this.title = title;
        this.message = message;
        this.cursoEntity = cursoEntity;
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

    public StatusTopico getStatusTopico() {
        return statusTopico;
    }

    public void setStatusTopico(StatusTopico statusTopico) {
        this.statusTopico = statusTopico;
    }

    public UsuarioEntity getUsuarioEntity() {
        return usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }

    public CursoEntity getCursoEntity() {
        return cursoEntity;
    }

    public void setCursoEntity(CursoEntity cursoEntity) {
        this.cursoEntity = cursoEntity;
    }

    public List<RespostaEntity> getRespostaEntityList() {
        return respostaEntityList;
    }

    public void setRespostaEntityList(List<RespostaEntity> respostaEntityList) {
        this.respostaEntityList = respostaEntityList;
    }
}
