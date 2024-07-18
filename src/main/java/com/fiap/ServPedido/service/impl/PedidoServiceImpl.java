package com.fiap.ServPedido.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.fiap.ServPedido.integracao.entrega.EntregaPedidoCliente;
import com.fiap.ServPedido.integracao.entrega.EntregaPedidoProducer;
import com.fiap.ServPedido.integracao.estoque.EstoquePedidoProducer;
import com.fiap.ServPedido.integracao.estoque.ProdutoReqCompra;
import com.fiap.ServPedido.model.jpaStructure.PedidoItemJpa;
import com.fiap.ServPedido.model.jpaStructure.PedidoJpa;
import com.fiap.ServPedido.records.PedidoItemRecords;
import com.fiap.ServPedido.records.PedidoRecords;
import com.fiap.ServPedido.repository.PedidoItemRepository;
import com.fiap.ServPedido.repository.PedidoRepository;
import com.fiap.ServPedido.service.interfaces.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {

	private PedidoRepository repositoryPedido;
	private PedidoItemRepository repositoryItemPedido;

	private final EstoquePedidoProducer estoque;
	private final EntregaPedidoProducer entrega;

	public PedidoServiceImpl(EstoquePedidoProducer estoque, EntregaPedidoProducer entrega,
			PedidoRepository repositoryPedido, PedidoItemRepository repositoryItemPedido) {
		this.estoque = estoque;
		this.entrega = entrega;
		this.repositoryPedido = repositoryPedido;
		this.repositoryItemPedido = repositoryItemPedido;
	}

	@Override
	public PedidoRecords BuscarPedidoPorId(Integer idPedido) {

		Optional<PedidoJpa> optPedidoJpa = repositoryPedido.findById(idPedido);

		if (optPedidoJpa.isEmpty()) {

			return null;

		} else {

			List<PedidoItemJpa> lstPedidoItem = repositoryItemPedido.BuscarItemsPedidoPorIdPedido(idPedido);
			List<PedidoItemRecords> ItensRecords = new ArrayList<>();

			if (!CollectionUtils.isEmpty(lstPedidoItem)) {

				for (int i = 0; i <= lstPedidoItem.size() - 1; i++) {

					PedidoItemRecords ItemRecords = new PedidoItemRecords(lstPedidoItem.get(i).idItemPedido,
							lstPedidoItem.get(i).idProduto, lstPedidoItem.get(i).qtde);

					ItensRecords.add(ItemRecords);

				}

			}

			return new PedidoRecords(optPedidoJpa.get().idPedido, optPedidoJpa.get().idCliente, ItensRecords);

		}

	}

	@Override
	public PedidoRecords CriarPedido(PedidoRecords objCriarPedido) {

		PedidoJpa pedidoJpa = new PedidoJpa();
		pedidoJpa.idCliente = objCriarPedido.idCliente();

		PedidoJpa savedPedidoJpa = repositoryPedido.save(pedidoJpa);

		for (int x = 0; x <= objCriarPedido.itemPedido().size() - 1; x++) {

			PedidoItemJpa itemJpa = new PedidoItemJpa();

			itemJpa.pedido = savedPedidoJpa;
			itemJpa.idProduto = objCriarPedido.itemPedido().get(x).idProduto();
			itemJpa.qtde = objCriarPedido.itemPedido().get(x).qtde();

			estoque.removerEstoque(new ProdutoReqCompra(objCriarPedido.itemPedido().get(x).idProduto(),
					objCriarPedido.itemPedido().get(x).qtde()));

			repositoryItemPedido.save(itemJpa);

		}

		entrega.entregaPedido(new EntregaPedidoCliente(savedPedidoJpa.idPedido, savedPedidoJpa.idCliente));

		return BuscarPedidoPorId(savedPedidoJpa.idPedido);

	}

	@Override
	public List<PedidoRecords> ListarPedidos() {

		List<PedidoJpa> lstPedidosJpa = repositoryPedido.findAll();

		if (!CollectionUtils.isEmpty(lstPedidosJpa)) {

			return null;

		} else {

			List<PedidoRecords> lstPedidosRecords = new ArrayList<>();

			for (int x = 0; x <= lstPedidosJpa.size() - 1; x++) {

				List<PedidoItemJpa> lstItensDePedidoJpa = repositoryItemPedido
						.BuscarItemsPedidoPorIdPedido(lstPedidosJpa.get(x).idPedido);

				List<PedidoItemRecords> ItensDePedidoRecords = new ArrayList<>();

				if (!CollectionUtils.isEmpty(lstItensDePedidoJpa)) {

					for (int i = 0; i <= lstItensDePedidoJpa.size() - 1; i++) {

						PedidoItemRecords ItemDePedidoRecord = new PedidoItemRecords(
								lstItensDePedidoJpa.get(i).idItemPedido, lstItensDePedidoJpa.get(i).idProduto,
								lstItensDePedidoJpa.get(i).qtde);

						ItensDePedidoRecords.add(ItemDePedidoRecord);

					}

				}

				PedidoRecords PedidoRecords = new PedidoRecords(lstPedidosJpa.get(x).idPedido,
						lstPedidosJpa.get(x).idCliente, ItensDePedidoRecords);

				lstPedidosRecords.add(PedidoRecords);

			}

			return lstPedidosRecords;

		}
	}

}
