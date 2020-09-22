package com.example.app.demo.dto;

import com.example.app.demo.domain.Cliente;
import com.example.app.demo.services.validation.ClienteUpdate;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@ClienteUpdate
public class ClienteDTO implements Serializable {

    private Integer id;

    @NotEmpty(message="preenchimento obrigatório")
    @Length(min=5, max=200, message="O tamanho deve ser entre 5 e 200 caracteres")
    private String nome;

    @NotEmpty(message="preenchimento obrigatório")
    @Email(message="Email inválido")
    private String email;

    public ClienteDTO(){
    }

    public ClienteDTO(Cliente obj){
        id = obj.getId();
        nome = obj.getNome();
        email = obj.getEmail();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return nome;
    }

    public void setNome(String name) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
