package org.narph.hstt.dao.hibernate;

import org.hibernate.SessionFactory;
import org.narph.hstt.dao.EventGroupDAO;
import org.narph.hstt.model.EventGroup;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ende
 * Date: 14.04.12
 * Time: 19:15
 */
@Repository
public class HibernateEventGroupDAO implements EventGroupDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int create(EventGroup _obj) throws DataAccessException {
        return 0;  //TODO change body of implemented methods.
    }

    public boolean delete(EventGroup _obj) throws DataAccessException {
        return false;  //TODO change body of implemented methods.
    }

    public boolean deleteById(String _id) throws DataAccessException {
        return false;  //TODO change body of implemented methods.
    }

    public EventGroup getById(String _id) throws DataAccessException {
        return null;  //TODO change body of implemented methods.
    }

    public List<EventGroup> getAll() throws DataAccessException {
        return null;  //TODO change body of implemented methods.
    }
}
