package com.fiap.ServPedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.ServPedido.model.jpaStructure.PedidoJpa;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoJpa, Integer> {

}
