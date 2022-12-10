package dataStructure;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class ArchiveSystem 
{
    private static ArchiveSystem instance = null ;
    private ArchiveSystem(){} ;
    public static ArchiveSystem getInstance()
    {
        if(instance == null) instance = new ArchiveSystem() ;
        return instance ;
    }

    public ArrayFigure openArchive()
    {
        /*
         * return arrayFigure input for archivo.txt
         * precondicion:
         *      + para imprimir triangulo debe estar el Char T con sus dos numeros correspondiente separado entre espacio
         *      + para imprimir rectangulo debe estar el Char R con sus dos numeros correspondiente separado entre espacio
         *      + para imprimir circulo debe estar el Char C con su numero correspondiente separado entre espacio
         */

        ArrayFigure arrFigura = new ArrayFigure(0) ;
        try
        {
            FileReader myObj = new FileReader("./archivo.txt") ;
            BufferedReader myReader = new BufferedReader(myObj) ;
            String data = myReader.readLine();
            ArrayFigure arrFigureAux = new ArrayFigure(Integer.parseInt(data)) ;
            int i= 0 ;
            while ((data = myReader.readLine()) != null) 
            {
                System.out.println("["+ (i++) +"] " + "Input: " + data) ;
                String[] dataSplit = data.split(" ") ;
                char inicial = data.charAt(0);
                double hieght = Double.parseDouble(dataSplit[1]) ;
                double width = inicial != 'C'?Double.parseDouble(dataSplit[2]):0;
                arrFigureAux.addFigure(inicial, hieght, width); 
            }
            myReader.close();
            arrFigura = arrFigureAux ;
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("Error.");
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println("Error.");
            e.printStackTrace();
        }
        return arrFigura ;
    }
}
