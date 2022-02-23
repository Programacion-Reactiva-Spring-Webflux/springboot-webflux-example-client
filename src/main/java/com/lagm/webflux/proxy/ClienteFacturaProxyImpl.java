package com.lagm.webflux.proxy;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.lagm.webflux.entity.Factura;

import reactor.core.publisher.Flux;

@Component
public class ClienteFacturaProxyImpl implements IClienteFacturaProxy {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClienteFacturaProxyImpl.class);
	
	@Value("${webservice.url}")
	private String apiUrl;
	
	@Value("${webservice.urlWebflux}")
	private String apiUrlWebflux;
	
	@Override
	public List<Factura> buscarTodas() {
		LOGGER.info("apiUrl: {}", apiUrl);
		RestTemplate template = new RestTemplate();
		Factura[] arrFactura = template.getForObject(apiUrl, Factura[].class);
		List<Factura> listaFacturas = Arrays.asList(arrFactura);
		return listaFacturas;
	}

	@Override
	public Flux<Factura> buscarTodasWebflux() {
		LOGGER.info("apiUrl: {}", apiUrlWebflux);
		WebClient cliente = WebClient.create(apiUrlWebflux);
		Flux<Factura> facturas = cliente.get().retrieve().bodyToFlux(Factura.class);
		Flux<Factura> facturas2 = cliente.get().retrieve().bodyToFlux(Factura.class);
		Flux<Factura> facturas3 = cliente.get().retrieve().bodyToFlux(Factura.class);
		Flux<Factura> todas = Flux.merge(facturas, facturas2, facturas3);
		LOGGER.info("Todas: {}", todas);
		return todas;
	}
	
}
