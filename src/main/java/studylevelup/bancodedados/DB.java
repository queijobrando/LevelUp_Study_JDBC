package studylevelup.bancodedados;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {
    private static Connection conn = null;

    //conectar com o banco de dados
    public static Connection getConnection(){
        if (conn == null){
            try {
                Properties props = carregarPropriedades();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);
                System.out.println("Conexão com banco bem sucedida");
            }
            catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }

    // desconectar do banco de dados
    public static void closeConnection(){
        if (conn != null){
            try {
                conn.close();
                System.out.println("Conexão com banco finalizada");
            }
            catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeStatement (Statement st){
        if (st != null){
            try {
                st.close();
            }
            catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs){
        try {
            if (rs != null){
                rs.close();
            }
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
    }

    //CARREGA AS PROPRIEDADES DO ARQUIVO db.properties
    private static Properties carregarPropriedades(){
        try(FileInputStream fs = new FileInputStream("db.properties")){
            Properties prop = new Properties();
            prop.load(fs);
            return prop;
        }
        catch (IOException e){
            throw new DbException(e.getMessage());
        }

    }

}
