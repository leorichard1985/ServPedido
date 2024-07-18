package com.fiap.ServPedido.integracao;

public class ProdutoReqCompra {

	private Integer idProduto;
	private Integer quantidade;

	public ProdutoReqCompra(Integer idProduto, Integer quantidade) {
		this.idProduto = idProduto;
		this.quantidade = quantidade;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}
}
