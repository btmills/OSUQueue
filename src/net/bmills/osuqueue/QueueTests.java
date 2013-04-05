package net.bmills.osuqueue;

import static org.junit.Assert.*;
import org.junit.Test;
import net.bmills.osuqueue.Queue;

public class QueueTests {

	@Test
	public void testConstructor() {
		Queue<String> q = new Queue<String>();
		assertEquals(0, q.Size());
	}
	
	@Test
	public void testSize() {
		Queue<String> q = new Queue<String>();
		assertEquals(0, q.Size());
		q.Enqueue("hello");
		assertEquals(1, q.Size());
		q.Enqueue("world");
		q.Peek();
		assertEquals(2, q.Size());
		q.Remove("hello");
		assertEquals(1, q.Size());
		q.Dequeue();
		assertEquals(0, q.Size());
	}
	
	@Test
	public void testEnqueue() {
		Queue<String> q = new Queue<String>();
		assertEquals(true, q.Enqueue("hello"));
		assertEquals(1, q.Size());
		assertEquals(true, q.Enqueue("world"));
		assertEquals(2, q.Size());
	}
	
	@Test
	public void testUnique() {
		Queue<String> q = new Queue<String>();
		assertEquals(true, q.Enqueue("hello"));
		assertEquals(1, q.Size());
		assertEquals(false, q.Enqueue("hello"));
		assertEquals(1, q.Size());
		q.Remove("hello");
		assertEquals(0, q.Size());
		assertEquals(true, q.Enqueue("hello"));
	}
	
	@Test
	public void testPeek() {
		Queue<String> q = new Queue<String>();
		try {
			q.Peek();
			fail();
		} catch (IllegalStateException e) {
			assertEquals("Cannot Peek an empty queue.", e.getMessage());
		} catch (Exception e) {
			fail();
		}
		q.Enqueue("hello");
		assertEquals("hello", q.Peek());
		q.Enqueue("world");
		assertEquals("hello", q.Peek());
	}
	
	@Test
	public void testDequeue() {
		Queue<String> q = new Queue<String>();
		try {
			q.Dequeue();
			fail();
		} catch (IllegalStateException e) {
			assertEquals("Cannot Dequeue from an empty queue.", e.getMessage());
		} catch (Exception e) {
			fail();
		}
		q.Enqueue("hello");
		q.Enqueue("world");
		assertEquals("hello", q.Dequeue());
		assertEquals("world", q.Dequeue());
	}
	
	@Test
	public void testRemove() {
		Queue<String> q = new Queue<String>();
		q.Enqueue("hello");
		assertEquals(1, q.Size());
		assertEquals(false, q.Remove("world"));
		assertEquals(1, q.Size());
		assertEquals(true, q.Remove("hello"));
		assertEquals(0, q.Size());
	}
	
	@Test
	public void testPosition() {
		Queue<String> q = new Queue<String>();
		q.Enqueue("let's");
		q.Enqueue("go");
		q.Enqueue("bucks");
		assertEquals(-1, q.Position("hello"));
		assertEquals(0, q.Position("let's"));
		assertEquals(2, q.Position("bucks"));
		q.Remove("go");
		assertEquals(1, q.Position("bucks"));
	}

}
