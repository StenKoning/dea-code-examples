package nl.oose.koenenkramers;

/**
 * Created by alexanderstenkoning on 13/03/17.
 */
public class NullDictionaryAdapter implements  IDictionaryAdapter{
    public String translate(String word) {
        return null;
    }

    public String getName() {
        return NullDictionaryAdapter.class.getName();
    }
}
