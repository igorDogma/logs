package com.igor.rozhnev.logs.repository;

import com.igor.rozhnev.logs.entity.Entry;
import com.igor.rozhnev.logs.entity.Log;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {

    @Transactional(readOnly = true)
    List<Entry> findByLog(Log log, Pageable pageable);
}
