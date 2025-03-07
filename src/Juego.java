public class Juego {
    public void partida (){
        Tablero t = new Tablero();

        t.llenar_tablero();
        t.mostrar_tablero();

        boolean partida_finalizada = false;

        //primer turno
        turno();
        t.colocar_bombas();
        t.contar_bombas();

        while(!partida_finalizada){
            turno();
            t.mostrar_tablero();

        }

    }

    public void turno(){
        Textos.imprimir(Textos.Codigo.ELECCION);
        String eleccion = Textos.llegirString();

        if(eleccion.equalsIgnoreCase("m")){
            Textos.imprimir(Textos.Codigo.ELECCION_CASILLA_F);
            int fila = Textos.llegirInt ();
            Textos.imprimir(Textos.Codigo.ELECCION_CASILLA_C);
            int columna = Textos.llegirInt ();

            Tablero.tablero[fila][columna].setMarcada(true);

        } else if(eleccion.equalsIgnoreCase("d")){
            Textos.imprimir(Textos.Codigo.ELECCION_CASILLA_F);
            int fila = Textos.llegirInt ();
            Textos.imprimir(Textos.Codigo.ELECCION_CASILLA_C);
            int columna = Textos.llegirInt ();

            Tablero.tablero[columna][fila].setTapada(false);

        }

    }

}
