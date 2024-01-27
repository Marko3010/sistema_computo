package com.computo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CommentDTO {

    private Long id;

    @NotEmpty // no puede quedar vacio la casilla
    @Size(min = 4, max = 50, message = "el comentario debe tener minimo 4 caracteres ")
    private String name;

    @NotEmpty(message = "el mail no debe estar vacio")
    @Email(message = "debe ingresar un correo")
    private String email;

    @NotEmpty // no puede quedar vacio la casilla
    @Size(min = 4, max = 100, message = "el comentario debe tener minimo 4 caracteres ")
    private String body;

}
