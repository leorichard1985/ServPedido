package com.fiap.ServPedido.model.jpaStructure;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_MOV_Pedido_Item")
public class PeditoItemJpa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idItemPedido")
	public Integer idItemPedido;

	@Column(name = "idProduto")
	public Integer idProduto;
	
	@Column(name = "qtde")
	public Integer qtde;
	

}
