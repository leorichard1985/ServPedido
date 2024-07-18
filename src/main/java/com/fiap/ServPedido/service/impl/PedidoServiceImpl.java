package com.fiap.ServPedido.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fiap.ServPedido.integracao.EstoquePedidoProducer;
import com.fiap.ServPedido.integracao.ProdutoReqCompra;
import com.fiap.ServPedido.model.jpaStructure.PedidoJpa;
import com.fiap.ServPedido.records.PedidoRecords;
import com.fiap.ServPedido.repository.PedidoRepository;
import com.fiap.ServPedido.service.interfaces.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {

	private PedidoRepository repository;
	private final EstoquePedidoProducer estoque;

	public PedidoServiceImpl(EstoquePedidoProducer estoque,PedidoRepository repository) {
		this.estoque = estoque;
		this.repository = repository;
	}

	@Override
	public PedidoRecords BuscarPedidoPorId(Integer idPedido) {

		Optional<PedidoJpa> optJpa = repository.findById(idPedido);

		if (optJpa.isEmpty()) {

			return null;

		} else {

			//return new PedidoRecords(optJpa.get().idPedido, optJpa.get().idCliente, optJpa.get().);
			return null;

		}

	}

	@Override
	public PedidoRecords CriarPedido(PedidoRecords objCriarPedido) {

		try {

			ProdutoReqCompra reqcompra = new ProdutoReqCompra(1, 1);
			this.estoque.removerEstoque(reqcompra);

		} catch (Exception e) {

			throw new UnsupportedOperationException("Fora de Estoque");
		}

		return null;
	}

	@Override
	public List<PedidoRecords> ListarPedidos() {
		
		return null;
	}

}
