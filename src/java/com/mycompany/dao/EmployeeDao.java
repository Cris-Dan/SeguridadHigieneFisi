/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.factory.UserFactory;

import com.mycompany.models.Employee;
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
public class EmployeeDao implements Dao<Employee> {

    UserFactory uf = new UserFactory();

    @Override
    public Employee get(Integer id) {
        Employee employee = (Employee) uf.createUser("EMPLOYEE");
        String pa = "{call getEmployee(?)}";
        Connection cn = DBAccess.getInstance().getConnection();
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(pa);
                cs.setInt(1, id);
                ResultSet rs = cs.executeQuery();
                if (rs.next()) {
                    employee.setIdEmployee(rs.getInt("id"));
                    employee.setFirstname(rs.getString("firstname"));
                    employee.setLastname(rs.getString("lastname"));
                    employee.setPassword(rs.getString("password"));
                    employee.setEmail(rs.getString("email"));
                    employee.setAge(rs.getInt("age"));
                    employee.setGenre(rs.getString("genre"));
                    employee.setHealthCondition(rs.getString("healthCondition"));
                }
            } catch (SQLException ex) {
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return employee;
    }

    @Override
    public List<Employee> getAll() {
        ArrayList<Employee> lista = new ArrayList<>();
        String pa = "{CALL getAllEmployees()}";
        Connection cn = DBAccess.getInstance().getConnection();
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(pa);
                ResultSet rs = cs.executeQuery();
                while (rs.next()) {
                    Employee employee = (Employee) uf.createUser("EMPLOYEE");
                    employee.setIdEmployee(rs.getInt("id"));
                    employee.setFirstname(rs.getString("firstname"));
                    employee.setLastname(rs.getString("lastname"));
                    employee.setPassword(rs.getString("password"));
                    employee.setEmail(rs.getString("email"));
                    employee.setAge(rs.getInt("age"));
                    employee.setGenre(rs.getString("genre"));
                    employee.setHealthCondition(rs.getString("healthCondition"));
                    lista.add(employee);
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
    public void save(Employee t) {
        Connection cn = DBAccess.getInstance().getConnection();
        String pa = "{call saveEmploye(?,?,?,?,?,?,?)}";
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(pa);
                cs.setString(1, t.getFirstname());
                cs.setString(2, t.getLastname());
                cs.setString(3, t.getPassword());
                cs.setString(4, t.getEmail());
                cs.setInt(5, t.getAge());
                cs.setString(6, t.getGenre());
                cs.setString(7, t.getHealthCondition());
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
    public void update(Employee t) {
        Connection cn = DBAccess.getInstance().getConnection();
        String pa = "{Call updateEmployee(?,?,?,?,?,?,?,?)}";
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(pa);
                cs.setInt(1, t.getIdEmployee());
                cs.setString(2, t.getFirstname());
                cs.setString(3, t.getLastname());
                cs.setString(4, t.getPassword());
                cs.setString(5, t.getEmail());
                cs.setInt(6, t.getAge());
                cs.setString(7, t.getGenre());
                cs.setString(8, t.getHealthCondition());
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
        String pa = "{call deleteEmployee(?)}";
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
