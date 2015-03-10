package boletin23;

public class Boletin23 {

    public static void main(String[] args) {
        Libreria obx = new Libreria();
        boolean libroStock = false;
        int opcion;
        do {
            opcion = Libreria.menu();
            switch (opcion) {
                case 1:
                    obx.engadir("libreria.txt");
                    break;
                case 2:
                    obx.consultar(obx.inxerirTitulo(), "libreria.txt");
                    break;
                case 3:
                    obx.visualizar("libreria.txt");
                    break;
                case 4:
                    obx.borrar("libreria.txt");
                    break;
                case 5:
                    obx.modificar(obx.inxerirTitulo(), "libreria.txt");
                    break;
                case 6:
                    obx.ordear("libreria.txt");
                    break;
                case 7:
                    obx.buscarXAutor(obx.inxerirAutor(), "libreria.txt");
                    break;
                case 8:
                    if (opcion == 8 && opcion == 0) {
                        System.exit(0);
                    }
                    break;
            }
        } while (opcion != 8 && opcion != 0);
    }

}
