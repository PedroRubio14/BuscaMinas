public class Juego {
    private static boolean partida_finalizada = false;

    public static void setPartida_finalizada(boolean partida_finalizada) {
        Juego.partida_finalizada = partida_finalizada;
    }

    public void partida (){
        Textos.imprimir(Textos.Codigo.DIFICULTAD);
        int dificultad = Textos.llegirInt ();
        Tablero t = TableroFactory.crearTablero(dificultad);
        int numeroTurno = 0;


        while(!partida_finalizada){
            if(numeroTurno == 0){

                t.llenar_tablero();
                Tablero.mostrar_tablero();
                primerTurno(t);
                Tablero.mostrar_tablero();
                numeroTurno++;
            } else {
                turno();
                if(partida_finalizada){
                    break;
                }
                Tablero.mostrar_tablero();
                numeroTurno++;
            }
            t.ganador(t);
        }

    }

    public void turno(){
        Textos.imprimir(Textos.Codigo.ELECCION_CASILLA_F);
        int fila = Textos.llegirInt ();
        Textos.imprimir(Textos.Codigo.ELECCION_CASILLA_C);
        int columna = Textos.llegirInt ();
        Textos.imprimir(Textos.Codigo.ESPACIO);

        Textos.imprimir(Textos.Codigo.ELECCION);
        Textos.llegirString();
        Textos.imprimir(Textos.Codigo.ESPACIO);
        String eleccion = Textos.llegirString();

        if(eleccion.equalsIgnoreCase("m")){

            if(!Tablero.tablero[fila][columna].isMarcada() &&  Tablero.tablero[fila][columna].isTapada()){
                Tablero.tablero[fila][columna].setMarcada(true);
            }

        } else if(eleccion.equalsIgnoreCase("d")){
            Tablero.destapar(fila, columna);
        }

        else if(eleccion.equalsIgnoreCase("DM")){
            Tablero.tablero[fila][columna].setMarcada(false);
        }

    }

    public void primerTurno(Tablero t){
            Textos.imprimir(Textos.Codigo.ELECCION_CASILLA_F);
            int fila = Textos.llegirInt ();
            Textos.imprimir(Textos.Codigo.ELECCION_CASILLA_C);
            int columna = Textos.llegirInt ();

            Tablero.destapar_primero(fila, columna,t);

    }


}
