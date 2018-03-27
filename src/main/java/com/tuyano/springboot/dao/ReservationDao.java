package com.tuyano.springboot.dao;

import com.tuyano.springboot.entity.Reservation;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@Dao
public interface ReservationDao {

    /**
     * @param id
     * @return the Reservation entity
     */
    @Select
    Reservation selectById(String id);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Reservation entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Reservation entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Reservation entity);
}