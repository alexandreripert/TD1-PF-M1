import java.util.Objects;

public class Chaine<T> implements Sommable<Chaine> {

    private final String val;

    public Chaine(final String val) {
        this.val = val;
    }

    @Override
    public Chaine sommer(Chaine v) {
        return new Chaine(this.val + v.getVal());
    }

    public String getVal() {
        return val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Chaine chaine = (Chaine) o;
        return Objects.equals(val, chaine.val);
    }

    @Override
    public String toString() {
        return "Chaine[" + "val=" + val + ']';
    }
}
