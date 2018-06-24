package com.igor.rozhnev.logs.controller;

import com.igor.rozhnev.logs.entity.Entry;
import com.igor.rozhnev.logs.service.EntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class LogController {

    private final EntryService entryService;

    @GetMapping("/logs/{label}")
    public List<Entry> getLogsForLabel(@PathVariable String label,
                           @PageableDefault(size = 100) Pageable pageable) {
        return entryService.getEntriesByLogLabel(label, pageable);
    }

    @PostMapping("/logs/{label}/entries")
    public List<Entry> saveEntriesForLabel(@PathVariable String label,
                                 @Valid @RequestBody List<Entry> beans) {
        return entryService.addEntries(label, beans);
    }
}
