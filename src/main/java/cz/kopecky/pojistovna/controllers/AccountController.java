package cz.kopecky.pojistovna.controllers;

import cz.kopecky.pojistovna.models.dto.PersonDTO;
import cz.kopecky.pojistovna.models.exceptions.DuplicateEmailException;
import cz.kopecky.pojistovna.models.services.PersonService;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private PersonService personService;
    @GetMapping("login")
    public String renderLogin()
    {
        return "/pages/account/login";
    }
    @GetMapping("/register")
    public String renderRegister(@ModelAttribute PersonDTO personDTO)
    {
        return "/pages/account/register";
    }
    @PostMapping("register")
    public String createRegisterForm(@Valid @ModelAttribute PersonDTO personDTO, BindingResult result, RedirectAttributes redirectAttributes)
    {
        if(result.hasErrors())
            return renderRegister(personDTO);
        try {
            personService.create(personDTO,false);
        }
        catch (DuplicateEmailException e)
        {
            result.rejectValue("email","error","Hesla se neshodují.");
            result.rejectValue("confirmPassword","error","Hesla se neshodují.");
            return "/pages/account/register";
        }
        redirectAttributes.addFlashAttribute("success","Uživatel byl právě zaregistrován.");
        return "redirect:/account/login";
    }
}
