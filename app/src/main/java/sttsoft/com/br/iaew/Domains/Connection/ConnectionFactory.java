package sttsoft.com.br.iaew.Domains.Connection;

import com.microsoft.signalr.HubConnection;
import com.microsoft.signalr.HubConnectionBuilder;

public final class ConnectionFactory {

    private static final String URL = "http://192.168.0.157/chathub";

    private HubConnection connection;

    private static ConnectionFactory instance;

    public static synchronized ConnectionFactory getInstance() {
        if (instance == null)
            instance = new ConnectionFactory();
        return instance;
    }

    private ConnectionFactory() {}

    public HubConnection getNewConnection(String user) {
        try {

            HubConnection connection = HubConnectionBuilder.create(URL).build();

            connection.start().subscribe();

            connection.on("register-user", () -> {
                connection.send("RegisterUser", user);
            });

            this.connection = connection;

            return connection;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public HubConnection getConnection() {
        return connection;
    }
}
