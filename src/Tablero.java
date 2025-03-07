public class Tablero {
    private final int filas = 10;
    private final int columnas = 10;
    public static Casilla[][] tablero;


    public Tablero (){
         tablero = new Casilla[columnas][filas];
    }

    public int getColumnas() {
        return columnas;
    }

    public static Casilla[][] getTablero() {
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

    public void colocar_bombas() {
        int numero_minas = 20;
        int bombas_colocadas = 0;

        while (bombas_colocadas < numero_minas) {
            int fila = (int) (Math.random() * 10);
            int columna = (int) (Math.random() * 10);

            if (!tablero[columna][fila].isBomba() && tablero[columna][fila].isTapada() ) {
                tablero[columna][fila].setBomba(true);
                bombas_colocadas++;
            }
        }
    }


    public void contar_bombas(){
        int[][] desplazamientos = { {-1, -1}, {-1, 0}, {-1, 1}, {0, -1},{0, 1}, {1, -1},  {1, 0}, {1, 1}};

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

    public void mostrar_tablero(){
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


}
