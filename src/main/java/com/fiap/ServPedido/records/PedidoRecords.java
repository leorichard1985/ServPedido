package com.fiap.ServPedido.records;

import java.util.List;

import com.fiap.ServPedido.model.jpaStructure.PeditoItemJpa;

public record PedidoRecords(Integer idPedido, Integer idCliente, List<PeditoItemJpa> itemPedido) {

}
