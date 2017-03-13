package nl.oose.koenenkramers;

/**
 * Created by alexanderstenkoning on 13/03/17.
 */
public class TranslateToDutch {
    public String translate(String word){
        String koenenTranslation = ServicesFactory.getInstance()
                .getDictionaryAdapter("Koenen")
                .translate(word);

        if(koenenTranslation != null){
            return koenenTranslation;
        }

        return ServicesFactory.getInstance()
                .getDictionaryAdapter("Kramers")
                .translate(word);
    }
}
