public class State {
    private String name;
    private boolean isFinal;
    private boolean isInitial;
    public State(String name, boolean isFinal, boolean isInitial) {
        this.name = name;
        this.isFinal = isFinal;
        this.isInitial = isInitial;
    }
    public String getName() {
        return name;
    }
    public boolean isFinal() {
        return isFinal;
    }
    public boolean isInitial() {
        return isInitial;
    }
    public void setFinal(boolean isFinal) {
        this.isFinal = isFinal;
    }
    public void setInitial(boolean isInitial) {
        this.isInitial = isInitial;
    }
    public String toString() {
        return name;
    }
    public boolean equals(State comperand) {
        if (comperand == null) {
            return false;
        }
        if (comperand == this) {
            return true;
        }
        return name.equals(comperand.name);
    }
}
