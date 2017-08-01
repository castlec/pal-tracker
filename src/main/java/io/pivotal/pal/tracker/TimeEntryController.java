package io.pivotal.pal.tracker;

import io.pivotal.pal.tracker.TimeEntry;
import io.pivotal.pal.tracker.TimeEntryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by accenturelabs on 8/1/17.
 */
@RestController
public class TimeEntryController {
    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity<>(timeEntryRepository.list(), HttpStatus.OK);
    }

    public ResponseEntity update(long l, TimeEntry expected) {
        TimeEntry timeEntry = timeEntryRepository.update(l, expected);
        HttpStatus status = timeEntry == null ? HttpStatus.NOT_FOUND: HttpStatus.OK;
        return new ResponseEntity<>(timeEntry, status);
    }

    public ResponseEntity<TimeEntry> delete(long l) {
        timeEntryRepository.delete(l);
        return new ResponseEntity<TimeEntry>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<TimeEntry> read(long l) {
        TimeEntry timeEntry = timeEntryRepository.find(l);
        HttpStatus status = timeEntry == null ? HttpStatus.NOT_FOUND: HttpStatus.OK;
        return new ResponseEntity<>(timeEntry, status);
    }

    public ResponseEntity create(TimeEntry today) {
        return new ResponseEntity<>(timeEntryRepository.create(today), HttpStatus.CREATED);
    }
}
