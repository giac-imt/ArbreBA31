package structure;

public class Arbre {

    /**
     * Valeur présente dans le noeud
     */
    private int valeur;

    /**
     * Référence vers ses 3 enfants
     */
    private Arbre filsGauche, filsMilieu, filsDroit;

    /**
     * Constructeur noeud feuille
     * @param valeur : Valeur à insérer dans le noeud
     */
    public Arbre(int valeur) {
        this.valeur = valeur;
    }

    /**
     * Constructeur noeud interne
     * @param val : Valeur à insérer dans le noeud
     * @param fg : Fils gauche du noeud
     * @param fm : Fils du milieu du noeud
     * @param fd : Fils droit du noeud
     */
    public Arbre(int val, Arbre fg, Arbre fm, Arbre fd) {

        this.valeur = val;  // Tableau de cles

        this.filsGauche = fg;
        this.filsMilieu = fm;
        this.filsDroit = fd;
    }

    public boolean recherche(int valeur) {
        if (valeur == getValeur())
            return true;
        if ((valeur < getValeur()) && (getFilsGauche() != null))
            return (getFilsGauche().recherche(valeur));
        if( (getFilsMilieu() != null) && (getFilsGauche() != null) && (getFilsDroit() != null) && (valeur > getValeur()) && (valeur < getFilsDroit().getValeur()))
            return (getFilsMilieu().recherche(valeur));
        if ((valeur > getValeur()) && (getFilsDroit() != null))
            return (getFilsDroit().recherche(valeur));
        return false;
    }

    /**
     * Parcours prefixe de l'arbre
     */
    public void parcoursPrefixe(){
        System.out.println(getValeur());
        if(getFilsGauche() != null)
            getFilsGauche().parcoursPrefixe();
        if(getFilsMilieu() != null)
            getFilsMilieu().parcoursPrefixe();
        if(getFilsDroit() != null)
            getFilsDroit().parcoursPrefixe();
    }

    /**
     * Parcours postfixe de l'arbre
     */
    public void parcoursPostFixe(){
        if(getFilsGauche() != null)
            getFilsGauche().parcoursPrefixe();
        if(getFilsMilieu() != null)
            getFilsMilieu().parcoursPrefixe();
        if(getFilsDroit() != null)
            getFilsDroit().parcoursPrefixe();
        System.out.println(getValeur());
    }/**/

    /**
     * Getters
     */
    public int getValeur() {
        return valeur;
    }

    public Arbre getFilsGauche() {
        return filsGauche;
    }

    public Arbre getFilsMilieu() {
        return filsMilieu;
    }

    public Arbre getFilsDroit() {
        return filsDroit;
    }
}