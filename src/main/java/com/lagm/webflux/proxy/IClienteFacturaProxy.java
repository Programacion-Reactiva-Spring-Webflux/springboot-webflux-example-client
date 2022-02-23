package com.lagm.webflux.proxy;

import java.util.List;

import com.lagm.webflux.entity.Factura;

import reactor.core.publisher.Flux;

public interface IClienteFacturaProxy {
	public List<Factura> buscarTodas();
	public Flux<Factura> buscarTodasWebflux();
}
