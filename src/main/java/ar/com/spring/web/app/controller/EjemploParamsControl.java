package ar.com.spring.web.app.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

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
	
	@GetMapping("/mix-params")
	public String param(@RequestParam String saludo, @RequestParam Integer num, Model model) {
		model.addAttribute("resultado", "el parametro enviado es: '" + saludo + "' y el numero es: '" + num +"'");
		return "params/ver";
	}
	
	@GetMapping("/mix-paramsRequest")
	public String param(HttpServletRequest request, Model model) {
		String saludo = request.getParameter("saludo");
		Integer num=null;
		try {
		 num= Integer.parseInt(request.getParameter("num"));
		}catch(NumberFormatException nfe){
			num=0;
		}
		
		model.addAttribute("resultado", "el parametro enviado es: '" + saludo + "' y el numero es: '" + num +"'");
		return "params/ver";
	}

}
