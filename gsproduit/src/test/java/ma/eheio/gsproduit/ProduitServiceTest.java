package ma.eheio.gsproduit;
import ma.eheio.gsproduit.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ProduitServiceTest {

    private ProduitService produitService;

    @BeforeEach
    public void setUp() {
        produitService = new ProduitService();
    }

    @Test
    public void testAjouterProduit() {
        Produit newProduit = new Produit(1L, "Nouveau Produit", 20.0, 3);

        produitService.ajouter(newProduit);

        Assertions.assertTrue(produitService.exist(newProduit.getId()));
    }
//    @Test
//    public void testModifierProduit() {
//        Produit existingProduit = new Produit(1L, "Produit existant", 10.0, 5);
//        produitService.getProduits().equals(existingProduit);
//
//        Produit updatedProduit = new Produit(1L, "Produit mis à jour", 15.0, 3);
//        produitService.modifierProduit(updatedProduit);
//
//        // Use produitService.exist directly in assertions
//        Assertions.assertTrue(produitService.exist(1L));
//
////        Produit resultProduit = produitService.exist(existingProduit(l).equals(1L));
//ProduitServiceTest resultProduit =existingProduit.getId);
//        Assertions.assertNotNull(resultProduit);
//        Assertions.assertEquals(updatedProduit.getNom(), resultProduit.getNom());
//        Assertions.assertEquals(updatedProduit.getPrix(), resultProduit.getPrix());
//        Assertions.assertEquals(updatedProduit.getQuantité(), resultProduit.getQuantité());
//    }


	@Test
    public void testSupprimerProduit() {
        Produit existingProduit = new Produit(1L, "Produit existant", 10.0, 5);
        produitService.ajouter(existingProduit);

        produitService.supprimerProduit(existingProduit.getId());

        Assertions.assertFalse(produitService.exist(existingProduit.getId()));
    }

    @Test
    public void testAfficherListe() {
        Produit produit1 = new Produit(1L, "Produit 1", 10.0, 5);
        Produit produit2 = new Produit(2L, "Produit 2", 15.0, 3);

        produitService.ajouter(produit1);
        produitService.ajouter(produit2);

        // Redirect System.out to capture printed output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        produitService.afficherListe();

        // Reset System.out
        System.setOut(System.out);

        String expectedOutput = "id : 1 Nom : Produit 1 Qté : 5 Prix : 10.0\n" +
                                "id : 2 Nom : Produit 2 Qté : 3 Prix : 15.0\n";

        Assertions.assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testModifierProduitNonExisting() {
        Produit nonExistingProduit = new Produit(2L, "Non-Existing Produit", 12.0, 8);

        // Ensure the product does not exist before modification
        Assertions.assertFalse(produitService.exist(nonExistingProduit.getId()));

        // Attempt to modify a non-existing product
        produitService.modifierProduit(nonExistingProduit);

        // Ensure the product still does not exist after attempted modification
        Assertions.assertFalse(produitService.exist(nonExistingProduit.getId()));
    }

    @Test
    public void testSupprimerProduitNonExisting() {
        Long nonExistingProductId = 3L;

        // Ensure the product does not exist before deletion
        Assertions.assertFalse(produitService.exist(nonExistingProductId));

        // Attempt to delete a non-existing product
        produitService.supprimerProduit(nonExistingProductId);

        // Ensure the product still does not exist after attempted deletion
        Assertions.assertFalse(produitService.exist(nonExistingProductId));
    }

    @Test
    public void testAfficherListeEmpty() {
        // Redirect System.out to capture printed output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Attempt to display the list when no products are present
        produitService.afficherListe();

        // Reset System.out
        System.setOut(System.out);

        // Ensure that the printed output is empty
        Assertions.assertEquals("", outputStream.toString().trim());
    }
}
