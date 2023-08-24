package com.nttdata.local.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.local.clienteDto.CatalogoDto;
import com.nttdata.local.clienteDto.ClienteResultDto;
import com.nttdata.local.excepciones.ExcepClienteNoExiste;
import com.nttdata.local.service.ClienteService;
import com.nttdata.local.service.ListarCatService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/clientes")
public class ControllerCliente {
	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	ListarCatService listarCatService;
	
	@GetMapping("/get")
	public ResponseEntity<ClienteResultDto> obtegerCliente(
			@RequestParam(required = false) String tipoDoc,
			@RequestParam(required = false) Long numeroDoc
            )throws ExcepClienteNoExiste{
		HttpHeaders httpHeaders = new HttpHeaders();
		ClienteResultDto infoCliete = clienteService.buscarCliente(tipoDoc, numeroDoc);
        return new ResponseEntity<ClienteResultDto>(infoCliete, httpHeaders, HttpStatus.OK);
	}
	
	@GetMapping("/get/catalogo")
	public List<CatalogoDto> listarCat(){
		return listarCatService.listarCatalogo();
		
	}
	

}
