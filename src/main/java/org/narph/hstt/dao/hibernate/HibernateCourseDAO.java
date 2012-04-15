package org.narph.hstt.dao.hibernate;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.narph.hstt.dao.CourseDAO;
import org.narph.hstt.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ende
 * Date: 14.04.12
 * Time: 19:19
 */
@Repository
@Transactional
public class HibernateCourseDAO implements CourseDAO {

    private static final Logger LOGGER = Logger.getLogger("hstt_dao");

    @Autowired
    private SessionFactory sessionFactory;

    public int create(Course _obj) throws DataAccessException {
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

    public int update(Course _obj) throws DataAccessException {
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

    public boolean delete(Course _obj) throws DataAccessException {
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

    public Course getById(String _id) throws DataAccessException {
        LOGGER.debug("try searching " + _id);
        try {
            Session session = sessionFactory.getCurrentSession();
            return (Course) session.get(Course.class,_id);
        } catch (Exception e) {
            LOGGER.error("could not search " + _id);
        }
        return null;
    }

    public List<Course> getAll() throws DataAccessException {
        LOGGER.debug("try searching all");
        try {
            Session session = sessionFactory.getCurrentSession();
            List<Course> result = session.createCriteria(Course.class).list();
            return result;
        } catch (Exception e) {
            LOGGER.error("could not search all");
        }
        return null;
    }
}
