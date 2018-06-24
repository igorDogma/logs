package com.igor.rozhnev.logs.service;

import com.igor.rozhnev.logs.TestApplicationConfiguration;
import com.igor.rozhnev.logs.entity.Entry;
import com.igor.rozhnev.logs.entity.Log;
import com.igor.rozhnev.logs.repository.EntryRepository;
import com.igor.rozhnev.logs.repository.LogRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)

public class EntryServiceTest {

    @Autowired
    private LogRepository logRepository;

    @Autowired
    private EntryRepository entryRepository;

    private final static String label = "abcde";

    @Before
    public void before(){
        Log log = new Log();
        log.setLabel(label);
        logRepository.save(log);
    }

    @Test
    public void addEntries(){
        Log log = logRepository.findByLabel(label);
        Assert.assertNotNull(log);

        Entry entry = new Entry();
        entry.setTimestamp(new Date());
        entry.setData("Data");
        entry.setLog(log);
        Assert.assertNotNull(entryRepository.save(entry));
    }

    @Test
    public void getEntriesByLabel(){
        Log log = logRepository.findByLabel(label);
        initEntries(log);
        Pageable page = new PageRequest(0, 100);
        List<Entry> entryPages = entryRepository.findByLog(log, page);

        for (Entry entry : entryPages) {
            System.err.println(entry.getTimestamp());
        }
    }

    private void initEntries(Log log){
        for(int i =0; i < 200; i++){
            Entry entry = new Entry();
            entry.setTimestamp(new Date());
            entry.setData("Data");
            entry.setLog(log);
            entryRepository.save(entry);
        }
    }

    @After
    public void deleteAll(){
        entryRepository.deleteAll(entryRepository.findAll());
        logRepository.delete(logRepository.findByLabel(label));
    }
}
