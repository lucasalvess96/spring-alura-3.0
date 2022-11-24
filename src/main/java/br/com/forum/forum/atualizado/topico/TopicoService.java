package br.com.forum.forum.atualizado.topico;

import br.com.forum.forum.atualizado.curso.CursoEntity;
import br.com.forum.forum.atualizado.curso.CursoRepository;
import br.com.forum.forum.atualizado.topico.dtos.TopicoAtualizarDTO;
import br.com.forum.forum.atualizado.topico.dtos.TopicoCriarDTO;
import br.com.forum.forum.atualizado.topico.dtos.TopicoDTO;
import br.com.forum.forum.atualizado.topico.dtos.TopicoDetalhesDTO;
import br.com.forum.forum.atualizado.usuario.UsuarioEntity;
import br.com.forum.forum.atualizado.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public TopicoService(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    public Page<TopicoDTO> listAllTopics(Pageable pageable){
        Page<TopicoEntity> topicoEntityPage = topicoRepository.findAll(pageable);
        Page<TopicoDTO> topicoDTOS = topicoEntityPage.map(TopicoDTO::new);

        return topicoDTOS;
    }

    public Optional<TopicoDetalhesDTO> topicDetailsDTO(Long id){
        TopicoEntity topicoEntity = topicoRepository.findById(id).get();

        return Optional.of(new TopicoDetalhesDTO(topicoEntity));
    }

    @Transactional
    public TopicoCriarDTO topicSave(TopicoCriarDTO topicoCriarDTO){
        TopicoEntity topicoEntity = new TopicoEntity();

        String nomeCurso = topicoCriarDTO.getCourseName();
        CursoEntity cursoEntity = cursoRepository.findByName(nomeCurso);

        String nomeUsuario = topicoCriarDTO.getUsuarioName();
        UsuarioEntity usuarioEntity = usuarioRepository.findByName(nomeUsuario);

        topicoEntity.setTitle(topicoCriarDTO.getTitle());
        topicoEntity.setMessage(topicoCriarDTO.getMessage());
        topicoEntity.setCursoEntity(cursoEntity);
        topicoEntity.setUsuarioEntity(usuarioEntity);

        return new TopicoCriarDTO(this.topicoRepository.save(topicoEntity));
    }

    @Transactional
    public TopicoAtualizarDTO topicUpdate(Long id, TopicoAtualizarDTO topicoAtualizarDTO){
        TopicoEntity topicoEntity = this.topicoRepository.findById(id).get();
        if(Objects.nonNull(topicoEntity)){
            topicoEntity.setTitle(topicoAtualizarDTO.getTitle());
            topicoEntity.setMessage(topicoAtualizarDTO.getMessage());

            return new TopicoAtualizarDTO(this.topicoRepository.save(topicoEntity));
        }
        return null;
    }

    @Transactional
    public void topicsDelete(Long id){
        this.topicoRepository.deleteById(id);
    }

}
