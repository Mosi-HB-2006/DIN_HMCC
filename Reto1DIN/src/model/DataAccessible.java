package model;

/**
 * @author Jago128
 */
public interface DataAccessible {

    /**
     * @param username The username of the saved person
     * @param password The password of the saved person
     * @return Method to check if the data is available in the database or saved file.
     */
    public User accessData(String username, String password);
}
