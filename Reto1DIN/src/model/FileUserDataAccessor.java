package model;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Mosi
 */
public class FileUserDataAccessor implements DataAccessible {

    /**
     * @param username The username of the saved person
     * @param password The password of the saved person
     * @return Method to check if the data is in the saved file.
     */
    @Override
    public User accessData(String username, String password) {
        File fich = new File("usuarios.dat");
        boolean endFile = false;
        User finalUser = null;

        if (fich.exists()) {
            finalUser = verifyUser(username, password, fich);
        } else {
            fillData(fich);
            finalUser = verifyUser(username, password, fich);
        }
        return finalUser;
    }

    public static void fillData(File fich) {
        User u1 = new User("user1", "user1", "17/10/2006", "New Description for User 1", Gender.MALE);
        User u2 = new User("user2", "user2", "17/10/2006", "New Description for User 2", Gender.FEMALE);
        User u3 = new User("user3", "user3", "17/10/2006", "New Description for User 3", Gender.NON_BINARY);

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fich));

            oos.writeObject(u1);
            oos.writeObject(u2);
            oos.writeObject(u3);

            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static User verifyUser(String username, String password, File fich) {
        boolean endFile = false;
        User endUser = null;
        
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fich));
            try {
                do {
                    User user = (User) ois.readObject();
                    if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                        endUser = user;
                        endFile = true;
                    }
                } while (!endFile);
            } catch (EOFException e) {
                endFile = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return endUser;
    }
}
