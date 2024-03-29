package main;

public class Arbre {
    //TODO : ajouter feuilles partout
    /**
     * Nombre de clés maximum d'un noeud
     */
    public static int max_cles = 2;

    /**
     * Est une feuille ?
     */
    private boolean isFeuille;

    /**
     * Valeurs présentes dans le noeud
     */
    private int[] valeurs = new int[max_cles];

    /**
     * Références vers ses enfants
     */
    private Arbre[] enfants = new Arbre[max_cles + 1];

    /**
     * Constructeur de feuilles
     * @param valeur : Valeur unique du noeud feuille
     */
    public Arbre(int valeur){
        this.valeurs[0] = valeur;
        this.isFeuille = true;
    }

    /**
     * Constructeur noeud interne
     * @param val : première valeur du noeud
     * @param val2 : deuxième valeur du noeud
     */
    public Arbre(int val, int val2) {
        this.valeurs[0] = val;
        this.valeurs[1] = val2;
        this.isFeuille = false;
    }

    /**
     * Recherche d'un nombre dans l'arbre
     * @param valeur : valeur à rechercher
     * @return vrai si le nombre est présent dans l'arbre
     */
    public boolean recherche(int valeur) {
        int valGauche = this.getValeurs()[0];
        int valDroite = this.getValeurs()[1];

        if(valeur == valGauche || valeur == valDroite){
            return true;
        }

        if((this.getEnfants()[0] != null) && (valeur < valGauche)){
            return this.getEnfants()[0].recherche(valeur);
        }
        if((this.getEnfants()[1] != null) && (valeur > valGauche && valeur < valDroite)){
            return this.getEnfants()[1].recherche(valeur);
        }
        if((this.getEnfants()[2] != null) && (valeur > valDroite)){
            return this.getEnfants()[2].recherche(valeur);
        }
        return false;
    }

    /**
     * Parcours prefixe de l'arbre
    **/
    public void parcoursPrefixe(){
        for(int val : this.getValeurs()){
                System.out.print(val + " ");
                if(isFeuille)
                    break;
        }
        //Passage à la ligne
        System.out.println();
        if(this.getEnfants()[0] != null)
            getEnfants()[0].parcoursPrefixe();
        if(this.getEnfants()[1] != null)
            this.getEnfants()[1].parcoursPrefixe();
        if(this.getEnfants()[2] != null)
            this.getEnfants()[2].parcoursPrefixe();
    }

    /**
     * Parcours postfixe de l'arbre
    **/
    public void parcoursPostFixe(){
        if(this.getEnfants()[0] != null)
            getEnfants()[0].parcoursPrefixe();
        if(this.getEnfants()[1] != null)
            this.getEnfants()[1].parcoursPrefixe();
        if(this.getEnfants()[2] != null)
            this.getEnfants()[2].parcoursPrefixe();
        for(int val : this.getValeurs()){
            System.out.println(val);
        }
    }

    /**
     * Getters
     */
    public int[] getValeurs() {
        return valeurs;
    }

    public Arbre[] getEnfants() {
        return enfants;
    }

    /**
     * Setters
     */

    public void setEnfants(Arbre[] enfants) {
        this.enfants = enfants;
    }
}