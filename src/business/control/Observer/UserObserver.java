package business.control.Observer;


public interface UserObserver {
    void onUserRegistered(String user);
    void onUserRemoved(String user);
}