package dataStructure;
import java.util.Arrays;

import figure.Circulo;
import figure.Figura;
import figure.Rectangulo;
import figure.Triangulo;

public class ArrayFigure {

    Figura[] arrayFigure ; 

    public ArrayFigure(int size)
    {   
        this.arrayFigure = new Figura[size] ;
    }

    public Figura getFigure(int num) throws ArrayIndexOutOfBoundsException, NullPointerException
    {
        /*
         * return figure for index
         */
        try 
        {
            return arrayFigure[num] ;   
        } 
        catch (Exception e) 
        {
            throw e ;
        }  
    }
    
    public void iterator()
    {
        /*
         * iterating all figure
         */
        int i = 0;
        for (Figura figuras:arrayFigure)
        {
            System.out.println( "[" + i++ + "] " + figuras) ;
        }
    }

    private boolean sizeArrayIsMaxWith(int num) {
        /*
         * devuelve si el tamano del array es mayot que Int *numero*
         * parametro:
         *      + numero - int : numero a comparar
         */
        return num < size();
    }

    private boolean indexNotNull(int index) throws ArrayIndexOutOfBoundsException
    {
        /*
         * return if isn't null
         * parametro:
         *      + posicion - int : posicion del elemento a consultar
         * precondicion: 
         *      + *posicion* no puede ser mas grande que el tamaño total de la lista
         *      + *posicion* no puede ser negativo
         */
        return getFigure(index) != null;
    }

    private int amoutFigure()
    {   
        /*
         * return amount of figure.
         */
        int cant = 0;
        for (int i=0 ; sizeArrayIsMaxWith(i) ; i++)
        {
            if(this.indexNotNull(i))
            {
                cant++ ;
            }
        }

        return cant ;
    }

    private boolean haveSpace()
    {
        /*
         * return if have space fot other figrue. 
         */
        return (amoutFigure() < this.size()) ;
    }

    public void addFigure(Figura figure)
    {   
        /*
         * añade nueva figura *Figura* al array, caso que no hay espacio este 
         * se rendimenciona para agregar a la nueva figura *figura*
         * parametro:
         *      +figura - Figura : agrega nueva figura
         */
        int pos = 0;
        int aux = !haveSpace()?1:0 ;
        Figura auxArray[] = Arrays.copyOf(arrayFigure, this.size()+aux) ;

        while(sizeArrayIsMaxWith(pos) && this.indexNotNull(pos))
            pos++ ;

        auxArray[pos] = figure ;
        arrayFigure = Arrays.copyOf(auxArray, auxArray.length) ;
        
    }

    public void addFigure(char inicialFigura, Double num1, Double... num2)
    {
        /*
         * agregra y crea una nueva instancia de figura en base de char *inicialFigura* con sus atributos double *num1* 
         * y double *num2*
         * parametro:
         *      + inicialFigura - char : la inicial de cada figura para definir la instancia (R - rectangulo, C - circulo, T - triangulo)
         *      + num1 - double : tamanno de diametro/Altura de la figura
         *      + num2 - double : tamanno de la base de la figura 
         * precondicion :
         *      + deber si o si los siguiente char T, R o C. Sino no se va a crear el objecto
         *      + los double (num1 y num2) no puede ser negativo
         *      + *num2* es opcional pero solo en el caso del circulo (C), en el resto es obligatorio.  
         */
        switch (inicialFigura) {

            case 'T' ->
                addTriangle(num1, num2[0]);
            case 'R' ->    
                addRectangle(num1, num2[0]);
            case 'C' ->
                addCircle(num1);
            default ->
                System.out.println("No existe figura");
        }
    }

    private void addCircle(Double diametro) 
    {
        /*
         * agregra y crea una nueva instancia de Circulo con Double *diametro*
         * parametro: 
         *      + diametro - Double : tamanno del atributo diametro del circulo
         * precondicion:
         *      + *diametro* no puede ser numero negativo
         */
        try 
        {
            if(0>diametro) throw new IllegalArgumentException("Solo numeros positivos");
            
            Figura c = new Circulo(diametro) ;
            this.addFigure(c) ;
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
        
    }

    private void addRectangle(Double height, Double width) 
    {
        /*
         * agregra y crea una nueva instancia de Rectangulo con Double *altura* y Double *base*
         * paranetro:
         *      + altura - Double : tamanno del atributo altura del Rectangulo
         *      + base - Double : tamanno del atributo base del Rectangulo
         * precondicion:
         *      + *altura* y *base* no puede ser negativo
         */
        try 
        {
            if(0>height || 0>width) throw new IllegalArgumentException("Solo numeros positivos");
            
            Figura r = new Rectangulo(height, width) ;
            this.addFigure(r) ;
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
        
    }

    private void addTriangle(Double height, Double width) 
    {
        /*
         * agregra y crea una nueva instancia de Triangulo con Double *altura* y Double *base*
         * paranetro:
         *      + altura - Double : tamanno del atributo altura del Triangulo
         *      + base - Double : tamanno del atributo base del Triangulo
         * precondicion:
         *      + *altura* y *base* no puede ser negativo
         */
        try 
        {
            if(0>height || 0>width) throw new IllegalArgumentException("Solo numeros positivos");
            
            Figura t = new Triangulo(height, width) ;
            this.addFigure(t) ;
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
        
    }
    
    public void deletFigure(int index) throws ArrayIndexOutOfBoundsException
    {
        /*
         * delet figure for index
         * parametro:
         *      + posicion - int : posicion del elemento a eliminar
         * precondicion:
         *      + *posicion* no debe pasarse del tamaño del arrary y ni tampoco negativo
         *      + *posicion* no puede ser null 
         */
        try
        {
            if (validarPosicion(index)) throw new IllegalArgumentException("no hay elemento en esa posicion");
    
            for (int i = 0; i < size(); i++) {
    
                if (i == index) 
                {
                    arrayFigure[i] = null;
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }   

    public void areaMax() 
    {   
        /*
         * print max area size
         */
        double max = getFigure(0).getArea() ;

        for (int i = 1 ; sizeArrayIsMaxWith(i) ; i++)
        {
            if(indexNotNull(i) && max < getFigure(i).getArea())
            {
                max = getFigure(i).getArea() ;
            }
        }

        System.out.println("La superficie maxima es de: " + max);
    }

    public void areaMin()
    {
        /*
         * print min area size
         */
        double min = getFigure(0).getArea() ;

        for (int i = 1 ; sizeArrayIsMaxWith(i) ; i++)
        {
            if(indexNotNull(i) && min > getFigure(i).getArea())
            {
                min = getFigure(i).getArea() ;
            }
        }

        System.out.println("La superficie minima es de: " + min);
    }

    private int size()
    {
        /*
         * returng size of array 
         */
        return arrayFigure.length ;
    }

    public void modify(int index, int opc, double size) throws ArrayIndexOutOfBoundsException
    {
        /*
         * modifica los atributos de la figura en la posicion Int *posicion* mediante un menu
         * parametros: 
         *      +posicion - int : posicion a modificar
         * precondicion:
         *      + debe haber objecto en dicha posicion *posicion*
         *      + *posicion* no puede ser mas grande que el tamaño de la lista total de la lista
         *      + *posicion* no debe ser numero negativo
         */
        try
        {
            if (validarPosicion(index)) throw new IllegalArgumentException("no hay elemento en esa posicion");
            
            getFigure(index).modify(opc*1.0, size);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void consultarPos(int index) throws ArrayIndexOutOfBoundsException
    {
        /*
         * print attributes for index
         * parametro:
         *      + posicion - int : posicion de la figura a consultar
         * precondicion: 
         *      + debe haber objecto en dicha posicion *posicion*
         *      + *posicion* no puede ser mas grande que el tamaño de la lista total de la lista
         *      + *posicion* no debe ser numero negativo
         */
        try
        {
            if(validarPosicion(index)) throw new IllegalArgumentException("no hay elemento en esa posicion");
        
            getFigure(index).attribute() ;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    private boolean validarPosicion(int index) 
    {
        /*
         * return if is valide.
         */
        return (!sizeArrayIsMaxWith(index) || !indexNotNull(index) || index < 0 || arrayFigure == null);
    }
    
}
