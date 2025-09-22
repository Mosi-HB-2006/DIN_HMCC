package model;

import java.io.EOFException;
import java.io.File;

public class FileUserDataAccessor implements DataAccessible {

    public User accessDataFile(File fich) {
        boolean endFile = false;
        
        try{
        }catch (EOFException e){
            endFile = true;
        }
        
        
        return null;
    }
}
