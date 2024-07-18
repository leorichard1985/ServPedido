package com.fiap.ServPedido.controller;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.ServPedido.records.PedidoRecords;
import com.fiap.ServPedido.service.interfaces.PedidoService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService service;

	@GetMapping
	public CompletableFuture<ResponseEntity<Object>> ListarPedidos() {

		try {

			List<PedidoRecords> pedidos = service.ListarPedidos();

			if (Objects.isNull(pedidos)) {
				return CompletableFuture.completedFuture(ResponseEntity.noContent().build());
			} else {
				return CompletableFuture.completedFuture(ResponseEntity.ok().body(pedidos));
			}

		} catch (DataIntegrityViolationException e) {

			return CompletableFuture.completedFuture(ResponseEntity.badRequest().body(e));
		}
	}

	@GetMapping("/{idPedido}")
	public CompletableFuture<ResponseEntity<Object>> BuscarPedidoPorId(
			@PathVariable("idPedido") Integer idPedido) {

		try {

			PedidoRecords pedido = service.BuscarPedidoPorId(idPedido);

			if (Objects.isNull(pedido)) {
				return CompletableFuture.completedFuture(ResponseEntity.noContent().build());
			} else {
				return CompletableFuture.completedFuture(ResponseEntity.ok().body(pedido));
			}

		} catch (DataIntegrityViolationException e) {

			return CompletableFuture.completedFuture(ResponseEntity.badRequest().body(e));
		}

	}

	@PostMapping()
	@Transactional
	public CompletableFuture<ResponseEntity<Object>> CriarPedido(@RequestBody PedidoRecords objCriarPedido)
			throws URISyntaxException {

		try {

			PedidoRecords pedido = service.CriarPedido(objCriarPedido);
			
			if (Objects.isNull(pedido)) {
				return CompletableFuture.completedFuture(ResponseEntity.noContent().build());
			} else {
				return CompletableFuture.completedFuture(ResponseEntity.status(HttpStatus.CREATED).body(pedido));
			}

			

		} catch (DataIntegrityViolationException e) {

			return CompletableFuture.completedFuture(ResponseEntity.badRequest().body(e));
		}

	}

	

}
