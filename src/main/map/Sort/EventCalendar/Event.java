package main.map.Sort.EventCalendar;

public class Event {
    private String name;
    private String speaker;

    public Event(String name, String speaker) {
        this.name = name;
        this.speaker = speaker;
    }

    @Override
    public String toString() {
        return "Event: " + name + ", speaker - " + speaker;
    }
}
