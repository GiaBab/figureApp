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
    ArrayFigure arrayFigure = ArchiveSystem.getInstance().openArchive() ;

    public void inicialMenu()
    {
        int opc ;

        do
        {
            new MenuString("Mostrar", "Add", "delete", "Consultar", "area Max", "area Min", "Modif", "exit").mostrarOpcion(); 
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
        arrayFigure.iterator();
    }

    private void superficieMaxima() {
        arrayFigure.areaMax();
    }

    private void superficieMinima() {
        arrayFigure.areaMin();
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
                System.out.print("input diametro: ");
                Double num = scanner.nextDouble() ; 
                arrayFigure.addFigure(inicial, num) ;
            }
            else if(inicial == 'T' || inicial == 'R')
            {
                System.out.print("input altura: ");
                Double num = scanner.nextDouble() ; 
                System.out.print("input base: ");
                Double num1 = scanner.nextDouble() ;
                arrayFigure.addFigure(inicial, num, num1) ;
            }
            else
            {
                throw new IllegalArgumentException("don't know this figure") ;
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
            System.out.print("input index: ");
            int pos = scanner.nextInt() ;
            arrayFigure.getFigure(pos).printOpcionModify();
            int opc = scanner.nextInt() ;
            System.out.print("new size: ");
            double size = scanner.nextDouble() ;
            arrayFigure.modify(pos, opc, size); 
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage()) ;
            System.out.println("input invalide");
        }
    }

    private void deletPos()
    {
        System.out.print("input index: ");
        int posicion = scanner.nextInt() ;
        arrayFigure.deletFigure(posicion);
    }

    private void consultPos()
    {
        System.out.print("input index: ");
        int posicion1 = scanner.nextInt() ;
        arrayFigure.consultIndex(posicion1);
    }

    private void endMenu() 
    {
        System.out.println("exiting");
        scanner.close(); 
    }
}
