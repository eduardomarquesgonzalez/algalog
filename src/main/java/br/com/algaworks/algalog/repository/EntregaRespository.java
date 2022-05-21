package br.com.algaworks.algalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.algaworks.algalog.model.Entrega;

@Repository
public interface EntregaRespository extends JpaRepository<Entrega, Long>{

}
