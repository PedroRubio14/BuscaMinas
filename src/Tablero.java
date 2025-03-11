public class Tablero {
    private int filas ;
    private int columnas;
    public static Casilla[][] tablero;
    private static final int[][] desplazamientos = { {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};


    public Tablero (int filas, int columnas){
        this.filas = filas;
        this.columnas = columnas;
         tablero = new Casilla[columnas][filas];
    }

    public int getColumnas() {
        return columnas;
    }

    public  Casilla[][] getTablero() {
        return tablero;
    }

    public void setTablero(Casilla[][] tablero) {
        Tablero.tablero = tablero;
    }

    public int getFilas() {
        return filas;
    }

    public void llenar_tablero(){
        for(int i = 0; i<tablero.length;i++) {
            for (int y = 0; y < tablero[1].length; y++) {
                tablero[y][i] = new Casilla(false,true,false,0);

            }
        }
    }

    public static void colocar_bombas(Tablero t) {
        int numero_minas = 30;
        int bombas_colocadas = 0;

        while (bombas_colocadas < numero_minas) {
            int fila = (int) (Math.random() * t.getFilas());
            int columna = (int) (Math.random() * t.getColumnas());

            if (!tablero[columna][fila].isBomba() && tablero[columna][fila].isTapada() ) {
                tablero[columna][fila].setBomba(true);
                bombas_colocadas++;
            }
        }
    }


    public static void contar_bombas(){
        for (int i = 0; i < tablero.length; i++) {
            for (int y = 0; y < tablero[i].length; y++) {
                if(tablero[i][y].isBomba()){

                    for (int k = 0; k < desplazamientos.length; k++) {
                        int nuevaFila = i + desplazamientos[k][0];
                        int nuevaColumna = y + desplazamientos[k][1];

                        if (nuevaFila >= 0 && nuevaFila < tablero.length &&
                                nuevaColumna >= 0 && nuevaColumna < tablero[i].length
                                && !tablero[nuevaFila][nuevaColumna].isBomba()) {
                                tablero[nuevaFila][nuevaColumna].setNum_bombas(tablero[nuevaFila][nuevaColumna].getNum_bombas()+1);

                        }
                    }
                }
            }
        }
    }

    public static void mostrar_tablero(){
            for (int i = 0; i < tablero.length; i++) {
                for (int y = 0; y < tablero[i].length; y++) {
                    if(y%10 == 0){
                        Textos.imprimir(Textos.Codigo.ESPACIO);
                    }
                    if (tablero[i][y].isMarcada()) {
                        Textos.imprimir(Textos.Codigo.CASILLA_MARCADA, tablero[i][y]);
                    }
                    else if (tablero[i][y].isTapada()) {
                        Textos.imprimir(Textos.Codigo.CASILLA_TAPADA, tablero[i][y]);
                    }
                    else if (!tablero[i][y].isTapada() && !tablero[i][y].isBomba()) {
                        Textos.imprimir(Textos.Codigo.CASILLA_DESTAPADA, tablero[i][y]);
                    }
                    else if (!tablero[i][y].isTapada() && tablero[i][y].isBomba()) {
                        Textos.imprimir(Textos.Codigo.CASILLA_BOMBA, tablero[i][y]);
                    }
                }
            }
    }

    public static boolean ganador(){
        for (int i = 0; i < tablero.length; i++) {
            for (int y = 0; y < tablero[i].length; y++) {

                if(tablero[i][y].isTapada() && !tablero[y][i].isBomba()){
                    return false;

                }


            }
        }
        Textos.imprimir(Textos.Codigo.GANADOR);
        return true;
    }

    public static boolean perdedor(){
        for (int i = 0; i < tablero.length; i++) {
            for (int y = 0; y < tablero[i].length; y++) {

                if(!tablero[y][i].isTapada() && tablero[y][i].isBomba()){
                    Textos.imprimir(Textos.Codigo.PERDEDOR);
                    mostrar_bombas();

                    return true;

                }


            }
        }
        return false;

    }
    public static void mostrar_bombas (){
        for (int i = 0; i < tablero.length; i++) {
            for (int y = 0; y < tablero[i].length; y++) {

                if(tablero[i][y].isBomba()){
                    tablero[i][y].setTapada(false);

                }

            }
        }
        mostrar_tablero();
    }


    public static void destapar(int fila, int columna) {
       if (fila < 0 || fila >= tablero.length || columna < 0 || columna >= tablero[0].length
                || !tablero[fila][columna].isTapada() || tablero[fila][columna].isMarcada()) {
            return;
        }



        tablero[fila][columna].setTapada(false);
        if(tablero[fila][columna].getNum_bombas() == 0){
            Destapar_ceros(fila, columna);
        }


    }



    public static void destapar_primero(int fila, int columna, Tablero t){

        if (fila < 0 || fila >= tablero.length || columna < 0 || columna >= tablero[0].length) {
            return;
        }

        tablero[fila][columna].setTapada(false);


        for (int k = 0; k < desplazamientos.length; k++) {
            int nuevaFila = fila + desplazamientos[k][0];
            int nuevaColumna = columna + desplazamientos[k][1];

            if (nuevaFila >= 0 && nuevaFila < tablero.length &&
                    nuevaColumna >= 0 && nuevaColumna < tablero[fila].length) {
                     tablero[nuevaFila][nuevaColumna].setTapada(false);

            }

        }

        colocar_bombas(t);
        contar_bombas();

        for (int k = 0; k < desplazamientos.length; k++) {
            int nuevaFila = fila + desplazamientos[k][0];
            int nuevaColumna = columna + desplazamientos[k][1];

            if (nuevaFila >= 0 && nuevaFila < tablero.length &&
                    nuevaColumna >= 0 && nuevaColumna < tablero[fila].length) {
                Destapar_ceros(nuevaColumna,nuevaColumna );

            }

        }




    }

    private static void Destapar_ceros(int fila, int columna) {
        int[][] desplazamientos = { {-1, -1}, {-1, 0}, {-1, 1}, {0, -1},{0, 1}, {1, -1},  {1, 0}, {1, 1}};

        if (tablero[fila][columna].getNum_bombas() == 0 && !tablero[fila][columna].isBomba()) {


            for (int i = 0; i < desplazamientos.length; i++) {
                int nuevaFila = fila + desplazamientos[i][0];
                int nuevaColumna = columna + desplazamientos[i][1];

                if (nuevaFila >= 0 && nuevaFila < tablero.length && nuevaColumna >= 0 && nuevaColumna < tablero[0].length
                        && tablero[nuevaFila][nuevaColumna].isTapada() && !tablero[nuevaFila][nuevaColumna].isMarcada()) {

                    tablero[nuevaFila][nuevaColumna].setTapada(false);

                    if( tablero[nuevaFila][nuevaColumna].getNum_bombas()==0){
                        Destapar_ceros(nuevaFila, nuevaColumna);
                    }
                }

            }
        }
    }


}
