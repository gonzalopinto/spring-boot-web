package com.springboot.web.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;

	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;

	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;

	// @GetMapping({"/index", "/", "/home"})
	// public ModelAndView index(ModelAndView mv) {
	// mv.addObject("titulo", "Hola Spring Framework");
	// mv.setViewName("index");
	// return mv;
	// }

	// @RequestMapping(value = "/index") //, method = RequestMethod.GET)
	@GetMapping({ "/index", "/", "", "/home" })
	public String index(ModelMap model) {
		// public ModelAndView index(ModelAndView mv) {
		model.addAttribute("titulo", textoIndex);
		return "index";

		// mv.addObject("titulo", "Hola Spring Framework");
		// mv.setViewName("index");
		// return mv;
	}

	// Por variar, se puede usar GetMapping
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario("Gonzalo", "Pinto", "gonzalo.pinto@gmail.com");

		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", textoPerfil + usuario.getNombre());
		return "perfil";
	}

	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", textoListar);

		return "listar";
	}

	@ModelAttribute("usuarios")
	public List<Usuario> populateUsers() {
		List<Usuario> usuarios = Arrays.asList(new Usuario("Gonzalo", "Pinto", "gonzalo.pinto@gmail.com"),
				new Usuario("John", "Doe", "john@gmail.com"), new Usuario("Michael", "Jordan", "michael@gmail.com"),
				new Usuario("Tornado", "Roe", "roe@gmail.com"));

		return usuarios;
	}

}
