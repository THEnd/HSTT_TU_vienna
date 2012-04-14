package org.narph.hstt.dao.hibernate;

import org.hibernate.SessionFactory;
import org.narph.hstt.dao.AssignmentDAO;
import org.narph.hstt.model.Assignment;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ende
 * Date: 14.04.12
 * Time: 19:12
 */
@Repository
public class HibernateAssignmentDAO implements AssignmentDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int create(Assignment _obj) throws DataAccessException {
        return 0;  //TODO change body of implemented methods.
    }

    public boolean delete(Assignment _obj) throws DataAccessException {
        return false;  //TODO change body of implemented methods.
    }

    public boolean deleteById(String _id) throws DataAccessException {
        return false;  //TODO change body of implemented methods.
    }

    public Assignment getById(String _id) throws DataAccessException {
        return null;  //TODO change body of implemented methods.
    }

    public List<Assignment> getAll() throws DataAccessException {
        return null;  //TODO change body of implemented methods.
    }
}
