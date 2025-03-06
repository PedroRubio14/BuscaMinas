import java.util.Scanner;

public class Textos {
    static Scanner sc = new Scanner(System.in);

    public static int llegirInt (){
        return sc.nextInt();
    }

    public static String llegirString() {
        return sc.nextLine();
    }

    public enum Codigo {
        ESPACIO,
        PARTIDA_FINALIZADA,
        CASILLA_TAPADA,
        CASILLA_BOMBA,
        CASILLA_MARCADA,
        CASILLA_DESTAPADA,

    }

    public static void mostrarTablero(Tablero t){

    }


    public static void imprimir (Codigo codigo, Object...args){
        switch (codigo){
            case PARTIDA_FINALIZADA:
                System.out.print("La partida ha finalizado");
                break;

            case CASILLA_TAPADA:
                System.out.print("[||]");
                break;

            case CASILLA_BOMBA:
                System.out.print("[X]");
                break;

            case CASILLA_MARCADA:
                System.out.print("[+]");
                break;

            case CASILLA_DESTAPADA:
                System.out.print("["+Casilla.getNum_bombas()+"]");
                break;

            case ESPACIO:
                System.out.println();
                break;


        }

    }
}
