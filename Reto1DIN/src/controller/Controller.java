/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.DBUserAccessor;
import model.DataAccessible;
import model.FileUserDataAccessor;
import model.User;

/**
 *
 * @author Mosi
 */
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
