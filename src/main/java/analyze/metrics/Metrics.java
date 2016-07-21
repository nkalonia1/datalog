package analyze.metrics;

/**
 * Created by nkalonia1 on 7/21/16.
 */
public abstract class Metrics {
    private boolean _locked;

    public Metrics() { _locked = false; }

    public void lock() { _locked = true; }

    public boolean isLocked() { return _locked; }
}
