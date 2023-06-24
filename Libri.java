/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteka14;

/**
 *
 * @author Admin
 */
public class Libri {
	
	private int isbn; //readonly
	private String titulli;
	private int numriFaqeve;
	
	public Libri(int i, String t, int vP){
		isbn = i;
		titulli = t;
		numriFaqeve = vP;
	}
	
	public int getIsbn(){
		return isbn;
	}
	
	public String getTitulli(){
		return titulli;
	}
	
	public int getNumriFaqeve(){
		return numriFaqeve;
	}
	
	public void setTitulli(String t){
		titulli = t;
	}
	
	public void setNumriFaqeve(int vP){
		numriFaqeve = vP;
	}
	
	public String toString(){
		return isbn + " : " + titulli + " - " + numriFaqeve;
	}
	
	public boolean equals(Object o){
		if(o instanceof Libri){
			Libri l = (Libri)o;
			return isbn == l.getIsbn();
		}
		return false;
	}
}
