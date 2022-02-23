package com.lagm.webflux.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lagm.webflux.entity.Factura;
import com.lagm.webflux.service.IClienteFacturaService;

@Controller
public class ClienteFacturaController {
	@Autowired
	private IClienteFacturaService clienteFacturaService;
	
	@GetMapping("/index")
	public String index(Model model) {
		return "index";
	}
	
	@RequestMapping("/lista")
	public String listaClienteFactura(Model modelo) {
		List<Factura> listaFacturas = new ArrayList<>();
		listaFacturas.addAll(clienteFacturaService.buscarTodas());
		listaFacturas.addAll(clienteFacturaService.buscarTodas());
		listaFacturas.addAll(clienteFacturaService.buscarTodas());
		
		modelo.addAttribute("listaFacturas", listaFacturas);
		return "lista";
	}
	
	@RequestMapping(path = "/listaWebflux", method = RequestMethod.GET)
	public String listaClienteFacturaWebflux(Model modelo) {
		List<Factura> listaFacturas = clienteFacturaService.buscarTodasWebflux().collectList().block();
		modelo.addAttribute("listaFacturas", listaFacturas);
		return "lista";
	}
}
