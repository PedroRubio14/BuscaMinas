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
        this.tablero = tablero;
    }

    public int getFilas() {
        return filas;
    }
}
