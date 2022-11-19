package menuStructure;

import java.util.Locale;
import java.util.Scanner;

import dataStructure.*;
import figure.*;

public class Menu {
    Scanner scanner = new Scanner(System.in).useLocale(Locale.US) ;
    ArrayFigure test1 = ReaderFiler.getInstance().imprimir() ;

    public Menu(){} ;
    public void inicialMenu()
    {
        int opc ;

        do
        {
            opciones();
            opc = scanner.nextInt();

            switch (opc) 
            {
                case 1:
                    test1.listar();
                    break;
                case 2:
                    agregarYCrearElemento();
                    break;
                case 3:
                    System.out.println("ingrese posicion");
                    int posicion = scanner.nextInt() ;
                    test1.borrarFiguraPosicion(posicion);
                    break;
                case 4:
                    System.out.println("ingrese posicion");
                    int posicion1 = scanner.nextInt() ;
                    test1.consultarPos(posicion1);
                    break;
                case 5:
                    test1.superficieMaximo();
                    break;
                case 6:
                    test1.superficieMinima();
                    break;
                case 7:
                    modificar() ;
                    break ;
                default:
                    System.out.println("finalizado");
                    scanner.close();
                    break; 
            }
        }
        while(opc < 8) ;
    }
    private void opciones() 
    {
        System.out.println("ingrese opcion:");
        System.out.println("1.-Mostrar elementos");
        System.out.println("2.-Agregar elemento");
        System.out.println("3.-Eliminar por posicion");
        System.out.println("4.-consultar Figura por posicion");
        System.out.println("5.-Superficie maxima");
        System.out.println("6.-Superficie minima");
        System.out.println("7.-Modificar Figura por posicion");
        System.out.println("8.-Salir");
    }
    
    private void agregarYCrearElemento() 
    {
        /*
         * Menu para agregar y crear instancia de figura 
         * precondicion:
         *      + char input deber si o si los siguiente char T, R o C, sino no se va a crear el objecto
         *      + los double input no puede ser negativo 
         */
        try {
            System.out.println("ingresar la inicial de la figura a crear");
            System.out.println("las opciones disponible son C (circulo), T (triangulo) y R (rectangulo)");
            char inicial = Character.toUpperCase(scanner.next().charAt(0));
            if(inicial == 'C')
            {
                System.out.println("ingrese diametro");
                Double num = scanner.nextDouble() ; 
                test1.agregarYCrearFigura(inicial, num) ;
            }
            else if(inicial == 'T' || inicial == 'R')
            {
                System.out.println("ingrese altura");
                Double num = scanner.nextDouble() ; 
                System.out.println("ingrese base");
                Double num1 = scanner.nextDouble() ;
                test1.agregarYCrearFigura(inicial, num, num1) ;
            }
            else
            {
                throw new IllegalArgumentException("No existe dicha figura") ;
            }
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
    }

    private void modificar()
    {
        
        test1.modificar(0, 0, 0); ;
    }
}
