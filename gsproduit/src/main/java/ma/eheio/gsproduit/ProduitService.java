package ma.eheio.gsproduit;

import java.util.ArrayList;
import java.util.List;

public class ProduitService {


    private List<Produit> produits = new ArrayList<Produit>();
	public boolean exist(long b ) {
		for(Produit p : produits) {
			if(p.getId()==b) {
				return true;
				
			}
		}
		
		return false;
	}
	
 public void ajouter( Produit p) {
	 try { 
		 if(exist(p.getId())) {
			 throw new Exception("Le produit exist deja");
		 }
		 
		 if(p.getPrix() <= 0 || p.getQuantité() <= 0) {
			 throw new IllegalArgumentException("La quantité et le prux doivent etre positive");
		 }
		 produits.add(p);
		 
	 }catch(IllegalArgumentException e) {
		 System.out.println(e.getMessage());
	 }
	 
	 catch(Exception e) {
		 System.out.println(e.getMessage());
		 
	 } 
 }
 public void modifierProduit(Produit p) {
	 try { 
		 if(!exist(p.getId())) {
			 throw new Exception("Le produit n'exist pas");
		 }
		 
		 if(p.getPrix() <= 0 || p.getQuantité() <= 0) {
			 throw new IllegalArgumentException("La quantité et le prux doivent etre positive");
		 }
		 for (Produit produit : produits) {
			if(produit.getId() == p.getId()) {
				produit.setNom(p.getNom());
				produit.setPrix(p.getPrix());
				produit.setQuantité(p.getQuantité());
			}
		}
	 }catch(IllegalArgumentException e) {
		 System.out.println(e.getMessage());
	 }
	 catch(Exception e) {
		 System.out.println(e.getMessage());
	 }
 }

 public void supprimerProduit(Long id) {
	 try {
	 if(!exist(id)) {
		 throw new Exception("Le produit n'exist pas");
	 }
	 for (Produit produit : produits) {
		if(produit.getId() == id) {
			produits.remove(produit);
		}
	}
	 }catch(Exception e) {
		 System.out.println(e.getMessage());
	 }
 }
 
	public void afficherListe() {
		for (Produit produit : produits) {
			System.out.println("id : " + produit.getId() + " Nom : " + produit.getNom() + " Qté : " + produit.getQuantité() + " Prix : " + produit.getPrix());
		}
	}

	public Object getProduits() {
		// TODO Auto-generated method stub
		return null;
	}

	public Produit exist(boolean equals) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
