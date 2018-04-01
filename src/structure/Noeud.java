package structure;

public class Noeud
{
    private static int ordre;  //Variable qui détermine l'ordre de l'arbre

    private int totalCles; // Nombre de cles dans un noeud

    private int cles[];  // Tableau des cles (valeurs)

    private Noeud enfants[]; //Tableau des noeuds enfants

    private boolean feuille; //Est une feuille ?

    private Noeud parent;  //Parent du noeud actuel

    /**
     * Constructeur par défaut
     */
    public Noeud() {  }

    /**
     * Constructeur avec arguments
     * @param ordre : ordre du noeud
     * @param parent : parent du noeurd
     */
    public Noeud(int ordre, Noeud parent)
    {
        this.ordre = ordre;  //assign size

        this.parent = parent; //assign parent

        cles = new int[2* ordre - 1];  // array of proper size

        enfants = new Noeud[2* ordre]; // array of refs proper size

        feuille = true; // everynode is feuille at first;

        totalCles = 0; //until we add keys later.
    }

    /**
     * Getters
     */
    public int getValeur(int index)
    {
        return cles[index];
    }

    public Noeud getEnfant(int index)
    {
        return enfants[index];
    }

    public int getTotalCles() {
        return totalCles;
    }

    public boolean estFeuille() {
        return feuille;
    }

    public int getCle(int index) {
        return cles[index];
    }

    /**
     * Setters
     */
    public void setTotalCles(int totalCles) {
        this.totalCles = totalCles;
    }

    public void setFeuille(boolean feuille) {
        this.feuille = feuille;
    }

    public void setCle(int index, int val) {
        this.cles[index] = val;
    }

    public void setEnfant(int index, Noeud child) {
        this.enfants[index] = child;
    }
}
