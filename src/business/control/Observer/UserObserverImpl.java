package business.control.Observer;


public class UserObserverImpl implements UserObserver {
    @Override
    public void onUserRegistered(String user) {
        System.out.println("\nNovo usuário registrado com sucesso: " + user);
    }

    @Override
    public void onUserRemoved(String user) {
        System.out.println("\nUsuário removido com sucesso: " + user);
    }

}
