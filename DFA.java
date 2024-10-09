import java.util.ArrayList;
import java.util.HashMap;
public class DFA extends NFA{
    static char lamda = 'λ';

    // Empty DFA
    public DFA(){
        super();
    }

    // NFA to DFA Conversion
    public DFA(NFA nfa){
        super();

        // Create a Matrix of the NFA
        State[][][] nfaMatrix = makeNFAMatrix(nfa);
        // Print what the NFA looks like
        printNFAMatrix(nfaMatrix);

        nfa.removeSymbol('λ');

        // Make a List of all the DFA states
        ArrayList<State> dfaStates = new ArrayList<>();
        // Make a List of all the unmarked DFA states
        ArrayList<State> unmarkedStates = new ArrayList<>();
        // Make a HashMap of the State and its Index
        HashMap<State, Integer> stateIndex = new HashMap<>();
        HashMap<Character, Integer> symbolIndex = new HashMap<>();
        for(State s: nfa.getQ()){
            stateIndex.put(s, stateIndex.size());
        }
        for(char c: nfa.getAlphabet()){
            symbolIndex.put(c, symbolIndex.size()+1);
        }
        // Create the Initial State of the DFA
        State[] initialState = new State[nfa.getQ().size()];
        System.out.println("Initial State: " + initialState[0].getName());




       
    
    }

    // Make Trap State
    public State makeTrapState(){
        State trap = new State("Trap");
        for (int i = 0; i < alphabet.size(); i++){
            trap.addTransition(alphabet.get(i), new State[]{trap});
        }
        return trap;
    }

    public State[][][] makeNFAMatrix(NFA nfa){
        State[][][] nfaMatrix = new State[nfa.getQ().size()][nfa.getAlphabet().size()][nfa.getQ().size()];
        for (int i = 0; i < nfa.getQ().size(); i++){
            for (int j = 0; j < nfa.getAlphabet().size(); j++){
                if (nfa.getQ().get(i).getTransitionFunction().containsKey(nfa.getAlphabet().get(j))){
                    nfaMatrix[i][j] = nfa.getQ().get(i).getTransitionFunction().get(nfa.getAlphabet().get(j));
                }
            }
        }
        for (int i = 0; i < nfa.getQ().size(); i++){
            nfaMatrix[i][0] = nfa.epsilonClosure(nfa.getQ().get(i)).toArray(new State[0]);
        }
        return nfaMatrix;

    }

    public ArrayList<State> union(ArrayList<State> a, State[] b){
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

    // Making a new State of that contains a group of states such as a powerset of states
    public State makeState(State[] states){
        State result = new State();
        String name = "";
        for (State state : states){
            name += state.getName();
        }
        result.setName(name);
        return result;
    }

    // Print the NFA Matrix to check how it looks like
    public void printNFAMatrix(State[][][] nfaMatrix){
        System.out.println("NFA Matrix: ");
        for (int i = 0; i < nfaMatrix.length; i++){
            for (int j = 0; j < nfaMatrix[i].length; j++){
                System.out.print("[");
                for (int k = 0; k < nfaMatrix[i][j].length; k++){
                    if (nfaMatrix[i][j][k] != null){
                        
                        System.out.print(nfaMatrix[i][j][k].getName());
                        if (k+1 != nfaMatrix[i][j].length){
                            System.out.print(", ");
                        }
                    }
                }
                System.out.print("]");
            }
            System.out.println();
        }
       
    }
}