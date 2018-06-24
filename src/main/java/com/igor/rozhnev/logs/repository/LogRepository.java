package com.igor.rozhnev.logs.repository;

import com.igor.rozhnev.logs.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface LogRepository extends JpaRepository<Log, Long>{

    @Transactional(readOnly = true)
    Log findByLabel(@Param("label") String label);
}
