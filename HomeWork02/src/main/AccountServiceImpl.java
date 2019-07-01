package main;

import inteface.AccountService;
import java.util.Map;
import java.util.HashMap;

public class AccountServiceImpl implements AccountService {
    private final Map<String, UserProfile> signedUpUsers = new HashMap<>();

    @Override
    public void singUp(String login, String password) {
        if(login != null) {
            signedUpUsers.put(login, new UserProfile(login, password));
        }
    }

    @Override
    public boolean singIn(String login, String password) {
        UserProfile profile = signedUpUsers.get(login);
        return profile != null;
    }
}
