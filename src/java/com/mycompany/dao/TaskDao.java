/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.models.Task;
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
public class TaskDao implements Dao<Task> {

    @Override
    public Task get(Integer id) {
        Task task = new Task();
        String pa = "{call getTask(?)}";
        Connection cn = DBAccess.getInstance().getConnection();
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(pa);
                cs.setInt(1, id);
                ResultSet rs = cs.executeQuery();
                if (rs.next()) {
                    task.setIdTask(rs.getInt("id"));
                    task.setTitleTask(rs.getString("titleTask"));
                    task.setDescriptionTask(rs.getString("descriptionTask"));
                    task.setIdEmployee(rs.getInt("idEmployee"));
                }
            } catch (SQLException ex) {
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return task;
    }

    @Override
    public List<Task> getAll() {
        ArrayList<Task> lista = new ArrayList<>();
        String pa = "{CALL getAllTasks()}";
        Connection cn = DBAccess.getInstance().getConnection();
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(pa);
                ResultSet rs = cs.executeQuery();
                while (rs.next()) {
                    Task task = new Task();
                    task.setIdTask(rs.getInt("id"));
                    task.setTitleTask(rs.getString("titleTask"));
                    task.setDescriptionTask(rs.getString("descriptionTask"));
                    task.setIdEmployee(rs.getInt("idEmployee"));
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
    public void save(Task t) {
        Connection cn = DBAccess.getInstance().getConnection();
        String pa = "{call saveTask(?,?,?)}";
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(pa);
                cs.setString(1, t.getTitleTask());
                cs.setString(2, t.getDescriptionTask());
                cs.setInt(3, t.getIdEmployee());
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
    public void update(Task t) {
        Connection cn = DBAccess.getInstance().getConnection();
        String pa = "{Call updateTask(?,?,?,?)}";
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(pa);
                cs.setInt(1, t.getIdTask());
                cs.setString(2, t.getTitleTask());
                cs.setString(3, t.getDescriptionTask());
                cs.setInt(4, t.getIdEmployee());
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
        String pa = "{call deleteTask(?)}";
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
