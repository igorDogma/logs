package com.igor.rozhnev.logs.service;

import com.igor.rozhnev.logs.entity.Entry;
import com.igor.rozhnev.logs.entity.Log;
import com.igor.rozhnev.logs.repository.EntryRepository;
import com.igor.rozhnev.logs.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EntryService{

    @Autowired
    private EntryRepository entryRepository;

    @Autowired
    private LogRepository logRepository;

    @Transactional
    public List<Entry> addEntries(String label, List<Entry> entries) {
        Log log = logRepository.findByLabel(label);
        if (log == null) {
            log = new Log();
            log.setLabel(label);
            logRepository.saveAndFlush(log);
        }
        for (Entry entry : entries){
            entry.setLog(log);
            entry.setTimestamp(new Date());
            entryRepository.saveAndFlush(entry);
        }
        return entries;
    }

    public List<Entry> getEntriesByLogLabel(String label, Pageable pageable) {
        Log log = logRepository.findByLabel(label);
        return entryRepository.findByLog(log, pageable);
    }

}
