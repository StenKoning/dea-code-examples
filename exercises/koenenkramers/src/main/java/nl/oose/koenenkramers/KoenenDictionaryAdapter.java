package nl.oose.koenenkramers;

import nl.oose.dea.koenenkramers.KoenenDictionary;

/**
 * Created by alexanderstenkoning on 13/03/17.
 */
public class KoenenDictionaryAdapter implements  IDictionaryAdapter{
    private KoenenDictionary koenenDictionary = new KoenenDictionary();

    public String translate(String word) {
        return koenenDictionary.lookUp(word);
    }

    public String getName() {
        return KoenenDictionary.class.getName();
    }
}
