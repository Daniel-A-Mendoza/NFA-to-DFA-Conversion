import java.util.ArrayList;
// Both NFA and DFA have the same structure with the slight modification of the transition function
public class NFA{
    /*  Definition of Automata
    Consists of the following:
        Q - Set of States
        Sigma - Set of Alphabets
        Delta - Transition Function
        Q0 - Initial State
        F - Set of Final States
    */
    // ArrayList can easily add or remove states/symbols from their respective list.
    // Set of States
   protected ArrayList<State> Q;

   // Set of Alphabets (Chose Character since each symbol is one character)
   protected ArrayList<Character> alphabet;

   /*
    Transition Function (We need a list of all Transition Functions for each State)
    Each Transition Function is the current State, the symbol(s), and the next states using the same symbol (3 things)
    We can use a matrix to represent the Transition Function:
    - Rows will be the States
    - Columns will be the Alphabet
    - Each cell will contain a list of States that the current State can go to using the symbol
   Data Structure to store a matrix is a matrix ArrayList
    */
    // Initial State
    protected State initialState;

    // Set of Final States
    protected ArrayList<State> finalStates;

   // Empty NFA
   public NFA (){
     Q = new ArrayList<State>();
     alphabet = new ArrayList<Character>();
     initialState = new State();
     finalStates = new ArrayList<State>();
   }

   // NFA with User Input
   public NFA(ArrayList<State> Q, ArrayList<Character> alphabet){
        this.Q = Q;
        this.alphabet = alphabet;
        this.initialState = findInitialState();
        this.finalStates = findFinalStates();
   }

   // Getters
   public ArrayList<State> getQ(){
       return Q;
   }

   public ArrayList<Character> getAlphabet(){
       return alphabet;
   }

   public State getInitialState(){
       return initialState;
   }
   
   public ArrayList<State> getFinalStates(){ 
      return finalStates;
   }         

     // Setters
     public void setQ(ArrayList<State> Q){
         this.Q = Q;
     }
     public void setAlphabet(ArrayList<Character> alphabet){
         this.alphabet = alphabet;
     }

     public void setInitialState(State initialState){
         this.initialState = initialState;
     }
     public void setFinalStates(ArrayList<State> finalStates){
         this.finalStates = finalStates;
     }

     // Adding a State to the Set of States
     public void addState(State state){
        if (Q.contains(state)){
            System.out.println("State already exists in the Set of States");
        }
        else{
            Q.add(state);
        }
        
     }

     // Removing a State from the Set of States
     public void removeState(State state){
        if (Q.contains(state)){
            Q.remove(state);
        }
        else{
            System.out.println("State does not exist in the Set of States");
        }
     }

     // Adding a Symbol to the Alphabet
     public void addSymbol(Character symbol){
        if (alphabet.contains(symbol)){
            System.out.println("Symbol already exists in the Alphabet");
        }
        else{
            alphabet.add(symbol);
        }
     }

     // Removing a Symbol from the Alphabet
     public void removeSymbol(Character symbol){
        if(alphabet.contains(symbol)){
            alphabet.remove(symbol);
        }
        else{
            System.out.println("Symbol does not exist in the Alphabet");
        }
     }

     // Find the initial State of the NFA
        public State findInitialState(){
            for (int i = 0; i < Q.size(); i++){
                if (Q.get(i).isInitial()){
                    return Q.get(i);
                }
            }
            return null;
        }

    // Find the Final States of the NFA
    public ArrayList<State> findFinalStates(){
        ArrayList<State> result = new ArrayList<State>();
        for (int i = 0; i < Q.size(); i++){
            if (Q.get(i).isFinal()){
                result.add(Q.get(i));
            }
        }
        return result;
    }
       

     // Find the Epsilon Closure of a State
        public ArrayList<State> epsilonClosure(State state){
            ArrayList<State> result = new ArrayList<State>();
            result.add(state);
            // If the state has a transition using the empty string, we will add the next state to the result
            if (state.getTransitionFunction().containsKey('λ')){
                State[] temp = state.getTransitionFunction().get('λ');
                for (int i = 0; i < temp.length; i++){
                    result.add(temp[i]);
                    result.addAll(epsilonClosure(temp[i]));
                }
            }
            return result;
        }


     // Overriding the toString method to return the characteristics of the NFA
     public String toString(){

        // Resturns the Names of the States in the NFA
        String result = "Set of States: \n{";
         for (int i = 0; i < Q.size(); i++){
            result += (Q.get(i).getName());
            if (i != Q.size() - 1){
                result += ", ";
            }   
         }
         result += "}\n";

         // Returns the Alphabet of the NFA
            result += "Alphabet: \n{";
            for (int i = 0; i < alphabet.size(); i++){
                result += alphabet.get(i);
                if (i != alphabet.size() - 1){
                    result += ", ";
                }
            }
            result += "}\n";

        // Return the Initial State of the NFA
        result += "Initial State: \n" + initialState.getName() + "\n";
        // Return the List of Final States of the NFA
        result += "Final States: \n{";
        for (int i = 0; i < finalStates.size(); i++){
            result += finalStates.get(i).getName();
            if (i != finalStates.size() - 1){
                result += ", ";
            }
        result += "}\n";
        result += "Transition Functions:";
        }
        for (int i = 0; i < Q.size(); i++){
            result += Q.get(i).transitionFunctionsToString();
        }
        return result;
     }

}