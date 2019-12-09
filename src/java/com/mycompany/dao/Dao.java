/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import java.util.List;


/**
 *
 * @author cristian
 */
public interface Dao<T> {

    T get(Integer id);

    List<T> getAll();

    void save(T t);

    void update(T t);

    void delete(Integer id);
}
