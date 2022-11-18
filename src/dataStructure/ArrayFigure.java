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
    
    public void listar()
    {
        /*
         * Lista todas las Figuras del array
         */
        for (Figura figuras:arrayFigura)
        {
            System.out.println(figuras) ;
        }
    }

    private boolean tamannoArrayEsMayorQue(int numero) {
        /*
         * devuelve si el tamano del array es mayot que Int *numero*
         * parametro:
         *      + numero - int : numero a comparar
         */
        return numero < this.tamanno();
    }

    private boolean posicionNoEsVacio(int posicion) 
    {
        /*
         * devuelve si el elemento que esta en el int *posicion* de la lista 
         * no sea null
         * parametro:
         *      + posicion - int : posicion del elemento a consultar
         * precondicion: 
         *      + *posicion* no puede ser mas grande que el tamaño total de la lista
         *      + *posicion* no puede ser negativo
         */
        return arrayFigura[posicion] != null;
    }

    private int cantidadDeFiguras()
    {   
        /*
         * devuelve la cantidad de figuras.
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
         * devuelve si hay espacio para otra figura 
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

            case 'T':
                agregarTriangulo(num1, num2[0]);
                break ;
            case 'R':    
                agregarRectangulo(num1, num2[0]);
                break ;
            case 'C':
                agregarCirculo(num1);
                break ;
            default:
                System.out.println("No existe figura");
                break ;
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
    
    public void borrarFiguraPosicion(int posicion) 
    {
        /*
         * borra una Figura del array de la int *posicion* deseada
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

    public void superficieMaximo() 
    {   
        /*
         * imprime la superficie de mayor tamanno
         */
        double max = 0 ;

        for (int i = 0 ; tamannoArrayEsMayorQue(i) ; i++)
        {
            if(posicionNoEsVacio(i) && max < arrayFigura[i].getSuperficie())
            {
                max = arrayFigura[i].getSuperficie() ;
            }
        }

        System.out.println("La superficie maxima es de: " + max);
    }

    public void superficieMinima()
    {
        /*
         * imprime la superficie de menor tamanno
         */
        double min = Double.MAX_VALUE;

        for (int i = 0 ; tamannoArrayEsMayorQue(i) ; i++)
        {
            if(posicionNoEsVacio(i) && min > arrayFigura[i].getSuperficie())
            {
                min = arrayFigura[i].getSuperficie() ;
            }
        }

        System.out.println("La superficie minima es de: " + min);
    }

    private int tamanno()
    {
        /*
         * devuelve el tamanno del array 
         */
        return arrayFigura.length ;
    }

    public void modificar(int posicion)
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
            
            arrayFigura[posicion].modificar();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void consultarPos(int posicion)
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
        
            this.arrayFigura[posicion].atributos() ;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    private boolean validarPosicion(int posicion) 
    {
        /*
         * devuelve si se cumple la condicion en dicha posicion
         */
        return (!posicionNoEsVacio(posicion) || posicion < 0 || !tamannoArrayEsMayorQue(posicion) || arrayFigura == null);
    }
    
}