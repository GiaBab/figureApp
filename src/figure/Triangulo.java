package figure;

public class Triangulo extends Rectangulo
{
    
    public Triangulo(double height, double width)
    {
        super(height, width) ;
    }

    @Override
    public void attribute()
    {
        /*
         * imprime los atributos de la Figura
         */
        System.out.println("la altura del triangulo es: " + this.getHeight() + ", la base: " + this.getWidth() + ", su superficie: " + this.getArea());
    }

    @Override
    public double getArea()
    {
        /*
         * devuelve la superficie de la figura
         */
        return (height * width)/2 ;
    }

}
