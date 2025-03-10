import java.util.Scanner;

public class Textos {
    static Scanner sc = new Scanner(System.in);

    public static int llegirInt (){
        return sc.nextInt();
    }

    public static String llegirString() {
        return sc.nextLine();
    }

    public static final String RESET = "\033[0m";
    public static final String GRIS = "\033[37m";
    public static final String ROJO = "\033[31m";
    public static final String AZUL = "\033[34m";

    public static final String[] COLORES_BOMBAS = {
            "\033[37m", // Gris
            "\033[34m", // Azul
            "\033[32m", // Verde
            "\033[31m", // Rojo
            "\033[35m", // Magenta
            "\033[36m", // Cian
            "\033[33m", // Amarillo
            "\033[91m", // Rojo claro
            "\033[94m", // Azul claro
    };


    public enum Codigo {
        ESPACIO,
        PARTIDA_FINALIZADA,
        CASILLA_TAPADA,
        CASILLA_BOMBA,
        CASILLA_MARCADA,
        CASILLA_DESTAPADA,
        ELECCION,
        ELECCION_CASILLA_F,
        ELECCION_CASILLA_C,
        GANADOR,
        PERDEDOR,

    }
    public static void imprimir (Codigo codigo, Object...args){
        switch (codigo){
            case PARTIDA_FINALIZADA:
                System.out.print("La partida ha finalizado");
                break;

            case CASILLA_TAPADA:
                System.out.printf("[%2s]", GRIS + "⬜" + RESET);
                break;

            case CASILLA_BOMBA:
                System.out.printf("[%2s]", ROJO + "💣" + RESET);
                break;

            case CASILLA_MARCADA:
                System.out.printf("[%2s]",AZUL +"🚩" + RESET);
                break;

            case CASILLA_DESTAPADA:
                if(args.length > 0 && args[0] instanceof Casilla c){
                    int numBombas = c.getNum_bombas();
                    String color = COLORES_BOMBAS[numBombas];
                    System.out.printf("[%s%2d%s]", color, numBombas, RESET);
                }

                break;

            case ESPACIO:
                System.out.println();
                break;

            case ELECCION:
                System.out.println();
                System.out.println("Que quieres hacer? ");
                System.out.println("Marcar casilla? M");
                System.out.println("Destapar casilla? D");
                break;

            case ELECCION_CASILLA_F:
                System.out.println();
                System.out.println("FILA: ");
                break;

            case ELECCION_CASILLA_C:
                System.out.println("COLUMNA: ");
                break;
            case GANADOR:
                System.out.println();
                System.out.println("HAS GANDO!!");
                break;
            case PERDEDOR:
                System.out.println();
                System.out.println("HAS PERDIDO  :( ");
                break;




        }

    }
}
