package com.TpDating.cahierDeCharge.controllers;

import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.TpDating.cahierDeCharge.entities.Adresse;
import com.TpDating.cahierDeCharge.entities.Apparence;
import com.TpDating.cahierDeCharge.entities.CentreInteret;
import com.TpDating.cahierDeCharge.entities.Photo;
import com.TpDating.cahierDeCharge.entities.Situation;
import com.TpDating.cahierDeCharge.entities.Utilisateur;
import com.TpDating.cahierDeCharge.enumerations.AdressTypeStreet;
import com.TpDating.cahierDeCharge.enumerations.AdressePrefixe;
import com.TpDating.cahierDeCharge.enumerations.Alcool;
import com.TpDating.cahierDeCharge.enumerations.ColorEyes;
import com.TpDating.cahierDeCharge.enumerations.ColorHair;
import com.TpDating.cahierDeCharge.enumerations.Fumeur;
import com.TpDating.cahierDeCharge.enumerations.MultimediaType;
import com.TpDating.cahierDeCharge.enumerations.Orientation;
import com.TpDating.cahierDeCharge.enumerations.Origine;
import com.TpDating.cahierDeCharge.enumerations.Sexe;
import com.TpDating.cahierDeCharge.enumerations.StatusPerso;
import com.TpDating.cahierDeCharge.enumerations.StatusPro;
import com.TpDating.cahierDeCharge.enumerations.TypeHair;
import com.TpDating.cahierDeCharge.services.UtilisateurService;

@Controller
public class UtilisateurController {
	private final UtilisateurService utilisateurService;

	@Autowired
	public UtilisateurController(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	// Les redirections lors des connection
	@GetMapping("/login")
	public ModelAndView loginRegister(HttpSession httpSession) {
		return new ModelAndView("pages/login").addObject("userLogin", new Utilisateur());

	}

	// Les redirections lors des connection
	@PostMapping("/login")
	public String login(@ModelAttribute Utilisateur utilisateur, RedirectAttributes attributes,
			HttpSession httpSession) {

		Utilisateur user = utilisateurService.findUtilisateurByEmailAndPassword(utilisateur.getEmail(),
				utilisateur.getPassword());

		if (user != null) {
			this.session(httpSession, user);
			return "redirect:/welcome";
		}

		return "redirect:/errorLogin";
	}

	// Configuration du mapping vers la page welcome, en cas de connexion reussi
	@GetMapping("/welcome")
	public ModelAndView welcome() {
		return new ModelAndView("/welcome");
	}

	// Configuration du mapping vers la page errorLogin, en cas de connexion non
	// autorisee
	@GetMapping("/errorLogin")
	public ModelAndView erreur() {
		return new ModelAndView("/errorLogin");
	}

	// Pour enregistrement
	@GetMapping("/fragmentsform")
	public ModelAndView enregistrement() {

		return new ModelAndView("pages/register").addObject("user", new Utilisateur())
				.addObject("adresse", new Adresse()).addObject("situation", new Situation())
				.addObject("apparence", new Apparence()).addObject("photo", new Photo())
				.addObject("ci", new CentreInteret()).addObject("sexe", Sexe.values())
				.addObject("colorEyes", ColorEyes.values()).addObject("alcool", Alcool.values())
				.addObject("fumeur", Fumeur.values()).addObject("origine", Origine.values())
				.addObject("statusPerso", StatusPerso.values()).addObject("statusPro", StatusPro.values())
				.addObject("orientation", Orientation.values()).addObject("typeStreet", MultimediaType.values())
				.addObject("colorHair", ColorHair.values()).addObject("prefix", AdressePrefixe.values())
				.addObject("typeStreet", AdressTypeStreet.values()).addObject("typeHair", TypeHair.values());

	}

	@GetMapping("/logout")
	public String logout(HttpSession httpSession) {
		httpSession.invalidate();
		return "redirect:/";
	}

	// CREATION D UNE SESSION
	public void session(HttpSession httpSession, Utilisateur utilisateur) {
		String sessionKey = "datjng.TP";
		Object time = httpSession.getAttribute(sessionKey);
		// RECUPERATION DE L HEURE
		if (time == null) {
			time = LocalDateTime.now();
			httpSession.setAttribute(sessionKey, time);
		}
		httpSession.setAttribute("utilisateurConnect", utilisateur);
		httpSession.setAttribute("nom", utilisateur.getEmail());
		httpSession.setAttribute("email", utilisateur.getEmail());
		httpSession.setAttribute("admin", utilisateur.getAdmin());
		httpSession.setAttribute("pseudo", utilisateur.getPseudo());
		httpSession.setMaxInactiveInterval(20 * 90);
	}
}
