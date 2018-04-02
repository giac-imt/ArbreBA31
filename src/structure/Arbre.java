package structure;

public class Arbre {

    private int valeur;  // Tableau des cles (valeurs)

    private Arbre filsGauche, filsMilieu, filsDroit; //Tableau des noeuds enfants

    public Arbre(int valeur) {
        this.valeur = valeur;
    }

    public Arbre(int val, Arbre fg, Arbre fm, Arbre fd) {

        this.valeur = val;  // Tableau de cles

        this.filsGauche = fg;
        this.filsMilieu = fm;
        this.filsDroit = fd;
    }

    public void parcoursPrefixe(){
        System.out.println(getValeur());
        if(getFilsGauche() != null)
            getFilsGauche().parcoursPrefixe();
        if(getFilsMilieu() != null)
            getFilsMilieu().parcoursPrefixe();
        if(getFilsDroit() != null)
            getFilsDroit().parcoursPrefixe();
    }

    public void parcoursPostFixe(){
        if(getFilsGauche() != null)
            getFilsGauche().parcoursPrefixe();
        if(getFilsMilieu() != null)
            getFilsMilieu().parcoursPrefixe();
        if(getFilsDroit() != null)
            getFilsDroit().parcoursPrefixe();
        System.out.println(getValeur());
    }/**/

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