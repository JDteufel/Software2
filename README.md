# Software2
Bloc de notas :D
Conexion con Singleton
public class DbConnection {

    private static DbConnection instance = null;
    private Connection conn = null;

    private DbConnection() {}

    private void init() throws SQLException {
        final String DB_URL = "jdbc:mysql://localhost:3306/library";
        final String USER = "root";
        final String PASS = "12345";
        
        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        System.out.println("Connected to database");
    }

    public Connection getConnection() {
        return conn;
    }

    public static Connection getInstance() throws SQLException {
        if (instance != null && !instance.getConnection().isClosed()) {
            return instance;
        } else {
            instance = new DbConnection();
            instance.init();
        }
    }
}
