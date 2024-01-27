package com.computo.dto;

import com.computo.model.Comment;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
public class ProductDTO {


    private Long id;

    @NotEmpty // no puede quedar vacio la casilla
    @Size(min = 4, max = 50, message = "el prducto debe tener minimo 4 caracteres ")
    private String name;

    @NotEmpty // no puede quedar vacio la casilla
    @Size(min = 4, max = 50, message = "el prducto debe tener minimo 4 caracteres ")
    private String description;

    private int amount;

    private double price;

    private Set<Comment> comments;



}
