package structure;

public class Main {
    public static void main(String[] args) {
        Arbre test = new Arbre(14,
                new Arbre(6,
                        new Arbre(4),
                        new Arbre(7),
                        new Arbre(10))
                , null,
                new Arbre(22,
                        new Arbre(18),
                        new Arbre(24),
                        new Arbre(26)));

        System.out.println("Parcours prefixe :");
        test.parcoursPrefixe();

        System.out.println("Parcours postfixe :");
        test.parcoursPostFixe();

        System.out.println("7 est-il présent dans l'arbre ? " +  test.recherche(7));
    }
}
