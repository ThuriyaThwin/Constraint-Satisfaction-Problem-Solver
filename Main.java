package csp_solver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Welcome to CSP Solver by Victor Antony");
		
		Scanner scanner = new Scanner(System.in);
		
		boolean solving = true;
		
		Assignment result;
		
		while(solving) {
		System.out.println("Which problem would you like the solver to solve?");
		System.out.println("1. Australia Map Coloring Problem");
		System.out.println("2. Job Scheduling Problem");
		System.out.println("3. N Queen Problem");
		System.out.println("Choose: 1, 2 or 3? Enter 0 to exit");

		int choice = scanner.nextInt();
		
		if(choice == 1) {
			System.out.println("Now testing the Australia Problem");
			
			result = australia_problem();
			
			result.print();
			
			System.out.println("Territory == Color");
			
		} else if(choice == 2) {
			System.out.println("Now testing the Job Scheduling Problem");
			
			result = job_scheduling();
			
			result.print();
			System.out.println("Job == Time (0 indexed)");
			
		} else if(choice == 3) {
			System.out.println("Now testing the N Queens Problem");
			System.out.println("Please enter your choice of N: ");
			int n = scanner.nextInt();
			result = queens_problem(n);
			result.print();
			System.out.println("");
			System.out.println("NOTE: Queen(Column -- NOT zero indexed) == Row(0 indexed)");
			System.out.println("");
		} else {
			System.out.println("It was a pleasure solving problem for you");
			solving = false;
		}
		
		}
	}
	
	

	
	
//Method that constructs and job scheduling CSP and returns the assignment worked upon by backtracking
public static Assignment job_scheduling() {
		
		ArrayList<Variable> Variables = new ArrayList<Variable>();
		ArrayList<Constraint> Constraints = new ArrayList<Constraint>();
		int n = 15+(2*10)+(4+4)+8+3;
		ArrayList<Integer> Times = initIntegerDomain(n);
		Domain<Integer> TimeSheet = new Domain<Integer>(Times);
		ArrayList<Variable> holder = new ArrayList<Variable>();
		
		Task AxleF = new Task("AxleF", TimeSheet.getDomain(), 10);
		Task AxleB = new Task("AxleB", TimeSheet.getDomain(), 10);
		Task WheelRF = new Task("WheelRF", TimeSheet.getDomain(), 1);
		Task WheelLF = new Task("WheelLF", TimeSheet.getDomain(), 1);
		Task WheelRB = new Task("WheelRB", TimeSheet.getDomain(), 1);
		Task WheelLB = new Task("WheelLB", TimeSheet.getDomain(), 1);
		Task NutsRF = new Task("NutsRF", TimeSheet.getDomain(), 2);
		Task NutsLF = new Task("NutsLF", TimeSheet.getDomain(), 2);
		Task NutsRB = new Task("NutsRB", TimeSheet.getDomain(), 2);
		Task NutsLB = new Task("NutsLB", TimeSheet.getDomain(), 2);
		Task CapRF = new Task("CapRF", TimeSheet.getDomain(), 1);
		Task CapLF = new Task("CapLF", TimeSheet.getDomain(), 1);
		Task CapRB = new Task("CapRB", TimeSheet.getDomain(), 1);
		Task CapLB = new Task("CapLB", TimeSheet.getDomain(), 1);
		Task Inspect = new Task("Inspect", TimeSheet.getDomain(), 3);
	
		
		Variables.add(AxleF);Variables.add(AxleB);Variables.add(WheelRF);
		Variables.add(WheelLF);Variables.add(WheelRB);Variables.add(WheelLB);
		Variables.add(NutsRF);Variables.add(NutsLF);Variables.add(NutsRB);Variables.add(NutsLB);
		Variables.add(CapRF);Variables.add(CapLF);Variables.add(CapRB);
		Variables.add(CapLB);Variables.add(Inspect);
		
		holder.add(AxleF);holder.add(AxleB);holder.add(WheelRF);
		holder.add(WheelLF);holder.add(WheelRB);holder.add(WheelLB);
		holder.add(NutsRF);holder.add(NutsLF);holder.add(NutsRB);holder.add(NutsLB);
		holder.add(CapRF);holder.add(CapLF);holder.add(CapRB);
		holder.add(CapLB);holder.add(Inspect);
		
		Constraints.add(new PrecedenceConstraint(AxleF, WheelLF));
		Constraints.add(new PrecedenceConstraint(AxleF, WheelRF));
		Constraints.add(new PrecedenceConstraint(AxleB, WheelLB));
		Constraints.add(new PrecedenceConstraint(AxleB, WheelRB));
		Constraints.add(new NoOverlapConstraint(AxleF, AxleB));
		Constraints.add(new PrecedenceConstraint(WheelLF, NutsLF));
		Constraints.add(new PrecedenceConstraint(WheelRF, NutsRF));
		Constraints.add(new PrecedenceConstraint(WheelLB, NutsLB));
		Constraints.add(new PrecedenceConstraint(WheelRB, NutsRB));
		Constraints.add(new NoOverlapConstraint(WheelLF, WheelRF));
		Constraints.add(new NoOverlapConstraint(WheelLF, WheelRB));
		Constraints.add(new NoOverlapConstraint(WheelLF, WheelLB));
		Constraints.add(new NoOverlapConstraint(WheelLB, WheelRB));
		Constraints.add(new NoOverlapConstraint(WheelLB, WheelRF));
		Constraints.add(new NoOverlapConstraint(WheelRB, WheelRF));
		Constraints.add(new PrecedenceConstraint(NutsLF, CapLF));
		Constraints.add(new PrecedenceConstraint(NutsRF, CapRF));
		Constraints.add(new PrecedenceConstraint(NutsLB, CapLB));
		Constraints.add(new PrecedenceConstraint(NutsRB, CapRB));
		Constraints.add(new NoOverlapConstraint(NutsLF, NutsRF));
		Constraints.add(new NoOverlapConstraint(NutsLF, NutsRB));
		Constraints.add(new NoOverlapConstraint(NutsLF, NutsLB));
		Constraints.add(new NoOverlapConstraint(NutsLB, NutsRB));
		Constraints.add(new NoOverlapConstraint(NutsLB, NutsRF));
		Constraints.add(new NoOverlapConstraint(NutsRB, NutsRF));
		Constraints.add(new PrecedenceConstraint(CapLF,Inspect));
		Constraints.add(new PrecedenceConstraint(CapRF,Inspect));
		Constraints.add(new PrecedenceConstraint(CapLB,Inspect));
		Constraints.add(new PrecedenceConstraint(CapRB,Inspect));
		Constraints.add(new NoOverlapConstraint(CapLF, CapRF));
		Constraints.add(new NoOverlapConstraint(CapLF, CapRB));
		Constraints.add(new NoOverlapConstraint(CapLF, CapLB));
		Constraints.add(new NoOverlapConstraint(CapLB, CapRB));
		Constraints.add(new NoOverlapConstraint(CapLB, CapRF));
		Constraints.add(new NoOverlapConstraint(CapRB, CapRF));
		Constraints.add(new PrecedenceConstraint(NutsLF,Inspect));
		Constraints.add(new PrecedenceConstraint(NutsRF,Inspect));
		Constraints.add(new PrecedenceConstraint(NutsLB,Inspect));
		Constraints.add(new PrecedenceConstraint(NutsRB,Inspect));
		Constraints.add(new PrecedenceConstraint(WheelLF,Inspect));
		Constraints.add(new PrecedenceConstraint(WheelRF,Inspect));
		Constraints.add(new PrecedenceConstraint(WheelLB,Inspect));
		Constraints.add(new PrecedenceConstraint(WheelRB,Inspect));
		Constraints.add(new PrecedenceConstraint(AxleF,Inspect));
		Constraints.add(new PrecedenceConstraint(AxleB,Inspect));
		

		CSP n_queens = new CSP(Variables, Constraints);
	
		Assignment initial = new Assignment(holder);
		
		Solver_E solver = new Solver_E(n_queens, initial);
		boolean solved = solver.backtrack();
		
		if(solved) {
			return initial;
		} else {
			return null;
		}
		
	}

//Method that constructs a n queens CSP and returns the assignment worked upon by backtracking
public static Assignment queens_problem(int n) {
	
	ArrayList<Variable> Variables = new ArrayList<Variable>();
	ArrayList<Constraint> Constraints = new ArrayList<Constraint>();
	ArrayList<Integer> blocks = initIntegerDomain(n);
	Domain<Integer> Board = new Domain<Integer>(blocks);
	ArrayList<Variable> holder = new ArrayList<Variable>();
	
	for(int i = 1; i <= n; i++) {
		
		Queen queen = new Queen(Integer.toString(i), Board.getDomain(), n);
	
		Variables.add(queen);
		holder.add(queen);
	}
	
	for(int i = 0; i < n; i++) {
		
		for(int o = i+1; o < n; o++) {
			Constraints.add(new NotAttackingConstraint((Queen) Variables.get(i), (Queen) Variables.get(o)));
		}
		
	}

	CSP n_queens = new CSP(Variables, Constraints);

	Assignment initial = new Assignment(holder);
	
	Solver_E solver = new Solver_E(n_queens, initial);
	boolean solved = solver.backtrack();
	
	if(solved) {
		return initial;
	} else {
		return null;
	}
	
}

//Method that constructs an australia problem CSP and returns the assignment worked upon by backtracking
	public static Assignment australia_problem() {
		
		ArrayList<Variable> Variables = new ArrayList<Variable>();
		ArrayList<Constraint> Constraints = new ArrayList<Constraint>();
		ArrayList<String> colors = new ArrayList<String>();
		colors.add("Red");
		colors.add("Blue");
		colors.add("Green");
		System.out.println(" " + colors.toString());
		Domain<String> RGB = new Domain<String>(colors);
		
		Variable WA = new Territory("WA", RGB.getDomain());
		Variable NT = new Territory("NT", RGB.getDomain());
		Variable NSW = new Territory("NSW", RGB.getDomain());
		Variable SA = new Territory("SA", RGB.getDomain());
		Variable Q = new Territory("Q", RGB.getDomain());
		Variable V = new Territory("V", RGB.getDomain());
		Variable T = new Territory("T", RGB.getDomain());
		
		Variables.add(WA);Variables.add(NT);Variables.add(NSW);
		Variables.add(SA);Variables.add(Q);Variables.add(V);
		Variables.add(T);
		
		Constraints.add(new NotEqualsConstraint(SA, WA));
		Constraints.add(new NotEqualsConstraint(SA, NT));
		Constraints.add(new NotEqualsConstraint(SA, Q));
		Constraints.add(new NotEqualsConstraint(SA, NSW));
		Constraints.add(new NotEqualsConstraint(SA, V));
		Constraints.add(new NotEqualsConstraint(WA, NT));
		Constraints.add(new NotEqualsConstraint(NT, Q));
		Constraints.add(new NotEqualsConstraint(Q, NSW));
		Constraints.add(new NotEqualsConstraint(NSW, V));
		
		CSP australia = new CSP(Variables, Constraints);
		
		ArrayList<Variable> holder = new ArrayList<Variable>();
		holder.add(WA);holder.add(NT);holder.add(NSW);
		holder.add(SA);holder.add(Q);holder.add(V);
		holder.add(T);
		
		Assignment initial = new Assignment(holder);
		
		Solver solver = new Solver(australia, initial);
		boolean solved = solver.backtrack();
		
		if(solved) {
			return initial;
		} else {
			return null;
		}
		
	}
	

	//Method that returns an array containing numbers 0 to n, 
		//essetially used to initialize an integer domain
	public static ArrayList<Integer> initIntegerDomain(int n){
			ArrayList<Integer> times = new ArrayList<Integer>();
			
			for(int i = 0; i <= n; i++) {
				times.add(i);
			}
			return times;
		}

	/*
	public static ArrayList<Block> initBlockDomain(int n){
		ArrayList<Block> blocks = new ArrayList<Block>();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				blocks.add(new Block(i, j));
			}
		}
		
		return blocks;
	}
	public static Assignment queens_problem(int n) {
		
		ArrayList<Variable> Variables = new ArrayList<Variable>();
		ArrayList<Constraint> Constraints = new ArrayList<Constraint>();
		ArrayList<Block> blocks = initBlockDomain(n);
		Domain<Block> Board = new Domain<Block>(blocks);
		ArrayList<Variable> holder = new ArrayList<Variable>();
		
		for(int i = 1; i <= n; i++) {
			
			Queen queen = new Queen(Integer.toString(i), Board.getDomain(), n);
		
			Variables.add(queen);
			holder.add(queen);
		}
		
		for(int i = 0; i < n; i++) {
			
			for(int o = i+1; o < n; o++) {
				Constraints.add(new NotAttackingConstraint((Queen) Variables.get(i), (Queen) Variables.get(o)));
			}
			
		}

		CSP n_queens = new CSP(Variables, Constraints);
	
		Assignment initial = new Assignment(holder);
		
		Solver_E solver = new Solver_E(n_queens, initial);
		boolean solved = solver.backtrack();
		
		if(solved) {
			return initial;
		} else {
			return null;
		}
		
	}*/
	


}
