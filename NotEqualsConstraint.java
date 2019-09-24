package csp_solver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NotEqualsConstraint implements Constraint{

	Variable a;
	Variable b;
	
	@Override
	public boolean contains(Variable x) {
	
		if(x.equals(a) || x.equals(b)) {
			return true;
		}
		return false;
	}

	//Constructor
	public NotEqualsConstraint(Variable a, Variable b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public String toString() {
		
		return "Constraint = " + a.name + " != " + b.name;	
	}

	//Self explanatory satifies function
	@Override
	public int satifies() {
		
		if(a.value == null && b.value == null) {
			return 0;
		} else if (a.value == null && b.value != null) {
			b.domain.values.remove(a.value);
			return 0;
		} else if (a.value != null && b.value == null) {
			a.domain.values.remove(b.value);
			return 0;
		} else if(a.value.equals(b.value)) {
				return -1;
		}
		
		return 1;
		
	}


}
