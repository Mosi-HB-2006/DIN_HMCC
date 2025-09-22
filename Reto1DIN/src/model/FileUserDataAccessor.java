package model;

import java.io.EOFException;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileUserDataAccessor implements DataAccessible {

    public User accessDataFile(String username, String password) {
        boolean endFile = false;
        ObjectInputStream ois = null;
        
        try {
            ois = new ObjectInputStream(ois);
            
        } catch (EOFException e){
            endFile = true;
        } catch (IOException ex) {
            Logger.getLogger(FileUserDataAccessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
