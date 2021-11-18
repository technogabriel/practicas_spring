package ar.com.spring.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsControl {
	
	@GetMapping("/")
	public String index() {
		return "params/index";
	}
	
	
	@GetMapping("/string")
	public String param(@RequestParam(name="texto", required = false, defaultValue = "no ha ingresado nada") String texto, Model model) {
		model.addAttribute("resultado", "el parametro enviado es: " + texto);
		return "params/ver";
	}

}
