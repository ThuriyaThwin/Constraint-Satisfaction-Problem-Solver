package csp_solver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;


//Class that defines an assignment to a CSP: A mapping from vars to values
public class Assignment<E> {

	//Hashmap that holds the mappings
	HashMap<Variable, E> result;
	
	//Constructor
	public Assignment(ArrayList<Variable> variables) {
		this.result = new HashMap<Variable, E>();
		for(Variable var: variables) {
			this.result.put(var, (E) var.value);
		}

	}
	
	//Returns true if all variables have a value assigned
	public boolean isComplete() {
		if(this.result.containsValue(null)) {
			return false;
		} else {
			return true;
		}
	}
	
	//Returns an unassigned variable 
	public Variable get_unassigned() {
		
		for (Variable var : this.result.keySet()) {
			if(this.result.get(var) == null) {
				return var;
			}
		}
		
		return null;
		
	}
	
	//Prints the assignment informatively
	public void print() {
		for (HashMap.Entry<Variable, E> entry : this.result.entrySet()) {
		    Variable key = entry.getKey();
		    E value = entry.getValue();
		    
		    System.out.println(key.name + " = " + value.toString());
		    
		}
	}
}
