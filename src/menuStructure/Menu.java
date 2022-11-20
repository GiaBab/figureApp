package menuStructure;

import java.util.Locale;
import java.util.Scanner;

import dataStructure.*;
import figure.*;

public class Menu {
    Scanner scanner = new Scanner(System.in).useLocale(Locale.US) ;
    ArrayFigure arrayFigure = ReaderFiler.getInstance().imprimir() ;

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
                    arrayFigure.listar();
                    break;
                case 2:
                    agregarYCrearElemento();
                    break;
                case 3:
                    System.out.println("ingrese posicion");
                    int posicion = scanner.nextInt() ;
                    arrayFigure.borrarFiguraPosicion(posicion);
                    break;
                case 4:
                    System.out.println("ingrese posicion");
                    int posicion1 = scanner.nextInt() ;
                    arrayFigure.consultarPos(posicion1);
                    break;
                case 5:
                    arrayFigure.superficieMaximo();
                    break;
                case 6:
                    arrayFigure.superficieMinima();
                    break;
                case 7:
                    modificar() ;
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
                arrayFigure.agregarYCrearFigura(inicial, num) ;
            }
            else if(inicial == 'T' || inicial == 'R')
            {
                System.out.println("ingrese altura");
                Double num = scanner.nextDouble() ; 
                System.out.println("ingrese base");
                Double num1 = scanner.nextDouble() ;
                arrayFigure.agregarYCrearFigura(inicial, num, num1) ;
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
        System.out.println("Posicion");
        int pos = scanner.nextInt() ;
        if(arrayFigure.getFigura(pos) instanceof Circulo)
        {
            System.out.println("1.Diametro");
            System.out.println("2.salir");
             
        }
        else
        {
            System.out.println("1.altura");
            System.out.println("2.base");
            System.out.println("3.salir");
        }
        int opc = scanner.nextInt() ;
        System.out.println("new size");
        double size = scanner.nextDouble() ;
        arrayFigure.modificar(pos, opc, size); ;
    }
}
