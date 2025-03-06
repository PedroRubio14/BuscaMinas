public class Tablero {
    private final int filas = 10;
    private final int columnas = 10;
    private static Casilla[][] tablero;
    private static int numero_minas = 20;


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
        this.tablero = tablero;
    }

    public int getFilas() {
        return filas;
    }

    private void colocar_bombas(){

        for(int i = 0; i < numero_minas;i++){
            int fila = (int) (Math.floor(Math.random()*(10+1)));
            int columna = (int) (Math.floor(Math.random()*(10+1)));
            if(!tablero[columna][fila].isBomba() ){
                tablero[columna][fila].setBomba(true);
            } else {
                i--;
            }
        }
    }

    private void contar_bombas(){

    }

}
