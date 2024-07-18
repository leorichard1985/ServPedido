package com.fiap.ServPedido;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServPedidoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServPedidoApplication.class, args);
	}

}
