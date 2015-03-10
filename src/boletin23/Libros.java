
package boletin23;

public class Libros {
    private String nome;
    private String autor;
    private float prezo;
    private int unidades;

    public Libros() {
    }

    public Libros(String nome, String autor, float prezo, int unidades) {
        this.nome = nome;
        this.autor = autor;
        this.prezo = prezo;
        this.unidades = unidades;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public float getPrezo() {
        return prezo;
    }

    public void setPrezo(float prezo) {
        this.prezo = prezo;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return "Libros " + "nome=" + nome + ", autor=" + autor + ", prezo=" + prezo + ", unidades=" + unidades ;
    }
    
}
