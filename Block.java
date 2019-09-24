package csp_solver;


//Block class that represents a chess position
//Only used in my initial representation of the Queens problem;
public class Block {

	int x;
	int y; 
	
	public Block(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "x: " + this.x + " y: " + this.y;
	}
	
	public boolean equals(Block b) {
		if(this.x == b.x && this.y == b.y) {
			return true;
		} else {
			return false;
		}
	}

}
