import java.util.Scanner;

public class exercics {

    // Exercici 1

    /* public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalSenseIVA = 0;
        double iva = 0;
        double totalAmbIVA;

        System.out.println("Elaboracio de Pressupost");
        System.out.println("------------------------------");

        // Bucle per introduir articles fins que es premi 0
        while (true) {
            double preuUnitari;
            int unitats;

            System.out.print("Introdueixi la descripcio de l'article (o 0 per finalitzar): ");
            String descripcio = scanner.nextLine();

            // Sortir del bucle si s'entra "0"
            if (descripcio.equals("0")) {
                break;
            }

            System.out.print("Introdueixi el preu unitari de l'article: ");
            preuUnitari = scanner.nextDouble();

            System.out.print("Introdueixi la quantitat d'unitats: ");
            unitats = scanner.nextInt();

            // Netegar el buffer de l'entrada estàndard
            scanner.nextLine();

            // Calcular i mostrar el subtotal de l'article
            double subtotal = calcularSubtotal(preuUnitari, unitats);
            System.out.println("Subtotal: " + subtotal);

            // Acumular el subtotal al total sense IVA
            totalSenseIVA += subtotal;
        }

        // Calcular l'IVA i el total amb IVA
        iva = calcularIVA(totalSenseIVA);
        totalAmbIVA = totalSenseIVA + iva;

        // Mostrar resultats finals
        System.out.println("\nResum del Pressupost");
        System.out.println("------------------------------");
        System.out.println("Total sense IVA: " + totalSenseIVA);
        System.out.println("IVA: " + iva);
        System.out.println("Total amb IVA: " + totalAmbIVA);

        // Tancar el scanner
        scanner.close();
    }

    // Mètode per calcular el subtotal d'un article
    private static double calcularSubtotal(double preuUnitari, int unitats) {
        return preuUnitari * unitats;
    }

    // Mètode per calcular l'IVA
    private static double calcularIVA(double totalSenseIVA) {
        // Suposem un IVA del 21%
        return totalSenseIVA * 0.21;
    } */


    /* // Exercici 2
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Conversor de Velocitat");
            System.out.println("1. Convertir de Km/h a m/s");
            System.out.println("2. Convertir de m/s a Km/h");
            System.out.println("0. Sortir");

            System.out.print("Seleccioneu una opcio: ");
            int opcio = scanner.nextInt();

            // Netegar el buffer de l'entrada estàndard
            scanner.nextLine();

            if (opcio == 0) {
                break;
            }

            if (opcio == 1) {
                System.out.print("Introdueixi la velocitat en Km/h: ");
                double velocitatKmH = scanner.nextDouble();
                double velocitatMS = convertirKmH_a_MS(velocitatKmH);
                System.out.println("Velocitat en m/s: " + velocitatMS);
            } else if (opcio == 2) {
                System.out.print("Introdueixi la velocitat en m/s: ");
                double velocitatMS = scanner.nextDouble();
                double velocitatKmH = convertirMS_a_KmH(velocitatMS);
                System.out.println("Velocitat en Km/h: " + velocitatKmH);
            } else {
                System.out.println("Opció no vàlida. Si us plau, trieu una opció vàlida.");
            }
        }

        // Tancar el scanner
        scanner.close();
    }

    // Mètode per convertir de Km/h a m/s
    private static double convertirKmH_a_MS(double velocitatKmH) {
        return velocitatKmH * 1000 / 3600;
    }

    // Mètode per convertir de m/s a Km/h
    private static double convertirMS_a_KmH(double velocitatMS) {
        return velocitatMS * 3600 / 1000;
    } */
    
    /* // Exercici 3
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Conversor d'Unitats");
            System.out.println("------------------------------");
            System.out.println("1. Convertir de MB a KB");
            System.out.println("2. Convertir de MB a bits");
            System.out.println("3. Convertir de KB a bits");
            System.out.println("0. Sortir");

            System.out.print("Seleccioneu una opció: ");
            int opcio = scanner.nextInt();

            if (opcio == 0) {
                break; // Sortir del bucle si l'usuari selecciona 0
            }

            switch (opcio) {
                case 1:
                    convertirMBaKB();
                    break;
                case 2:
                    convertirMBaBits();
                    break;
                case 3:
                    convertirKBaBits();
                    break;
                default:
                    System.out.println("Opció no vàlida. Torneu a intentar.");
            }
        }

        // Tancar el scanner
        scanner.close();
    }

    private static void convertirMBaKB() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduïu la quantitat en MB: ");
        double quantitatMB = scanner.nextDouble();

        // Fórmula de conversió: 1 MB = 1024 KB
        double quantitatKB = quantitatMB * 1024;

        System.out.println("La quantitat en KB és: " + quantitatKB);
    }

    private static void convertirMBaBits() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduïu la quantitat en MB: ");
        double quantitatMB = scanner.nextDouble();

        // Fórmula de conversió: 1 MB = 8 * 1024 * 1024 bits
        double quantitatBits = quantitatMB * 8 * 1024 * 1024;

        System.out.println("La quantitat en bits és: " + quantitatBits);
    }

    private static void convertirKBaBits() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduïu la quantitat en KB: ");
        double quantitatKB = scanner.nextDouble();

        // Fórmula de conversió: 1 KB = 8 * 1024 bits
        double quantitatBits = quantitatKB * 8 * 1024;

        System.out.println("La quantitat en bits és: " + quantitatBits);
    } */

    /* // Exercici 4
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Simulador de Calculadora");
            System.out.println("------------------------------");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicació");
            System.out.println("4. Divisió");
            System.out.println("0. Sortir");

            System.out.print("Seleccioneu una opció: ");
            int opcio = scanner.nextInt();

            if (opcio == 0) {
                break; // Sortir del bucle si l'usuari selecciona 0
            }

            switch (opcio) {
                case 1:
                    realitzarSuma();
                    break;
                case 2:
                    realitzarResta();
                    break;
                case 3:
                    realitzarMultiplicacio();
                    break;
                case 4:
                    realitzarDivisio();
                    break;
                default:
                    System.out.println("Opció no vàlida. Torneu a intentar.");
            }
        }

        // Tancar el scanner
        scanner.close();
    }

    private static void realitzarSuma() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduïu el primer nombre: ");
        double operand1 = scanner.nextDouble();

        System.out.print("Introduïu el segon nombre: ");
        double operand2 = scanner.nextDouble();

        double resultat = operand1 + operand2;
        System.out.println("La suma és: " + resultat);
    }

    private static void realitzarResta() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduïu el primer nombre: ");
        double operand1 = scanner.nextDouble();

        System.out.print("Introduïu el segon nombre: ");
        double operand2 = scanner.nextDouble();

        double resultat = operand1 - operand2;
        System.out.println("La resta és: " + resultat);
    }

    private static void realitzarMultiplicacio() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduïu el primer nombre: ");
        double operand1 = scanner.nextDouble();

        System.out.print("Introduïu el segon nombre: ");
        double operand2 = scanner.nextDouble();

        double resultat = operand1 * operand2;
        System.out.println("La multiplicació és: " + resultat);
    }

    private static void realitzarDivisio() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduïu el dividend: ");
        double dividend = scanner.nextDouble();

        System.out.print("Introduïu el divisor: ");
        double divisor = scanner.nextDouble();

        if (divisor != 0) {
            double resultat = dividend / divisor;
            System.out.println("La divisió és: " + resultat);
        } else {
            System.out.println("Error: No es pot dividir per zero.");
        }
    }*/
    // Exercici 5

        public static void main(String[] args) {
            // Declarar i inicialitzar un array de 10 posicions
            int[] array = new int[10];
    
            // Inicialitzar l'array amb els valors de l'1 al 10
            for (int i = 0; i < array.length; i++) {
                array[i] = i + 1;
            }
    
            // Mostrar l'array abans d'afegir el nou valor
            System.out.println("Array original:");
            mostrarArray(array);
    
            // Afegeix un nou valor al final de l'array
            int nouValor = 11;
            array = afegirValorAlFinal(array, nouValor);
    
            // Mostrar l'array després d'afegir el nou valor
            System.out.println("\nArray amb el nou valor afegit:");
            mostrarArray(array);
        }
    
        // Mètode per mostrar els elements d'un array
        private static void mostrarArray(int[] array) {
            for (int valor : array) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
    
        // Mètode per afegir un nou valor al final d'un array
        private static int[] afegirValorAlFinal(int[] arrayOriginal, int nouValor) {
            // Crear un nou array amb una posició més
            int[] arrayNou = new int[arrayOriginal.length + 1];
    
            // Copiar els valors de l'array original al nou array
            System.arraycopy(arrayOriginal, 0, arrayNou, 0, arrayOriginal.length);
    
            // Afegir el nou valor al final del nou array
            arrayNou[arrayNou.length - 1] = nouValor;
    
            // Retornar el nou array
            return arrayNou;
        }
    }
      






