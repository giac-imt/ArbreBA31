package structure;

public class Arbre {

    static int ordre;

    Noeud racine;  //every tree has at least a racine node


    public Arbre(int ordre)
    {
        this.ordre = ordre;

        racine = new Noeud(ordre, null);

    }

    public Arbre(int ordre, Noeud noeudEnfant1, Noeud noeudEnfant2, Noeud noeudEnfant3) {

    }

/**
 * Méthode qui recherche récursivement le noeud dans lequel insérer notre entier
 * @param racine : Noeud racine de l'arbre B
 * @param cle : Cle que l'on veut insérer
 * @return noeud dans lequel insérer la clé
 */
    public Noeud rechercheNoeud(Noeud racine, int cle)
    {
        //Recherche à paritr de l'index 0
        int i = 0;

        //On incrémente tant que la clé est supérieure à la valeur actuelle
        while(i < racine.getTotalCles() && cle > racine.getCle(i)) { i++; }

        //Si la clé est dans la racine, sinon on recherche récursivement
        if(i <= racine.getTotalCles() && cle == racine.getCle(i))
            return racine;
        else
            return rechercheNoeud(racine.getEnfant(i),cle);

    }

    /**
     * Méthode permettant de diviser un noeud s'il est plein
     * @param x : Noeud vierge
     * @param i : Valeur à insérer
     * @param noeudADiviser : Noeud avec un trop grand nombre de clés
     */
    public void diviser(Noeud x, int i, Noeud noeudADiviser)
    {
        //Noeud supplémentaire en cas de division
        Noeud temp = new Noeud(ordre,null);

        //Si le noeud est une feuille, on indique cette information dans le noeud temp
        temp.setFeuille(noeudADiviser.estFeuille());

        //On calcule la taille par rapport à l'ordre
        temp.setTotalCles(ordre - 1);

        //On copie ce qui ne rentre pas dans le noeud dans le noeud temp
        for(int j = 0; j < ordre - 1; j++)
        {
            temp.setCle(j, noeudADiviser.getCle(j + ordre));

        }

        //Si le noeud à diviser n'est pas une feuille, on assigne les enfants à temp
        if(!noeudADiviser.estFeuille())
        {
            for(int k = 0; k < ordre; k++)
            {
                temp.setEnfant(k, noeudADiviser.getEnfant(k+ ordre));
            }
        }

        //Nouvelle taile du noeud divisé
        noeudADiviser.setTotalCles(ordre - 1);


        for(int j = x.getTotalCles(); j> i ; j--)
        {

            x.setEnfant(j+1, x.getEnfant(j));

        }
        x.setEnfant(i+1, temp); //reassign i+1 child of x

        for(int j = x.getTotalCles(); j> i; j--)
        {
            x.setCle(j + 1, x.getCle(j)); // shift keys
        }
        x.setCle(i, noeudADiviser.getCle(ordre -1));//finally push value up into racine.

        noeudADiviser.setCle(ordre - 1, 0);//erase value where we pushed from

        for(int j = 0; j < ordre - 1; j++)
        {
            noeudADiviser.setCle(j + ordre, 0);//'delete' old values
        }



        x.setTotalCles(x.getTotalCles() + 1);  //increase count of keys in x
    }

    /**
     * Insertion sans éclatement du noeud
     * @param x : Noeud où insérer
     * @param key : Valeur à insérer
     */
    public void nonfullInsert(Noeud x, int key)
    {
        //Nombre de clés du noeud x
        int i = x.getTotalCles();


        if(x.estFeuille())
        {
            while(i >= 1 && key < x.getCle(i-1))//here find spot to put key.
            {
                x.setCle(i, x.getCle(i-1));//shift values to make room

                i--;//decrement
            }

            x.setCle(i, key);//finally assign value to node
            x.setTotalCles(x.getTotalCles() + 1);//increment count of keys in this node now.

        }


        else
        {
            int j = 0;
            while(j < x.getTotalCles()  && key > x.getCle(j))//find spot to recurse
            {			             //on correct child
                j++;
            }

            //	i++;

            if(x.getEnfant(j).getTotalCles() == ordre *2 - 1)
            {
                diviser(x,j,x.getEnfant(j));//call diviser on node x's ith child

                if(key > x.getCle(j))
                {
                    j++;
                }
            }

            nonfullInsert(x.getEnfant(j),key);//recurse
        }
    }

    /**
     * Méthode d'insertion qui appelera nonFullInsert au besoin
     * @param key : Valeur à insérer
     */
    public void insert(int key)
    {
        Noeud r = this.racine;//this method finds the node to be inserted as
        //it goes through this starting at racine node.
        if(r.getTotalCles() == 2* ordre - 1)//if is full
        {
            Noeud s = new Noeud(ordre,null);//new node

            this.racine = s;    //\
            // \
            s.setFeuille(false);//  \
            //   > this is to initialize node.
            s.setTotalCles(0);   //  /
            // /
            s.setEnfant(0, r);//

            diviser(s,0,r);//diviser racine

            nonfullInsert(s, key); //call insert method
        }
        else
            nonfullInsert(r,key);//if its not full just insert it
    }


    /**
     * Méthode d'affichage des valeurs de l'arbre
     * (Continue récursivement si le noeud n'est pas une feuille)
     * @param n : Noeud à afficher
     */
    public void print(Noeud n)
    {
        for(int i = 0; i < n.getTotalCles(); i++)
        {
            System.out.print(n.getValeur(i)+" " );//this part prints racine node
        }

        if(!n.estFeuille())//this is called when racine is not leaf;
        {

            for(int j = 0; j <= n.getTotalCles(); j++)//in this loop we recurse
            {				  //to print out tree in
                if(n.getEnfant(j) != null) //preorder fashion.
                {			  //going from left most
                    System.out.println();	  //child to right most
                    print(n.getEnfant(j));     //child.
                }
            }
        }
    }


    /**
     * Méthode affichant le noeud contenant la valeur recherchée
     * @param arbre : Arbre dans lequel rechercher
     * @param x : Valeur à rechercher
     * @return Vrai si la valeur existe dans l'arbre, faux le cas échéant
     */
    public boolean rechercherValeur(Arbre arbre, int x)
    {
        Noeud temp= new Noeud(ordre,null);

        temp= rechercheNoeud(arbre.racine,x);

        if (temp==null)
        {
            return false;
        }

        else
        {
            return true;
        }
    }
}