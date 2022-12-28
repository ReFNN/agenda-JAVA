package factoryDAO;
import java.sql.*;


public class ConnectionDAO {
    
        private static final String USERNAME = "be4d18b120edd7";
        private static final String PASSWORD = "93e9678e";
        private static final String URL = "jdbc:mysql://us-cdbr-east-06.cleardb.net/heroku_7f18a21482299d8";
        
        // FUNÇÃO PRINCIPAL PARA CONEXÃO COM BANCO DE DADOS
        public static Connection createConnectionToMySQL() throws Exception {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return connection;
        }
        
        // FUNÇÃO PARA TESTAR SE A CONEÇÃO ESTÁ FUNCIONANDO
        public static void main(String[] args) throws Exception {
        Connection con = createConnectionToMySQL();
        
        if(con!=null){
            System.out.println("Conexão obtida com sucesso!");
            con.close();
        }
    }
}
