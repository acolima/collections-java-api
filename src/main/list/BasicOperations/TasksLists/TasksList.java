package main.list.BasicOperations.TasksLists;

import java.util.ArrayList;
import java.util.List;

public class TasksList {
    private List<Task> tasksList;

    public TasksList() {
        tasksList = new ArrayList<>();
    }

    public void addTask(String description) {
        tasksList.add(new Task(description));
    }

    public void removeTask(String description) {
        List<Task> tasksToRemove = new ArrayList<>();

        for(Task t: tasksList){
            if(t.getDescription().equalsIgnoreCase(description)) {
                tasksToRemove.add(t);
            }
        }

        tasksList.removeAll(tasksToRemove);
    }

    public int getNumberOfTasks() {
        return tasksList.size();
    }

    public void getTasks() {
        System.out.println(tasksList);
    }

    public static void main(String[] args) {
        TasksList tasksList = new TasksList();
        System.out.println(tasksList.getNumberOfTasks());

        tasksList.addTask("Task 1");
        tasksList.addTask("Task 1");
        tasksList.addTask("Task 2");
        System.out.println(tasksList.getNumberOfTasks());

        tasksList.removeTask("Task 2");
        System.out.println(tasksList.getNumberOfTasks());

        tasksList.getTasks();
    }
}
