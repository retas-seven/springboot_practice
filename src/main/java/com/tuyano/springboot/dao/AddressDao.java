package com.tuyano.springboot.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

import com.tuyano.springboot.entity.Address;

/**
 */
@Dao
@ConfigAutowireable
public interface AddressDao {

    /**
     * @param id
     * @return the Address entity
     */
    @Select
    Address selectById(String id);

    /**
     * @param id
     * @param version
     * @return the Address entity
     */
    @Select(ensureResult = true)
    Address selectByIdAndVersion(String id, Integer version);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Address entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Address entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Address entity);
    
	@Select
	List<Address> selectAll();
	
	@Select
	Integer selectMaxId();
	
    @Select(ensureResult = true)
    List<Address> selectByBelongUserEmail(String belongUserEmail);

}