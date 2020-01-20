
package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eduardo Rocha
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    static Connection con=null;
    
    public static void main(String[] args) {
        // SOBE O BANCO
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", ""); 
            Statement stmt=con.createStatement(); 

            String sql = "CREATE DATABASE IF NOT EXISTS ESCOLA";
            stmt.executeUpdate(sql);

            sql = "USE ESCOLA";
            stmt.executeUpdate(sql);

            sql = "create table IF NOT EXISTS aluno ( codigo int auto_increment primary key , nome varchar(50)) ";
            stmt.executeUpdate(sql);

            sql = " create table IF NOT EXISTS curso( codigo int auto_increment primary key , descricao varchar(50), ementa text)";
            stmt.executeUpdate(sql);

            sql = "create table IF NOT EXISTS curso_aluno ( codigo int auto_increment primary key , codigo_aluno int , codigo_curso int, foreign key (codigo_aluno) references aluno (codigo), foreign key (codigo_curso) references curso (codigo))";
            stmt.executeUpdate(sql); 
            
            TelaPrincipal tela = new TelaPrincipal();
            tela.setVisible(true);

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Nao foi possivel acessar o banco de dados\nAplicacao sera encerrada", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
       
        
    }
    
}
