import java.util.Scanner;

public class Part2 {

    public static void main(String[] args) {
         Scanner lector = new Scanner(System.in);
         String[][] persones = new String[0][5];
         String nom = "", cognom = "", edat = "", telefon = "";
         int opcio = 0;
         int idPersona = 0;
         int posPersona = 0;
         boolean trobat = false;
         String[][] personesAux = new String[0][5];
        do {
            mostrarMenu();
            opcio = lector.nextInt();
            lector.nextLine();

            switch (opcio) {
                case 1:
                    afegirPersona(persones, nom, cognom, edat, telefon, idPersona, posPersona, trobat, personesAux, lector);
                    break;
                case 2:
                    llistarPersones(persones, idPersona, posPersona, trobat, lector);
                    break;
                case 3:
                    llistarPersona(persones, idPersona, posPersona, trobat, lector);
                    break;
                case 4:
                    modificarPersona(persones, nom, cognom, edat, lector, telefon, idPersona, posPersona, trobat, personesAux);
                    break;
                case 5:
                    eliminarPersona(persones, lector, idPersona, posPersona, trobat, personesAux);
                    break;
                case 0:
                    System.out.println("Adéu...");
                    break;
                default:
                    System.out.println("Opció incorrecta...");
            }

        } while (opcio != 0);
    }

    static void mostrarMenu() {
        System.out.println("Selecciona una opció...");
        System.out.println("1.Afegir persona"); // C-reate
        System.out.println("2.Llistar persones"); // R-ead
        System.out.println("3.Llistar persona"); // Read
        System.out.println("4.Modificar persona");// U-pdate
        System.out.println("5.Eliminar persona"); // D-elete
        System.out.println("0.Sortir");
    }

    static void afegirPersona(String[][] persones, String nom, String cognom, String edat, 
    String telefon, int idPersona, int posPersona, boolean trobat, String[][] personesAux, Scanner lector) {
        System.out.print("Donam el nom: ");
        nom = lector.nextLine();

        System.out.print("Donam el cognom: ");
        cognom = lector.nextLine();

        System.out.print("Donam l'edat: ");
        while (!lector.hasNextInt()) {
            System.out.print("Donam l'edat: ");
            lector.nextLine();
        }
        edat = String.valueOf(lector.nextInt());
        lector.nextLine();

        System.out.print("Donam el telèfon: ");
        while (!lector.hasNextInt()) {
            System.out.print("Donam el telèfon: ");
            lector.nextLine();
        }
        telefon = String.valueOf(lector.nextInt());
        lector.nextLine();

        if (persones.length == 0) {
            idPersona = 0;
            personesAux = new String[1][5];

            personesAux[0][0] = String.valueOf(idPersona);
            personesAux[0][1] = nom;
            personesAux[0][2] = cognom;
            personesAux[0][3] = edat;
            personesAux[0][4] = telefon;

        } else {
            idPersona = Integer.parseInt(persones[persones.length - 1][0]) + 1;
            personesAux = new String[persones.length + 1][persones[0].length];

            for (int i = 0; i < persones.length; i++) {
                personesAux[i][0] = persones[i][0];
                personesAux[i][1] = persones[i][1];
                personesAux[i][2] = persones[i][2];
                personesAux[i][3] = persones[i][3];
                personesAux[i][4] = persones[i][4];
            }

            personesAux[personesAux.length - 1][0] = String.valueOf(idPersona);
            personesAux[personesAux.length - 1][1] = nom;
            personesAux[personesAux.length - 1][2] = cognom;
            personesAux[personesAux.length - 1][3] = edat;
            personesAux[personesAux.length - 1][4] = telefon;
        }
        persones = personesAux;
    }

    static void llistarPersones(String[][] persones, int idPersona, int posPersona, boolean trobat, Scanner lector) {
        if (persones.length == 0) {
            System.out.println("Encara no hi ha persones...");
        } else {
            System.out.println("*** Llista de totes les persones ***");
            System.out.printf("%3s %10s %10s %5s %10s\n", "id", "nom", "cognom", "edat", "telèfon");
            for (int i = 0; i < persones.length; i++) {
                System.out.printf("%3s %10s %10s %5s %10s\n",
                        persones[i][0], // id
                        persones[i][1], // nom
                        persones[i][2], // cognom
                        persones[i][3], // edat
                        persones[i][4]);// telèfon
            }
            System.out.println("");
        }
    }

    static void llistarPersona(String[][] persones, int idPersona, int posPersona, boolean trobat, Scanner lector) {
        if (persones.length == 0) {
            System.out.println("Encara no hi ha persones...");
        } else {
            System.out.println("Selecciona el id de la persona a llistar...");
            System.out.printf("%3s %10s %10s\n", "id", "nom", "cognom");
            for (int i = 0; i < persones.length; i++) {
                System.out.printf("%3s %10s %10s\n",
                        persones[i][0], // id
                        persones[i][1], // nom
                        persones[i][2]);// cognom
            }
            System.out.println("");

            while (!lector.hasNextInt()) {
                System.out.println("Has de posar un número");
                lector.nextLine();
            }
            idPersona = lector.nextInt();
            lector.nextLine();

            trobat = false;
            for (int i = 0; i < persones.length && !trobat; i++) {
                if (persones[i][0].equals(String.valueOf(idPersona))) {
                    posPersona = i;
                    trobat = true;
                }
            }

            if (trobat) {
                System.out.printf("%3s %10s %10s %5s %10s\n", "id", "nom", "cognom", "edat", "telèfon");
                System.out.printf("%3s %10s %10s %5s %10s\n",
                        persones[posPersona][0], // id
                        persones[posPersona][1], // nom
                        persones[posPersona][2], // cognom
                        persones[posPersona][3], // edat
                        persones[posPersona][4]);// telèfon
                System.out.println("");
            } else {
                System.out.println("El id de la persona no existeix...");
                System.out.println("");
            }
        }
    }

    static void modificarPersona(String[][] persones, String nom, String cognom, String edat, Scanner lector, String telefon, int idPersona, int posPersona, boolean trobat, String[][] personesAux) {
        if (persones.length == 0) {
            System.out.println("Encara no hi ha persones...");
        } else {
            System.out.println("Selecciona el id de la persona a llistar...");
            System.out.printf("%3s %10s %10s\n", "id", "nom", "cognom");
            for (int i = 0; i < persones.length; i++) {
                System.out.printf("%3s %10s %10s\n",
                        persones[i][0], // id
                        persones[i][1], // nom
                        persones[i][2]);// cognom
            }
            System.out.println("");

            while (!lector.hasNextInt()) {
                System.out.println("Has de posar un número");
                lector.nextLine();
            }
            idPersona = lector.nextInt();
            lector.nextLine();

            trobat = false;
            for (int i = 0; i < persones.length && !trobat; i++) {
                if (persones[i][0].equals(String.valueOf(idPersona))) {
                    posPersona = i;
                    trobat = true;
                }
            }

            if (trobat) {

                System.out.print("Donam el nom: ");
                nom = lector.nextLine();

                System.out.print("Donam el cognom: ");
                cognom = lector.nextLine();

                System.out.print("Donam l'edat: ");
                while (!lector.hasNextInt()) {
                    System.out.print("Donam l'edat: ");
                    lector.nextLine();
                }
                edat = String.valueOf(lector.nextInt());
                lector.nextLine();

                System.out.print("Donam el telèfon: ");
                while (!lector.hasNextInt()) {
                    System.out.print("Donam el telèfon: ");
                    lector.nextLine();
                }
                telefon = String.valueOf(lector.nextInt());
                lector.nextLine();

                persones[posPersona][1] = nom;
                persones[posPersona][2] = cognom;
                persones[posPersona][3] = edat;
                persones[posPersona][4] = telefon;

            } else {
                System.out.println("El id de la persona no existeix...");
                System.out.println("");
            }
        }
    }

    static void eliminarPersona(String[][] persones, Scanner lector, int idPersona, int posPersona, boolean trobat, String[][] personesAux) {
        if (persones.length == 0) {
            System.out.println("Encara no hi ha persones...");
        } else {
            System.out.println("Selecciona el id de la persona a llistar...");
            System.out.printf("%3s %10s %10s\n", "id", "nom", "cognom");
            for (int i = 0; i < persones.length; i++) {
                System.out.printf("%3s %10s %10s\n",
                        persones[i][0], // id
                        persones[i][1], // nom
                        persones[i][2]);// cognom
            }
            System.out.println("");

            while (!lector.hasNextInt()) {
                System.out.println("Has de posar un número");
                lector.nextLine();
            }
            idPersona = lector.nextInt();
            lector.nextLine();

            trobat = false;
            for (int i = 0; i < persones.length && !trobat; i++) {
                if (persones[i][0].equals(String.valueOf(idPersona))) {
                    posPersona = i;
                    trobat = true;
                }
            }

            if (trobat) {
                personesAux = new String[persones.length - 1][persones[0].length];

                if (posPersona == 0) {
                    for (int i = 1; i < persones.length; i++) {
                        personesAux[i - 1][0] = persones[i][0];
                        personesAux[i - 1][1] = persones[i][1];
                        personesAux[i - 1][2] = persones[i][2];
                        personesAux[i - 1][3] = persones[i][3];
                        personesAux[i - 1][4] = persones[i][4];
                    }
                } else if (posPersona == persones.length - 1) {
                    for (int i = 1; i < persones.length - 1; i++) {
                        personesAux[i][0] = persones[i][0];
                        personesAux[i][1] = persones[i][1];
                        personesAux[i][2] = persones[i][2];
                        personesAux[i][3] = persones[i][3];
                        personesAux[i][4] = persones[i][4];
                    }
                } else {
                    for (int i = 0, j = 0; i < persones.length; i++) {
                        if (posPersona != i) {
                            personesAux[j][0] = persones[i][0];
                            personesAux[j][1] = persones[i][1];
                            personesAux[j][2] = persones[i][2];
                            personesAux[j][3] = persones[i][3];
                            personesAux[j][4] = persones[i][4];
                            j++;
                        }
                    }
                }

                persones = personesAux;
            } else {
                System.out.println("El id de la persona no existeix...");
                System.out.println("");
            }
        }
    }
}
