package cz.kopecky.pojistovna.models.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Service;

public class PersonDTO {
    @Email(message = "Vyplňte email.")
    @NotBlank(message ="Vyplňte svůj email.")
    @NotNull(message = "Vyplňte svůj email.")
    private String email;
    @NotBlank(message = "Vyplňte své heslo.")
    @NotNull(message = "Vyplňte své heslo.")
    @Size(min=6,message = "Minimální délka hesla je 6 znaků.")
    private String password;
    @NotBlank(message = "Zopakujte své heslo.")
    @NotNull(message = "Zopakujte své heslo.")
    @Size(min=6,message = "Minimální délka hesla je 6 znaků.")
    private String confirmPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
