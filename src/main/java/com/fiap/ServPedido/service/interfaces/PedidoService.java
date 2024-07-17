package com.fiap.ServPedido.service.interfaces;

import java.util.List;

import com.fiap.ServPedido.records.PedidoRecords;

public interface PedidoService {

	List<PedidoRecords> ListarPedidos();

	PedidoRecords BuscarPedidoPorId(Integer idPedido);

	PedidoRecords CriarPedido(PedidoRecords objCriarPedido);


	

}
