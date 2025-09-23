package controller;

import model.DBUserAccessor;
import model.DataAccessible;
import model.FileUserDataAccessor;
import model.User;

public class Controller {
    DataAccessible dao = null;
    
    public User loginDB(String username, String password){
        dao=new DBUserAccessor();
        return dao.accessData(username, password);
    }
    
    public User loginFich(String username, String password){
        dao=new FileUserDataAccessor();
        return dao.accessData(username, password);
    }
}
