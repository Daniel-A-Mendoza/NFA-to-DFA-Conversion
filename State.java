public class State {
    // States contain the following characteristics: name, isFinal, isInitial
    private String name;
    private boolean isFinal;
    private boolean isInitial;

    // Empty State or Default Constructor
    public State() {
        name = "";
        isFinal = false;
        isInitial = false;
    }

    // Creating a State with information about its characteristics
    public State(String name, boolean isFinal, boolean isInitial) {
        this.name = name;
        this.isFinal = isFinal;
        this.isInitial = isInitial;
    }

    // Getters
    public String getName() {
        return name;
    }
    public boolean isFinal() {
        return isFinal;
    }
    public boolean isInitial() {
        return isInitial;
    }

    // Setters
    public void setName(String name){
        this.name = name;
    }
    public void setFinal(boolean isFinal) {
        this.isFinal = isFinal;
    }
    public void setInitial(boolean isInitial) {
        this.isInitial = isInitial;
    }

    // Overriding the toString method and returning characteristics about the State
    public String toString() {
        return "State Name: " + name + "\nFIs Final State?: " + isFinal + "\nIs Initial State?: " + isInitial;
    }

    // Overriding the equals method to compare two states
    public boolean equals(State operand) {
        // If the operand is null, that means they cannot be the same state since one of them does not exist
        if (operand == null) {
            return false;
        }
        // If the operand is the same as the current state, then they are the same state
        if (operand == this) {
            return true;
        }
        // If the operand is not the same instance, but we compare that they have the same name, they are the same state
        // We will use this case when we create a temporary State object but it has the same name as the original, and we want to compare
        return name.equals(operand.name);
    }
}
