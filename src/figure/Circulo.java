package figure;
import java.util.*;

public class Circulo extends Figura
{
    double diametro ;
    
    public Circulo(double tamannoDiametro)
    {
        this.diametro = tamannoDiametro ;   
    }

    @Override
    public void atributos()
    {
        /*
         * imprime los atributos de la Figura
         */
        System.out.println("el diametro del circulo es de: " + this.getDiametro() + ", su superficie es de: " + this.getSuperficie());
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
            
            this.diametro = tamannoDiametro ;  
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
        
    }

    @Override
    public void modificar()
    {
        /*
         * modifica los atributos mediante un menu
         * precondicion:
         *      + el cambio de valor no puede ser negativo 
         */
        Scanner scn = new Scanner(System.in).useLocale(Locale.US) ;
        System.out.println("1.-cambiar diametro");
        System.out.println("2.-salir");
        int opc = scn.nextInt();
        switch(opc)
        {
            case 1:
                System.out.println("introduce el nuevo valor:");
                double newDiametro = scn.nextDouble() ;
                setDiametro(newDiametro);
                modificar();
                break ;
            default :
                break ;
        }
    }
}
