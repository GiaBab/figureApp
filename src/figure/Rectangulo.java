package figure;
import java.util.*;

public class Rectangulo extends Figura
{
    double altura ;
    double base ;

    public Rectangulo(double tamannoAltura, double tamannoBase) 
    {
        this.altura = tamannoAltura ;
        this.base = tamannoBase ;
    }

    @Override
    public void atributos()
    {
        /*
         * imprime los atributos de la Figura
         */
        System.out.println("la altura del rectangulo es de: " + this.getAltura() + ", la base de: " + this.getBase() + ", su superficie es de: " + this.getSuperficie());
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
            this.altura = tamannoAltura ;  
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
            
            this.base = tamannoBase ;  
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
        System.out.println("1.-cambiar altura");
        System.out.println("2.-cambiar base");
        System.out.println("3.-salir");
        int opc = scn.nextInt();
        switch(opc)
        {
            case 1:
                System.out.println("introduce el nuevo valor:");
                double newAltura = scn.nextDouble() ;
                setAltura(newAltura);
                modificar();
                break ;
            case 2:
                System.out.println("introduce el nuevo valor:");
                double newBase = scn.nextDouble() ;
                setBase(newBase);
                modificar();
                break ;
            default :
                break ;
        }
    }
}
