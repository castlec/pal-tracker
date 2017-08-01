package io.pivotal.pal.tracker;

import java.util.*;


/**
 * Created by accenturelabs on 8/1/17.
 */
public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private Map<Long, TimeEntry> timeEntries = new HashMap<>();
    long lastId;


    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(++lastId);
        timeEntries.put(timeEntry.getId(), timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry find(Long id) {
        return timeEntries.get(id);

    }

    @Override
    public List<TimeEntry> list() {
        Collection<TimeEntry> values = timeEntries.values();
        return new ArrayList<>(values);

    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
        timeEntry.setId(id);
        timeEntries.put(timeEntry.getId(), timeEntry);
        return timeEntry;
    }

    @Override
    public void delete(Long id) {
        timeEntries.remove(id);
    }
}
