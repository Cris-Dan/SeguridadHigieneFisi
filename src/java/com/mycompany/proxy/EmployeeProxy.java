/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proxy;

import com.mycompany.models.Employee;
import com.mycompany.models.User;

/**
 *
 * @author cristian
 */
public class EmployeeProxy extends User {

    Employee employee = new Employee();

    public EmployeeProxy() {
    }

    public EmployeeProxy(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean match(String tipo) {
        return employee.match(tipo);
    }

    @Override
    public User returner(String tipo) {
        return employee.returner(tipo);
    }

    public Integer getIdEmployee() {
        return this.employee.getIdEmployee();
    }

    public void setIdEmployee(Integer idEmployee) {
        this.employee.setIdEmployee(idEmployee);
    }

    public Integer getAge() {
        return employee.getAge();
    }

    public void setAge(Integer age) {
        this.employee.setAge(age);
    }

    public String getGenre() {
        return this.employee.getGenre();
    }

    public void setGenre(String genre) {
        this.employee.setGenre(genre);
    }

    public String getHealthCondition() {
        return this.employee.getHealthCondition();
    }

    public void setHealthCondition(String healthCondition) {
        this.employee.setHealthCondition(healthCondition);
    }

    @Override
    public Integer getIdUser() {
        return this.employee.getIdUser();
    }

    @Override
    public void setIdUser(Integer idUser) {
        this.employee.setIdUser(idUser);
    }

    @Override
    public String getFirstname() {
        return this.employee.getFirstname();
    }

    @Override
    public void setFirstname(String firstname) {
        this.employee.setFirstname(firstname);
    }

    @Override
    public String getLastname() {
        return this.employee.getLastname();
    }

    @Override
    public void setLastname(String lastname) {
        this.employee.setLastname(lastname);
    }

    @Override
    public String getPassword() {
        return this.employee.getPassword();
    }

    @Override
    public void setPassword(String password) {
        this.employee.setPassword(password);
    }

    @Override
    public String getEmail() {
        return this.employee.getEmail();
    }

    @Override
    public void setEmail(String email) {
        this.employee.setEmail(email);
    }

    @Override
    public Integer getDni() {
        return this.employee.getDni();
    }

    @Override
    public void setDni(Integer dni) {
        this.employee.setDni(dni);
    }

    @Override
    public String getDireccion() {
        return this.employee.getDireccion();
    }

    @Override
    public void setDireccion(String direccion) {
        this.employee.setDireccion(direccion);
    }
}
