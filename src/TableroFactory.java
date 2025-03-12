public class TableroFactory {

    public static Tablero crearTablero(int nivell){

        switch(nivell){
            case 1:
                return new Tablero(8,8,10);

            case 2:
                return new Tablero(16,16,40);

            case 3:
                return new Tablero(16,30,99);


            default:
                return new Tablero(8,8,10);
        }

    }
}
