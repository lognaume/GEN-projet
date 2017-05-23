package ch.heigvd.server;

import java.rmi.server.UID;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Communicate with the database for loginInformation, stats and more
 *
 * @author Maxime Guillod
 */
public class BDD {

    static enum Type {
        INFO,
        ERROR
    }

    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://proteck.ch:3306/HEIG_GEN";
    private static final String USERNAME = "GEN";
    private static final String PASSWORD = "Jm0y2x1&";
    private static final String MAX_POOL = "250";

    private static BDD instance = null;

    private Connection connection = null;

    private BDD() {
        /*
        Connect the database on the first call of getInsatnce()
         */
        connect();
    }

    public static BDD getInstance() {
        if (instance == null) {
            instance = new BDD();
        }
        return instance;
    }

    public void connect() {
        if (connection == null) {
            try {
                Class.forName(DATABASE_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, getProperties());
            } catch (SQLException e) {
                Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, e);
            } catch (ClassNotFoundException e) {
                Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    private Properties getProperties() {
        Properties properties = new Properties();
        properties.setProperty("user", USERNAME);
        properties.setProperty("password", PASSWORD);
        properties.setProperty("MaxPooledStatements", MAX_POOL);
        return properties;
    }

    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isClosed() {
        try {
            return connection.isClosed();
        } catch (SQLException ex) {
            Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public boolean testLogin(String login, String pwd) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private void log(Class c, UID uid, BDD.Type type, String content) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Log"
                    + " (class, uid, type, content) VALUES "
                    + " (\"" + c.getName() + "\","
                    + "\"" + uid.hashCode() + "\","
                    + "\"" + type + "\","
                    + "\"" + content + "\");");

        } catch (SQLException ex) {
            Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void logError(ILog object, Exception e) {
        log(object.getClass(), object.getUid(), BDD.Type.ERROR, e.getMessage());
    }

    public void logInfo(ILog obj, String content) {
        log(obj.getClass(), obj.getUid(), BDD.Type.INFO, content);
    }
    
    public String getLastLogContent() {
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT content FROM Log ORDER BY id DESC LIMIT 1;");
            if (result.next()) {
                return result.getNString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
