// Let's great a Hashmap to store the symbol (key) and the list of states (value) that the current state can go to using the symbol
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
public class State {
    // States contain the following characteristics: name, isFinal, isInitial
    private String name;
    private boolean isFinal;
    private boolean isInitial;
    HashMap <Character, State[]> transitionFunction;
    // Empty State or Default Constructor
    public State() {
        name = "";
        isFinal = false;
        isInitial = false;
        transitionFunction = new HashMap<>();
    }
    // Creating a State with just the Name
    public State(String name){
        this.name = name;
        isFinal = false;
        isInitial = false;
        transitionFunction = new HashMap<>();
    }

    // Creating a State with information about its characteristics
    public State(String name, boolean isFinal, boolean isInitial, HashMap<Character, State[]> transitionFunction){
        this.name = name;
        this.isFinal = isFinal;
        this.isInitial = isInitial;
        if (transitionFunction == null){
            this.transitionFunction = new HashMap<>();
        }
        else{
        this.transitionFunction = transitionFunction;
        }
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
    public HashMap<Character, State[]> getTransitionFunction(){
        return transitionFunction;
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
    public void setTransitionFunction(HashMap<Character, State[]> transitionFunction){
        this.transitionFunction = transitionFunction;
    }

    // Add a Transition
    public void addTransition(Character symbol, State[] states){
        // If the symbol is not in the transition function, we will add it
        if (!transitionFunction.containsKey(symbol)){
            transitionFunction.put(symbol, states);
        }
        // If the symbol is in the transition function, we will add the state to the list of states that the current state can go to using the symbol
        else{
            int tempLength = states.length;
            State[] temp = transitionFunction.get(symbol);
            State[] temp2 = new State[temp.length + tempLength];
            for (int i = 0; i < temp.length; i++){
                temp2[i] = temp[i];
            }
            for (int i = temp.length; i < tempLength; i++){
                temp2[i] = temp[i];
            }
            transitionFunction.put(symbol, temp2);
        }
    }

    // Remove a Transition
    public void removeTransition(Character symbol, State[] states){
        // If the symbol is not in the transition function, we will not remove anything
        if (!transitionFunction.containsKey(symbol)){
            System.out.println("Symbol does not exist in the Transition Function");
        }
        // If the symbol is in the transition function, we will remove the state from the list of states that the current state can go to using the symbol
        else{
            ArrayList<State> arrayListTemp = new ArrayList<>();
            State[] temp = new State[transitionFunction.get(symbol).length - states.length];
            for (int i = 0; i < transitionFunction.get(symbol).length; i++){
                boolean found = false;
                for (int j = 0; j < states.length; j++){
                    if (transitionFunction.get(symbol)[i] == states[j]){
                        found = true;
                    }
                }
                if(!found){
                    arrayListTemp.add(transitionFunction.get(symbol)[i]);
                }
            }
           arrayListTemp.toArray(temp);
        }
    }

    public String transitionFunctionsToString(){
        String result = "";
        if (transitionFunction.isEmpty()){
            result += "Empty";
        }
        else{
            for (Map.Entry<Character, State[]> entry : transitionFunction.entrySet()){
                result += "\nδ(" + name + ", ";
                result += entry.getKey().toString() + ") = {";
                State firstState = entry.getValue()[0];
                State lastState = entry.getValue()[entry.getValue().length - 1];
               
                for (State state : entry.getValue()) {
                    if (!state.equals(firstState)){
                        result += ",";
                    }
                    result += state.getName();
                    if (state.equals(lastState)){
                        result += "}"; 
                    }
                }
            }
            
        }
        return result;
    }
    
    // Overriding the toString method and returning characteristics about the State
    public String toString() {
        String result = "State: " + name + "\n" + "Is Initial: " + isInitial + "\n" + "Is Final: " + isFinal + "\n" + "Transition Function: ";
        if (transitionFunction.isEmpty()){
            result += "Empty";
        }
        else{
            for (Map.Entry<Character, State[]> entry : transitionFunction.entrySet()){
                result += "\nδ(" + name + ", ";
                result += entry.getKey().toString() + ") = {";
                State firstState = entry.getValue()[0];
                State lastState = entry.getValue()[entry.getValue().length - 1];
               
                for (State state : entry.getValue()) {
                    if (!state.equals(firstState)){
                        result += ",";
                    }
                    result += state.getName();
                    if (state.equals(lastState)){
                        result += "}"; 
                    }
                }
            }
            
        }
        return result;
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