public class CalculateurTVA {
 public double calculerTVA(double montant, String pays) {
 switch (pays) {
 case "Maroc":
 return montant * 0.20;
 case "France":
 return montant * 0.30;
 case "Espagne":
 if (montant < 1000) {
 return 0;
 } else {
 return montant * 0.15;
 }
 default:
 throw new IllegalArgumentException("Pays non pris en charge");
 }
 }
}//test
