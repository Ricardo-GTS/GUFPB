package business.control.MementoLogin;

import java.util.Stack;

public class LoginMementoCareTaker {
    private Stack<LoginMemento> mementoStack;
    
    public LoginMementoCareTaker() {
        mementoStack = new Stack<>();
    }
    
    public void saveMemento(LoginMemento memento) {
        mementoStack.push(memento);
    }
    
    public LoginMemento retrieveMemento() {
        if (!mementoStack.isEmpty()) {
            return mementoStack.pop();
        }
        return null;
    }
}