/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.models;

public class Administrator extends User {

    private Integer idAdministrator;

    public Administrator() {
    }

    public Administrator(Integer idAdministrator, Integer idPerson, String firstname, String lastname, String password, String email) {
        super(idPerson, firstname, lastname, password, email);
        this.idAdministrator = idAdministrator;
    }

    @Override
    public boolean match(String tipo) {
        return tipo.equalsIgnoreCase("ADMINISTRATOR");
    }

    @Override
    public User returner(String tipo) {
        if (match(tipo)) {
            return new Administrator();
        } else {
            return null;
        }
    }

    public Integer getIdAdministrator() {
        return idAdministrator;
    }

    public void setIdAdministrator(Integer idAdministrator) {
        this.idAdministrator = idAdministrator;
    }

}
