package com.fiap.ServPedido.integracao.entrega;

public class EntregaPedidoCliente {

	private Integer idCliente;
	private Integer idPedido;

	public EntregaPedidoCliente(Integer idPedido, Integer idCliente) {
		this.idPedido = idPedido;
		this.idCliente = idCliente;
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

}
