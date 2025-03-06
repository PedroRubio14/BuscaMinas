public class Tablero {
    private final int filas = 10;
    private final int columnas = 10;
    private static Casilla[][] tablero;


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
                tablero[y][i] = new Casilla(false,true,false);

            }
        }

        colocar_bombas();
    }

    public void colocar_bombas() {
        int numero_minas = 20;
        int bombas_colocadas = 0;

        while (bombas_colocadas < numero_minas) {
            int fila = (int) (Math.floor(Math.random() * 10));
            int columna = (int) (Math.floor(Math.random() * 10));

            if (!tablero[columna][fila].isBomba()) {
                tablero[columna][fila].setBomba(true);
                bombas_colocadas++;
            }
        }
    }


    private void contar_bombas(){

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
