package structure;

public class Main {
    public static void main(String[] args) {
        Arbre.max_cles = 2;

        Arbre racine = new Arbre(10, 15);

        Arbre enf1 = new Arbre(5, 7);
        Arbre enf2 = new Arbre(11, 14);
        Arbre enf3 = new Arbre(16, 19);

        Arbre feuille1 = new Arbre(2);
        Arbre feuille2 = new Arbre(6);
        Arbre feuille3 = new Arbre(9);

        Arbre[] enfantsRacine = {enf1, enf2, enf3};
        Arbre[] enfantsEnf1 = {feuille1, feuille2, feuille3};

        racine.setEnfants(enfantsRacine);
        enf1.setEnfants(enfantsEnf1);

        System.out.println("Parcours prefixe :");
        //racine.parcoursPrefixe();

        System.out.println("7 est-il présent dans l'arbre ? " +  racine.recherche(10));
    }
}
