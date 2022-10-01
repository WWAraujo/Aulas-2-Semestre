package br.sp.senac.exemplojdbc.dao;

import br.sp.senac.exemplojdbc.model.NotaFiscal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando.fernandes
 */
public class NotaFiscalDAO {

    public static String url = "jdbc:mysql://localhost:3306/basenotafiscal";
    public static String login = "root";
    public static String senha = "P@$$w0rd";

    public static boolean salvar(NotaFiscal obj) {

        Connection conexao = null;

        boolean retorno = false;

        try {

            //TODO: Implementar insert na tabela NotaFiscal
            // Dependencias > add dependencies > pesquisa mysql connecotor
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Abrir a conexão
            conexao = DriverManager.getConnection(url, login, senha);
            
            //Criar o comando sql
            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO NotaFiscal (numeroNota, valorNota) values(?,?)");
            //Passanod os valores que estão com o ponto de interogação
            comandoSQL.setInt(1,obj.getNumeroNota());
            comandoSQL.setDouble(2, obj.getValorNota());
            
            //Executar o comando
            int linhasAfetadas = comandoSQL.executeUpdate();
            if(linhasAfetadas>0){
                retorno = true;
            }

            retorno = true;
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return retorno;
    }

    public static ArrayList<NotaFiscal> listar() {
        
        ArrayList<NotaFiscal> lista = new ArrayList<NotaFiscal>();
        Connection conexao= null;
        
        try {
            
            //TODO: Implementar consulta à tabela NotaFiscal
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Abrir conexão
            conexao = DriverManager.getConnection(url,login,senha);
            
            //criar comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM NotaFiscal");
            
            //Executar o comando
            ResultSet rs = comandoSQL.executeQuery();
            
            if(rs!=null){
                while(rs.next()){
                    NotaFiscal novoObjeto = new NotaFiscal();
                    novoObjeto.setIdNota(rs.getInt("idNota"));
                    novoObjeto.setNumeroNota(rs.getInt("numeroNota"));
                    novoObjeto.setValorNota(rs.getDouble("valorNota"));
                    
                    lista.add(novoObjeto);
                    
                }
            }
            
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return lista;
    }

    public static NotaFiscal consultarPorID(int idNota) {
        NotaFiscal lista = new NotaFiscal();

        //TODO: Implementar consulta à tabela NotaFiscal pelo id
        return lista;
    }

    public static boolean atualizar(NotaFiscal obj) {
        boolean retorno = false;

        //TODO: Implementar atualização do objeto na tabela NotaFisca
        return retorno;
    }

}
