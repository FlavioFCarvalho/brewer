package com.reobotnet.brewer.controller.validator;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.reobotnet.brewer.model.Venda;

@Component
public class VendaValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Venda.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "cliente.codigo", "", "Selecione um cliente na pesquisa rápida");
		
		Venda venda = (Venda) target;
		validarSeInformouApenasHorarioEntrega(errors, venda);
		validarSeInformouItens(errors, venda);
	
	}
	
	private void validarSeInformouApenasHorarioEntrega(Errors errors, Venda venda) {
		if (venda.getHorarioEntrega() != null && venda.getDataEntrega() == null) {
			errors.rejectValue("dataEntrega", "", "Informe uma data da entrega para um horário");
		}
	}
	
	private void validarSeInformouItens(Errors errors, Venda venda) {
		if (venda.getItens().isEmpty()) {
			errors.reject("", "Adicione pelo menos uma cerveja na venda");
		}
	}

}