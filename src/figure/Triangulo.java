package figure;

public class Triangulo extends Rectangulo
{
    
    public Triangulo(double altura, double base)
    {
        super(altura, base) ;
    }

    @Override
    public void atributos()
    {
        /*
         * imprime los atributos de la Figura
         */
        System.out.println("la altura del triangulo es: " + this.getAltura() + ", la base: " + this.getBase() + ", su superficie: " + this.getSuperficie());
    }

    @Override
    public double getSuperficie()
    {
        /*
         * devuelve la superficie de la figura
         */
        return (altura * base)/2 ;
    }

}
