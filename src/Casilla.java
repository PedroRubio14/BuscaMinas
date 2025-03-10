public class Casilla {

    private boolean tapada;
    private boolean bomba;
    private boolean marcada;


    private int num_bombas = 0;

    public Casilla(boolean bomba, boolean tapada, boolean marcada, int num_bombas) {
        this.bomba = bomba;
        this.tapada = tapada;
        this.marcada = marcada;
        this.num_bombas = 0;
    }

    public boolean isTapada() {
        return tapada;
    }

    public void setTapada(boolean tapada) {
        this.tapada = tapada;
    }

    public boolean isBomba() {
        return bomba;
    }

    public void setBomba(boolean bomba) {
        this.bomba = bomba;
    }

    public boolean isMarcada() {
        return marcada;
    }

    public void setMarcada(boolean marcada) {
        this.marcada = marcada;
    }

    public int getNum_bombas() {
        return num_bombas;
    }

    public void setNum_bombas(int num_bombas) {
        this.num_bombas = num_bombas;
    }

}
