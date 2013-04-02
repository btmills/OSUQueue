package net.bmills.osuqueue;

import java.util.HashMap;

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
	private HashMap<E, Entry<E>> map;
	
	Queue() {
		this.size = 0;
		this.head = new Entry<E>(null, null, null);
		this.tail = new Entry<E>(head, null, null);
		this.head.next = tail;
		this.map = new HashMap<E, Entry<E>>();
	}
	
	/**
	 * Add an item to the end of the queue if it is not already present.
	 * 
	 * Essentially the enqueue operation of a standard queue, with the
	 * additional restriction of a set's add operation.
	 * 
	 * @param value Item to add to the queue
	 * @return      True if added, false if already present
	 */
	public boolean Enqueue(E value) {
		if (map.containsKey(value))
			return false;
		
		Entry<E> entry = new Entry<E>(tail.prev, tail, value);
		this.map.put(value, entry);
		entry.prev.next = entry;
		this.tail.prev = entry;
		this.size++;
		return true;
	}
	
	public E Dequeue() {
		if (this.size < 1)
			throw new IllegalStateException("Cannot Dequeue from an empty queue.");

		Entry<E> first = this.head.next;
		this.map.remove(first.value);
		this.head.next = first.next;
		this.head.next.prev = this.head;
		this.size--;
		return first.value;
	}
	
	public E Peek() {
		if (this.size < 1)
			throw new IllegalStateException("Cannot Peek an empty queue.");

		return this.head.next.value;
	}
	
	public int Size() {
		return this.size;
	}
	
}
