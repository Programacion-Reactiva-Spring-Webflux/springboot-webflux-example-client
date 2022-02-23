package com.lagm.webflux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lagm.webflux.entity.Factura;
import com.lagm.webflux.proxy.IClienteFacturaProxy;

import reactor.core.publisher.Flux;

@Service
public class ClienteFacturaService implements IClienteFacturaService {
	
	@Autowired
	private IClienteFacturaProxy clienteFacturaProxy;

	@Override
	public List<Factura> buscarTodas() {
		return clienteFacturaProxy.buscarTodas();
	}

	@Override
	public Flux<Factura> buscarTodasWebflux() {
		return clienteFacturaProxy.buscarTodasWebflux();
	}
	
}
