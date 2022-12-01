package dataStructure;
import java.util.Arrays;

import figure.Circulo;
import figure.Figura;
import figure.Rectangulo;
import figure.Triangulo;

public class ArrayFigure {

    Figura[] arrayFigura ; 

    public ArrayFigure(int tamanno)
    {   
        this.arrayFigura = new Figura[tamanno] ;
    }

    public Figura getFigura(int num) throws ArrayIndexOutOfBoundsException, NullPointerException
    {
        try 
        {
            return arrayFigura[num] ;   
        } 
        catch (Exception e) 
        {
            throw e ;
        }  
    }
    
    public void listar()
    {
        /*
         * iterating all figure
         */
        int i = 0;
        for (Figura figuras:arrayFigura)
        {
            System.out.println( "[" + i++ + "] " + figuras) ;
        }
    }

    private boolean tamannoArrayEsMayorQue(int numero) {
        /*
         * devuelve si el tamano del array es mayot que Int *numero*
         * parametro:
         *      + numero - int : numero a comparar
         */
        return numero < tamanno();
    }

    private boolean posicionNoEsVacio(int posicion) throws ArrayIndexOutOfBoundsException
    {
        /*
         * return if isn't null
         * parametro:
         *      + posicion - int : posicion del elemento a consultar
         * precondicion: 
         *      + *posicion* no puede ser mas grande que el tamaño total de la lista
         *      + *posicion* no puede ser negativo
         */
        return getFigura(posicion) != null;
    }

    private int cantidadDeFiguras()
    {   
        /*
         * return amount of figure.
         */
        int cant = 0;
        for (int i=0 ; tamannoArrayEsMayorQue(i) ; i++)
        {
            if(this.posicionNoEsVacio(i))
            {
                cant++ ;
            }
        }

        return cant ;
    }

    private boolean hayEspacio()
    {
        /*
         * return if have space fot other figrue. 
         */
        return (cantidadDeFiguras() < this.tamanno()) ;
    }

    public void agregarFigura(Figura figura)
    {   
        /*
         * añade nueva figura *Figura* al array, caso que no hay espacio este 
         * se rendimenciona para agregar a la nueva figura *figura*
         * parametro:
         *      +figura - Figura : agrega nueva figura
         */
        int pos = 0;
        int aux = !hayEspacio()?1:0 ;
        Figura auxArray[] = Arrays.copyOf(arrayFigura, this.tamanno()+aux) ;

        while(tamannoArrayEsMayorQue(pos) && this.posicionNoEsVacio(pos))
            pos++ ;

        auxArray[pos] = figura ;
        this.arrayFigura = Arrays.copyOf(auxArray, auxArray.length) ;
        
    }

    public void agregarYCrearFigura(char inicialFigura, Double num1, Double... num2)
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
                agregarTriangulo(num1, num2[0]);
            case 'R' ->    
                agregarRectangulo(num1, num2[0]);
            case 'C' ->
                agregarCirculo(num1);
            default ->
                System.out.println("No existe figura");
        }
    }

    private void agregarCirculo(Double diametro) 
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
            this.agregarFigura(c) ;
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
        
    }

    private void agregarRectangulo(Double altura, Double base) 
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
            if(0>altura || 0>base) throw new IllegalArgumentException("Solo numeros positivos");
            
            Figura r = new Rectangulo(altura, base) ;
            this.agregarFigura(r) ;
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
        
    }

    private void agregarTriangulo(Double altura, Double base) 
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
            if(0>altura || 0>base) throw new IllegalArgumentException("Solo numeros positivos");
            
            Figura t = new Triangulo(altura, base) ;
            this.agregarFigura(t) ;
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
        
    }
    
    public void borrarFiguraPosicion(int posicion) throws ArrayIndexOutOfBoundsException
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
            if (validarPosicion(posicion)) throw new IllegalArgumentException("no hay elemento en esa posicion");
    
            for (int i = 0; i < tamanno(); i++) {
    
                if (i == posicion) 
                {
                    arrayFigura[i] = null;
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }   

    public void superficieMaxima() 
    {   
        /*
         * imprime la superficie de mayor tamanno
         */
        double max = getFigura(0).getSuperficie() ;

        for (int i = 1 ; tamannoArrayEsMayorQue(i) ; i++)
        {
            if(posicionNoEsVacio(i) && max < getFigura(i).getSuperficie())
            {
                max = getFigura(i).getSuperficie() ;
            }
        }

        System.out.println("La superficie maxima es de: " + max);
    }

    public void superficieMinima()
    {
        /*
         * imprime la superficie de menor tamanno
         */
        double min = getFigura(0).getSuperficie() ;

        for (int i = 1 ; tamannoArrayEsMayorQue(i) ; i++)
        {
            if(posicionNoEsVacio(i) && min > getFigura(i).getSuperficie())
            {
                min = getFigura(i).getSuperficie() ;
            }
        }

        System.out.println("La superficie minima es de: " + min);
    }

    private int tamanno()
    {
        /*
         * returng size of array 
         */
        return arrayFigura.length ;
    }

    public void modificar(int posicion, int opc, double size) throws ArrayIndexOutOfBoundsException
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
            if (validarPosicion(posicion)) throw new IllegalArgumentException("no hay elemento en esa posicion");
            
            getFigura(posicion).modificar(opc*1.0, size);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void consultarPos(int posicion) throws ArrayIndexOutOfBoundsException
    {
        /*
         * imprime los atributos de la figura de dicha int *posicion*
         * parametro:
         *      + posicion - int : posicion de la figura a consultar
         * precondicion: 
         *      + debe haber objecto en dicha posicion *posicion*
         *      + *posicion* no puede ser mas grande que el tamaño de la lista total de la lista
         *      + *posicion* no debe ser numero negativo
         */
        try
        {
            if(validarPosicion(posicion)) throw new IllegalArgumentException("no hay elemento en esa posicion");
        
            getFigura(posicion).atributos() ;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    private boolean validarPosicion(int posicion) 
    {
        /*
         * return if is valide.
         */
        return (!tamannoArrayEsMayorQue(posicion) || !posicionNoEsVacio(posicion) || posicion < 0 || arrayFigura == null);
    }
    
}
