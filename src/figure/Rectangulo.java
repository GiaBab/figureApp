package figure;

import menuStructure.MenuString;

public class Rectangulo extends Figura
{
    double altura ;
    double base ;

    public Rectangulo(double altura, double base) 
    {
        this.altura = altura ;
        this.base = base ;
    }

    @Override
    public void atributos()
    {
        /*
         * imprime los atributos de la Figura
         */
        System.out.println("la altura del rectangulo es de: " + getAltura() + ", la base de: " + getBase() + ", su superficie es de: " + getSuperficie());
    }

    @Override
    public double getSuperficie()
    {
        /*
         * devuelve la superficie de la figura
         */
        return altura * base ;
    }

    public double getAltura()
    {
        /*
         * devuelve la altura de la figura
         */
        return altura ;
    }

    public double getBase()
    {
        /*
         * devuelve la base de la figura
         */
        return base ;
    }

    public void setAltura(double tamannoAltura)
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
            if(0>tamannoAltura) throw new IllegalArgumentException("Solo numeros positivos");
            altura = tamannoAltura ;  
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
    }

    public void setBase(double tamannoBase)
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
            if(0>tamannoBase) throw new IllegalArgumentException("Solo numeros positivos");
            
            base = tamannoBase ;  
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public void modificar(Double...opc)
    { 
        /*
         * modifica los atributos mediante un menu
         * precondicion:
         *      + el cambio de valor no puede ser negativo
         */
        
        switch(opc[0].intValue())
        {
            case 1:
                setAltura(opc[1]);
                break ;
            case 2:
                setBase(opc[1]);
                break ;
            default :
                break ;
        }
    }

    @Override
    public void auxStrModificar()
    {
        new MenuString("Altura", "Base", "Salir").mostrarOpcion();
    } 
}
