package br.com.forum.forum.atualizado.topico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
@CrossOrigin
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    /**
     * method GET(All)
     * */
    @GetMapping
    public ResponseEntity<Page<TopicoDTO>> listTopics(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(topicoService.listAllTopics(pageable));
    }

    /**
     * method GET(ID)
     * */
    @GetMapping("/{id}")
    public ResponseEntity<TopicoDetalhesDTO> topicoDetalhesDTOResponseEntity(@PathVariable Long id){
        Optional<TopicoDetalhesDTO> topicoDetalhesDTO = topicoService.topicDetailsDTO(id);
        if(topicoDetalhesDTO.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(topicoDetalhesDTO.get());
        }

        return ResponseEntity.notFound().build();
    }

    /**
     * method POST
     * */
    @PostMapping
    @Transactional
    public ResponseEntity<TopicoCriarDTO> topicoCriarDTOResponseEntity(@RequestBody @Valid TopicoCriarDTO topicoCriarDTO){
        TopicoCriarDTO criarDTO = topicoService.topicSave(topicoCriarDTO);

        return new ResponseEntity<>(criarDTO, HttpStatus.CREATED);
    }

    /**
     * method PUT
     * */
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicoAtualizarDTO> topicoAtualizarResponseEntity(@PathVariable Long id, @RequestBody @Valid TopicoAtualizarDTO topicoAtualizarDTO){
        TopicoAtualizarDTO atualizar = topicoService.topicUpdate(id, topicoAtualizarDTO);
        if (atualizar == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(atualizar, HttpStatus.OK);
    }

    /**
     * method DELETE
     * */
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicoDTO> topicoDTOResponseEntity(@PathVariable Long id){
        topicoService.topicsDelete(id);
        return ResponseEntity.ok().build();
    }

}
