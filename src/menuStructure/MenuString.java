package menuStructure;

public class MenuString 
{
    final String[] opcionsList ;

    public MenuString(String...opcionsList)
    {
        this.opcionsList = opcionsList ;
    }

    public void mostrarOpcion()
    {
        System.out.println("---------------------------------");
        for(int i=0 ; opcionsList.length > i ; i++)
        {
            System.out.println("["+(i+1)+"] " + opcionsList[i]);
        }
    }
}
