package com.nttdata.local.service;

import com.nttdata.local.clienteDto.ClienteResultDto;

public interface ClienteService {

	public ClienteResultDto buscarCliente(String tipoDoc, Long numeroDoc);
}
