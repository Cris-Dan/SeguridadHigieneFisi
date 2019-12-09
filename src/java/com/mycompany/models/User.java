/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.models;


public abstract class User {
    protected Integer idUser;
    protected String firstname;
    protected String lastname;
    protected String password;
    protected String email;

    public User() {
    }

    public User(Integer idUser, String firstname, String lastname, String password, String email) {
        this.idUser = idUser;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public boolean match(String tipo) {
        return tipo.equalsIgnoreCase("USER");
    }

    public User returner(String tipo) {
        if (match(tipo)) {
            return new User(){};
        } else {
            return null;
        }
    }
}

