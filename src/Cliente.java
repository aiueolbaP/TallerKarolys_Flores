public class Cliente {
    private String cedula;
    private String pelicula;
    private int entradas;


    public Cliente(String cedula, String pelicula, int entradas) {
        this.cedula = cedula;
        this.pelicula = pelicula;
        this.entradas = entradas;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    public int getEntradas() {
        return entradas;
    }

    public void setEntradas(int entradas) {
        this.entradas = entradas;
    }

    @Override
    public String toString() {
        return "Cliente: " + cedula + ", pelicula: " + pelicula + ", entradas: " + entradas;
    }
}
