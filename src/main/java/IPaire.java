public interface IPaire<T, U> {

    T fst();
    U snd();
    <V>IPaire<V, U> changerFst(V v);
    <V>IPaire<T, V> changerSnd(V v);
}
