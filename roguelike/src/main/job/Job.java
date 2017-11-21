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
	
	public Job(String n) {
		name = n;
	}
	
	public String getName() {
		return name;
	}
	
	public int[] getStatsArray() {
		int[] ret = {hpGain, mpGain, bufGain, tufGain, witGain, snkGain};
		return ret;
	}
	
}