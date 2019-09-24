package csp_solver;
import java.util.ArrayList;
import java.util.List;

//Interface that defines a constraint
public interface Constraint {
	
	//returns -1 if assignment is violating a constraint,
	// returns  0 if assignment is not violated due to a null value
	// returns 1 if assignment is valid and does not violate anything
	public int satifies();
	public String toString();
	public boolean contains(Variable a);
}
