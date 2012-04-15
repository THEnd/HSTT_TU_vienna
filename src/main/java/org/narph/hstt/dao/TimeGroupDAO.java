package org.narph.hstt.dao;

import org.narph.hstt.model.TimeGroup;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ende
 * Date: 10.04.12
 * Time: 09:05
 */
public interface TimeGroupDAO extends DAO<TimeGroup> {

    /**
     * searches the TimeGroup and returns a List of Elements with the given TimeGroupType
     *  Types:
     *  @see TimeGroup.TimeGroupType
     * @param type
     * @return list of found TimeGroups
     * @throws DataAccessException
     */
    public List<TimeGroup> getByType(TimeGroup.TimeGroupType type) throws DataAccessException;
}
