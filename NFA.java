import java.util.HashMap;
// We will list all the basic methods used in both types of Automata
public class NFA{
    /*  Definition of Automata
    Consists of the following:
        Q - Set of States
        Sigma - Set of Alphabets
        Delta - Transition Function
        Q0 - Initial State
        F - Set of Final States
    */
    // Since there is no need to quickly find a state
    // We will use an Array

   HashMap<String, State> Q = new HashMap<String,State>();
}