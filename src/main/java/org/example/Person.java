package org.example;

import org.example.annotation.rgpd;
import org.example.annotation.rgpd.Style;
import org.example.service.RgpdService;

import java.time.LocalDate;

public class Person {

    @rgpd(role = "dev", style = Style.STARS)
    private String name;
    private LocalDate birthDate;
    @rgpd(role = "dev", style = Style.SHUFFLE)
    private String ssNumber;

    private static RgpdService rgpdService = new RgpdService();

    public String getName() {
        Style style = rgpdService.getStyle(this.getClass(), "name");
        return rgpdService.obfuscate(name, style);
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getSsNumber() {
        Style style = rgpdService.getStyle(this.getClass(), "ssNumber");
        return rgpdService.obfuscate(ssNumber, style);
    }

    public void setSsNumber(String ssNumber) {
        this.ssNumber = ssNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                " \n\tname      = '" + getName() + '\'' +
                ",\n\tbirthDate = " + birthDate +
                ",\n\tssNumber  = '" + getSsNumber() + '\'' +
                "\n}";
    }
}
