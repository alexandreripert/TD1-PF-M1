import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Noeud<T extends Sommable<T> & Comparable<T>> implements Arbre<T> {

    private final List<Arbre> fils;

    public Noeud(final List<Arbre> fils) {
        this.fils = fils;
    }

    @Override
    public int taille() {
        int rtr = 0;
        for (final Arbre a : fils) {
            rtr += a.taille();
        }
        return rtr;
    }

    @Override
    public boolean contient(final T val) {
        boolean rtr = false;
        for (final Arbre a : fils) {
            if (a.contient(val)) return true;
        }
        return rtr;
    }

    @Override
    public Set<T> valeurs() {
        Set<T> rtr = new HashSet<>();
        for (final Arbre a : fils) {
            rtr.addAll(a.valeurs());
        }
        return rtr;
    }

    @Override
    public T somme() {
        Iterator<Arbre> elem = fils.iterator();
        T t1 = (T) elem.next().somme();
        T next;
        while (elem.hasNext()) {
            next = (T) elem.next().somme();
            t1 = t1.sommer(next);
        }
        return t1;
    }

    @Override
    public T min() {
        T t = (T) fils.get(0).min();
        for(Arbre <T> minimum : fils){
            T var = minimum.min();
            if(t.compareTo(minimum.min()) >0)
            {
                t = var;
            }
        }
        return t;
    }

    @Override
    public T max() {
        T t = (T) fils.get(0).max();
        for (Arbre<T> maximum : fils) {
            T var = maximum.max();
            if (t.compareTo(maximum.max()) < 0) {
                t = var;
            }
        }
        return t;
    }

   @Override
    public boolean estTrie() {
        return conditionTrie1() && conditionTrie2();
    }

    private boolean conditionTrie1() {
        boolean rtr = true;
        for (int i = 0; i < fils.size() - 1; i++) {
            final Arbre fi = fils.get(i);
            if (!fi.estTrie())
                return false;
        }
        return rtr;
    }

    private boolean conditionTrie2() {
        boolean rtr = true;
        for (int i = 0; i < fils.size() - 1; i++) {
            Arbre<T> fi = fils.get(i);
            if (!fi.estTrie())
                return false;
        }
        return rtr;
    }
}