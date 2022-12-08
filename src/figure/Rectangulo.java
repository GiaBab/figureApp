package figure;

import menuStructure.MenuString;

public class Rectangulo extends Figura
{
    double height ;
    double width ;

    public Rectangulo(double height, double width) 
    {
        this.height = height ;
        this.width = width ;
    }

    @Override
    public void attribute()
    {
        /*
         * imprime los atributos de la Figura
         */
        System.out.println("la altura del rectangulo es de: " + getHeight() + ", la base de: " + getWidth() + ", su superficie es de: " + getArea());
    }

    @Override
    public double getArea()
    {
        /*
         * devuelve la superficie de la figura
         */
        return height * width ;
    }

    public double getHeight()
    {
        /*
         * devuelve la altura de la figura
         */
        return height ;
    }

    public double getWidth()
    {
        /*
         * devuelve la base de la figura
         */
        return width ;
    }

    public void setHeight(double height)
    {
        /*
         * cambia el valor del altura a double *tamannoAltura*
         * parametros :
         *      + tamannoAltura - double : nuevo tamaño de altura
         * precondicion :
         *      + *tamannoAltura* no puede ser numero negativo
         */
        try 
        {
            if(0>height) throw new IllegalArgumentException("Solo numeros positivos");
            this.height = height ;  
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
    }

    public void setWidth(double width)
    {
        /*
         * cambia el valor del base a double *tamannoBase*
         * parametros :
         *      + tamannoBase - double : nuevo tamaño de base
         * precondicion :
         *      + *tamannoBase* no puede ser numero negativo
         */
        try 
        {
            if(0>width) throw new IllegalArgumentException("Solo numeros positivos");
            
            this.width = width ;  
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public void modify(Double...opc)
    { 
        /*
         * modifica los atributos mediante un menu
         * precondicion:
         *      + el cambio de valor no puede ser negativo
         */
        
        switch(opc[0].intValue())
        {
            case 1:
                setHeight(opc[1]);
                break ;
            case 2:
                setWidth(opc[1]);
                break ;
            default :
                break ;
        }
    }

    @Override
    public void auxStrModify()
    {
        new MenuString("Altura", "Base", "Salir").mostrarOpcion();
    } 
}
