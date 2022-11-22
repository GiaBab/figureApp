package menuStructure;

import java.util.Locale;
import java.util.Scanner;
import dataStructure.*;

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
        int opc ;

        do
        {
            new MenuString("Mostrar", "Agregar", "Eliminar", "Consultar", "Superficie Maxima", "Superficie Minima", "Modificar", "Salir").mostrarOpcion(); 
            opc = scanner.nextInt();

            switch (opc) 
            {
                case 1 ->
                    listar();
                case 2 ->
                    agregarYCrearElemento();
                case 3 ->
                    deletPos();
                case 4 ->
                    consultPos();
                case 5 ->
                    superficieMaxima();
                case 6 ->
                    superficieMinima();
                case 7 ->
                    modificar() ;
                case 8 ->
                    endMenu();
            }
        }
        while(opc != 8) ;
    }
    
    private void listar() {
        arrayFigure.listar();
    }

    private void superficieMaxima() {
        arrayFigure.superficieMaxima();
    }

    private void superficieMinima() {
        arrayFigure.superficieMinima();
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
        try {
            System.out.println("Posicion");
            int pos = scanner.nextInt() ;
            arrayFigure.getFigura(pos).auxStrModificar();
            int opc = scanner.nextInt() ;
            System.out.println("new size");
            double size = scanner.nextDouble() ;
            arrayFigure.modificar(pos, opc, size); 
        } catch (Exception e) {
            System.out.println(e.getMessage()) ;
            System.out.println("input invalide");
        }
    }

    private void deletPos()
    {
        System.out.println("ingrese posicion");
        int posicion = scanner.nextInt() ;
        arrayFigure.borrarFiguraPosicion(posicion);
    }

    private void consultPos()
    {
        System.out.println("ingrese posicion");
        int posicion1 = scanner.nextInt() ;
        arrayFigure.consultarPos(posicion1);
    }

    private void endMenu() 
    {
        System.out.println("finalizado");
        scanner.close(); 
    }
}
