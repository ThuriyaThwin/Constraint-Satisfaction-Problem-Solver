package csp_solver;

import java.util.ArrayList;

public class NotAttackingConstraint implements Constraint{

	Queen a; 
	Queen b;
	
	@Override
	public boolean contains(Variable x) {
		
		Queen y = (Queen) x;
		
		if(y.equals(a) || y.equals(b)) {
			return true;
		}
		return false;
	}
	
	public NotAttackingConstraint(Queen a, Queen b) {
		this.a = a;
		this.b = b;
	}
	
	public String toString() {
		return "Queen " + a.name + " at " + a.value +  " not attacking Queen " + b.name + " at " + b.value;
	}

	@Override
	public int satifies() {

		if(a.value == null && b.value == null) {
			return 0;
		}

		ArrayList<Block> Attacking_a; 
		ArrayList<Block> Attacking_b;
		
		
		//if only one value has been assigned, edits the domain of the other one appropriately
		 if (a.value == null && b.value != null) {
			
			Attacking_b = this.b.get_attacking();
			for(Block block: Attacking_b) {
				a.domain.values.remove(block);
			}
			return 0;
			
			//if only one value has been assigned, edits the domain of the other one appropriately

		} else if (a.value != null && b.value == null) {
			
			Attacking_a = this.a.get_attacking();
			for(Block block: Attacking_a) {
				b.domain.values.remove(block);
			}
			
			return 0;
		} else {

			//Determines whether a queen is attacking another and returns appropriate value
			
			int ax = (int) a.value;
			int bx = (int) b.value;
			int ay = Integer.parseInt(a.name);
			int by = Integer.parseInt(b.name);
			
			
			int dRow = Math.abs(ax - bx);
			int dCol = Math.abs(ay - by);

			if(dCol == 0) {
				return -1;
			}
			
			if(dRow == 0) {
				return -1;
			}
				
			if(dRow == dCol) {
				return -1;
			} else {
				return 1;
			}
			
			
		}
	}


}
