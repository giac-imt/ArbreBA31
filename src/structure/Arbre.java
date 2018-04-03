package structure;

public class Arbre {
    /**
     * Nombre de clés maximum d'un noeud
     */
    public static int max_cles;

    private boolean isFeuille;

    /**
     * Valeurs présentes dans le noeud
     */
    private int[] valeurs = new int[max_cles];

    /**
     * Référence vers ses enfants
     */
    private Arbre[] enfants = new Arbre[max_cles + 1];

    public Arbre() {
    }

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

    public boolean recherche(int valeur) {

        return false;
    }

    /**
     * Parcours prefixe de l'arbre
    **/
    public void parcoursPrefixe(){
        for(int val : this.getValeurs()){
                System.out.println(val);
                if(isFeuille)
                    break;
        }
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
    public void setValeurs(int[] valeurs) {
        this.valeurs = valeurs;
    }

    public void setEnfants(Arbre[] enfants) {
        this.enfants = enfants;
    }
}