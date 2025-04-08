import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int [][] anfi ;
        int option;
        anfi = cracionAnfiteatro(); //Creacion del anfiteatro

        System.out.println("Bienvenido al anfiteatro de Maipu\n");
        while (true){
            option = menu();
            if (option== 1){
                mostrarAnfiteatro(anfi); //Muestro el anfiteatro
            }else if (option == 2) {
                comprarEntradas(anfi);
            } else if (option == 3) {
                break;
            } else {
                System.out.println("El valor ingresado no es valido");
            }
        }

        System.out.println("ADIOS!!");
    }

    //Menu
    public static int menu(){
        Scanner sc = new Scanner(System.in);
        int option;
        System.out.println("""
                        Elija una de las siguientes opciones:\s
                        1)_Ver asientos disponibles
                        2)_Comprar entradas para un asiento
                        3)_Salir
                        """);
        while (true){
            try {
                System.out.print("--->");
                option = sc.nextInt();
                break;
            }catch (InputMismatchException e){
                System.out.println("El valor ingresado no es valido");
                sc.nextLine();
            }
        }
        return option;
    }

    //Creacion de anfiteatro
    public static int [][] cracionAnfiteatro(){
        int [][] anfiteatro = new int[10][10];

        for (int i = 0; i <= 9; i++){
            for (int z = 0; z <= 9; z++){
                anfiteatro[i][z] = 0; //Asiento vacio
            }
        }
        return anfiteatro;
    }

    //Muestro el anfiteatro
    public static void mostrarAnfiteatro(int [][] anfi){
        for (int i = 0; i <= 9; i++){
            for (int z = 0; z <= 9; z++ ){
                if (anfi[i][z] == 0){
                    System.out.print("[L]");
                }else System.out.print("[X]");
            }
            System.out.println(" ");
        }
    }

    //Funcion para comprar las entradas
    public static void comprarEntradas(int [][] anfi){
        Scanner sc = new Scanner(System.in);
        int fila, columna;
        while (true){
            try {
                System.out.println(" ");
                System.out.println("Elija fila en la que desea estar: ");
                System.out.print("--->");
                fila = sc.nextInt();
                System.out.println("Elija la columna en la que desea estar: ");
                System.out.print("--->");
                columna = sc.nextInt();

                if (fila > 9 || columna > 9 || fila < 0 || columna < 0) {
                    System.out.println("No existe ese asiento");
                }else{
                    //Si esta desocupada
                    if (anfi[fila][columna] == 0){
                        anfi[fila][columna] = 1;
                        break;
                    }else {
                        //Si esta ocupada
                        System.out.println("No es posible, asiento ocupado");
                    }
                }

            }catch (Exception e){
                System.out.println("Valor ingresado no valido");
                sc.nextLine();
            }
        }
    }
}