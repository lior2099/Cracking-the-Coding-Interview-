package stacks.testing;

import static org.junit.Assert.*;

import stacks.QueueviaStacks;
import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

public class QueueviaStacksTest {

    private QueueviaStacks<Integer> queue;

    @Before
    public void setUp() {
        queue = new QueueviaStacks<>();
    }

    @Test
    public void testAddAndSize() {
        // Adding elements to the queue
        queue.add(1);
        queue.add(2);
        queue.add(3);

        // Check if size is correct
        assertEquals(3, queue.size());
    }

    @Test
    public void testPeek() {
        // Adding elements to the queue
        queue.add(1);
        queue.add(2);
        queue.add(3);

        // Peek should return the first element in the queue (1)
        assertEquals(Integer.valueOf(1), queue.peek());
    }

    @Test
    public void testRemove() {
        // Adding elements to the queue
        queue.add(1);
        queue.add(2);
        queue.add(3);

        // Remove should return the first element (1)
        assertEquals(Integer.valueOf(1), queue.remove());

        // Check if size is reduced correctly
        assertEquals(2, queue.size());

        // Remove the second element (2)
        assertEquals(Integer.valueOf(2), queue.remove());

        // Check if size is reduced again
        assertEquals(1, queue.size());
    }

    @Test
    public void testEmptyQueue() {
        // Attempting to peek or remove from an empty queue should not throw exceptions
        assertThrows(EmptyStackException.class, () -> {
            queue.peek();
        });

        assertThrows(EmptyStackException.class, () -> {
            queue.remove();
        });
    }

    @Test
    public void testQueueOrder() {
        // Adding elements to the queue
        queue.add(1);
        queue.add(2);
        queue.add(3);

        // Remove elements and check if they come out in the correct order
        assertEquals(Integer.valueOf(1), queue.remove());
        assertEquals(Integer.valueOf(2), queue.remove());
        assertEquals(Integer.valueOf(3), queue.remove());
    }
}
