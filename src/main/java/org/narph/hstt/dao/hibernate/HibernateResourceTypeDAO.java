package org.narph.hstt.dao.hibernate;

import org.hibernate.SessionFactory;
import org.narph.hstt.dao.ResourceTypeDAO;
import org.narph.hstt.model.ResourceType;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ende
 * Date: 14.04.12
 * Time: 19:17
 */
@Repository
public class HibernateResourceTypeDAO implements ResourceTypeDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int create(ResourceType _obj) throws DataAccessException {
        return 0;  //TODO change body of implemented methods.
    }

    public boolean delete(ResourceType _obj) throws DataAccessException {
        return false;  //TODO change body of implemented methods.
    }

    public boolean deleteById(String _id) throws DataAccessException {
        return false;  //TODO change body of implemented methods.
    }

    public ResourceType getById(String _id) throws DataAccessException {
        return null;  //TODO change body of implemented methods.
    }

    public List<ResourceType> getAll() throws DataAccessException {
        return null;  //TODO change body of implemented methods.
    }
}
