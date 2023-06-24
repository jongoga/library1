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
public class Biblioteka14{
	
	private String emri;
	private Libri[] librat;
	private int index = 0;
	
	public Biblioteka14(String e, int nrLibrave){
		emri = e;
		librat = new Libri[nrLibrave];
	}
	
	public boolean ekziston(Libri l){
		for(int i = 0; i < index; i++){
			if(librat[i].equals(l))
				return true;
		}
		return false;
	}
	
	public void shtoLibrin(Libri l){
		if(l == null){
			System.out.println("Libri eshte i painicializuar!");
			return;
		}
		if(ekziston(l)){
			System.out.println("Libri ekziston!");
			return;
		}
		if(index == librat.length){
			Libri[] temp = new Libri[librat.length + 3];
			for(int i = 0;  i < librat.length; i++){
				temp[i] = librat[i];
			}
			librat = temp;
		}
		librat[index++] = l;
	}
	
	public Libri titulliMeIGjate(){
		if(index == 0){
			System.out.println("Nuk ka asnje liber!");
			return null;
		}
		Libri l = null;
		for(int i = 0;  i < index; i++){
			Libri li = librat[i];
			if(l == null 
					|| li.getTitulli().length() >= l.getTitulli().length())
				l = li;
		}
		return l;
	}
	
	public int[] ktheNumratEFaqeve(){
		if(index < 2){
			return null;
		}
		int minNumri = 0;
		int maxNumri = 0;
		for(int i = 0; i < index; i++){
			Libri li = librat[i];
			if(i == 0){
				minNumri = li.getNumriFaqeve();
				maxNumri = li.getNumriFaqeve();
			}
			else{
				if(minNumri > li.getNumriFaqeve())
					minNumri = li.getNumriFaqeve();
				if(maxNumri < li.getNumriFaqeve())
					maxNumri = li.getNumriFaqeve();
			}
		}
		return new int[] {minNumri, maxNumri};
	}
	
	public void fshijLibrat(int nrF){
		if(index == 0){
			System.out.println("Nuk ka asnje liber!");
			return;
		}
		for(int i = 0; i < index; i++){
			if(eshtePerTuFshire(librat[i].getTitulli(), nrF))
				fshij(i--);
		}
	}
	
	public boolean eshtePerTuFshire(String t, int nrF){
		int count = 0;
		String[] fjalet = t.split(" ");
		if(fjalet.length < nrF)
			return false;
		for(int i = 0; i < fjalet.length; i++){
			if(fjalet[i].length() > 6)
				count++;
		}
		return count == nrF;
	}
	
	private void fshij(int i){
		for(int j = i; j < index - 1; j++){
			librat[j] = librat[j + 1];
		}
		librat[--index] = null;
	}
	
	public void shtypTeGjitheLibrat(){
		for(int i = 0; i < index; i++){
			System.out.println(librat[i]);
		}
	}
	
	public static void main(String[] args){
		Biblioteka14 b = new Biblioteka14("UBT Library", 10);
		Libri l1 = new Libri(12345, "Hyrje ne Shkenca Kompjuterike", 325);
		Libri l2 = new Libri(24345, "Programimi i Orientuar ne Objekte", 397);
		Libri l3 = new Libri(12389, "Bazat e te Dhenave te Avancuara", 455);
		b.shtoLibrin(l1);
		b.shtoLibrin(l2);
		b.shtoLibrin(l3);
		b.shtoLibrin(new Libri(22389, "Matematika 1", 412));
		b.shtoLibrin(new Libri(22399, "Matematika 2", 326));
		b.shtoLibrin(new Libri(22396, "Bazat Teknike te Informatikes 1", 295));
		b.shtoLibrin(new Libri(22319, "Bazat Teknike te Informatikes 2", 344));
		b.shtoLibrin(new Libri(21319, "Menaxhimi i Projekteve Inxhinierike", 305));

		System.out.println();
		Libri l = new Libri(12344, "Meshari", 188);
		System.out.println(l + (b.ekziston(l)? ":" : ": nuk") + " ekziston!");

		System.out.println();
		System.out.println("Libri me titullin me te gjate:\n"
						+ b.titulliMeIGjate());
		System.out.println();
		int[] numrat = b.ktheNumratEFaqeve();
		if(numrat == null){
			System.out.println("Nuk jane se paku dy libra!");
		}
		else{
			System.out.println("Numri me i vogel i faqeve ne biblioteke: " + numrat[0]);
			System.out.println("Numri me i madh i faqeve ne biblioteke: " + numrat[1]);
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Librat: ");
		b.shtypTeGjitheLibrat();
		
		b.fshijLibrat(3);
		
		System.out.println();
		System.out.println();
		System.out.println("Librat: ");
		b.shtypTeGjitheLibrat();
	}
}