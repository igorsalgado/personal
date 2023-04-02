package com.project.personal.repository;


import com.project.personal.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository // Indica que a classe é um repositório
@Transactional // Indica que a classe é responsável por gerenciar transações
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query("select p from Pessoa p where p.name like %?1%")
        // Indica que a query será executada no banco de dados
        // select p from Pessoa p where p.name like %?1% -> Retorna todos os registros da tabela pessoa que possuem o nome igual ao name/
        // ?1 -> Indica que o primeiro parâmetro do método será passado para a query
    List<Pessoa> findPessoaByName(String name); // Retorna uma lista de pessoas que possuem o nome igual ao name
}
