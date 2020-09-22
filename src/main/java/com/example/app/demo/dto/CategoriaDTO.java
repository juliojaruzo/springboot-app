package com.example.app.demo.dto;

import com.example.app.demo.domain.Categoria;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

import java.io.Serializable;

public class CategoriaDTO implements Serializable {

    public Integer id;

    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=5, max=100, message="O tamanho desse ser entre 5 e 100 caracteres")
    public String nome;

    public CategoriaDTO(){
    }

    public CategoriaDTO(Categoria obj){
        id = obj.getId();
        nome = obj.getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String name) {
        this.nome = nome;
    }
}
