package boletin23;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Libreria {

    public Libreria() {
    }

    public static int menu() {
        int opcion = JOptionPane.showOptionDialog(null, "Selecciona unha opción", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{"engadir", "consultar", "visualizar", "borrar", "modificar", "exit"}, "exit");
        return opcion + 1;
    }
    PrintWriter escribe;
    ArrayList<Libros> libreria = new ArrayList<>();

    public ArrayList<Libros> engadir(String nomeF) {
      
        try {
            escribe = new PrintWriter(new FileWriter(new File(nomeF),true));
            int outroLibro;
            do{
            String nome = JOptionPane.showInputDialog("Escribe o nome");
            String autor = JOptionPane.showInputDialog("Escribe o autor");
            float prezo = Float.parseFloat(JOptionPane.showInputDialog("escribe o prezo"));
            int unidades = Integer.parseInt(JOptionPane.showInputDialog("Escribe o no de uds"));
            libreria.add(new Libros(nome, autor, prezo, unidades));
            outroLibro=JOptionPane.showConfirmDialog(null, "engadir outro libro?");
            }while(outroLibro==0);
            for (Object ob : libreria) {
                
                escribe.println(" " + libreria);
            }
            return libreria;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Libreria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Libreria.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            escribe.close();
        }
        return libreria;
    }
}
