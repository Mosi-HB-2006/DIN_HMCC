package model;

import java.io.File;

public interface DataAccessible {
    public User accessDataFile(File fich);
    public User accessDataBD();
}
