import java.util.*;
import java.util.Scanner;

public class EjemploTS 
{
    int llamados = 0;
    static ArrayList<String> ejemplo = new ArrayList<String>();
    static List<String> palabras = new ArrayList<String>();
    //static Lexer analizadorLexico = new Lexer();
    public static class Token 
    {
        public final String t;
        public final String c; // contents

        public Token(String t, String c) 
        {
            this.t = t;
            this.c = c;
        }
    }
    public void Tabla() 
    {
        //EJEMPLOS
        String c= "Indefinido",d ="indefinido";
        //Este contador cuanta las posiciones de los elementos detectados
        int contador = -1;
        System.out.println("╔════════════════════╗");
        System.out.println("║  TABLA DE SIMBOLOS ║");
        System.out.println("╠════════════════════╣");
        System.out.println("║   Nombre/Simbolo   ║");
        System.out.println("╠════════════════════╣");
        for (int i = 0; i < palabras.size(); i++)
        {
        System.out.println("║"+palabras.get(i));
        }
        System.out.println("╚════════════════════╝");
        System.out.println("╔════════════════════╗");
        System.out.println("║  TABLA DE SIMBOLOS ║");
        System.out.println("╠════════════════════╣");
        System.out.println("║     Dirección      ║");
        System.out.println("╠════════════════════╣");
        for (int i = 0; i < palabras.size(); i++)
        {
            contador = contador + 1;
            System.out.println("║"  +contador);
        }
        System.out.println("╚════════════════════╝");
        System.out.println("╔════════════════════╗");
        System.out.println("║  TABLA DE SIMBOLOS ║");
        System.out.println("╠════════════════════╣");
        System.out.println("║       Tipo         ║");
        System.out.println("╠════════════════════╣");
        for (int i = 0; i < palabras.size(); i++)
        {
        System.out.println("║"+c);
        }
        System.out.println("╚════════════════════╝");
        System.out.println("╔════════════════════╗");
        System.out.println("║  TABLA DE SIMBOLOS ║");
        System.out.println("╠════════════════════╣");
        System.out.println("║       Clave        ║");
        System.out.println("╠════════════════════╣");
        for (int i = 0; i < palabras.size(); i++)
        {
        System.out.println("║"+d);
        }
        System.out.println("╚════════════════════╝");
    }
    public void IdTipo()
    {

    }
    public static int existeEnArreglo(String[] arreglo, String busqueda) 
    {
        for (int x = 0; x < arreglo.length; x++) 
        {
            if (arreglo[x].equals(busqueda))
             {
				return x;
			}
		}
		return -1;
	}
    public static void main(String[] args)  
    {  
        String dato;
        int rep= 1;
        List<Token> tokens = new ArrayList<Token>();  
        String path ="test.txt";
        ReadFile fileReader = new ReadFile();  
        palabras = fileReader.ReadTxt(path);
        //System.out.println(palabras);
        //*String previous = "";
        EjemploTS Obtener = new EjemploTS(); 
        Obtener.Tabla();
        while (rep == 1)
        {
            System.out.println("Que desea realizar?");
            System.out.println("1.Insertar en la tabla");
            System.out.println("2.Buscar en la tabla");
            System.out.println("3.Comparar elmentos en la tabla");
            System.out.println("4. Ver la tabla");
            Scanner teclado = new Scanner(System.in); 
            int opc = teclado.nextInt();
            switch(opc)
            {
                case 1:
                System.out.println("*********INSERTAR**************");
                System.out.println("Porfavor ingresa el dato que desee ingresar:");
                dato = teclado.next();
                palabras.add(dato);
                //Aqui faltaria analizar el dato reconocido y verificarlo contra el analizador lexico para verificar el lexema dentro de la tabla
                break;

                case 2:
                String elemento2;
                System.out.println("**********BUSCAR**************");
                String[] ArEjemplo2 = new String[palabras.size()];
                ArEjemplo2 = palabras.toArray(ArEjemplo2);
                System.out.println("Porfavor ingrese un elemento que desea buscar dentro de la tabla");
                elemento2 = teclado.next();
                String ejemploBuscado = elemento2 ;
                int posicionDeElementoBuscado  = existeEnArreglo(ArEjemplo2,ejemploBuscado);
                if (posicionDeElementoBuscado == -1) 
                {
			        System.out.println("El elemento NO existe en el arreglo");
                }
                 else 
                {
			    System.out.println("El elemento existe en la posición: " + posicionDeElementoBuscado);
                }
                break;

                case 3:
                String elemento3;
                System.out.println("*********COMPARAR**************");
                String[] ArEjemplo3 = new String[palabras.size()];
                ArEjemplo3 = palabras.toArray(ArEjemplo3);
                System.out.println("Porfavor ingrese un elemento para comprarlo dentro de la tabla");
                elemento3 = teclado.next();
                String ejemploComparar = elemento3 ;
                for(int posicion = 0; posicion<palabras.size(); posicion++)
                {
                 if(ArEjemplo3[posicion].equals(ejemploComparar))
                 {
                 System.out.println("Elemento en comun es: "+ArEjemplo3[posicion]);
                 }
                 else
                 {
                 System.out.println("Elemento: "+ArEjemplo3[posicion]+" no es comun con ningun elemento de la tabla");  
                 }  
                } 
                break;

                case 4:
                Obtener.Tabla();
                break;

                default:
                System.out.println("Nos pillamos pues");
                break;
            }
        if (opc == 5)
        {
        rep = 0;
        }
        } 
    } 
 }

