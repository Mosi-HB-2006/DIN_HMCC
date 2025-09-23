package controller;

import model.*;

public class UserDataWindowController {
    DataAccessible dao = new FileUserDataAccessor();
    
    public User accessDataFile(String username, String password)  {
        return dao.accessDataFile(username, password);
    }
}
