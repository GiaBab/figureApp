package figure;

public class Triangle extends Rectangle
{
    
    public Triangle(double height, double width)
    {
        super(height, width) ;
    }

    @Override
    public double getArea()
    {
        /*
         * return area
         */
        return (height * width)/2 ;
    }

}
