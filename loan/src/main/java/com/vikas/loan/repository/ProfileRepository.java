package com.vikas.loan.repository;

import com.vikas.loan.entity.ProfileEntity;
import org.springframework.data.cassandra.repository.MapIdCassandraRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ProfileRepository extends MapIdCassandraRepository<ProfileEntity> {
    //
}
