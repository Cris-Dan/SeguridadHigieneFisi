/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.factory.UserFactory;
import com.mycompany.models.Administrator;
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
public class AdministratorDao implements Dao<Administrator> {

    UserFactory uf = new UserFactory();

    @Override
    public Administrator get(Integer id) {
        Administrator administrator = (Administrator) uf.createUser("ADMINISTRATOR");
        String pa = "{call getAdministrator(?)}";
        Connection cn = DBAccess.getInstance().getConnection();
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(pa);
                cs.setInt(1, id);
                ResultSet rs = cs.executeQuery();
                if (rs.next()) {
                    administrator.setIdAdministrator(rs.getInt("id"));
                    administrator.setFirstname(rs.getString("firstname"));
                    administrator.setLastname(rs.getString("lastname"));
                    administrator.setPassword(rs.getString("password"));
                    administrator.setEmail(rs.getString("email"));
                    administrator.setDni(rs.getInt("dni"));
                    administrator.setDireccion(rs.getString("direccion"));
                }
            } catch (SQLException ex) {
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return administrator;
    }

    @Override
    public List<Administrator> getAll() {
        ArrayList<Administrator> lista = new ArrayList<>();
        String pa = "{CALL getAllAdministrators()}";
        Connection cn = DBAccess.getInstance().getConnection();
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(pa);
                ResultSet rs = cs.executeQuery();
                while (rs.next()) {
                    Administrator administrator = (Administrator) uf.createUser("ADMINISTRATOR");
                    administrator.setIdAdministrator(rs.getInt("id"));
                    administrator.setFirstname(rs.getString("firstname"));
                    administrator.setLastname(rs.getString("lastname"));
                    administrator.setPassword(rs.getString("password"));
                    administrator.setEmail(rs.getString("email"));
                    administrator.setDni(rs.getInt("dni"));
                    administrator.setDireccion(rs.getString("direccion"));
                    lista.add(administrator);
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
    public void save(Administrator t) {

        Connection cn = DBAccess.getInstance().getConnection();
        String pa = "{call saveAdministrator(?,?,?,?,?,?)}";
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(pa);
                cs.setString(1, t.getFirstname());
                cs.setString(2, t.getLastname());
                cs.setString(3, t.getPassword());
                cs.setString(4, t.getEmail());
                cs.setString(5, String.valueOf(t.getDni()));
                cs.setString(6, t.getDireccion());
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
    public void update(Administrator t) {

        Connection cn = DBAccess.getInstance().getConnection();
        String pa = "{call updateAdministrator(?,?,?,?,?,?,?)}";
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(pa);
                cs.setInt(1, t.getIdAdministrator());
                cs.setString(2, t.getFirstname());
                cs.setString(3, t.getLastname());
                cs.setString(4, t.getPassword());
                cs.setString(5, t.getEmail());
                cs.setString(6, String.valueOf(t.getDni()));
                cs.setString(7, t.getDireccion());
                cs.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        }

    }

    @Override
    public void delete(Integer id) {

        Connection cn = DBAccess.getInstance().getConnection();
        String pa = "{call deleteAdministrator(?)}";
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
