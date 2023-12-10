import java.util.Scanner;

public class Part3 {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        String[][] persones = new String[0][5];
        int opcio = 0;
        do {
            mostrarMenu();
            opcio = lector.nextInt();
            lector.nextLine();

            switch (opcio) {
                case 1:
                    persones = afegirPersona(persones, lector);
                    break;
                case 2:
                    llistarPersones(persones);
                    break;
                case 3:
                    llistarPersona(persones, lector);
                    break;
                case 4:
                    persones = modificarPersona(persones, lector);
                    break;
                case 5:
                    persones = eliminarPersona(persones, lector);
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
        System.out.println("3.Llistar persona"); // R-ead
        System.out.println("4.Modificar persona");// U-pdate
        System.out.println("5.Eliminar persona"); // D-elete
        System.out.println("0.Sortir");
    }

    static String[][] afegirPersona(String[][] persones, Scanner lector) {
        String nom, cognom, edat, telefon;
        int idPersona = 0;

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

        return afegirPersonaArray(persones, nom, cognom, edat, telefon, idPersona);
    }

    static String[][] afegirPersonaArray(String[][] persones, String nom, String cognom, String edat, String telefon, int idPersona) {
        String[][] personesAux;
        if (persones.length == 0) {
            idPersona = 0;
            personesAux = new String[1][5];
        } else {
            idPersona = Integer.parseInt(persones[persones.length - 1][0]) + 1;
            personesAux = new String[persones.length + 1][persones[0].length];
        }

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

        return personesAux;
    }

    static void llistarPersones(String[][] persones) {
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

    static void llistarPersona(String[][] persones, Scanner lector) {
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

            int idPersona;
            while (!lector.hasNextInt()) {
                System.out.println("Has de posar un número");
                lector.nextLine();
            }
            idPersona = lector.nextInt();
            lector.nextLine();

            int posPersona = trobarPersona(persones, idPersona);
            if (posPersona != -1) {
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

    static int trobarPersona(String[][] persones, int idPersona) {
        for (int i = 0; i < persones.length; i++) {
            if (persones[i][0].equals(String.valueOf(idPersona))) {
                return i;
            }
        }
        return -1;
    }

    static String[][] modificarPersona(String[][] persones, Scanner lector) {
        if (persones.length == 0) {
            System.out.println("Encara no hi ha persones...");
        } else {
            System.out.println("Selecciona el id de la persona a modificar...");
            System.out.printf("%3s %10s %10s\n", "id", "nom", "cognom");
            for (int i = 0; i < persones.length; i++) {
                System.out.printf("%3s %10s %10s\n",
                        persones[i][0], // id
                        persones[i][1], // nom
                        persones[i][2]);// cognom
            }
            System.out.println("");

            int idPersona;
            while (!lector.hasNextInt()) {
                System.out.println("Has de posar un número");
                lector.nextLine();
            }
            idPersona = lector.nextInt();
            lector.nextLine();

            int posPersona = trobarPersona(persones, idPersona);
            if (posPersona != -1) {
                String nom, cognom, edat, telefon;

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
        return persones;
    }

    static String[][] eliminarPersona(String[][] persones, Scanner lector) {
        if (persones.length == 0) {
            System.out.println("Encara no hi ha persones...");
        } else {
            System.out.println("Selecciona el id de la persona a eliminar...");
            System.out.printf("%3s %10s %10s\n", "id", "nom", "cognom");
            for (int i = 0; i < persones.length; i++) {
                System.out.printf("%3s %10s %10s\n",
                        persones[i][0], // id
                        persones[i][1], // nom
                        persones[i][2]);// cognom
            }
            System.out.println("");

            int idPersona;
            while (!lector.hasNextInt()) {
                System.out.println("Has de posar un número");
                lector.nextLine();
            }
            idPersona = lector.nextInt();
            lector.nextLine();

            int posPersona = trobarPersona(persones, idPersona);
            if (posPersona != -1) {
                persones = eliminarPersonaArray(persones, posPersona);
            } else {
                System.out.println("El id de la persona no existeix...");
                System.out.println("");
            }
        }
        return persones;
    }

    static String[][] eliminarPersonaArray(String[][] persones, int posPersona) {
        String[][] personesAux = new String[persones.length - 1][persones[0].length];

        if (posPersona == 0) {
            for (int i = 1; i < persones.length; i++) {
                personesAux[i - 1][0] = persones[i][0];
                personesAux[i - 1][1] = persones[i][1];
                personesAux[i - 1][2] = persones[i][2];
                personesAux[i - 1][3] = persones[i][3];
                personesAux[i - 1][4] = persones[i][4];
            }
        } else if (posPersona == persones.length - 1) {
            for (int i = 0; i < persones.length - 1; i++) {
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

        return personesAux;
    }
}

