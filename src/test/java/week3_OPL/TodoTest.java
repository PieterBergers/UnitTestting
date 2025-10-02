package week3_OPL;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TodoTest {
    private Todo todo = new Todo();

    @Test
    void addTask_EmptyOrNullTask_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> todo.addTask(null));
        assertThrows(IllegalArgumentException.class, () -> todo.addTask(""));
        assertThrows(IllegalArgumentException.class, () -> todo.addTask(" \t\n"));
    }

    @Test
    void addTask_TaskLengthIsAbove50_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> todo.addTask("xxxxxxxxx xxxxxxxxx xxxxxxxxx xxxxxxxxx xxxxxxxxx !!!"));
    }

    @Test
    void addTask_ValidTask_TaskIsAddedAndCorrectIdIsReturned() {
        assertEquals(1, todo.addTask("Buy milk"));
        assertEquals(2, todo.addTask("Buy eggs"));
    }

    @Test
    void getTasks_RetrievesImmutableCopyOfList() {
        todo.addTask("Buy milk");
        todo.addTask("Buy eggs");

        List<String> list1 = todo.getTasks();
        assertThrows(UnsupportedOperationException.class, () -> list1.add("Test"));
    }

    @Test
    void flagTaskAsDone_InvalidIndex_ThrowsException() {
        todo.addTask("Buy milk");
        assertThrows(IndexOutOfBoundsException.class, () -> todo.flagTaskAsDone(0));
        assertThrows(IndexOutOfBoundsException.class, () -> todo.flagTaskAsDone(2));
    }

    @Test
    void flagTaskAsDone_OtherTasksKeepTheirInternalIndex() {
        todo.addTask("Buy milk");
        todo.addTask("Buy eggs");

        todo.flagTaskAsDone(2);
        assertEquals(1, todo.getTasks().size());
        assertEquals("Buy milk", todo.getTasks().get(0));

        todo.flagTaskAsDone(1);
        assertEquals(0, todo.getTasks().size());
    }

    @Test
    void flagTaskAsDone_TaskWasDoneAlready_ThrowsException() {
        todo.addTask("Buy milk");
        todo.addTask("Buy eggs");

        todo.flagTaskAsDone(1);
        assertThrows(IllegalStateException.class, () -> todo.flagTaskAsDone(1));
    }
}