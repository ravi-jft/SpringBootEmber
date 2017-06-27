package com.goGame.Dao;

import com.goGame.domain.Event;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ravi on 27/6/17.
 */
public interface EventDao extends CrudRepository<Event,Long> {

}
