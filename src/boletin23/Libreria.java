package boletin23;

import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.JOptionPane;

public class Libreria {

    public Libreria() {
    }

    public static int menu() {
        int opcion = JOptionPane.showOptionDialog(null, "Selecciona unha opción", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{"engadir", "consultar", "visualizar", "borrar", "modificar", "exit"}, "exit");
        return opcion + 1;
    }
    Libros libros = new Libros();
    PrintWriter escribe;
    ArrayList<Libros> libreria = new ArrayList<>();
    Scanner ler;

    public ArrayList<Libros> engadir(String nomeF) {

        try {
            escribe = new PrintWriter(new FileWriter(new File(nomeF), true));
            int outroLibro;
            do {
                String nome = JOptionPane.showInputDialog("Escribe o nome");
                String autor = JOptionPane.showInputDialog("Escribe o autor");
                float prezo = Float.parseFloat(JOptionPane.showInputDialog("escribe o prezo"));
                int unidades = Integer.parseInt(JOptionPane.showInputDialog("Escribe o no de uds"));
                libreria.add(new Libros(nome, autor, prezo, unidades));
                escribe.println("libro: " + nome + "\tautor: " + autor + "\tprezo: " + prezo + "\tuds: " + unidades);
                outroLibro = JOptionPane.showConfirmDialog(null, "engadir outro libro?");
            } while (outroLibro == 0);
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

    public String inxerirTitulo() {
        String titulo = JOptionPane.showInputDialog("Introduce o titulo do libro que queres atopar");
        return titulo;

    }
     public String inxerirAutor() {
        String autor = JOptionPane.showInputDialog("Introduce o nome do autor que queres atopar");
        return autor;

    }

    public void consultar(String titulo, String nomeF) {
        try {
            ler = new Scanner(new File(nomeF));
            if (ler.hasNextLine() && ler.nextLine() == "libro: " + titulo) {
                JOptionPane.showMessageDialog(null, "Prezo de " + titulo + ": " + ler.nextFloat());

            } else {
                JOptionPane.showMessageDialog(null, "O libro: " + titulo + " non está na nosa libreria");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Libreria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void visualizar(String nomeF) {
        String letura;
        try {
            ler = new Scanner(new File(nomeF));
            while (ler.next() != null) {
                letura = ler.next();
                JOptionPane.showMessageDialog(null, ler.next());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("ERRO" + ex.toString());
        } finally {
            ler.close();
        }
    }
    public ArrayList<Libros> borrar(String nomeF){
        try {
            ler=new Scanner(new File(nomeF));
            escribe=new PrintWriter(new File(nomeF));
            while(ler.hasNextInt()&&ler.nextInt()==0){
                libreria.remove(ler.nextLine());
                ler.remove();
            }
            return libreria;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Libreria.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ler.close();
            escribe.close();
        }
        return libreria;
    }
    public ArrayList<Libros> modificar(String titulo, String nomeF){
        try {
            ler=new Scanner(new File(nomeF));
            escribe=new PrintWriter(new File(nomeF));
            if (titulo==ler.nextLine()){
                JOptionPane.showMessageDialog(null, "o prezo de "+titulo+" é "+ler.nextFloat());
                float novoPrezo=Float.parseFloat(JOptionPane.showInputDialog("Introduce o novo prezo"));
                escribe.print(novoPrezo);
                libreria.set(libreria.indexOf(ler.nextFloat()), new Libros(libros.getNome(), libros.getAutor(),novoPrezo,libros.getUnidades()));
            }
            return libreria;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Libreria.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            escribe.close();
            ler.close();
        }
        return libreria;
        
    }
    public void ordear(String nomeF){
        try {
            escribe=new PrintWriter(new File(nomeF));
            libreria.sort(null);
            escribe.print(libreria);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Libreria.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            escribe.close();
        }
    }
     public void buscarXAutor(String autor, String nomeF) {
        try {
            ler = new Scanner(new File(nomeF));
            if (ler.hasNextLine() && ler.nextLine() == "libro: " + autor) {
                JOptionPane.showMessageDialog(null, "Prezo de " + autor + ": " + ler.nextFloat());

            } else {
                JOptionPane.showMessageDialog(null, autor + " non ten libros na nosa libreria");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Libreria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
