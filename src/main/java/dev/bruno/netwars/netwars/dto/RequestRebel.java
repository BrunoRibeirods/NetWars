package dev.bruno.netwars.netwars.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RequestRebel {

    @NotNull(message="NOME não pode ser nulo") @NotEmpty(message = "Necessario preencher NOME")
    private String name;

    @NotNull(message="IDADE não pode ser nulo") @NotEmpty(message = "Necessario preencher IDADE")
    private Integer age;

    @NotNull(message="GENERO não pode ser nulo") @NotEmpty(message = "Necessario preencher GENERO")
    private String gender;
}
