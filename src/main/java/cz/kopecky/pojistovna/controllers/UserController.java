package cz.kopecky.pojistovna.controllers;

import cz.kopecky.pojistovna.data.repositories.UserRepository;
import cz.kopecky.pojistovna.models.dto.UserDTO;
import cz.kopecky.pojistovna.models.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
   private UserService userService;
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
        userService.create(user);
        return "redirect:/users";

    }


}
