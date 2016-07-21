package util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nkalonia1 on 7/21/16.
 */
public class DefaultHashMap<K, V> extends HashMap<K, V> {
    protected V defaultValue;

    public DefaultHashMap(V defaultValue) {
        super();
        this.defaultValue = defaultValue;
    }

    public DefaultHashMap(int initialCapacity, V defaultValue) {
        super(initialCapacity);
        this.defaultValue = defaultValue;
    }

    public DefaultHashMap(int initialCapacity, float loadFactor, V defaultValue) {
        super(initialCapacity, loadFactor);
        this.defaultValue = defaultValue;
    }

    public DefaultHashMap(Map<? extends K, ? extends V> m, V defaultValue) {
        super(m);
        this.defaultValue = defaultValue;
    }

    @Override
    public V get(Object k) {
        return containsKey(k) ? super.get(k) : defaultValue;
    }
}
