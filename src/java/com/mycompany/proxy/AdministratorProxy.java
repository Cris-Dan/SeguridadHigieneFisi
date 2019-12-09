/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proxy;

import com.mycompany.models.Administrator;
import com.mycompany.models.User;

/**
 *
 * @author cristian
 */
public class AdministratorProxy extends User {

    private Administrator administrator = new Administrator();

    public AdministratorProxy() {

    }

    public AdministratorProxy(Administrator administrator) {
        this.administrator = administrator;
    }

    @Override
    public boolean match(String tipo) {
        return this.administrator.match(tipo);
    }

    @Override
    public User returner(String tipo) {
        return this.administrator.returner(tipo);
    }

    public Integer getIdAdministrator() {
        return this.administrator.getIdAdministrator();
    }

    public void setIdAdministrator(Integer idAdministrator) {
        this.administrator.setIdAdministrator(idAdministrator);
    }

    @Override
    public Integer getIdUser() {
        return this.administrator.getIdUser();
    }

    @Override
    public void setIdUser(Integer idUser) {
        this.administrator.setIdUser(idUser);
    }

    @Override
    public String getFirstname() {
        return this.administrator.getFirstname();
    }

    @Override
    public void setFirstname(String firstname) {
        this.administrator.setFirstname(firstname);
    }

    @Override
    public String getLastname() {
        return this.administrator.getLastname();
    }

    @Override
    public void setLastname(String lastname) {
        this.administrator.setLastname(lastname);
    }

    @Override
    public String getPassword() {
        return this.administrator.getPassword();
    }

    @Override
    public void setPassword(String password) {
        this.administrator.setPassword(password);
    }

    @Override
    public String getEmail() {
        return this.administrator.getEmail();
    }

    @Override
    public void setEmail(String email) {
        this.administrator.setEmail(email);
    }
}
