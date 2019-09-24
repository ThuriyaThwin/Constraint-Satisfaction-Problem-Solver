package csp_solver;

import java.util.Iterator;

public class PrecedenceConstraint implements Constraint {

	
	Task a;
	Task b;
	
	@Override
	public boolean contains(Variable x) {
		
		Task y = (Task) x;
		
		if(y.equals(a) || y.equals(b)) {
			return true;
		}
		return false;
	}
	
	//Constructor
	public PrecedenceConstraint(Task a, Task b) {
		this.a = a;
		this.b = b;
	}
	
	public String toString() {
		return "Task " + a.name + " is at " + a.value +  " before Task " + b.name + " at " + b.value;
	}

	@Override
	public int satifies() {
		
		//returns 0 if neither values have been assigned
		if(a.value == null || b.value == null) {
			return 0;
			//if only one value has been assigned, edits the domain of the other one appropriately
		} else if (a.value == null && b.value != null) {
			b.time = (int) b.value;			
			Iterator<Integer> aIterator = a.avaliable_slots.iterator();
			while (aIterator.hasNext()) {
				Integer i = aIterator.next();
				if( i + a.duration > b.time ) {
					a.avaliable_slots.remove(i);
				}
			}
			return 0;
			//if only one value has been assigned, edits the domain of the other one appropriately
		} else if (a.value != null && b.value == null) {
			a.time = (int) a.value;
			Iterator<Integer> bIterator = b.avaliable_slots.iterator();
			while (bIterator.hasNext()) {
				Integer i = bIterator.next();
				if(i < a.time + a.duration) {
					b.avaliable_slots.remove(i);
				}
			}
			return 0;
			
		} else {
			//Makes sure that time assigned to b is after a + duration
			a.time = (int) a.value;
			b.time = (int) b.value;
			if(a.time + a.duration > b.time) {
				return -1;
			} else {
				return 1;
			}
			
		}

	}
	
}
