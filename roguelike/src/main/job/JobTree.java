package main.job;

import main.util.TreeNode;

public class JobTree {
	private TreeNode<Job> jobs = new TreeNode<Job>();
	private TreeNode<Job> fightJobs = new TreeNode<Job>();
	
	private TreeNode<Job> currentViewNode = new TreeNode<Job>();
	
	public Job getCurrentJob(){
		return currentViewNode.getObject();
	}
}
