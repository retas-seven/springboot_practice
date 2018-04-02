package com.tuyano.springboot.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

import com.tuyano.springboot.entity.UserInfo;

/**
 */
@Dao
@ConfigAutowireable
public interface UserInfoDao {

    /**
     * @param id
     * @return the UserInfo entity
     */
    @Select
    UserInfo selectById(String id);

    /**
     * @param id
     * @param version
     * @return the UserInfo entity
     */
    @Select(ensureResult = true)
    UserInfo selectByIdAndVersion(String id, Integer version);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(UserInfo entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(UserInfo entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(UserInfo entity);
    
    @Select
    UserInfo selectByEmail(String email);
}