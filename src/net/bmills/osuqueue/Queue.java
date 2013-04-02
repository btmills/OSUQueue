package net.bmills.osuqueue;

public class Queue<T> {
	
	private class Entry<T> {
		// These are going to be public now to simplify things
		public Entry<T> prev = null;
		public Entry<T> next = null;
		public T value = null;
		
		Entry(Entry<T> prev, Entry<T> next, T value) {
			this.prev = prev;
			this.next = next;
			this.value = value;
		}
	}
	
	private Entry<T> head;
	private Entry<T> tail;
	
	Queue() {
		this.head = new Entry<T>(null, null, null);
		this.tail = new Entry<T>(head, null, null);
		this.head.next = tail;
	}
	
	public void Enqueue(T value) {
		Entry<T> entry = new Entry<T>(tail.prev, tail, value);
		entry.prev.next = entry;
		this.tail.prev = entry;
	}
	
	public T Dequeue() {
		Entry<T> first = this.head.next;
		if (first == tail)
			throw new IllegalStateException("Cannot Dequeue from an empty queue.");
		
		this.head.next = first.next;
		this.head.next.prev = this.head;
		
		return first.value;
	}
	
	public T Peek() {
		Entry<T> first = this.head.next;
		if (first == tail)
			throw new IllegalStateException("Cannot Peek an empty queue.");
		
		return first.value;
	}
	
}
