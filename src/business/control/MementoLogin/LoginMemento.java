package business.control.MementoLogin;

import business.model.User;

public class LoginMemento {
    private User loggedInUser;
    private boolean loggedIn;
    
    public LoginMemento(User loggedInUser, boolean loggedIn) {
        this.loggedInUser = loggedInUser;
        this.loggedIn = loggedIn;
    }
    
    public User getLoggedInUser() {
        return loggedInUser;
    }
    
    public boolean isLoggedIn() {
        return loggedIn;
    }
}
