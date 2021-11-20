package ar.com.spring.web.app.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.com.spring.web.app.model.Usuario;



@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.indexcontroller.textoIndex}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.textoPerfil}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar}")
	private String textoListar;
	
	@RequestMapping(value = {"/","/index","/home"}, method = RequestMethod.GET)
	public String index(Model model) {	
		model.addAttribute("titulo", textoIndex);
		
		return "index";
	}
	
	@GetMapping("/perfil")
	public String perfil(Model model) {
		Usuario us = new Usuario();
		us.setNombre("Adan");
		us.setApellido("Gabriel");
		us.setEmail("adan@email.com");
		
		model.addAttribute("usuario", us);
		model.addAttribute("titulo", textoPerfil.concat(us.getNombre()));
		
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		
		model.addAttribute("titulo", textoListar);
		
		
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario>insertUsuarios(){
		List<Usuario>usuarios = Arrays.asList(new Usuario("Adan","Gabriel", "micorreo@gmail.com"),
				new Usuario("Jhon","Doe", "tucorreo@gmail.com"),
				new Usuario("Lorenzo","Lamas", "elcorreo@gmail.com"),
				new Usuario("tomas", "rode", "tomas@rode.com"));
		
		return usuarios;
	}
	
	

}
