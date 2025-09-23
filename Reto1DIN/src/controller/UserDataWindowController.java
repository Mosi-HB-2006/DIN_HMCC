package controller;

import model.*;

/**
 * @author Jago128
 */
public class UserDataWindowController {
    DataAccessible dao = new FileUserDataAccessor();
    
    /**
     * @param username The username of the saved person
     * @param password The password of the saved person
     * @return Method to check if the data is available in the database or saved file.
     */
    public User accessDataFile(String username, String password)  {
        return dao.accessData(username, password);
    }
}
