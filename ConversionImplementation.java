// import java.util.ArrayList;
import java.util.Arrays;
public class ConversionImplementation {
    public static void main(String[] args) {
        // Create an NFA
        NFA nfa = new NFA();
       // Create States
        nfa.addSymbol('a');
        nfa.addSymbol('b');
        nfa.addSymbol('λ');
        // Create an NFA with User Input
        State q0 = new State("q0");
        State q1 = new State("q1");
        State q2 = new State("q2");

        q0.addTransition('a', new State[]{q0,q1});
        q1.addTransition('b', new State[]{q1,q2});
        q2.addTransition('a', new State[]{q2});
        nfa.addState(q0);
        nfa.addState(q1);
        nfa.addState(q2);
        q0.setInitial(true);
        q2.setFinal(true);
        nfa.setInitialState(nfa.findInitialState());
   
        nfa.setFinalStates(nfa.findFinalStates());
        System.out.println(nfa);
        nfa.epsilonClosure(q0);
        nfa.epsilonClosure(q1);
        nfa.epsilonClosure(q2);
        DFA dfa = new DFA(nfa);
        System.out.println("DFA: ");
        System.out.println(dfa);
        // State[][][] nfaMatrix = new State[2][3][4];
        // nfaMatrix[0][0] = new State[]{q0,q2};
        // System.out.println(Arrays.toString(nfaMatrix[0][0]));
    }
}
