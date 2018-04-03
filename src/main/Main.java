package main;

public class Main {
    public static void main(String[] args) {
        //Initialisation de la racine
        Arbre racine = new Arbre(10, 15);

        //Initialisation de ses enfants
        Arbre enf1 = new Arbre(5, 7);
        Arbre enf2 = new Arbre(11, 14);
        Arbre enf3 = new Arbre(16, 19);

        //Initialisation des feuilles de l'enfant 1
        Arbre feuille1 = new Arbre(2);
        Arbre feuille2 = new Arbre(6);
        Arbre feuille3 = new Arbre(9);

        //Initialisation des tableaux d'enfants de chaque noeud
        Arbre[] enfantsRacine = {enf1, enf2, enf3};
        Arbre[] enfantsEnf1 = {feuille1, feuille2, feuille3};

        //Renseigne les enfants via un setter
        racine.setEnfants(enfantsRacine);
        enf1.setEnfants(enfantsEnf1);

        //Affichage de l'arbre en parcours prefixe
        System.out.println("Parcours prefixe :");
        racine.parcoursPrefixe();

        //Affichage du resultat d'une recherche dans l'arbre
        System.out.println("7 est-il présent dans l'arbre ? " + racine.recherche(10));
    }
}
