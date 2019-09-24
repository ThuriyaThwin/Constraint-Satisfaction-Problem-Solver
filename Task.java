package csp_solver;

import java.util.ArrayList;

//Class representing a task in the job schedule CSP
public class Task<E> extends Variable<E> {

	int duration;
	int time; 
	ArrayList<Integer> avaliable_slots;
	
	public Task(String name, Domain domain, int duration) {
		super(name, domain);
		this.value = null;
		this.time = 0;
		this.duration = duration;
		this.avaliable_slots = domain.values;
	}
	
	

}
