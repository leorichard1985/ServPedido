package com.fiap.ServPedido.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fiap.ServPedido.model.jpaStructure.PedidoItemJpa;

@Repository
public interface PedidoItemRepository extends JpaRepository<PedidoItemJpa, Integer> {

	@Query(value = "SELECT PedidoItem FROM PedidoItemJpa PedidoItem WHERE PedidoItem.pedido.idPedido = :idPedido")
	public List<PedidoItemJpa> BuscarItemsPedidoPorIdPedido(@Param(value = "idPedido") Integer idPedido);

}
