package week3_OPL;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

record Task(String task, boolean done) {}

public class Todo {
    private final Map<Integer, Task> tasks = new HashMap<>();

    int addTask(String task) {
        if (task == null || task.trim().isEmpty()) {
            throw new IllegalArgumentException("Task cannot be null or empty.");
        }
        if (task.length() > 50) {
            throw new IllegalArgumentException("Task cannot be longer than 50 characters.");
        }
        tasks.put(tasks.size() + 1, new Task(task, false));

        return tasks.size();
    }

    List<String> getTasks() {
        return tasks.values().stream()
                .filter(t -> !t.done())
                .map(Task::task)
                .toList();
    }

    void flagTaskAsDone(int taskIndex) {
        if (!tasks.containsKey(taskIndex)) {
            throw new IndexOutOfBoundsException("Task index out of bounds.");
        }
        Task task = tasks.get(taskIndex);
        if (task.done()) {
            throw new IllegalStateException("Task is already marked as done.");
        }
        tasks.put(taskIndex, new Task(task.task(), true));
    }
}
