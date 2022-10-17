public class Paire<T, U> implements IPaire<T, U> {

    private final T fst;
    private final U snd;

    public Paire(T fst, U snd){
        this.fst = fst;
        this.snd = snd;
    }

    @Override
    public T fst(){
        return fst;
    }

    @Override
    public U snd(){
        return snd;
    }
    @Override
    public <V>  IPaire<V,U> changerFst(V v){
        return new Paire<>(v, snd);
    }

    @Override
    public <V>  IPaire<T,V> changerSnd(V v){
        return new Paire<>(fst, v);
    }
}
