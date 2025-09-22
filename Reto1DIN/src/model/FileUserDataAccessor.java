package model;

import java.io.*;

public class FileUserDataAccessor implements DataAccessible {

    @Override
    public User accessDataFile(String username, String password) {
        File fich = new File("usuarios.obj");
        boolean endFile = false;
        ObjectInputStream ois = null;
        User finalUser = null;

        if (fich.exists()) {
            try {
                ois = new ObjectInputStream(new FileInputStream(fich));
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
