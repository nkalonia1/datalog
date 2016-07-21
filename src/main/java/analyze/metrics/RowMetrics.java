package analyze.metrics;

/**
 * Created by nkalonia1 on 7/21/16.
 */
public class RowMetrics extends Metrics {
    private long _num_rows;

    public RowMetrics() {
        _num_rows = 0L;
    }

    public long getRows() { return _num_rows; }

    public void addRow(long amount) {
        if (isLocked()) { throw new IllegalStateException("RowMetrics is locked"); }
        else { _num_rows += amount; }
    }

    public void addRow() { addRow(1L); }
}
