package br.com.api.demo.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.demo.models.ProdutoModelo;
import br.com.api.demo.models.ProdutoRespostaModelo;
import br.com.api.demo.repositorio.ProdutoRepositorio;

@Service

public class ProdutoServico {
    @Autowired

    private ProdutoRepositorio pr;

    @Autowired
    private ProdutoRespostaModelo rm;


    public List<ProdutoModelo> listar(){
        return pr.findAll();
    }

    public ResponseEntity<?> cadastraralterar(ProdutoModelo pm, String acao) {
    if (pm.getNome() == null || pm.getNome().equals("")) {
        rm.setMensagem("O nome do produto é obrigatório");
        return new ResponseEntity<ProdutoRespostaModelo>(rm, HttpStatus.BAD_REQUEST);
    } else if (pm.getMarca() == null || pm.getMarca().equals("")) {
        rm.setMensagem("O nome da marca é obrigatório");
        return new ResponseEntity<ProdutoRespostaModelo>(rm, HttpStatus.BAD_REQUEST);
    } else {
       if(acao.equals("cadastrar")){
         return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.CREATED);
       }else{
          return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.OK);
       }
    }
}

    public ResponseEntity<ProdutoRespostaModelo> remover(long codigo){
        pr.deleteById(codigo);
        rm.setMensagem("produto removido com sucesso");

        return new ResponseEntity<ProdutoRespostaModelo>(rm,HttpStatus.OK);
    }
}
