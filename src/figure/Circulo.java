package figure;

import menuStructure.MenuString;

public class Circulo extends Figura
{
    double diametro ;
    
    public Circulo(double diametro)
    {
        this.diametro = diametro ;   
    }

    @Override
    public void atributos()
    {
        /*
         * imprime los atributos de la Figura
         */
        System.out.println("el diametro del circulo es de: " + getDiametro() + ", su superficie es de: " + getSuperficie());
    }

    @Override
    public double getSuperficie()
    {   
        /*
         * devuelve la superficie de la figura
         */
        return Math.PI * Math.pow(diametro/2,2); 
    }

    public double getDiametro()
    {
        /*
         * devuelve el diametro de la figura
         */
        return diametro ;
    }
    
    public void setDiametro(double tamannoDiametro)
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
            if(0>tamannoDiametro) throw new IllegalArgumentException("Solo numeros positivos"); 
            
            diametro = tamannoDiametro ;  
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
                setDiametro(opc[1]);
                break ;
            default :
                break ;
        }
    }

    @Override
    public void auxStrModificar()
    {
        new MenuString("Diametro", "Salir").mostrarOpcion();
    }
}
