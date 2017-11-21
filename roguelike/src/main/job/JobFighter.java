package main.job;

import main.util.Names;

public class JobFighter extends Job {
	
	public JobFighter() {
		super(Names.fighterName());
		hpGain = 1;
		mpGain = 0;
		bufGain = 2;
		tufGain = 1;
		witGain = 0;
		snkGain = 0;
	}

}
