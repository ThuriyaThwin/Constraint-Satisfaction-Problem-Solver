package csp_solver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

//Class that defines a CSP with a variables and constraints
public class CSP {
	
	
	ArrayList<Variable> variables;
	ArrayList<Constraint> constraints;
	
	//Constructor
	public CSP(ArrayList<Variable> variables, ArrayList<Constraint> constraints) {
		this.variables = variables; 
		this.constraints = constraints; 
	}
	
	//Returns unassigned var: this method was used actually in the final solver 
	//the get unassigned from assignment is NOT used
	public Variable get_unassigned() {
		
		for (Variable var : this.variables) {
			if(var.value == null) {
				return var;
			}
		}
		
		return null;
		
	}
	
}
