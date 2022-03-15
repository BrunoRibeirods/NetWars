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

    @Pattern(regexp = "^-?([1-8]?[1-9]|[1-9]0)\\.{1}\\d{1,6}", message = "Latitude invalida")
    @NotNull(message="LATITUDE não pode ser nulo") @NotEmpty(message = "Necessario preencher LATITUDE")
    private String latitude;

    @Pattern(regexp = "^-?([1]?[1-7][1-9]|[1]?[1-8][0]|[1-9]?[0-9])\\.{1}\\d{1,6}", message = "Longitude invalida")
    @NotNull(message="LONGITUDE não pode ser nulo") @NotEmpty(message = "Necessario preencher LONGITUDE")
    private String longitude;

}
