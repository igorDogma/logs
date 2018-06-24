package com.igor.rozhnev.logs.service;

import com.igor.rozhnev.logs.entity.Log;
import com.igor.rozhnev.logs.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class LogService {

    @Autowired
    private LogRepository logRepository;

    public Log saveLog(Log log){
        return logRepository.save(log);
    }
}
