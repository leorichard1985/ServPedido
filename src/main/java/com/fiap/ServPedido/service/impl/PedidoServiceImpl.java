package com.fiap.ServPedido.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fiap.ServPedido.records.PedidoRecords;
import com.fiap.ServPedido.service.interfaces.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService{
	
	@Override
	public PedidoRecords BuscarPedidoPorId(Integer idPedido) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public PedidoRecords CriarPedido(PedidoRecords objCriarPedido) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<PedidoRecords> ListarPedidos() {
		// TODO Auto-generated method stub
		return null;
	}


	private Boolean VerificarProdutoEstoque(Integer idProduto, Integer qtdeSolicitada) {
		// TODO Auto-generated method stub
		return null;
	}

}
