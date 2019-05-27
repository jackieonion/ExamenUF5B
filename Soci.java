public class Soci implements Comparable<Soci>{
    //La classe Soci implementa Comparable, ja que serà emmagatzemada en un TreeSet.

    String nom;

    public Soci(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public int compareTo(Soci soci) {
        //Sobreescribim el mètode compareTo per ordenar els socis per nom.

        return this.getNom().compareToIgnoreCase(soci.getNom());
    }
}
