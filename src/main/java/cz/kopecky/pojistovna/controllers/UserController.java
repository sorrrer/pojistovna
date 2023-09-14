package cz.kopecky.pojistovna.controllers;

import cz.kopecky.pojistovna.data.repositories.UserRepository;
import cz.kopecky.pojistovna.models.dto.UserDTO;
import cz.kopecky.pojistovna.models.exceptions.UserNotFoundException;
import cz.kopecky.pojistovna.models.mappers.UserMapper;
import cz.kopecky.pojistovna.models.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
   private UserService userService;
    @Autowired
    private UserMapper userMapper;
    /* controller pro šablonu users/index */
    @GetMapping
    public String renderUserIndex(Model model)
    {
        List<UserDTO> users = userService.getAll();
        model.addAttribute("users",users);
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
    public String createUserForm(@Valid @ModelAttribute UserDTO user, BindingResult result, RedirectAttributes redirectAttributes)
    {
        if(result.hasErrors())
            return renderUserForm(user);
        userService.create(user);
        /* stavová zpráva */
        redirectAttributes.addFlashAttribute("success","Pojištěnec byl vytvořen.");
        return "redirect:/users";
    }
    /* controller pro zobrazení detailu pojištěnce */
    @GetMapping("{userId}")
    public String renderDetailUser(@PathVariable long userId, Model model)
    {
        UserDTO user = userService.getById(userId);
        model.addAttribute("user",user);
        return "pages/users/detail";
    }
    /* controller pro zobrazení šablony pro editaci */
    @GetMapping("edit/{userId}")
    public String renderEditUser(@PathVariable long userId, UserDTO user)
    {
        UserDTO fetchedUser = userService.getById(userId);
        userMapper.updateUserDTO(fetchedUser,user);
        return "pages/users/edit";
    }
    /* PostMapping pro odeslání editace uživatele */
    @PostMapping("edit/{userId}")
    public String createEditForm(@PathVariable long userId, @Valid UserDTO user,BindingResult result,RedirectAttributes redirectAttributes)
    {
        if (result.hasErrors())
            renderEditUser(userId,user);
        user.setUserId(userId);
        userService.edit(user);
        /* stavová zpráva */
        redirectAttributes.addFlashAttribute("success","Pojištěnec byl úspěšně editován.");
        return "redirect:/users";
    }
    /* controller pro mazání pojištěnce */
    @PostMapping("delete/{userId}")
    public String deleteUser(@PathVariable long userId,RedirectAttributes redirectAttributes)
    {
        userService.remove(userId);
        /* stavová zpráva */
        redirectAttributes.addFlashAttribute("success","Pojištěnec byl úspěšně odstraněn.");
        return "redirect:/users";
    }

    /*metoda, která zpracovává chyby*/
    @ExceptionHandler({UserNotFoundException.class})
    public String handleUserNotFoundException(RedirectAttributes redirectAttributes)
    {
        redirectAttributes.addFlashAttribute("error","Pojištěnec nebyl nalezen.");
        return "redirect:/users";
    }



}
