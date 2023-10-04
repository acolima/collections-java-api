package main.set.Search.TaskList;

import java.util.Objects;

public class Task {
    private String description;
    private boolean done;

    public Task(String description) {
        this.description = description;
        this.done = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "{ Task: " + description + ", done: " + done + " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return Objects.equals(getDescription(), task.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription());
    }
}
