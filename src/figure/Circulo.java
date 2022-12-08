package figure;

import menuStructure.MenuString;

public class Circulo extends Figura
{
    double diameter ;
    
    public Circulo(double diameter)
    {
        this.diameter = diameter ;   
    }

    @Override
    public void attribute()
    {
        /*
         * imprime los atributos de la Figura
         */
        System.out.println("el diametro del circulo es de: " + getDiameter() + ", su superficie es de: " + getArea());
    }

    @Override
    public double getArea()
    {   
        /*
         * devuelve la superficie de la figura
         */
        return Math.PI * Math.pow(diameter/2,2); 
    }

    public double getDiameter()
    {
        /*
         * devuelve el diametro de la figura
         */
        return diameter ;
    }
    
    public void setDiameter(double diameter)
    {
        /*
         * cambia el valor del diametro a double *tamannoDiametro*
         * parametros :
         *      + tamannoDiametro - double : nuevo tamaño de diametro
         * precondicion :
         *      + no puede ser numero negativo
         */
        try 
        {
            if(0>diameter) throw new IllegalArgumentException("Solo numeros positivos"); 
            
            this.diameter = diameter ;  
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
                setDiameter(opc[1]);
                break ;
            default :
                break ;
        }
    }

    @Override
    public void auxStrModify()
    {
        new MenuString("Diametro", "Salir").mostrarOpcion();
    }
}
