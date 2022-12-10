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
        int opcInput ;

        do
        {
            new MenuString("Show", "Add", "delete", "Consult", "area Max", "area Min", "Modif", "exit").mostrarOpcion(); 
            opcInput = scanner.nextInt();

            switch (opcInput) 
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
        while(opcInput != 8) ;
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
            new MenuString("Circle", "Triangle", "Rectangle").mostrarOpcion();
            switch (scanner.nextInt()) {
                case 1 -> addCircle() ;
                case 2 -> addTriangle() ;
                case 3 -> addRectangle() ;
                default -> throw new IllegalArgumentException("don't know this figure") ;
            } ;
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
    }

    private void addTriangle() {
        System.out.print("[User] input Height: ");
        Double num = scanner.nextDouble() ; 
        System.out.print("[User] input Width: ");
        Double num1 = scanner.nextDouble() ;
        arrayFigure.addFigure('T', num, num1) ;
    }

    private void addRectangle() {
        System.out.print("[User] input Height: ");
        Double num = scanner.nextDouble() ; 
        System.out.print("[User] input Width: ");
        Double num1 = scanner.nextDouble() ;
        arrayFigure.addFigure('R', num, num1) ;
    }

    private void addCircle() {
        System.out.print("[User] input Diameter: ");
        Double num = scanner.nextDouble() ; 
        arrayFigure.addFigure('C', num) ;
    }

    private void modificar()
    {
        try {
            System.out.print("[User] input index: ");
            int pos = scanner.nextInt() ;
            arrayFigure.getFigure(pos).printOpcionModify();
            int opc = scanner.nextInt() ;
            System.out.print("[User] new size: ");
            double size = scanner.nextDouble() ;
            arrayFigure.modify(pos, opc, size); 
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage()) ;
            System.out.println("[User] input invalide");
        }
    }

    private void deletPos()
    {
        System.out.print("[User] input index: ");
        int posicion = scanner.nextInt() ;
        arrayFigure.deletFigure(posicion);
    }

    private void consultPos()
    {
        System.out.print("[User] input index: ");
        int posicion1 = scanner.nextInt() ;
        arrayFigure.consultIndex(posicion1);
    }

    private void endMenu() 
    {
        System.out.println("exiting");
        scanner.close(); 
    }
}
