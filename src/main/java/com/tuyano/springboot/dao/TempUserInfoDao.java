package com.tuyano.springboot.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

import com.tuyano.springboot.entity.TempUserInfo;

/**
 */
@Dao
@ConfigAutowireable
public interface TempUserInfoDao {

    /**
     * @param id
     * @return the TempUserInfo entity
     */
    @Select
    TempUserInfo selectById(Integer id);

    /**
     * @param id
     * @param version
     * @return the TempUserInfo entity
     */
    @Select(ensureResult = true)
    TempUserInfo selectByIdAndVersion(Integer id, Integer version);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(TempUserInfo entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(TempUserInfo entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(TempUserInfo entity);

    @Select
    TempUserInfo selectByAuthKey(String authKey);
}