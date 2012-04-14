package org.narph.hstt.dao.hibernate;

import org.hibernate.SessionFactory;
import org.narph.hstt.dao.ResourceGroupDAO;
import org.narph.hstt.model.ResourceGroup;
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
public class HibernateResourceGroupDAO implements ResourceGroupDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int create(ResourceGroup _obj) throws DataAccessException {
        return 0;  //TODO change body of implemented methods.
    }

    public boolean delete(ResourceGroup _obj) throws DataAccessException {
        return false;  //TODO change body of implemented methods.
    }

    public boolean deleteById(String _id) throws DataAccessException {
        return false;  //TODO change body of implemented methods.
    }

    public ResourceGroup getById(String _id) throws DataAccessException {
        return null;  //TODO change body of implemented methods.
    }

    public List<ResourceGroup> getAll() throws DataAccessException {
        return null;  //TODO change body of implemented methods.
    }
}
