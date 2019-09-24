package csp_solver;

import java.util.ArrayList;

//Abstract Class defining a variable
public abstract class Variable<E> {

	String name;
	Domain domain;
	Domain original;
	E value;
	
	public Variable(String name, Domain domain) {
		this.name = name;
		this.domain = domain;
		this.original = domain;
	}
	
	public void reset() {
		this.domain = original; 
		this.value = null;
	}
	
}
