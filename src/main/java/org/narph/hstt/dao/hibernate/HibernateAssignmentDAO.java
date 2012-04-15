package org.narph.hstt.dao.hibernate;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.narph.hstt.dao.AssignmentDAO;
import org.narph.hstt.model.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ende
 * Date: 14.04.12
 * Time: 19:12
 */
@Repository
@Transactional
public class HibernateAssignmentDAO implements AssignmentDAO {

    private static final Logger LOGGER = Logger.getLogger("hstt_dao");

    @Autowired
    private SessionFactory sessionFactory;

    public int create(Assignment _obj) throws DataAccessException {
        LOGGER.debug("try saving " + _obj);
        try {
            Session session = sessionFactory.getCurrentSession();
            session.save(_obj);
            session.flush();
            return 1;
        } catch (Exception e) {
            LOGGER.error("could not save " + _obj + ", " + e);
        }
        return 0;
    }

    public int update(Assignment _obj) throws DataAccessException {
        LOGGER.debug("try updating " + _obj);
        try {
            Session session = sessionFactory.getCurrentSession();
            session.update(_obj);
            session.flush();
            return 1;
        } catch (Exception e) {
            LOGGER.error("could not update " + _obj + ", " + e);
        }
        return 0;
    }

    public boolean delete(Assignment _obj) throws DataAccessException {
        LOGGER.debug("try deleting " + _obj);
        try {
            Session session = sessionFactory.getCurrentSession();
            session.delete(_obj);
            return true;
        } catch (Exception e) {
            LOGGER.error("could not delete " + _obj);
        }
        return false;
    }

    public boolean deleteById(String _id) throws DataAccessException {
        return delete(getById(_id));
    }

    public Assignment getById(String _id) throws DataAccessException {
        LOGGER.debug("try searching " + _id);
        try {
            Session session = sessionFactory.getCurrentSession();
            return (Assignment) session.get(Assignment.class,_id);
        } catch (Exception e) {
            LOGGER.error("could not search " + _id);
        }
        return null;
    }

    public List<Assignment> getAll() throws DataAccessException {
        LOGGER.debug("try searching all");
        try {
            Session session = sessionFactory.getCurrentSession();
            List<Assignment> result = session.createCriteria(Assignment.class).list();
            return result;
        } catch (Exception e) {
            LOGGER.error("could not search all");
        }
        return null;
    }
}
