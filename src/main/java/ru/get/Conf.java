package ru.get;

public class Conf {
    private boolean tracingEnabled = false;

    public void enableTracing() {
        tracingEnabled = true;
    }

    public void disableTracing() {
        tracingEnabled = false;
    }

    public boolean isTracingEnabled() {
        return tracingEnabled;
    }

}
