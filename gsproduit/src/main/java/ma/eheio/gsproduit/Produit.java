package ma.eheio.gsproduit;


public class Produit {

	private long id;
	private String nom;
	private double prix;
	private int quantité;
	
	public Produit(Long id, String nom, double prix, int quantité) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.quantité = quantité;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", prix=" + prix + ", quantité=" + quantité + "]";
	}
	final public String getNom() {
		return nom;
	}
	final public void setNom(String nom) {
		this.nom = nom;
	}
	final public double getPrix() {
		return prix;
	}
	final public void setPrix(double prix) {
		this.prix = prix;
	}
	final public int getQuantité() {
		return quantité;
	}
	final public void setQuantité(int quantité) {
		this.quantité = quantité;
	}
	final public long getId() {
		return id;
	}
	
	
	
}