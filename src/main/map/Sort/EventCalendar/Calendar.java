package main.map.Sort.EventCalendar;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Calendar {
    private Map<LocalDate, Event> calendar;

    public Calendar() {
        calendar = new HashMap<>();
    }
    public void addEvent(LocalDate date, String name, String speaker) {
        Event newEvent = new Event(name, speaker);
        calendar.put(date, newEvent);
    }

    public void showCalendar() {
        Map<LocalDate, Event> events = new TreeMap<>(calendar);
        System.out.println(events);
    }

    public void getNextEvent() {
        LocalDate currentDate = LocalDate.now();
        Map<LocalDate, Event> events = new TreeMap<>(calendar);

        for(Map.Entry<LocalDate, Event> entry : events.entrySet()) {
            LocalDate nextDate = entry.getKey();
            Event nextEvent = entry.getValue();
            if (nextDate.isEqual(currentDate) || nextDate.isAfter(currentDate)) {
                System.out.println("The next event " + nextEvent + " will happen in " + nextDate);
                break;
            }
        }
    }

    public static void main(String[] args) {
        Calendar calendar = new Calendar();

        calendar.addEvent(LocalDate.of(2022, 7, 15), "Event 1", "Speaker 1");
        calendar.addEvent(LocalDate.of(2022, 7, 9), "Event 2", "Speaker 2");
        calendar.addEvent(LocalDate.of(2000, 1, 11), "Event 3", "Speaker 3");
        calendar.addEvent(LocalDate.of(2023, 11, 8), "Event 4", "Speaker 4");

        calendar.showCalendar();

        calendar.getNextEvent();
    }
}
