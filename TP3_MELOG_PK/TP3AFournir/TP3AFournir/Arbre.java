class Arbre <T>{
    protected T valeur;
    protected Arbre<T> filsGauche, filsDroit;

    public T valeur() {
        return valeur;
    }
    public boolean existeFilsGauche() {
        return filsGauche != null;
    }
    public boolean existeFilsDroit() {
        return filsDroit != null;
    }
    public Arbre<T> filsGauche() {
        return filsGauche;
    }
    public Arbre<T> filsDroit() {
        return filsDroit;
    }
    public void affecterValeur(T c) {
        valeur = c;
    }
    public void affecterFilsGauche(Arbre<T> g) {
        filsGauche = g;
    }
    public void affecterFilsDroit(Arbre<T> d) {
        filsDroit = d;
    }
    public boolean feuille() {
        return (filsDroit==null && filsGauche==null);
    }
    public int hauteur() {
        int g = existeFilsGauche() ? filsGauche.hauteur() : 0;
        int d = existeFilsDroit() ? filsDroit.hauteur() : 0;
        return 1 + Math.max(g, d);
    }
    // Constructeurs
    public Arbre(T val) {
        valeur = val;
        filsGauche = filsDroit = null;
    }
    public Arbre(T val, Arbre<T> g, Arbre<T> d) {
        valeur = val;
        filsGauche = g; filsDroit = d;
    }
    // Affichage
    public void afficherPrefixe() {
        System.out.print(valeur+"\t");
        if (existeFilsGauche()) filsGauche.afficherPrefixe();
        if (existeFilsDroit())	filsDroit.afficherPrefixe();
    }
    public void afficherInfixe() {
        if (existeFilsGauche()) filsGauche.afficherInfixe();
        System.out.print(valeur+"\t");
        if (existeFilsDroit())filsDroit.afficherInfixe();
    }
    public void afficherPostfixe() {
        if (existeFilsGauche()) filsGauche.afficherPostfixe();
        if (existeFilsDroit())filsDroit.afficherPostfixe();
        System.out.print(valeur+"\t");
    }
 }
