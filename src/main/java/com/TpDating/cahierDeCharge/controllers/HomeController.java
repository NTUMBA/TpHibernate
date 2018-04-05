package com.TpDating.cahierDeCharge.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
import com.TpDating.cahierDeCharge.enumerations.Orientation;
import com.TpDating.cahierDeCharge.enumerations.Origine;
import com.TpDating.cahierDeCharge.enumerations.Sexe;
import com.TpDating.cahierDeCharge.enumerations.StatusPerso;
import com.TpDating.cahierDeCharge.enumerations.TypeHair;
import com.TpDating.cahierDeCharge.services.AdresseService;
import com.TpDating.cahierDeCharge.services.ApparenceService;
import com.TpDating.cahierDeCharge.services.Centre_interetService;
import com.TpDating.cahierDeCharge.services.PhotoService;
import com.TpDating.cahierDeCharge.services.SituationService;
import com.TpDating.cahierDeCharge.services.UtilisateurService;


@Controller
public class HomeController {

    private final UtilisateurService utilisateurService;
    private final AdresseService adresseService;
    private final SituationService situationService;
    private final PhotoService photoService;
    private final Centre_interetService centre_interetService;
    private final ApparenceService apparenceService;
    private final PhotoController photoController;

    @Autowired
    public HomeController(UtilisateurService utilisateurService, AdresseService adresseService, SituationService situationService, PhotoService photoService, Centre_interetService centre_interetService, ApparenceService apparenceService, PhotoController photoController) {
        this.utilisateurService = utilisateurService;
        this.adresseService = adresseService;
        this.situationService = situationService;
        this.photoService = photoService;
        this.centre_interetService = centre_interetService;
        this.apparenceService = apparenceService;
        this.photoController = photoController;
    }


    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Dating - Site de rencontre");

        model.addAttribute("userLogin", new Utilisateur());
        return "/index";
    }

    @GetMapping("/register")
    public String getRegister(ModelMap model) {
        model.addAttribute("title", "Dating - Site de rencontre - Formulaire");
        model.addAttribute("user", new Utilisateur());
        model.addAttribute("userLogin", new Utilisateur());
        model.addAttribute("adresse", new Adresse());
        model.addAttribute("situation", new Situation());
        model.addAttribute("apparence", new Apparence());
        model.addAttribute("photo", new Photo());
        model.addAttribute("ci", new CentreInteret());
        model.addAttribute("prefix", AdressePrefixe.values());
        model.addAttribute("statusPerso", StatusPerso.values());
        model.addAttribute("typeStreet", AdressTypeStreet.values());
        model.addAttribute("sexe", Sexe.values());
        model.addAttribute("orientation", Orientation.values());
        model.addAttribute("fumeur", Fumeur.values());
        model.addAttribute("alcool", Alcool.values());
        model.addAttribute("colorEyes", ColorEyes.values());
        model.addAttribute("origine", Origine.values());
        model.addAttribute("colorHair", ColorHair.values());
        model.addAttribute("typeHair", TypeHair.values());

        return "pages/register";
    }

    @PostMapping("/register")
    public String postRegister(@Valid @ModelAttribute(value = "user") Utilisateur utilisateur, BindingResult userResult,
                               @Valid @ModelAttribute(value = "userLogin") Utilisateur userLogin, BindingResult userLoginResult,
                               @Valid @ModelAttribute(value = "adresse") Adresse adresse, BindingResult adresseResult,
                               @Valid @ModelAttribute(value = "situation") Situation situation, BindingResult situationResult,
                               @Valid @ModelAttribute(value = "apparence") Apparence apparence, BindingResult apparenceResult,
                               @Valid @ModelAttribute(value = "photo") Photo photo, BindingResult photoResult,
                               @Valid @ModelAttribute(value = "ci") CentreInteret centreInteret, BindingResult ciResult,
                               ModelMap model) {
        if (userResult.hasErrors() || adresseResult.hasErrors() ||
                situationResult.hasErrors() || apparenceResult.hasErrors() ||
                photoResult.hasErrors() || ciResult.hasErrors()) {
            model.addAttribute("prefix", AdressePrefixe.values());
            model.addAttribute("statusPerso", StatusPerso.values());
            model.addAttribute("typeStreet", AdressTypeStreet.values());
            model.addAttribute("sexe", Sexe.values());
            model.addAttribute("orientation", Orientation.values());
            model.addAttribute("fumeur", Fumeur.values());
            model.addAttribute("alcool", Alcool.values());
            model.addAttribute("colorEyes", ColorEyes.values());
            model.addAttribute("origine", Origine.values());
            model.addAttribute("colorHair", ColorHair.values());
            model.addAttribute("typeHair", TypeHair.values());
            return "pages/register";
        }

        situationService.save(situation);
        utilisateur.setSituation(situation);



        apparenceService.save(apparence);
        utilisateur.setApparence(apparence);
        utilisateur.setAdmin(0);

        adresseService.save(adresse);
        utilisateur.setAdresse(adresse);

        utilisateurService.save(utilisateur);

        photo.setUtilisateur(utilisateur);
        photoController.save(photo);



        return "redirect:/";
    }
}
