package br.com.api.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.demo.models.ProdutoModelo;


@Repository
public interface ProdutoRepositorio extends JpaRepository <ProdutoModelo,Long > {
    
}
