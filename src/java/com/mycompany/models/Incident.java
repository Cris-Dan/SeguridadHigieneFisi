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
public class Incident {

    private Integer idIncident;
    private String descriptionIncident;
    private String IncidentType;
    private Integer idTask;

    public Incident() {
    }

    public Incident(Integer idIncident, String descriptionIncident, String IncidentType, Integer idTask) {
        this.idIncident = idIncident;
        this.descriptionIncident = descriptionIncident;
        this.idTask = idTask;
        this.IncidentType = IncidentType;
    }

    public String getIncidentType() {
        return IncidentType;
    }

    public void setIncidentType(String IncidentType) {
        this.IncidentType = IncidentType;
    }

    public Integer getIdIncident() {
        return idIncident;
    }

    public void setIdIncident(Integer idIncident) {
        this.idIncident = idIncident;
    }

    public String getDescriptionIncident() {
        return descriptionIncident;
    }

    public void setDescriptionIncident(String descriptionIncident) {
        this.descriptionIncident = descriptionIncident;
    }

    public Integer getIdTask() {
        return idTask;
    }

    public void setIdTask(Integer idTask) {
        this.idTask = idTask;
    }

}
