package cz.kopecky.pojistovna.controllers;

import cz.kopecky.pojistovna.models.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    @GetMapping
    public String renderUserIndex()
    {
        return "pages/users/index";
    }
    @GetMapping("create")
    public String renderUserForm(@ModelAttribute UserDTO user)
    {
        return "pages/users/create";
    }

}
