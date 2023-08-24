package com.nttdata.local.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.nttdata.local.clienteDto.CatalogoDto;
import com.nttdata.local.clienteDto.ClienteResultDto;
import com.nttdata.local.excepciones.ExcepClienteNoExiste;
import com.nttdata.local.model.Catalogo;
import com.nttdata.local.model.Cliente;
import com.nttdata.local.repository.CatalogoRepositorio;
import com.nttdata.local.repository.ClienteRepositorio;
import com.nttdata.local.service.ClienteService;
import com.nttdata.local.service.ListarCatService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClienteServiceImpl implements ClienteService, ListarCatService {

	@Autowired
	ClienteRepositorio clienteRepo;

	@Autowired
	CatalogoRepositorio catalogoRepo;

	@Autowired
	ModelMapper modelMapper;

	@Transactional
	public ClienteResultDto buscarCliente(String tipoDoc, Long numeroDoc) {

		Optional<Cliente> cliente = clienteRepo.getCliente(numeroDoc, tipoDoc);
		log.info("Cliente consultado: "+cliente.get());
		Optional<Catalogo> catalogo = catalogoRepo.buscarCatalogo(tipoDoc);
		
		if (tipoDoc.isEmpty() || numeroDoc == null) {
			log.info("Los parametros son obligatorios, tipoDoc, numeroDoc");
			throw new ExcepClienteNoExiste("400", HttpStatus.BAD_REQUEST, "Los parametros son obligatorios");
		}

		if (!cliente.isPresent()) {
			log.info("El cliente no existe en base de datos");
			throw new ExcepClienteNoExiste("500", HttpStatus.INTERNAL_SERVER_ERROR, "El cliente no existe en base de datos");
		}
		ClienteResultDto response = new ClienteResultDto();
		response.setNumeroDocumento(cliente.get().getNumeroDocumento());
		response.setTipoDoc(catalogo.get().getNombre());
		response.setPrimerNombre(cliente.get().getPrimerNombre());
		response.setSegundoNombre(cliente.get().getSegundoNombre());
		response.setPrimerApellido(cliente.get().getPrimerApellido());
		response.setSegundoApellido(cliente.get().getSegundoApellido());
		response.setTelefono(cliente.get().getTelefono());
		response.setDireccion(cliente.get().getDireccion());
		response.setCiudadResidencia(cliente.get().getCiudadResidencia());
		return response;

	}

	@Transactional
	public List<CatalogoDto> listarCatalogo() {
		return catalogoRepo.findAll().stream().map(obj -> modelMapper.map(obj, CatalogoDto.class))
				.collect(Collectors.toList());

	}

}
