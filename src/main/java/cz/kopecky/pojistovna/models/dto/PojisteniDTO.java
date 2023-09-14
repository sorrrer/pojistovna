package cz.kopecky.pojistovna.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PojisteniDTO {
    @NotNull(message = "Vyplňte částku.")
    private int price;
    @NotBlank(message = "Vyplňte předmět pojištění.")
    @NotNull(message = "Vyplňte předmět pojištění.")
    private String predmetPojisteni;
    @NotNull(message = "Vyplňte datum od:")
    private int timeFrom;
    @NotNull(message = "Vyplňte datum do:")
    private int timeTo;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPredmetPojisteni() {
        return predmetPojisteni;
    }

    public void setPredmetPojisteni(String predmetPojisteni) {
        this.predmetPojisteni = predmetPojisteni;
    }

    public int getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(int timeFrom) {
        this.timeFrom = timeFrom;
    }

    public int getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(int timeTo) {
        this.timeTo = timeTo;
    }
}
