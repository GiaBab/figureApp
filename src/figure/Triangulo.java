package figure;

public class Triangulo extends Rectangulo
{
    
    public Triangulo(double altura, double base)
    {
        super(altura, base) ;
    }

    @Override
    public void attribute()
    {
        /*
         * imprime los atributos de la Figura
         */
        System.out.println("la altura del triangulo es: " + this.getAltura() + ", la base: " + this.getBase() + ", su superficie: " + this.getArea());
    }

    @Override
    public double getArea()
    {
        /*
         * devuelve la superficie de la figura
         */
        return (altura * base)/2 ;
    }

}
