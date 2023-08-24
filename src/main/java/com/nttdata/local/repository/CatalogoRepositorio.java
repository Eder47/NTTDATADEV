package com.nttdata.local.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nttdata.local.model.Catalogo;

public interface CatalogoRepositorio extends JpaRepository<Catalogo, Long>{
	
	@Query("select p from Catalogo p where p.tipoDocumento = ?1")
	public Optional<Catalogo> buscarCatalogo(String id);

}
