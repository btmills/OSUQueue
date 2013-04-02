package net.bmills.osuqueue;

public class Queue<E> {
	
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

	private int size;
	private Entry<E> head;
	private Entry<E> tail;
	
	Queue() {
		this.size = 0;
		this.head = new Entry<E>(null, null, null);
		this.tail = new Entry<E>(head, null, null);
		this.head.next = tail;
	}
	
	public void Enqueue(E value) {
		Entry<E> entry = new Entry<E>(tail.prev, tail, value);
		entry.prev.next = entry;
		this.tail.prev = entry;
		this.size++;
	}
	
	public E Dequeue() {
		Entry<E> first = this.head.next;
		if (first == tail)
			throw new IllegalStateException("Cannot Dequeue from an empty queue.");
		
		this.head.next = first.next;
		this.head.next.prev = this.head;
		
		this.size--;
		return first.value;
	}
	
	public E Peek() {
		Entry<E> first = this.head.next;
		if (first == tail)
			throw new IllegalStateException("Cannot Peek an empty queue.");
		
		return first.value;
	}
	
	public int Size() {
		return this.size;
	}
	
}
