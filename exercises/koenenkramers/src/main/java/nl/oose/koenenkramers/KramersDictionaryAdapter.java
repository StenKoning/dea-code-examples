package nl.oose.koenenkramers;

import nl.oose.dea.koenenkramers.KramersDictionary;

/**
 * Created by alexanderstenkoning on 13/03/17.
 */
public class KramersDictionaryAdapter implements  IDictionaryAdapter{
    private KramersDictionary kramersDictionary = new KramersDictionary();

    public String translate(String word) {
        return kramersDictionary.find(word);
    }

    public String getName() {
        return KramersDictionary.class.getName();
    }
}
