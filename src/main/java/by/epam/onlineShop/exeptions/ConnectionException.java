package by.epam.onlineShop.exeptions;

import java.sql.SQLException;

public class ConnectionException extends SQLException {

    public ConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

}
