package cz.kopecky.pojistovna.controllers;

import cz.kopecky.pojistovna.models.dto.UserDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    /* controller pro šablonu users/index */
    @GetMapping
    public String renderUserIndex()
    {
        return "pages/users/index";
    }
    /* controller pro šablonu users/create */
    @GetMapping("create")
    public String renderUserForm(@ModelAttribute UserDTO user)
    {
        return "pages/users/create";
    }
    /* controller pro odeslání dat z create šablony */
    @PostMapping("create")
    public String createUserForm(@Valid @ModelAttribute UserDTO user,BindingResult result)
    {
        if(result.hasErrors())
            return renderUserForm(user);
        System.out.println(user.getFirstName() + " " + user.getSecondName()) ;
        return "redirect:/users";

    }


}
