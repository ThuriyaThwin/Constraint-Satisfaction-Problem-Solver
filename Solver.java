package csp_solver;

//THIS solver was my first attempt and is also functional
public class Solver {
	
	CSP csp;
	Assignment assignment;
	
	public Solver(CSP csp, Assignment assignment) {
		this.csp = csp;
		this.assignment = assignment;
	}
	
	//Almost same implementation as the of backtrack in Solver_E 
	public boolean backtrack() {
		
		if(this.assignment.isComplete()) {
			System.out.println("Assignment Complete Returning");
			return true;
		}
		
		
		
		Variable current = this.assignment.get_unassigned();
		
		for(Object entry: current.domain.values) {
			
			current.value = entry;
			
			
			
			
			boolean consistent = true;
			for(Constraint c: this.csp.constraints) {
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
			
			if(consistent) {
			this.assignment.result.remove(current);
			this.assignment.result.put(current, entry);
			
			boolean result = this.backtrack();
			
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
		current.reset();
		current.value = null;
		return false;
	}

}
