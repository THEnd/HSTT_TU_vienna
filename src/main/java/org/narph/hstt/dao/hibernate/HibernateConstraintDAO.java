package org.narph.hstt.dao.hibernate;

import org.hibernate.SessionFactory;
import org.narph.hstt.dao.ConstraintDAO;
import org.narph.hstt.model.Constraint;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ende
 * Date: 14.04.12
 * Time: 19:13
 */
@Repository
public class HibernateConstraintDAO implements ConstraintDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int create(Constraint _obj) throws DataAccessException {
        return 0;  //TODO change body of implemented methods.
    }

    public boolean delete(Constraint _obj) throws DataAccessException {
        return false;  //TODO change body of implemented methods.
    }

    public boolean deleteById(String _id) throws DataAccessException {
        return false;  //TODO change body of implemented methods.
    }

    public Constraint getById(String _id) throws DataAccessException {
        return null;  //TODO change body of implemented methods.
    }

    public List<Constraint> getAll() throws DataAccessException {
        return null;  //TODO change body of implemented methods.
    }
}
