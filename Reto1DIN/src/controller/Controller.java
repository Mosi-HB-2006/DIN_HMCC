package controller;

import model.DBUserAccessor;
import model.DataAccessible;
import model.FileUserDataAccessor;
import model.User;

/**
 * @author Jago128
 */
public class Controller {
    DataAccessible dao = null;
    
    /**
     * @param username The username of the saved person
     * @param password The password of the saved person
     * @return Method to check if the data is in the Database.
     */
    public User loginDB(String username, String password){
        dao=new DBUserAccessor();
        return dao.accessData(username, password);
    }
    
    /**
     * @param username The username of the saved person
     * @param password The password of the saved person
     * @return Method to check if the data is in the saved file.
     */
    public User loginFich(String username, String password){
        dao=new FileUserDataAccessor();
        return dao.accessData(username, password);
    }
}
