package ar.com.spring.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesPathController {
	
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("titulo", "Enviar parametros de la ruta - @PathVariable");
		return "/variables/index";
	}
	
	@GetMapping("/string/{texto}")
	public String variables(@PathVariable String texto, Model model) {
		
		model.addAttribute("titulo", "Recibir parametros de la ruta - @PathVariable");
		model.addAttribute("resultado", "el resultado del texto es: " + texto);
		
		return "variables/ver";
		
	}
	
	@GetMapping("/string/{texto}/{num}")
	public String variables(@PathVariable String texto, @PathVariable Integer num, Model model) {
		
		model.addAttribute("titulo", "Recibir parametros de la ruta - @PathVariable");
		model.addAttribute("resultado", "el resultado del texto es: " + texto +
				" y el numero enviado en el path es: " + num);
		
		return "variables/ver";
		
	}

}
