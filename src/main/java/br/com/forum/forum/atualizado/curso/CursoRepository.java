package br.com.forum.forum.atualizado.curso;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<CursoEntity, Long> {
    CursoEntity findByName(String name);

}
