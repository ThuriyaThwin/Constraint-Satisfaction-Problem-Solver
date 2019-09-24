package csp_solver;

//Class representing a Australian Territory 
public class Territory<E> extends Variable<E> {

	public Territory(String name, Domain domain) {
		super(name, domain);
		this.value = null;
	}


}
