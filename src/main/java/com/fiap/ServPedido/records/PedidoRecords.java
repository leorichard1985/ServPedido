package com.fiap.ServPedido.records;

import java.util.List;

public record PedidoRecords(Integer idPedido, Integer idCliente, List<PedidoItemRecords> itemPedido) {

}
