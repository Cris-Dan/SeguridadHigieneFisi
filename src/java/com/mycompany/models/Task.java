/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.models;

/**
 *
 * @author cristian
 */
public class Task {

    private Integer idTask;
    private String titleTask;
    private String descriptionTask;
    private Integer idEmployee;

    public Task() {
    }

    public Task(Integer idTask,String titleTask, String descriptionTask, Integer idIncidents, Integer idEmployee) {
        this.idTask = idTask;
        this.descriptionTask = descriptionTask;
        this.idEmployee = idEmployee;
        this.titleTask = titleTask;
    }

    public Integer getIdTask() {
        return idTask;
    }

    public void setIdTask(Integer idTask) {
        this.idTask = idTask;
    }

    public String getTitleTask() {
        return titleTask;
    }

    public void setTitleTask(String titleTask) {
        this.titleTask = titleTask;
    }
    
    public String getDescriptionTask() {
        return descriptionTask;
    }

    public void setDescriptionTask(String descriptionTask) {
        this.descriptionTask = descriptionTask;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

}
