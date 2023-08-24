package com.nttdata.local.clienteDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CatalogoDto {

	private Long id;
	private String tipoDocumento;
	private String nombre;
}
