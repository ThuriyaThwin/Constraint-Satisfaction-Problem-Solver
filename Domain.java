package csp_solver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//Class that defines a domain
public class Domain<E> {

	//ArrayList containing values and a copy of original values to be used 
	//for reseting domain
	ArrayList<E> values;
	ArrayList<E> original;
	
	
	//Constructor
	public Domain(ArrayList<E> entries){
		this.values = entries;
		this.original = entries;
	}
	
	//initializes domain to the original values
	public void initDomain() {
		this.values = (ArrayList<E>) this.original.clone();
	}
	
	//returns a copy of current domain
	public Domain getDomain() {
		
		ArrayList<E> domain = new ArrayList<E>();
		
		for(E e : values) {
			domain.add(e);
		}
		
		return new Domain(domain);
	}
	
}
