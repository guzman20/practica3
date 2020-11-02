package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorQuiz {

	@GetMapping("/inicio")
	public String inicio_get(Model model, HttpSession session) {
		return "inicio";
	}

	@PostMapping(value = "/inicio")
	public String inicio_post(Model model, HttpServletRequest request, @RequestParam String nombre) {
		Integer puntacion = (Integer) request.getAttribute("sessionPuntacion");
		if (puntacion == null) {
			puntacion = 0;
			request.getSession().setAttribute("sessionPuntacion", puntacion);
		}
		if (nombre.equals(null))
			return "redirect:/inicio";
		else
			request.getSession().setAttribute("sessionNombre", nombre);
		model.addAttribute("sessionPuntacion", puntacion);
		model.addAttribute("sessionNombre", nombre);
		return "pregunta1";
	}

	@PostMapping(value = "/pregunta1")
	public String pregunta_post(Model model, 
			@RequestParam String respuesta, 
			HttpServletRequest request) {
		Integer puntacion = (Integer) request.getSession().getAttribute("sessionPuntacion");
		switch(respuesta) {
		case "tirador":
			puntacion=puntacion+3;
			break;
		case "mago":
			puntacion=puntacion+2;
			break;
		case "luchador":
			puntacion=puntacion+1;
			break;
		case "asesino":
			puntacion=puntacion+0;
			break;
		default:
			return "redirect:/pregunta1";
		}
		request.getSession().setAttribute("sessionPuntacion", puntacion);
		return "pregunta2";
	}

	@PostMapping(value = "/pregunta2")
	public String pregunta2_post(Model model, 
			@RequestParam List<String> respuesta, 
			HttpServletRequest request) {
		Integer puntacion = (Integer) request.getSession().getAttribute("sessionPuntacion");
		if(respuesta==null)
			return "redirect:/pregunta2";
		Integer x= respuesta.size();
		for(int i=0;i<x;i++) {
			if(respuesta.get(i).equals("tirador"))
				puntacion=puntacion+2;
			else if(respuesta.get(i).equals("mago"))
				puntacion=puntacion+1;
			else if(respuesta.get(i).equals("luchador"))
				puntacion=puntacion-1;
			else if(respuesta.get(i).equals("asesino"))
				puntacion=puntacion-2;
			else
				return "pregunta2";
		}
		request.getSession().setAttribute("sessionPuntacion", puntacion);
		return "pregunta3";
		}
	
	
	@PostMapping(value = "/pregunta3")
	public String pregunta3_post(Model model, 
			@RequestParam String respuesta, 
			HttpServletRequest request) {
		Integer puntacion = (Integer) request.getSession().getAttribute("sessionPuntacion");
		switch(respuesta) {
		case "tirador":
			puntacion=puntacion+3;
			break;
		case "mago":
			puntacion=puntacion+2;
			break;
		case "luchador":
			puntacion=puntacion+1;
			break;
		case "asesino":
			puntacion=puntacion+0;
			break;
		default:
			return "redirect:/pregunta3";
		}
		request.getSession().setAttribute("sessionPuntacion", puntacion);
		return "pregunta4";
		}
	
	@PostMapping(value = "/pregunta4")
	public String pregunta4_post(Model model, 
			@RequestParam Integer guapo, 
			@RequestParam Integer fuerte, 
			@RequestParam Integer inteligente, 
			@RequestParam Integer astuto, 
			HttpServletRequest request) {
		Integer puntacion = (Integer) request.getSession().getAttribute("sessionPuntacion");
		Integer mediaInteligenteYGuapo = (guapo+inteligente)/2;
		Integer mediaFuerteYAstuto = (fuerte+astuto)/2;
		int x=(int)((Math.random()*2)+1);
		if(mediaInteligenteYGuapo>7)
			if(mediaFuerteYAstuto<3)
				puntacion=puntacion+3;
			else
				puntacion=puntacion+2;
		else if(mediaInteligenteYGuapo<3)
			if(mediaFuerteYAstuto>7)
				puntacion=puntacion+0;
			else
				puntacion=puntacion+1;
		else
			puntacion=puntacion+x;
		request.getSession().setAttribute("sessionPuntacion", puntacion);
		return "pregunta5";
		}
	
	@PostMapping(value = "/pregunta5")
	public String pregunta5_post(Model model, 
			@RequestParam Integer romance, 
			@RequestParam Integer aventura, 
			@RequestParam Integer drama, 
			@RequestParam Integer cienciaficcion, 
			HttpServletRequest request) {
		Integer puntacion = (Integer) request.getSession().getAttribute("sessionPuntacion");
		Integer mediaRomanceYDrama = (romance+drama)/2;
		Integer mediaAventuraYCienciaficcion = (aventura+cienciaficcion)/2;
		int x=(int)((Math.random()*2)+1);
		if(mediaRomanceYDrama>7)
			if(mediaAventuraYCienciaficcion<3)
				puntacion=puntacion+3;
			else
				puntacion=puntacion+2;
		else if(mediaRomanceYDrama<3)
			if(mediaAventuraYCienciaficcion>7)
				puntacion=puntacion+0;
			else
				puntacion=puntacion+1;
		else
			puntacion=puntacion+x;
		request.getSession().setAttribute("sessionPuntacion", puntacion);
		return "pregunta6";
		}
	
	@PostMapping(value = "/pregunta6")
	public String pregunta6_post(Model model, 
			@RequestParam String respuesta, 
			HttpServletRequest request) {
		Integer puntacion = (Integer) request.getSession().getAttribute("sessionPuntacion");
		switch(respuesta) {
		case "tirador":
			puntacion=puntacion+3;
			break;
		case "mago":
			puntacion=puntacion+2;
			break;
		case "luchador":
			puntacion=puntacion+1;
			break;
		case "asesino":
			puntacion=puntacion+0;
			break;
		default:
			return "redirect:/pregunta6";
		}
		request.getSession().setAttribute("sessionPuntacion", puntacion);
		return "pregunta7";
		}
	
	
	@PostMapping(value = "/pregunta7")
	public String pregunta7_post(Model model, 
			@RequestParam String respuesta,
			HttpServletRequest request) {
		Integer puntacion = (Integer) request.getSession().getAttribute("sessionPuntacion");
		String resultado=null;
		if(respuesta.length()<=15)
			puntacion=puntacion+0;
		else if(respuesta.length()<30)
			puntacion=puntacion+1;
		else if(respuesta.length()<45)
			puntacion=puntacion+2;
		else
			puntacion=puntacion+3;
		request.getSession().setAttribute("sessionPuntacion", puntacion);
		if((int)request.getSession().getAttribute("sessionPuntacion")>=15)
			resultado="Tirador";
		else if((int)request.getSession().getAttribute("sessionPuntacion")>=10)
			resultado="Mago";
		else if((int)request.getSession().getAttribute("sessionPuntacion")>=5)
			resultado="Luchador";
		else
			resultado="Asesino";
		model.addAttribute("resultado", resultado);
		return "resultados";
		}
	/*
	@PostMapping(value = "/resultados")
	public String resultados_post(Model model,
			HttpServletRequest request) {
		return "pregunta7";
		}*/
	}