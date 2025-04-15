import java.util.ArrayDeque;
import java.util.Queue;

public class Cine {
    Queue<Cliente> xmen;
    Queue<Cliente> mario;
    Queue<Cliente> batman;
    Queue<Cliente> todas;
    private int totalXmen = 0;
    private int totalMario = 0;
    private int totalBatman = 0;



    public Cine() {
    xmen = new ArrayDeque<>();
    mario = new ArrayDeque<>();
    batman = new ArrayDeque<>();
    todas = new ArrayDeque<>();


    }

    public int getTotalXmen() {
        return totalXmen;
    }

    public int getTotalMario() {
        return totalMario;
    }

    public int getTotalBatman() {
        return totalBatman;
    }

    public void agregarXmen(Cliente dato){
        xmen.add(dato);
        todas.add(dato);
    }

    public void agregarMario(Cliente dato){
        mario.add(dato);
        todas.add(dato);
    }

    public void agregarBatman(Cliente dato){
        batman.add(dato);
        todas.add(dato);
    }

    public String pagarXmen(Cliente c) throws Exception{
        if(xmen.isEmpty()){
            throw new Exception("No hay ventas");
        }
        else{
            StringBuilder sb = new StringBuilder();
            sb.append("Cliente con C.I:" + c.getCedula()+ " cancela: " + c.getEntradas()*5 +"$" + "\n");
           for (int i = 0; i < c.getEntradas(); i++){
                xmen.poll();
            }
             totalXmen = totalXmen + c.getEntradas()*5;
            return sb.toString();
        }

    }

    public String pagarMario(Cliente c) throws Exception{
        if(mario.isEmpty()){
            throw new Exception("No hay ventas");
        }
        else{
            StringBuilder sb = new StringBuilder();
            sb.append("Cliente con C.I:" + c.getCedula()+ " cancela: " + c.getEntradas()*5 +"$" + "\n");
            for (int i = 0; i < c.getEntradas(); i++){
                mario.poll();
            }
            totalMario = totalMario + c.getEntradas()*5;
            return sb.toString();
        }

    }

    public String pagarBatman(Cliente c) throws Exception{
        if(batman.isEmpty()){
            throw new Exception("No hay ventas");
        }
        else{
            StringBuilder sb = new StringBuilder();
            sb.append("Cliente con C.I:" + c.getCedula()+ " cancela: " + c.getEntradas()*5 +"$" + "\n");
            for (int i = 0; i < c.getEntradas(); i++){
                batman.poll();
            }
            totalBatman = totalBatman + c.getEntradas()*5;
            return sb.toString();
        }

    }


    public String listarTodos(Cliente c){
        StringBuilder sb = new StringBuilder();

            sb.append(c.toString()).append("\n");

        return sb.toString();

    }

}
