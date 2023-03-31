package com.project.personal.repository;


import com.project.personal.model.Pessoa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {
}
