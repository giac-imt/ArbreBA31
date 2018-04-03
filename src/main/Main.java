package main;

public class Main {
    public static void main(String[] args) {
        //Initialisation de la racine
        Arbre racine = new Arbre(9, 15);

        //Initialisation de ses enfants
        Arbre enfGauche = new Arbre(5, 7);
        Arbre enfCentre = new Arbre(11, 13);
        Arbre enfDroit = new Arbre(17, 19);

        //Initialisation des feuilles de l'enfant gauche de la racine
        Arbre enfGaucheFeuilleGauche = new Arbre(2);
        Arbre enfGaucheFeuilleCentre = new Arbre(6);
        Arbre enfGaucheFeuilleDroite = new Arbre(8);

        //Initialisation des feuilles de l'enfant centre de la racine
        Arbre enfCentreFeuilleGauche = new Arbre(10);
        Arbre enfCentreFeuilleCentre = new Arbre(12);
        Arbre enfCentreFeuilleDroite = new Arbre(14);

        //Initialisation des feuilles de l'enfant droit de la racine
        Arbre enfDroitFeuilleGauche = new Arbre(16);
        Arbre enfDroitFeuilleCentre = new Arbre(18);
        Arbre enfDroitFeuilleDroite = new Arbre(20);

        //Initialisation des tableaux d'enfants de chaque noeud
        Arbre[] enfantsRacine = {enfGauche, enfCentre, enfDroit};
        Arbre[] feuillesEnfGauche = {enfGaucheFeuilleGauche, enfGaucheFeuilleCentre, enfGaucheFeuilleDroite};
        Arbre[] feuillesEnfCentre = {enfCentreFeuilleGauche, enfCentreFeuilleCentre, enfCentreFeuilleDroite};
        Arbre[] feuillesEnfDroit = {enfDroitFeuilleGauche, enfDroitFeuilleCentre, enfDroitFeuilleDroite};

        //Renseigne les enfants via un setter
        racine.setEnfants(enfantsRacine);
        enfGauche.setEnfants(feuillesEnfGauche);
        enfCentre.setEnfants(feuillesEnfCentre);
        enfDroit.setEnfants(feuillesEnfDroit);

        //Affichage de l'arbre en parcours prefixe
        System.out.println("Parcours prefixe :");
        racine.parcoursPrefixe();

        //Valeur à rechercher
        int val = 10;

        //Affichage du resultat d'une recherche dans l'arbre
        System.out.println(val + " est-il présent dans l'arbre ? " + racine.recherche(val));
    }
}
