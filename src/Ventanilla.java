import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Ventanilla {
    private JPanel principal;
    private JTextField txtCedula;
    private JComboBox cboPelicula;
    private JTextField txtCantidad;
    private JTextArea txtCompras;
    private JButton btnComprar;
    private JButton btnPagar;
    private JTextArea txtTotales;
    private JLabel lblXmen;
    private JLabel lblMario;
    private JLabel lblBatman;
    private Cine peliculas = new Cine();

    public Ventanilla() {
        btnComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedula = txtCedula.getText();
                String pelicula = cboPelicula.getSelectedItem().toString();
                int entradas = Integer.parseInt(txtCantidad.getText());

                if(Objects.equals(pelicula, "XMEN" ) && entradas <= 5 && entradas >=1){

                    if (peliculas.xmen.size()+entradas < 18 ){

                        for(int i = 0; i < entradas; i++){
                            peliculas.agregarXmen(new Cliente(cedula,pelicula, entradas));
                        }
                        txtCompras.append(peliculas.listarTodos(new Cliente(cedula,pelicula,entradas)));

                    } else {
                        JOptionPane.showMessageDialog(null, "Limite de la sala xmen alcanzado");
                    }


                } else if(Objects.equals(pelicula, "MARIO" ) && entradas <= 5 && entradas >=1){
                    if (peliculas.mario.size()+entradas < 18 ){

                        for(int i = 0; i < entradas; i++){
                            peliculas.agregarMario(new Cliente(cedula,pelicula, entradas));
                        }
                        txtCompras.append(peliculas.listarTodos(new Cliente(cedula,pelicula,entradas)));

                    } else {
                        JOptionPane.showMessageDialog(null, "Limite de la sala Mario alcanzado");
                    }
                } else if(Objects.equals(pelicula, "BATMAN" ) && entradas <= 5 && entradas >=1){
                    if (peliculas.batman.size()+entradas < 18 ){

                        for(int i = 0; i < entradas; i++){
                            peliculas.agregarBatman(new Cliente(cedula,pelicula, entradas));
                        }
                        txtCompras.append(peliculas.listarTodos(new Cliente(cedula,pelicula,entradas)));

                    } else {
                        JOptionPane.showMessageDialog(null, "Limite de la sala Batman alcanzado");
                    }
                }

                else{
                    JOptionPane.showMessageDialog(null, "Cantidad de entradas invalida");
                }


            }
        });
        btnPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String pelicula = peliculas.todas.peek().getPelicula();
                    if (Objects.equals(pelicula, "XMEN")){
                        txtTotales.append(peliculas.pagarXmen(peliculas.todas.poll()));
                        lblXmen.setText("TOTAL XMEN: "+ peliculas.getTotalXmen());
                    }else if (Objects.equals(pelicula, "MARIO")){
                        txtTotales.append(peliculas.pagarMario(peliculas.todas.poll()));
                        lblMario.setText("TOTAL MARIO: "+ peliculas.getTotalMario());
                    } else if (Objects.equals(pelicula, "BATMAN")){
                        txtTotales.append(peliculas.pagarBatman(peliculas.todas.poll()));
                        lblBatman.setText("TOTAL BATMAN: "+ peliculas.getTotalBatman());
                    }


                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventanilla");
        frame.setContentPane(new Ventanilla().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
