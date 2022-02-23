package com.lagm.webflux.service;

import java.util.List;

import com.lagm.webflux.entity.Factura;

import reactor.core.publisher.Flux;

public interface IClienteFacturaService {
	public List<Factura> buscarTodas();
	public Flux<Factura> buscarTodasWebflux();
}
