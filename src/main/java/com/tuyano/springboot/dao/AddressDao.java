package com.tuyano.springboot.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import com.tuyano.springboot.entity.Address;

@ConfigAutowireable
@Dao
public interface AddressDao {

	@Select
	List<Address> selectAll();
	
	@Select
	Integer selectMaxId();
	
	@Insert
	int insert(Address address);
}
