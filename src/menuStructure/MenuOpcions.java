package menuStructure;

import java.util.Locale;
import java.util.Scanner;

public class MenuOpcions {
    final String[] opcions ;
    Scanner scanner = new Scanner(System.in).useLocale(Locale.US) ;

    public MenuOpcions(String...opcions)
    {
        this.opcions = opcions ;
    }

    private int listar()
    {
        int i ;
        for(i=0 ; opcions.length > i ; i++)
            System.out.println( "["+(i+1)+"] " + opcions[i]);
        return i ;
    }

    public int selectionOptionSystem()
    {
        int limit = listar() ; 
        System.out.print("User: ");
        int out = scanner.nextInt() ;
        if(!(0 < out && out < limit+1)) 
            return selectionOptionSystem() ; 
        return out - 1 ;
    }

}
