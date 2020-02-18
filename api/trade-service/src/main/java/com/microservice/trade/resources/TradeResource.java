package com.microservice.trade.resources;

import com.microservice.trade.domain.dto.TradeDTO;
import com.microservice.trade.services.TradeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/trades")
public class TradeResource {

	@Autowired
	private TradeService service;

	@ApiOperation(value = "Busca Todos os Comercios")
	@GetMapping
	public ResponseEntity<List<TradeDTO>> findAll(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		return ResponseEntity.ok().body(service.findAll());
	}

	@ApiOperation(value = "Busca por um Comercio pelo seu id")
	@GetMapping(value = "/{id}")
	public ResponseEntity<TradeDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findById(id));
	}

	@ApiOperation(value = "insere um novo Comercio")
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody TradeDTO obj) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(service.insert(obj)).toUri();
		return ResponseEntity.created(uri).build();
	}

	@ApiOperation(value = "Atualiza um Comercio")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@Valid @PathVariable Long id, @Valid @RequestBody TradeDTO obj) {
		service.update(obj, id);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Deleta um Comercio")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
