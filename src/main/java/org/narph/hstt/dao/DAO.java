package org.narph.hstt.dao;

import org.springframework.dao.DataAccessException;

import java.io.Serializable;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ende
 * Date: 05.04.12
 * Time: 14:44
 */
public interface DAO<T extends Serializable> {

    public int create(T _obj) throws DataAccessException;

    public int update(T _obj) throws DataAccessException;

    public boolean delete(T _obj) throws DataAccessException;

    public boolean deleteById(String _id) throws DataAccessException;

    public T getById(String _id) throws DataAccessException;

    public List<T> getAll() throws DataAccessException;

}
