public class Juego {
    public void partida (){
        Tablero t = new Tablero(10,10);
        int numeroTurno = 0;
        boolean partida_finalizada = false;

        while(!partida_finalizada){
            if(numeroTurno == 0){
                t.llenar_tablero();
                Tablero.mostrar_tablero();
                primerTurno(t);
            } else {
                turno();
                Tablero.mostrar_tablero();
                partida_finalizada = (Tablero.ganador() || Tablero.perdedor());
            }
            numeroTurno++;

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

    }

    public void primerTurno(Tablero t){
            Textos.imprimir(Textos.Codigo.ELECCION_CASILLA_F);
            int fila = Textos.llegirInt ();
            Textos.imprimir(Textos.Codigo.ELECCION_CASILLA_C);
            int columna = Textos.llegirInt ();

            Tablero.destapar_primero(fila, columna,t);

    }


}
