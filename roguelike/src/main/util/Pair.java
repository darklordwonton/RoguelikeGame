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
	
}
