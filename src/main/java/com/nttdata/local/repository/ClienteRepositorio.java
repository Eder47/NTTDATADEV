package com.nttdata.local.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nttdata.local.model.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long>{
	@Query("select p from Cliente p where p.numeroDocumento=?1 and p.tipoDoc = ?2 ")
	public Optional<Cliente> getCliente(Long numeroDoc, String tipoDoc);

}
