import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class CalculateurTVATest {

    @Test
    public void testCalculTVA_Maroc() {
        CalculateurTVA calculateur = new CalculateurTVA();
        double montant = 100.0;
        String pays = "Maroc";
        double resultatAttendu = 20.0;
        assertEquals(resultatAttendu, calculateur.calculerTVA(montant, pays), 0.001);
    }

    @Test
    public void testCalculTVA_France() {
        CalculateurTVA calculateur = new CalculateurTVA();
        double montant = 100.0;
        String pays = "France";
        double resultatAttendu = 30.0;
        assertEquals(resultatAttendu, calculateur.calculerTVA(montant, pays), 0.001);
    }

    @Test
    public void testCalculTVA_EspagneInf1000() {
        CalculateurTVA calculateur = new CalculateurTVA();
        double montant = 900.0;
        String pays = "Espagne";
        double resultatAttendu = 0.0;
        assertEquals(resultatAttendu, calculateur.calculerTVA(montant, pays), 0.001);
    }

    @Test
    public void testCalculTVA_EspagneSup1000() {
        CalculateurTVA calculateur = new CalculateurTVA();
        double montant = 1200.0;
        String pays = "Espagne";
        double resultatAttendu = 180.0;
        assertEquals(resultatAttendu, calculateur.calculerTVA(montant, pays), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculTVA_PaysNonPrisEnCharge() {
        CalculateurTVA calculateur = new CalculateurTVA();
        double montant = 100.0;
        String pays = "Italie";
        calculateur.calculerTVA(montant, pays);
        fail("Devrait lancer une IllegalArgumentException");
    }
}
