package com.reobotnet.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.reobotnet.brewer.model.Cerveja;

@Controller
public class CervejasController {
	@RequestMapping("/cervejas/novo")
	public String novo() {
		return "cerveja/CadastroCerveja";
	}
	
	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Cerveja cerveja, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Tem erro sim !");
		}
		System.out.println(">>> sku: " + cerveja.getSku());
		return "cerveja/CadastroCerveja";
	}
}
