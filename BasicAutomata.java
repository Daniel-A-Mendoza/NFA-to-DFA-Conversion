// We will list all the basic methods used in both types of Automata
public interface BasicAutomata <E> {
    public void setInitialState(E state); // This method will set the initial state of the automata
    public E getInitialState(); // This method will return the initial state of the automata
    public void setFinalState(E state); // This method will set the final state of the automata
    public E getFinalState(); // This method will return the final state of the automata
    public char getTransition(E state, char symbol); // This method will return the transition of the automata
    public boolean isFinalState(E state); // This method will return true if the current state is in the final state.
}