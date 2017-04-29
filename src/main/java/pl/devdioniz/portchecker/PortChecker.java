package pl.devdioniz.portchecker;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Util class for testing if network connection can be
 * established from one host to another.
 *
 * @author TheDioniz, created on 29.04.2017.
 */
public class PortChecker {

    public static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    String host = "";
    Integer port = 0;

    public PortChecker(String host, Integer port) {
        this.host = host;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * Tries to connect to host and port specified in constructor
     * @return true if connected, false if not
     */
    public boolean connect() {

        try (Socket socket = new Socket(host, port)) {

            if (socket.isConnected()) {
                LOGGER.log(Level.INFO, "Successfully connected to " + host + ":" + port);
                return true;
            }

        } catch (UnknownHostException e) {
            LOGGER.log(Level.SEVERE, "DNS cannot be resolved for: " + host);
            e.printStackTrace();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Cannot connect to " + host + ":" + port);
            e.printStackTrace();
        }

        return false;
    }
}
