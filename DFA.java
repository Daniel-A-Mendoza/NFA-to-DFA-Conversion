import java.util.ArrayList;
public class DFA extends NFA{
    static char lamda = 'λ';
    // Empty DFA
    public DFA (){
        super();
    }
    // DFA with User Input
    public DFA(ArrayList<State> Q, ArrayList<Character> alphabet){
        super(Q, alphabet);
    }

    // NFA to DFA Conversion
    public DFA(NFA nfa){
        // Create a new DFA that will be returned
        DFA dfa = new DFA();

        // Find the first state of the DFA
        ArrayList<State> initialState = epsilonClosure(nfa.getInitialState());
        
        // We now check the other symbols in the alphabet
        // If it exists in the alphabet, we find the epsilon closure of the state
    
    }
   
    // Find the Epsilon Closure of a State
    public ArrayList<State> epsilonClosure(State state){
        ArrayList<State> closure = new ArrayList<>();
        closure.add(state);
        if (state.transitionFunction.containsKey(lamda)){
            for (State s : state.transitionFunction.get(lamda)){
                closure.addAll(epsilonClosure(s));
            }
        }
        return closure;
    }

    public ArrayList<State> union(ArrayList<State> a, ArrayList<State> b){
        ArrayList<State> result = new ArrayList<>();
        for (State s : a){
            result.add(s);
        }
        for (State s : b){
            if (!result.contains(s)){
                result.add(s);
            }
        }
        return result;
    }

}