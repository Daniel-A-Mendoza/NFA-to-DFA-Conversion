// import java.util.ArrayList;
public class ConversionImplementation {
    public static void main(String[] args) {
        // Create an NFA
        NFA nfa = new NFA();
       // Create Staes
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

        DFA dfa = new DFA(nfa);
        
    }
}
