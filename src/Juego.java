public class Juego {
    private static boolean partida_finalizada = false;

    public static void setPartida_finalizada(boolean partida_finalizada) {
        Juego.partida_finalizada = partida_finalizada;
    }

    public void partida (){
        Tablero t = new Tablero(10,10,80);
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
        Textos.imprimir(Textos.Codigo.ELECCION);
        Textos.llegirString();
        Textos.imprimir(Textos.Codigo.ESPACIO);
        String eleccion = Textos.llegirString();

        if(eleccion.equalsIgnoreCase("m")){
            Textos.imprimir(Textos.Codigo.ELECCION_CASILLA_F);
            int fila = Textos.llegirInt ();
            Textos.imprimir(Textos.Codigo.ELECCION_CASILLA_C);
            int columna = Textos.llegirInt ();

            if(!Tablero.tablero[fila][columna].isMarcada() &&  Tablero.tablero[fila][columna].isTapada()){

                Tablero.tablero[fila][columna].setMarcada(true);
            }



        } else if(eleccion.equalsIgnoreCase("d")){
            Textos.imprimir(Textos.Codigo.ELECCION_CASILLA_F);
            int fila = Textos.llegirInt ();
            Textos.imprimir(Textos.Codigo.ELECCION_CASILLA_C);
            int columna = Textos.llegirInt ();

            Tablero.destapar(fila, columna);

        }

        else if(eleccion.equalsIgnoreCase("DM")){
            Textos.imprimir(Textos.Codigo.ELECCION_CASILLA_F);
            int fila = Textos.llegirInt ();
            Textos.imprimir(Textos.Codigo.ELECCION_CASILLA_C);
            int columna = Textos.llegirInt ();

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
