package br.com.forum.forum.atualizado.topico;

import br.com.forum.forum.atualizado.curso.CursoEntity;
import br.com.forum.forum.atualizado.curso.CursoRepository;
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

    public TopicoService(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    /**
     * method Get(All)
     * */
    public Page<TopicoDTO> listAllTopics(Pageable pageable){
        Page<TopicoEntity> topicoEntityPage = topicoRepository.findAll(pageable);
        Page<TopicoDTO> topicoDTOS = topicoEntityPage.map(TopicoDTO::new);

        return topicoDTOS;
    }

    /**
     * method Get(ID)
     * */
    public Optional<TopicoDetalhesDTO> topicDetailsDTO(Long id){
        TopicoEntity topicoEntity = topicoRepository.findById(id).get();

        return Optional.of(new TopicoDetalhesDTO(topicoEntity));
    }

    /**
     * method POST
     * */
    @Transactional
    public TopicoCriarDTO topicSave(TopicoCriarDTO topicoCriarDTO){
        TopicoEntity topicoEntity = new TopicoEntity();

        String nomeCurso = topicoCriarDTO.getCourseName();
        CursoEntity cursoEntity = cursoRepository.findByName(nomeCurso);

        topicoEntity.setTitle(topicoCriarDTO.getTitle());
        topicoEntity.setMessage(topicoCriarDTO.getMessage());
        topicoEntity.setCursoEntity(cursoEntity);

        return new TopicoCriarDTO(this.topicoRepository.save(topicoEntity));
    }

    /**
     * method PUT
     * */
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

    /**
     * method DELETE
     * */
    @Transactional
    public void topicsDelete(Long id){
        this.topicoRepository.deleteById(id);
    }

}
