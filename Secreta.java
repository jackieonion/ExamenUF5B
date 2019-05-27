import java.io.*;
import java.util.TreeSet;

public class Secreta {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static TreeSet<Soci> Socis = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        //Programa principal.

        int operacio=9;

        while(operacio!=0){
            System.out.println("1)Afegir soci");
            System.out.println("2)Llistat socis");
            System.out.println("3)Consultar si existeix soci");
            System.out.println("4)Eliminar soci");
            System.out.println("5)Mostrar número total socis");
            System.out.println("6)Llistat socis ordenat per nom");
            System.out.println("0)Sortir");


            System.out.print("Introdueix opcio: ");
            try {
                operacio = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                operacio = 7;
            }

            switch(operacio){
                case 1:
                    try {
                        afegirSoci();
                    } catch (RepetitException e) {
                        System.out.println("Soci repetit.");
                    }
                    break;
                case 2:
                    llistarSocis();
                    break;
                case 3:
                    if (buscaSoci()) {
                        System.out.println("El soci es troba al sistema.");
                    }else {
                        System.out.println("El soci no es troba al sistema.");
                    }
                    break;
                case 4:
                    if (eliminaSoci()) {
                        System.out.println("Soci eliminat.");
                    } else {
                        System.out.println("El soci no es troba al sistema");
                    }
                    break;
                case 5:
                    System.out.println("El nombre de socis és: " + Socis.size() + ".");
                    break;
                case 6:
                    llistarSocis();
                    break;
                case 0:
                    System.out.println("Adeu, bon dia tingui!");
                    break;
                default:
                    System.out.println("OPCIO INCORRECTA!!!");
            }
        }
    }

    private static boolean eliminaSoci() throws IOException {
        //Funció per eliminar socis

        String sociElim;

        System.out.print("Introdueix el nom del soci a eliminar: ");
        sociElim = reader.readLine();

        for (Soci soci : Socis) {
            if (soci.getNom().equals(sociElim)) {
                Socis.remove(soci);
                return true;
            }
        }
        return false;
    }

    private static boolean buscaSoci() throws IOException {
        //Funció per buscar socis

        String sociBusq;

        System.out.print("Introdueix el nom del soci a buscar: ");
        sociBusq = reader.readLine();

        for (Soci soci : Socis) {
            if (soci.getNom().equals(sociBusq)) {
                return true;
            }
        }
        return false;
    }

    private static boolean buscaSoci(String sociAff) {
        //Funció per buscar socis abans d'afegir-los

        for (Soci soci : Socis) {
            if (soci.getNom().equalsIgnoreCase(sociAff)) {
                return true;
            }
        }
        return false;
    }

    private static void llistarSocis() {
        //Funció per mostrar socis

        System.out.println("Socis\n--------");

        for (Soci soci : Socis) {
            System.out.println(soci.getNom());
        }
        System.out.println("--------");
    }

    private static void afegirSoci() throws IOException, RepetitException {
        //Funció per afegir socis

        String nom;

        System.out.print("Introdueix el nom: ");
        nom = reader.readLine();
        if (!buscaSoci(nom)) {
            Socis.add(new Soci(nom));
        } else {
            throw new RepetitException();
        }
    }
}