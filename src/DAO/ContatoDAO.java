package DAO;

import java.sql.*;
import com.mysql.jdbc.PreparedStatement;

import java.util.ArrayList;
import java.util.List;

import agenda.Contato;
import factoryDAO.ConnectionDAO;

// CLASSE DE ACESSO PARA MANIPULAR OS DADOS DO BANCO DE DADOS
public class ContatoDAO {
    
    // CRIANDO CONTATO
    public void save(Contato contato){
        
        // COMANDO SQL
        String sql = "INSERT INTO tb_contato(nome_ctt, telefone_ctt, email_ctt) VALUES (?, ?, ?)";
        
       Connection conn = null;
       PreparedStatement pstm = null;
       
       try {
           // CRIA CONEXÃO COM BD
           conn = ConnectionDAO.createConnectionToMySQL();
           
           pstm = (PreparedStatement) conn.prepareStatement(sql);
           
           //ADICIONANDO OS VALORES NA QUERY DO SQL "INSERT"
           pstm.setString(1, contato.getNome_ctt());
           pstm.setString(2, contato.getTelefone_ctt());
           pstm.setString(3, contato.getEmail_ctt());
           
           //EXECUTANDO
           pstm.execute();
           
       }catch (Exception e){
           System.out.println("Erro na execução: " + e);
       }finally {
           //FECHANDO CONEXÕES
            try {
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch(SQLException e2) {
                System.out.println("Erro ao fechar sessões: "+ e2);
            }
       }
       
    }
    
    // EXIBINDO TODOS CONTATOS
    public List<Contato> getContatos() {
        
        // COMANDO SQL
        String sql = "SELECT * FROM tb_contato";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        
        // CRIANDO COLLECTION DO TIPO LIST
        List<Contato> contatos = new ArrayList<Contato>();
        
        // CRIA CONEXÃO COM BD
        try {
            conn = ConnectionDAO.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            // EXECUTA A QUERY SQL
            rset = pstm.executeQuery();
            
            // ADICIONANDO TODOS CONTATOS DO BD NO ARRAYLIST
            while (rset.next()){
                Contato contato = new Contato();
                // PEGANDO ID
                contato.setId_ctt(rset.getInt("id_ctt"));
                // PEGANDO NOME
                contato.setNome_ctt(rset.getString("nome_ctt"));
                // PEGANDO TELEFONE
                contato.setTelefone_ctt(rset.getString("telefone_ctt"));
                // PEGANDO EMAIL
                contato.setEmail_ctt(rset.getString("email_ctt"));
                // ADICIONANDO AO ARRAY
                contatos.add(contato);
            }
        }catch(Exception e) {
            System.out.println("Erro na exibição dos contatos: " + e);
        }finally {
            
            // FECHANDO CONEXÕES
            try {
                if (rset!=null){
                rset.close();
            }
            if(pstm!=null){
                pstm.close();
            }
            if(conn!=null){
                conn.close();
            }
            }catch(SQLException e){
                System.out.println("Erro no fechamento da conexão: " + e);
            }
        }
        return contatos;
}
    
    // ATUALIZANDO CONTATO
    public void update(Contato contato){
        
        // COMANDO SQL
        String sql = "UPDATE tb_contato SET nome_ctt = ?, telefone_ctt = ?, email_ctt = ?"+" WHERE id_ctt= ?";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try {
            //CONEXÃO COM BD
            conn = ConnectionDAO.createConnectionToMySQL();
            
            //CLASSE PARA EXECUTAR A QUERY
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            
            // ADICIONANDO VALORES PARA ATUALIZAR
            pstm.setString(1, contato.getNome_ctt());
            pstm.setString(2, contato.getTelefone_ctt());
            pstm.setString(3, contato.getEmail_ctt());
            
            // QUAL ID PRA ATUALIZAR?
            pstm.setInt(4, contato.getId_ctt());
            
            // EXECUTANDO QUERY
            pstm.execute();
            System.out.println("O contato foi atualizado!");
            
        }catch(Exception e){
            System.out.println("Erro na atualizando do banco de dados: " + e);

        }finally {
            // ENCERRANDO CONEXÃO COM BD
            try {
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch(SQLException e){
                System.out.println("Erro no encerramento da conexão: " + e);
            }
        }
         
    }
    
    // DELETANDO CONTATO
    public void delete(int id){
        
        // COMANDO SQL
        String sql = "DELETE FROM tb_contato WHERE id_ctt = ?";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        // INICIANDO CONEXÃO
        try {
            conn = ConnectionDAO.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            
            // INDICANDO QUAL CONTATO DELETAR PELO ID
            pstm.setInt(1, id);
            
            // EXECUTANDO QUERY
            pstm.execute();
            
        }catch(Exception e){
            System.out.println("Erro na exclusão do contato: "+e);
        } finally {
            try {
                // ENCERRANDO CONEXÕES
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch(SQLException e){
                System.out.println("Erro no encerramento da conexão: " + e);
            }
        }
    }
    
    // FUNÇÃOZINHA PRA LIMPAR A TELA

}

