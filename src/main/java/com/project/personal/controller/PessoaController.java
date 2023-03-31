package com.project.personal.controller;

import com.project.personal.model.Pessoa;
import com.project.personal.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller // Indica que a classe é um controlador
public class PessoaController {

    @Autowired // Indica que a classe deve ser injetada
    private PessoaRepository pessoaRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/cadastropessoa") // Indica que o método deve ser executado quando a requisição for do tipo GET e o valor for /cadastropessoa
    public String inicio() {
        return "cadastro/cadastropessoa";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/salvarpessoa") // Indica que o método deve ser executado quando a requisição for do tipo POST e o valor for /salvarpessoa
    public ModelAndView salvar(Pessoa pessoa) {
        pessoaRepository.save(pessoa);
        ModelAndView andView = new ModelAndView("cadastro/cadastropessoa"); // Indica que a página a ser carregada é cadastro/cadastropessoa
            Iterable<Pessoa> pessoasIt = pessoaRepository.findAll(); // Retorna todos os registros da tabela pessoa
            andView.addObject("pessoas", pessoasIt); // Adiciona o objeto pessoasIt no atributo pessoas
        return andView; // Retorna a view como resposta
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listarpessoa")
    public ModelAndView pessoas() {
        ModelAndView andView = new ModelAndView("cadastro/cadastropessoa"); // Indica que a página a ser carregada é cadastro/cadastropessoa
        Iterable<Pessoa> pessoasIt = pessoaRepository.findAll(); // Retorna todos os registros da tabela pessoa
        andView.addObject("pessoas", pessoasIt); // Adiciona o objeto pessoasIt no atributo pessoas
        return andView; // Retorna a view como resposta
    }


}
