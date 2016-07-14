package student.server;

import java.util.Comparator;

import student.common.Task;

public class TaskComparator implements Comparator<Task> {
	public int compare(Task o1, Task o2) {
		return Integer.valueOf(o1.priority).compareTo(o2.priority);
	}
}
