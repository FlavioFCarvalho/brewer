package com.reobotnet.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.reobotnet.brewer.model.TipoPessoa;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

	@RequestMapping("novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("cliente/CadastroCliente");
		mv.addObject("tiposPessoa", TipoPessoa.values());
		return mv;
	}
	
}