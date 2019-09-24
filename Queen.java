package csp_solver;

import java.util.ArrayList;
import java.util.List;

//Class representing a Queen
public class Queen<E> extends Variable {
	
	int n;
	
	public Queen(String name, Domain domain, int n) {
		super(name, domain);
		this.value = null;
		this.n = n;
	}
	
	//determines if a queen is attacking a block: not used; 
	public boolean attacking(ArrayList<Block> attacking, Block b) {
		
		
		for(Block block: attacking) {
			
			if(block.equals(b)) {
				return true;
			}
		
		}
		return false;
		
	}
	
	
	//Returns queens position as a block NOT USED
	public Block getBlock() {
		Block position = (Block) this.value;
		
		return position;
	}
	
	//Returns an arraylist of blocks the queen is attacking.
	public ArrayList<Block> get_attacking() {
		
		ArrayList<Block> attacking = new ArrayList<Block>();
		 
		
		if(this.value == null) {
			return attacking;
		} else {
			
			int n = this.n;

			int x = (Integer) this.value;
			int y = Integer.parseInt(this.name);
			
			attacking.add(new Block(x, y));
			
			int i = x;
			int j = y;
			
			
			while(i + 1 < n && j + 1 < n) {
				i += 1; j += 1;
				attacking.add(new Block(i, j));
			}
			
			i = x;
			j = y;
			
			while(i - 1 >= 0 && j - 1 >= 0) {
				i -= 1; j -= 1;
				attacking.add(new Block(i, j));
			}
			
			i = x;
			j = y;
			
			while(i + 1 < n && j - 1 >= 0) {
				i += 1; j -= 1;
				attacking.add(new Block(i, j));
			}	
			
			i = x;
			j = y;
			
			while(j + 1 < n && i - 1 >= 0) {
				j += 1; i -= 1;
				attacking.add(new Block(i, j));
			}
			
			
			for(int a = 0; a < n; a++) {
				attacking.add(new Block(a, y));
			}
			
			for(int a = 0; a < n; a++) {
				attacking.add(new Block(x, a));
			}
			
			return attacking;
		}

	}
	
}
