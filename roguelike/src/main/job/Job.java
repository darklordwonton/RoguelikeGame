package main.job;

import main.entities.Stats;
import main.util.TreeNode;

public class Job {
	protected String name = "";
	
	protected int hpGain = 0;
	protected int mpGain = 0;
	protected int bufGain = 0;
	protected int tufGain = 0;
	protected int witGain = 0;
	protected int snkGain = 0;
	
	protected Job[] nextJobs = null;
	
	public Job(String n) {
		name = n;
		nextJobs = new Job[3];
	}
	
	public String getName() {
		return name;
	}
	
	public int[] getStatsArray() {
		int[] ret = {hpGain, mpGain, bufGain, tufGain, witGain, snkGain};
		return ret;
	}
	
	public void generateNextJobs(){
		for (int i = 0; i < nextJobs.length; i++){
			nextJobs[i] = new JobFighter();
		}
	}
	
	public Job maxJob() {
		System.out.println("-----------------");
		System.out.println("Class max reached");
		System.out.println("Classes available:");
		generateNextJobs();
		for (int i = 0; i < nextJobs.length; i++){
			System.out.print(nextJobs[i].getName() + "  ");
		}
		System.out.println();
		return nextJobs[1];
	}
	
}