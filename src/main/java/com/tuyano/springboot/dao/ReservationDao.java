package com.tuyano.springboot.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import com.tuyano.springboot.entity.Reservation;

@ConfigAutowireable
@Dao
public interface ReservationDao {

	@Select
	List<Reservation> selectAll();
}
