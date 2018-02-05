package main.util;

public class Pair {
	
	private int n1;
	private int n2;
	
	public Pair(){
		n1 = -1;
		n2 = -1;
	}
	
	public Pair(int n1, int n2){
		this.n1 = n1;
		this.n2 = n2;
	}
	
	public int getFirst(){
		return n1;
	}
	
	public void setFirst(int n){
		n1 = n;
	}
	
	public int getSecond(){
		return n2;
	}
	
	public void setSecond(int n){
		n2 = n;
	}
	
	public void randFirst(int upperbound){
		setFirst((int)(Math.random() * upperbound));
	}
	
	public void randSecond(int upperbound){
		setSecond((int)(Math.random() * upperbound));
	}
	
	public void rand(int upperbound){
		setFirst((int)(Math.random() * upperbound));
		setSecond((int)(Math.random() * upperbound));
	}
	
	public void rand(int firstUpperbound, int secondUpperbound){
		setFirst((int)(Math.random() * firstUpperbound));
		setSecond((int)(Math.random() * secondUpperbound));
	}
	
	public String toString(){
		return ("[" + getFirst() + ", " + getSecond() + "]");
	}
	
}
