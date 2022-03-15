package dev.bruno.netwars.netwars.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class RequestLocalization {

    @NotNull(message="NOME não pode ser nulo") @NotEmpty(message = "Necessario preencher NOME")
    private String name;

    @Pattern(regexp = "^(\\\\+|-)?(?:90(?:(?:\\\\.0{1,6})?)|(?:[0-9]|[1-8][0-9])(?:(?:\\\\.[0-9]{1,6})?))$", message = "Latitude invalida")
    @NotNull(message="LATITUDE não pode ser nulo") @NotEmpty(message = "Necessario preencher LATITUDE")
    private String latitude;

    @Pattern(regexp = "^(\\+|-)?(?:180(?:(?:\\.0{1,6})?)|(?:[0-9]|[1-9][0-9]|1[0-7][0-9])(?:(?:\\.[0-9]{1,6})?))$\n", message = "Longitude invalida")
    @NotNull(message="LONGITUDE não pode ser nulo") @NotEmpty(message = "Necessario preencher LONGITUDE")
    private String longitude;

}
