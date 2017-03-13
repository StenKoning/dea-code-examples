package nl.oose.koenenkramers;

import nl.oose.dea.koenenkramers.KoenenDictionary;
import nl.oose.dea.koenenkramers.KramersDictionary;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Welcome to the English 2 Dutch translator");
        TranslateToDutch translator = new TranslateToDutch();
        System.out.println(translator.translate("submarine"));
    }
}
