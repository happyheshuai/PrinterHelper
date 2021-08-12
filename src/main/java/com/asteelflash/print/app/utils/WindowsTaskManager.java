package com.asteelflash.print.app.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Hashtable;
import java.util.regex.Pattern;

public class WindowsTaskManager {

	private static final String X = " ";
	private static final String TSKILL_CMD = "Taskkill";
	private static final String REPLACEMENT = "";
	private static final String STRING = ",";
	private static final String K = "K";
	private static final String UTF_8 = "UTF-8";
	private static final String TASK_LIST_CMD = "taskList";

	/*
	 * kill task by process id
	 */
	public static void killTask(Integer pid) throws IOException {
		Hashtable<Integer, WindowsTask> tasks = getTaskList();
		WindowsTask task = tasks.get(pid);
		if (task != null) {
			Runtime.getRuntime().exec(TSKILL_CMD + " " + "/F /PID "  + pid);
		}
	}

	/*
	 * kill windows task by name
	 */
	public static void killTask(String taskName) throws IOException {
		Hashtable<Integer, WindowsTask> tasks = getTaskList();
		Collection<WindowsTask> allTasks = tasks.values();
		for (WindowsTask task : allTasks) {
			if (task.getName().equals(taskName)) {
				killTask(task.getPid());
			}
		}
	}

	/*
	 * get windows task list
	 */
	public static Hashtable<Integer, WindowsTask> getTaskList() throws IOException {
		Hashtable<Integer, WindowsTask> tasks = new Hashtable<Integer, WindowsTask>();

		Process process = Runtime.getRuntime().exec(TASK_LIST_CMD);
		InputStreamReader in = new InputStreamReader(process.getInputStream(), UTF_8);
		BufferedReader reader = new BufferedReader(in);
		String taskInfo = null;
		String tmp = null;
		while ((taskInfo = reader.readLine()) != null) {
			if (taskInfo.trim().length() > 0 && taskInfo.toUpperCase().indexOf(K) != -1) {

				WindowsTask task = new WindowsTask();

				tmp = taskInfo.substring(0, 26);
				task.setName(tmp.trim());

				tmp = taskInfo.substring(26, 35);
				task.setPid(Integer.valueOf(tmp.trim()));

				tmp = taskInfo.substring(35, 52);
				task.setSessionName(tmp.trim());

				tmp = taskInfo.substring(52, 64);
				task.setSessionId(Integer.valueOf(tmp.trim()));

				tmp = taskInfo.substring(64, taskInfo.lastIndexOf(K));
				tmp = tmp.replaceAll(STRING, REPLACEMENT);
				task.setMem(Long.valueOf(tmp.trim()).longValue());

				tasks.put(task.getPid(), task);
			}
		}

		return tasks;
	}

	/*
	 * get windows task list by Regular expression
	 */
	public static Hashtable<Integer, WindowsTask> getTaskListByRegex(String expression) throws IOException {
		Hashtable<Integer, WindowsTask> tasks = new Hashtable<Integer, WindowsTask>();

		Process process = Runtime.getRuntime().exec(TASK_LIST_CMD);
		InputStreamReader in = new InputStreamReader(process.getInputStream(), UTF_8);
		BufferedReader reader = new BufferedReader(in);
		String taskInfo = null;
		String tmp = null;
		while ((taskInfo = reader.readLine()) != null) {
			if (taskInfo.trim().length() > 0 && taskInfo.toUpperCase().indexOf(K) != -1) {

				WindowsTask task = new WindowsTask();
				tmp = taskInfo.substring(0, 26);
				task.setName(tmp.trim());

				tmp = taskInfo.substring(26, 35);
				task.setPid(Integer.valueOf(tmp.trim()));

				tmp = taskInfo.substring(35, 52);
				task.setSessionName(tmp.trim());

				tmp = taskInfo.substring(52, 64);
				task.setSessionId(Integer.valueOf(tmp.trim()));

				tmp = taskInfo.substring(64, taskInfo.lastIndexOf(K));
				tmp = tmp.replaceAll(STRING, REPLACEMENT);
				task.setMem(Long.valueOf(tmp.trim()).longValue());
				if (Pattern.matches(expression, task.getName())) {
					tasks.put(task.getPid(), task);
					System.out.println(task.getName().trim());
				}
			}
		}

		return tasks;
	}

	public static void startTask(String task) throws IOException {
		Runtime.getRuntime().exec(task);
	}

}
