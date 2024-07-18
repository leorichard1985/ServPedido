package com.fiap.ServPedido.integracao.entrega;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "entrega", url = "http://localhost:8083/api")
public interface EntregaPedidoProducer {

	@PostMapping(value = "/consumer-solicita-entrega")
	void entregaPedido(EntregaPedidoCliente reqEntrega);

}
