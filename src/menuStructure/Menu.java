package menuStructure;

import java.util.Locale;
import java.util.Scanner;

import dataStructure.*;
import figure.*;

public class Menu {

    private static Menu instance = null ;
    private Menu(){} ;
    public static Menu getInstance()
    {
        if(instance == null) instance = new Menu() ;
        return instance ;
    }

    Scanner scanner = new Scanner(System.in).useLocale(Locale.US) ;
    ArrayFigure arrayFigure = ReaderFiler.getInstance().imprimir() ;

    public void inicialMenu()
    {
        MenuOpcions opc = new MenuOpcions("Mostrar", "Agregar", "eliminar", "consultar", "superficie maxima", "superficie minima", "modificar", "salir") ;

            switch (opc.selectionOptionSystem()) 
            {
                case 0 ->
                    listar();
                case 1 ->
                    agregarYCrearElemento();
                case 2 ->
                    deletPos();
                case 3 ->
                    consultPos();
                case 4 ->
                    superficieMaxima();
                case 5 ->
                    superficieMinima();
                case 6 ->
                    modificar() ;
                default ->
                    endMenu();
            }
        }

    private void listar() 
    {
        arrayFigure.listar();
        inicialMenu();
    }

    private void superficieMinima() 
    {
        arrayFigure.superficieMinima();
        inicialMenu();
    }
    
    private void superficieMaxima() {
        arrayFigure.superficieMaxima();
        inicialMenu();
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
        inicialMenu() ;
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
        arrayFigure.modificar(pos, opc, size); 
        inicialMenu() ;
    }

    private void deletPos()
    {
        System.out.println("ingrese posicion");
        int posicion = scanner.nextInt() ;
        arrayFigure.borrarFiguraPosicion(posicion);
        inicialMenu() ;
    }

    private void consultPos()
    {
        System.out.println("ingrese posicion");
        int posicion1 = scanner.nextInt() ;
        arrayFigure.consultarPos(posicion1);
        inicialMenu() ;
    }

    private void endMenu() {
        System.out.println("finalizado");
        scanner.close(); 
    }
}
