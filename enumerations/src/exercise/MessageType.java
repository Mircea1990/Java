package exercise;

public enum MessageType {

	A(Priority.HIGH), B(Priority.MEDIUM), C(Priority.LOW), D(Priority.LOW);

	private Priority priority;

	private MessageType(Priority pri) {
		this.priority = pri;
	}

	public Priority getPriority() {
		return priority;
	}
}
