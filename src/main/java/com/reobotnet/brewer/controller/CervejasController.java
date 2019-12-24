package com.reobotnet.brewer.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.reobotnet.brewer.model.Cerveja;
import com.reobotnet.brewer.repository.Cervejas;

@Controller
public class CervejasController {
	
	@Autowired
	private Cervejas cervejas;
	
	@RequestMapping("/cervejas/novo")
	public String novo(Cerveja cerveja) {
		Optional<Cerveja> cervejaOptional = cervejas.findBySkuIgnoreCase("AAA1111"); //Teste apagar depois
		System.out.println(cervejaOptional.isPresent());
		return "cerveja/CadastroCerveja";
	}
	
	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(cerveja);
		}
		
		// Salvar no banco de dados...
		attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso!");
		System.out.println(">>> sku: " + cerveja.getSku());
		return "redirect:/cervejas/novo";
	}
	
	
}
