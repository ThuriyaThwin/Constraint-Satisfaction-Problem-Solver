package csp_solver;

//Class defining a Solver that takes in a CSP and an Assignment and uses Backtracking to produce
//a consistent assignment if one exists
public class Solver_E {

	CSP csp;
	Assignment assignment;
	
	public Solver_E(CSP csp, Assignment assignment) {
		this.csp = csp;
		this.assignment = assignment;
	}
	
	//The backtracking algorithm implementation 
	public boolean backtrack() {
		
		//returns true if assignment is complete;
		if(this.assignment.isComplete()) {
			System.out.println("Assignment Complete Returning");
			return true;
		}
		
		//Gets an unassigned variable from the csp
		Variable current = this.csp.get_unassigned();
		//Assigns a domain value and loops
		for(Object entry: current.domain.values) {
			
			current.value = entry;			
			
			boolean consistent = true;
			
			//sees if constraints have been violated by assignment
			for(Constraint c: this.csp.constraints) {
				//only checks assignment if it contains the current var
				if(c.contains(current)) {
					if(c.satifies() == -1) {
						consistent = false;
						break;
					} else {
					}
					
					if(!consistent) {
						break;
					}
				}
			}
			
			//if assignment if consistent adds, value to assignment
			if(consistent) {
			this.assignment.result.remove(current);
			this.assignment.result.put(current, current.value);
			
			//recursive call;
			boolean result = this.backtrack();
			
			//if backtrack returns true keeps current value and returns assignment
			//else removes current assignment and tries another
			if(result != false) {
				return result;
			} else {
				this.assignment.result.remove(current);
				current.reset();
				this.assignment.result.put(current, current.value);
			
				
				current.domain.initDomain();
			}
			}
		}
		
		//if no valid choices avaliable resets the var and returns false;
		current.reset();
		current.value = null;
		return false;
	}


}
