package dev.bruno.netwars.netwars.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Localization {

    private String name;

    @Pattern(regexp = "^(\\\\+|-)?(?:90(?:(?:\\\\.0{1,6})?)|(?:[0-9]|[1-8][0-9])(?:(?:\\\\.[0-9]{1,6})?))$", message = "Latitude invalida")
    private String latitude;

    @Pattern(regexp = "^(\\+|-)?(?:180(?:(?:\\.0{1,6})?)|(?:[0-9]|[1-9][0-9]|1[0-7][0-9])(?:(?:\\.[0-9]{1,6})?))$\n", message = "Longitude invalida")
    private String longitude;

}
