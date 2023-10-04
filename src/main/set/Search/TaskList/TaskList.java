package main.set.Search.TaskList;

import java.util.HashSet;
import java.util.Set;

public class TaskList {
    private Set<Task> taskList;

    public TaskList() {
        taskList = new HashSet<>();
    }

    public void addTask(String description) {
        Task newTask = new Task(description);
        taskList.add(newTask);
    }

    public void removeTask(String description) {
        boolean taskFound = false;
        if(!taskList.isEmpty()){
            for(Task t : taskList) {
                if(t.getDescription().equalsIgnoreCase(description)) {
                    taskList.remove(t);
                    taskFound = true;
                    break;
                }
            }
        } else {
            System.out.println("The list is empty");
            return;
        }

        if(!taskFound) {
            System.out.println("Task not found");
        }
    }

    public void displayTasks() {
        if(!taskList.isEmpty()) {
            System.out.println(taskList);
        } else {
            System.out.println("The list is empty");
        }
    }

    public int getNumberOfTasks() {
        return taskList.size();
    }

    public Set<Task> getDoneTasks() {
        Set<Task> doneTasks = new HashSet<>();

        for(Task t : taskList) {
            if(t.isDone()) {
                doneTasks.add(t);
            }
        }

        return doneTasks;
    }

    public Set<Task> getTodoTasks() {
        Set<Task> todoTasks = new HashSet<>();

        for(Task t : taskList) {
            if(!t.isDone()) {
                todoTasks.add(t);
            }
        }

        return todoTasks;
    }

    public void markTaskAsDone(String description) {
        boolean taskFound = false;

        for(Task t : taskList) {
            if(t.getDescription().equalsIgnoreCase(description)) {
                t.setDone(true);
                taskFound = true;
                break;
            }
        }

        if(!taskFound) {
            System.out.println("Task " + description + " not found");
        }
    }

    public void markTaskTodo(String description) {
        boolean taskFound = false;

        for(Task t : taskList) {
            if(t.getDescription().equalsIgnoreCase(description)) {
                t.setDone(false);
                taskFound = true;
                break;
            }
        }

        if(!taskFound) {
            System.out.println("Task " + description + " not found");
        }
    }

    public void cleanList() {
        taskList.clear();
    }


    public static void main(String[] args) {
        TaskList taskList = new TaskList();

        taskList.addTask("Task 1");
        taskList.addTask("Task 1");
        taskList.addTask("Task 2");
        taskList.addTask("Task 3");
        taskList.addTask("Task 4");

        System.out.println("TASK-LIST");
        taskList.displayTasks();

        System.out.println("Number of tasks: " + taskList.getNumberOfTasks());

        System.out.println("\nRemoving Task 1");
        taskList.removeTask("Task 1");
        taskList.displayTasks();

        System.out.println("\nRemoving Task 5 (doesn't exist)");
        taskList.removeTask("Task 5");
        taskList.displayTasks();

        System.out.println("\nMarking tasks as done");
        taskList.markTaskAsDone("Task 2");
        taskList.markTaskAsDone("Task 3");
        taskList.markTaskAsDone("Task 5");
        taskList.displayTasks();

        System.out.println("\nMarking tasks to-do");
        taskList.markTaskTodo("Task 2");
        taskList.displayTasks();

        System.out.println("\nDone tasks: \n" + taskList.getDoneTasks());
        System.out.println("\nTo-do tasks: \n" + taskList.getTodoTasks());

        System.out.println("\nReset task-list");
        taskList.cleanList();
        taskList.displayTasks();
    }
}
