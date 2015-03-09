
package boletin23;

public class Boletin23 {

    public static void main(String[] args) {
      Libreria obx=new Libreria();
      boolean libroStock=false;
      int opcion;
      do{
          opcion=Libreria.menu();
          switch(opcion){
              case 1:
                  obx.engadir("libreria.txt");
                  break;
              case 2:
                  //obx.consultar();
                  break;
              case 3:
                  //obx.visualizar();
                  break;
              case 4:
                  //obx.borrar();
                  break;
              case 5:
                  //obx.modificar();
                  break;
              case 6:
                  if (opcion==6&&opcion==0){
                      System.exit(0);
                  }
              break;
          }
      }while(opcion!=6&&opcion!=0);
    }
    
}
