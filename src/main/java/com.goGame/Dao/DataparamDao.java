package com.goGame.Dao;

import com.goGame.domain.Dataparam;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ravi on 3/7/17.
 */
public interface DataparamDao extends CrudRepository<Dataparam,Long> {

   /* @Query("SELECT dt.id FROM dataparam dt")
    Iterable<Long> findAllId();*/
   // custom query example and return a stream
   /*@Query("select c from Dataparam c where c.email = :email")
   Stream<Dataparam> findByEmailReturnStream(@Param("email") String email);*/
}
