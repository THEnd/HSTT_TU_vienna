package org.narph.hstt.dao.hibernate;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.narph.hstt.dao.InstanceDAO;
import org.narph.hstt.model.Instance;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ende
 * Date: 14.04.12
 * Time: 18:24
 */
@Repository
public class HibernateInstanceDAO implements InstanceDAO {

    private static final Logger LOGGER = Logger.getLogger("hstt_dao");

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int create(Instance _obj) throws DataAccessException {
        LOGGER.debug("try saving " + _obj);
        Session session = sessionFactory.getCurrentSession();
        session.save(_obj);
        return 0;  //TODO change body of implemented methods.
    }

    public boolean delete(Instance _obj) throws DataAccessException {
        return false;  //TODO change body of implemented methods.
    }

    public boolean deleteById(String _id) throws DataAccessException {
        return false;  //TODO change body of implemented methods.
    }

    public Instance getById(String _id) throws DataAccessException {
        return null;  //TODO change body of implemented methods.
    }

    public List<Instance> getAll() throws DataAccessException {
        return null;  //TODO change body of implemented methods.
    }
}
