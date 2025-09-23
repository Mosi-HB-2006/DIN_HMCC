package model;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @author Usuario
 */
public class FileUserDataAccessor implements DataAccessible {

    /**
     * @param username The username of the saved person
     * @param password The password of the saved person
     * @return Method to check if the data is in the saved file.
     */
    @Override
    public User accessData(String username, String password) {
        File fich = new File("usuarios.obj");
        boolean endFile = false;
        User finalUser = null;

        if (fich.exists()) {
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fich));
                try {
                    do {
                        User user = (User) ois.readObject();
                        if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                            finalUser = user;
                            endFile = true;
                        }
                    } while (!endFile);
                } catch (EOFException e) {
                    endFile = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return finalUser;
    }
}
