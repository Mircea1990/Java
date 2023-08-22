package multithreding.executors.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class DefaultRecursiveTask extends RecursiveTask<Integer> {

	private int workload = 0;

	public DefaultRecursiveTask(int workload) {
		this.workload = workload;
	}

	@Override
	protected Integer compute() {
		if (this.workload < 18) {
			System.out.println("Doing workLoad myself in thread " + Thread.currentThread().getName()
					+ " with workload: " + this.workload);
			return workload * 2;
		} else {
			System.out.println("Splitting workload in thread " + Thread.currentThread().getName() + " with workload: "
					+ this.workload);
			List<DefaultRecursiveTask> subtasks = new ArrayList<DefaultRecursiveTask>(createSubtasks());
			for (RecursiveTask subtask : subtasks) {
				subtask.fork();
			}

//			int result = 0;
//			for (DefaultRecursiveTask subtask : subtasks) {
//				result += subtask.join();
//			}
		}

		return null;
	}

	private List<DefaultRecursiveTask> createSubtasks() {
		List<DefaultRecursiveTask> subtasks = new ArrayList<DefaultRecursiveTask>();

		var subtask1 = new DefaultRecursiveTask(this.workload / 2);
		var subtask2 = new DefaultRecursiveTask(this.workload / 2);

		subtasks.add(subtask1);
		subtasks.add(subtask2);
		return subtasks;
	}

}
