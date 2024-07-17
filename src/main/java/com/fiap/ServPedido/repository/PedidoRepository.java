package com.fiap.ServPedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.ServPedido.model.jpaStructure.PedidoJpa;

public interface PedidoRepository extends JpaRepository<PedidoJpa, Integer> {

}
