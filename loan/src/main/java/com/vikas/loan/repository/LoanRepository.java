package com.vikas.loan.repository;

import com.vikas.loan.entity.LoanEntity;
import org.springframework.data.cassandra.repository.MapIdCassandraRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface LoanRepository extends MapIdCassandraRepository<LoanEntity> {
    //

    LoanEntity findByIdAndLobAndType(String profileId, String lob, String type);
}
