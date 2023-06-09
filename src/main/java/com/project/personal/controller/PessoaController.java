package com.project.personal.controller;

import com.project.personal.model.Pessoa;
import com.project.personal.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.PostRemove;
import java.util.Optional;

@SuppressWarnings("ALL")
@Controller // Indica que a classe é um controlador
public class PessoaController {

    @Autowired // Indica que a classe deve ser injetada
    private PessoaRepository pessoaRepository;

    ModelAndView modelAndView = new ModelAndView("cadastro/cadastropessoa"); // Indica qual view será retornada

    @GetMapping("/cadastropessoa")
    public ModelAndView inicio() {
        modelAndView.addObject("pessoaobj",new Pessoa()); // Adiciona o objeto pessoa no atributo pessoaobj
        return modelAndView;
    }

    @PostMapping("**/salvarpessoa") // Indica que o método será chamado quando a url for /salvarpessoa e ** ignora qualquer coisa que vier antes
    public ModelAndView salvar(Pessoa pessoa) {
        pessoaRepository.save(pessoa);
        Iterable<Pessoa> pessoasIt = pessoaRepository.findAll(); // Retorna todos os registros da tabela pessoa
        modelAndView.addObject("pessoas", pessoasIt); // Adiciona o objeto pessoasIt no atributo pessoas
        modelAndView.addObject("pessoaobj",new Pessoa()); // Adiciona o objeto pessoa no atributo pessoaobj
        return modelAndView; // Retorna a view como resposta
    }

    @GetMapping("/listarpessoas")
    public ModelAndView listar() {
        Iterable<Pessoa> pessoasIt = pessoaRepository.findAll(); // Retorna todos os registros da tabela pessoa
        modelAndView.addObject("pessoas", pessoasIt); // Adiciona o objeto pessoasIt no atributo pessoas
        modelAndView.addObject(("pessoaobj"), new Pessoa()); // Adiciona o objeto pessoa no atributo pessoaobj
        return modelAndView; // Retorna a view como resposta

    }

    @GetMapping("/editarpessoa/{idpessoa}")
    public ModelAndView editar(@PathVariable("idpessoa") Long idpessoa) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(idpessoa); // Retorna o registro da tabela pessoa que possui o id igual ao idpessoa
        modelAndView.addObject("pessoaobj", pessoa.get()); // Adiciona o objeto pessoa no atributo pessoaobj
        return modelAndView; // Injeta o objeto pessoa no formulário

    }

    @GetMapping("/removerpessoa/{idpessoa}")
    public ModelAndView excluir(@PathVariable("idpessoa") Long idpessoa) {
        pessoaRepository.deleteById(idpessoa); // Deleta o registro da tabela pessoa que possui o id igual ao idpessoa
        modelAndView.addObject("pessoas",pessoaRepository.findAll());
        modelAndView.addObject("pessoaobj", new Pessoa()); // Adiciona o objeto pessoa no atributo pessoaobj
        return modelAndView; // Retorna a view como resposta

    }

    @PostMapping("**/pesquisarpessoa")
    public ModelAndView pesquisar(@RequestParam("pesquisanome") String nomepesquisa){ // @RequestParam("pesquisanome") indica que o parâmetro nomepesquisa será injetado no atributo pesquisanome

        modelAndView.addObject("pessoas", pessoaRepository.findPessoaByName(nomepesquisa));
        modelAndView.addObject("pessoaobj", new Pessoa()); // Adiciona o objeto pessoa no atributo pessoaobj

        return modelAndView;
    }



}
