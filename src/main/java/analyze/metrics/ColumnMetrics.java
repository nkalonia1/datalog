package analyze.metrics;

import util.DefaultHashMap;

import java.util.Collection;
import java.util.Map;

/**
 * Created by nkalonia1 on 7/21/16.
 */
public class ColumnMetrics extends Metrics {

    private int _max_cols;
    private int _min_cols;
    private Map<Integer, Long> _col_lengths;

    public ColumnMetrics() {
        _max_cols = -1;
        _min_cols = Integer.MAX_VALUE;
        _col_lengths = new DefaultHashMap<Integer, Long>(0L);
    }

    public void addColumns(int col_length) {
        if (isLocked()) { throw new IllegalStateException("ColumnMetrics is locked"); }
        else {
            _col_lengths.put(col_length, _col_lengths.get(col_length) + 1);
            if (col_length > _max_cols) { _max_cols = col_length; }
            if (col_length < _min_cols) { _min_cols = col_length; }
        }
    }

    public int getMax() {
        if (_max_cols < _min_cols) {
            throw new IllegalStateException("No columns have been added");
        } else {
            return _max_cols;
        }
    }

    public int getMin() {
        if (_min_cols > _max_cols) {
            throw new IllegalStateException("No columns have been added");
        } else {
            return _min_cols;
        }
    }

    public Collection<Integer> getLengths() { return _col_lengths.keySet(); }

    public long getQuantity(int col_length) {return _col_lengths.get(col_length); }
}
