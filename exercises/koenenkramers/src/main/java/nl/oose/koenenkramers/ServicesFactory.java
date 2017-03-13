package nl.oose.koenenkramers;

/**
 * Created by alexanderstenkoning on 13/03/17.
 */
public class ServicesFactory {
    private static ServicesFactory instance = null;

    public static ServicesFactory getInstance(){
        if(instance == null){
            instance = new ServicesFactory();
        }

        return instance;
    }

    public IDictionaryAdapter getDictionaryAdapter(String dictionaryName){
        if(dictionaryName.equals("Koenen")){
            return new KoenenDictionaryAdapter();
        }

        if(dictionaryName.equals("Kramers")){
            return new KramersDictionaryAdapter();
        }

        return null;
    }
}
