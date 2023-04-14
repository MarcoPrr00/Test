/**
 La classe rappresenta la vendita di un singolo elemento.
 La classe ignora tasse, sconti e qualsiasi altro aggiustamento del prezzo.
 Il prezzo assume valori non negativi; il nome � una stringa non vuota
*/
public class Vendita {
	private String nome; //Una stringa non vuota
	private double prezzo; //non negativo

	public Vendita() {
		nome = "Nessu nome";
		prezzo = 0;
	}
	
	/**
	 Precondizione: ilNome � una stringa non vuota; ilPrezzo � non negativo.
	*/
	public Vendita(String ilNome, double ilPrezzo) {
		setNome(ilNome);
		setPrezzo(ilPrezzo);
	}
	 
	public Vendita(Vendita oggettoOriginale) {
		if(oggettoOriginale == null) {
			System.out.println("Errore: oggetto Vendita null.");
			System.exit(0);
		} //else
		nome = oggettoOriginale.nome;
		prezzo = oggettoOriginale.prezzo;
	}

	 
	public double getPrezzo() {
		return prezzo;
	}
	 
	/**
	 Precondizione: nuovoPrezzo � non negativo.
	*/
	public void setPrezzo(double nuovoPrezzo) {
		if(nuovoPrezzo >= 0)
			prezzo = nuovoPrezzo;
		else {
			System.out.println("Errore: Prezzo negativo.");
			System.exit(0);
		}
	}
	  
	public String getNome() {
		return nome;
	}
	  
	/**
	 Precondizione: nuovoNome � una stringa non vuota.
	*/
	public void setNome(String nuovoNome) {
		if(nuovoNome != null && nuovoNome != "")
			nome = nuovoNome;
		else {
			System.out.println("Errore: nome errato.");
			System.exit(0);
		}
	}
	
	public String toString() {
		return ("Componente = " + nome + 
				", Prezzo e costo totale = E" + prezzo);
	}
	  
	public double totale() {
		return prezzo;
	}
	
	/**
	 Restituisce true se i nomi ed i totali delle vendite sono gli stessi; 
	 altrimenti restituisce false.
	 Il metodo restituisce false anche se altraVendita � null.
	*/
	public boolean uguaglianzaVendite(Vendita altraVendita) {
		if(altraVendita == null)
			return false;
		else
			return (nome.equals(altraVendita.nome) &&
					totale() == altraVendita.totale());
	}

	/**
	Restituisce true se il totale dell'oggetto � minore del totale
	dell'oggetto altraVendita; altrimenti restituisce false.
	*/
	public boolean minoreDi(Vendita altraVendita) {
		if(altraVendita == null) {
			System.out.println("Errore: oggetto Vendita � null.");
			System.exit(0);
		}
		//else
		return (totale() < altraVendita.totale());
	}
	 
	public boolean equals(Object altroOggetto) {
		if(altroOggetto == null)
			return false;
		else if(!(altroOggetto instanceof Vendita)) 
			return false;
		else {
			Vendita altraVendita = (Vendita)altroOggetto;
			return (nome.equals(altraVendita.nome) && 
				(prezzo == altraVendita.prezzo));
		}
	}
	

}
