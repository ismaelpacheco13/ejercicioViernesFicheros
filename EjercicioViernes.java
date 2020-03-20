
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class EjercicioViernes {

  public static void main(String[] args) {
    
    if (args.length != 1) {
      System.out.println("Uso del programa: EjercicioViernes opcion");
      System.out.println("Las opciones son: primo / no_primo / capicua / par / impar");
      System.exit(-1);
    }
    
    try {
      
      // If's para elegir el nombre del fichero en función de la opción elegida
      String nombre = "";
      if (args[0].equalsIgnoreCase("primo")) {
        nombre = "primo.dat";
      } else if (args[0].equalsIgnoreCase("no_primo")) {
        nombre = "no_primo.dat";
      } else if (args[0].equalsIgnoreCase("capicua")) {
        nombre = "capicua.dat";
      } else if (args[0].equalsIgnoreCase("par")) {
        nombre = "par.dat";
      } else if (args[0].equalsIgnoreCase("impar")) {
        nombre = "impar.dat";
      }
      
      BufferedWriter bw = new BufferedWriter(new FileWriter(nombre));
      
      for (int i = 1; i <= 500; i++) {
        if (args[0].equalsIgnoreCase("primo")) {
          if (esPrimo(i)) {
            bw.write(String.valueOf(i) + "\n");
          }
        } else if (args[0].equalsIgnoreCase("no_primo")) {
          if (!esPrimo(i)) {
            bw.write(String.valueOf(i) + "\n");
          }
        } else if (args[0].equalsIgnoreCase("capicua")) {
          if (esCapicua(i)) {
            bw.write(String.valueOf(i) + "\n");
          }
        } else if (args[0].equalsIgnoreCase("par")) {
          if (esPar(i)) {
            bw.write(String.valueOf(i) + "\n");
          }
        } else if (args[0].equalsIgnoreCase("impar")) {
          if (!esPar(i)) {
            bw.write(String.valueOf(i) + "\n");
          }
        }
      }
      bw.close();
    } catch (IOException ioe) {
      System.out.println("Error en la escritura");
    }
  }
  
  // Calcular si el número primo
  public static boolean esPrimo(int x) {
    for (int i = 2; i < x; i++) {
      if ((x % i) == 0) {
        return false;
      }
    }
    return true;
  }

  // Calcular si el número es capicúa
  public static boolean esCapicua(long x) {
    return x == voltea(x);
  }

  public static boolean esCapicua(int x) {
    return esCapicua((long) x);
  }

  // Función voltea para usar en capicúa
  public static long voltea(long x) {
    if (x < 0) {
      return -voltea(-x);
    }

    long volteado = 0;

    while (x > 0) {
      volteado = (volteado * 10) + (x % 10);
      x = x / 10;
    }

    return volteado;
  }

  public static int voltea(int x) {
    return (int) voltea((long) x);
  }
  
  // Función que calcula si el número es par o impar
  public static boolean esPar(int x) {
    if ((x % 2) == 0) {
      return true;
    } else {
      return false;
    }
  }
}
