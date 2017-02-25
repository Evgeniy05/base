package com.exmaples.threads;

public class Queue {

	private TaskBox head = null;
	private TaskBox tail = null;
	private int size = 0;

	public void push(Object task) {
		TaskBox help = new TaskBox();
		help.setTask(task);
		if (head == null) {
			head = help;
		} else {
			tail.setNext(help);
		}
		tail = help;
		size++;
	}

	public Object pull() {
		if (size == 0) {
			return null;
		}
		Object task = head.getTask();
		head = head.getNext();
		if (head == null) {
			tail = null;
		}
		size--;
		return task;
	}

	public int size() {
		return size;
	}

	private class TaskBox {
		private Object task;
		private TaskBox next;

		public TaskBox() {

		}

		public Object getTask() {
			return task;
		}

		public void setTask(Object task) {
			this.task = task;
		}

		public TaskBox getNext() {
			return next;
		}

		public void setNext(TaskBox next) {
			this.next = next;
		}
	}

}
