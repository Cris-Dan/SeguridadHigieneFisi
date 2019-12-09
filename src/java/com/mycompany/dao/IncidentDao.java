/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.models.Incident;
import com.mycompany.singleton.DBAccess;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cristian
 */
public class IncidentDao implements Dao<Incident> {

    @Override
    public Incident get(Integer id) {
        Incident incident = new Incident();
        String pa = "{call getIncident(?)}";
        Connection cn = DBAccess.getInstance().getConnection();
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(pa);
                cs.setInt(1, id);
                ResultSet rs = cs.executeQuery();
                if (rs.next()) {
                    incident.setIdIncident(rs.getInt("id"));
                    incident.setIdTask(rs.getInt("idTask"));
                    incident.setDescriptionIncident(rs.getString("descriptionIncident"));
                    incident.setIncidentType(rs.getString("incidentType"));

                }
            } catch (SQLException ex) {
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return incident;
    }

    @Override
    public List<Incident> getAll() {
        ArrayList<Incident> lista = new ArrayList<>();
        String pa = "{CALL getAllIncidents()}";
        Connection cn = DBAccess.getInstance().getConnection();
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(pa);
                ResultSet rs = cs.executeQuery();
                while (rs.next()) {
                    Incident incident = new Incident();
                    incident.setIdIncident(rs.getInt("id"));
                    incident.setIdTask(rs.getInt("idTask"));
                    incident.setDescriptionIncident(rs.getString("descriptionIncident"));
                    incident.setIncidentType(rs.getString("incidentType"));
                    lista.add(incident);
                }
            } catch (SQLException ex) {
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return lista;
    }

    @Override
    public void save(Incident t) {
        Connection cn = DBAccess.getInstance().getConnection();
        String pa = "{call saveIncident(?,?,?)}";
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(pa);

                cs.setString(1, t.getDescriptionIncident());
                cs.setString(2, t.getIncidentType());
                cs.setInt(3, t.getIdTask());

                cs.executeUpdate();
            } catch (SQLException e) {

            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public void update(Incident t) {
        Connection cn = DBAccess.getInstance().getConnection();
        String pa = "{Call updateIncident(?,?,?,?)}";
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(pa);
                cs.setInt(1, t.getIdIncident());
                cs.setString(2, t.getDescriptionIncident());
                cs.setString(3, t.getIncidentType());
                cs.setInt(4, t.getIdTask());
                cs.executeUpdate();
            } catch (SQLException e) {

            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {

                }
            }
        }
    }

    @Override
    public void delete(Integer id) {
        Connection cn = DBAccess.getInstance().getConnection();
        String pa = "{call deleteIncident(?)}";
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(pa);
                cs.setInt(1, id);
                cs.executeUpdate();

            } catch (SQLException e) {

            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

}
