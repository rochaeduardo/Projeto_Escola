/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.*;
import javax.swing.table.*;
import javax.swing.*;

/**
 *
 * @author Eduardo Rocha
 */
public class TelaCurso extends javax.swing.JFrame {

    /**
     * Creates new form TelaCurso
     */
    
    Connection con=null;
    
    public TelaCurso() {
        initComponents();
        setLocationRelativeTo(null);
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/escola", "root", ""); 
            
            // Exibir todos os dados da tabela
            
            DefaultTableModel aModel = (DefaultTableModel)tblCurso.getModel();
            aModel.setRowCount(0);
            Statement stmt=con.createStatement();            
            ResultSet rs=stmt.executeQuery("select codigo, descricao, ementa from curso");
            java.sql.ResultSetMetaData rsmd = rs.getMetaData();
            int colNo = rsmd.getColumnCount();
            
            while(rs.next())
            {
                Object[] objects = new Object[colNo];
                for(int i = 0; i < colNo; i++) {
                    objects[i] = rs.getObject(i+1);
                }
                aModel.addRow(objects);
            }
            
            tblCurso.setModel(aModel);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Nao foi possivel acessar o banco de dados", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exibir_curso = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCurso = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btn_cadastrar = new javax.swing.JButton();
        btn_excluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        descricaoCurso = new javax.swing.JTextField();
        ementaCurso = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastrar Curso");
        setResizable(false);

        exibir_curso.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        exibir_curso.setText("Procurar");
        exibir_curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exibir_cursoActionPerformed(evt);
            }
        });
        exibir_curso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                exibir_cursoKeyPressed(evt);
            }
        });

        tblCurso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Ementa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCurso.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblCurso);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("< Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn_cadastrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_cadastrar.setText("Cadastrar");
        btn_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrarActionPerformed(evt);
            }
        });
        btn_cadastrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_cadastrarKeyPressed(evt);
            }
        });

        btn_excluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_excluir.setText("Excluir");
        btn_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirActionPerformed(evt);
            }
        });
        btn_excluir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_excluirKeyPressed(evt);
            }
        });

        jLabel1.setText("Descrição:");

        jLabel2.setText("Ementa:");

        descricaoCurso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                descricaoCursoKeyPressed(evt);
            }
        });

        ementaCurso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ementaCursoKeyPressed(evt);
            }
        });

        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ementaCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(descricaoCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(15, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_cadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(exibir_curso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(btn_excluir)
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(descricaoCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ementaCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cadastrar)
                    .addComponent(exibir_curso)
                    .addComponent(btn_excluir)
                    .addComponent(jButton2))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exibir_cursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exibir_cursoActionPerformed
        try
        {            
            if(con.isClosed())
            {
                JOptionPane.showMessageDialog(null, "Nao ha conexao com o banco de dados", "Aviso", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            DefaultTableModel aModel = (DefaultTableModel)tblCurso.getModel();
            aModel.setRowCount(0);
            Statement stmt=con.createStatement();            
            String sql="select codigo, descricao, ementa from curso where descricao like '%" + descricaoCurso.getText() + "%'";
            if(ementaCurso.getText().length() > 0){
                sql= "select codigo, descricao, ementa from curso where descricao like '%" + descricaoCurso.getText() + "%' or ementa like '%" + ementaCurso.getText() + "%'";
            }            
            if(descricaoCurso.getText().length() == 0 && ementaCurso.getText().length() == 0){
                sql = "select codigo, descricao, ementa from curso";
            }
            ResultSet rs=stmt.executeQuery(sql);
            java.sql.ResultSetMetaData rsmd = rs.getMetaData();
            int colNo = rsmd.getColumnCount();

            while(rs.next())
            {
                Object[] objects = new Object[colNo];
                for(int i = 0; i < colNo; i++) {
                    objects[i] = rs.getObject(i+1);
                }
                aModel.addRow(objects);
            }

            tblCurso.setModel(aModel);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Operacao falhou (exception)", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_exibir_cursoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new TelaPrincipal().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrarActionPerformed
        try 
        {        
            if(con.isClosed())
            {
                JOptionPane.showMessageDialog(null, "Nao ha conexao com o banco de dados", "Aviso", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if(descricaoCurso.getText().length() == 0 || ementaCurso.getText().length() == 0)
            {                
                JOptionPane.showMessageDialog(null, "Ha campos vazios!", "Aviso", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            PreparedStatement ps = con.prepareStatement("INSERT INTO CURSO (DESCRICAO, EMENTA) VALUES(?,?)");
            ps.setString(1, descricaoCurso.getText());
            ps.setString(2, ementaCurso.getText());
            int result = ps.executeUpdate();
            if(result > 0){
                JOptionPane.showMessageDialog(null, "Operacao concluida", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Operacao falhou", "Aviso", JOptionPane.ERROR_MESSAGE);
            }            
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Operacao falhou (sql)", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Operacao falhou (exception)", "Aviso", JOptionPane.ERROR_MESSAGE);
        }

        descricaoCurso.setText("");
        ementaCurso.setText("");
        descricaoCurso.requestFocus();                                    
    }//GEN-LAST:event_btn_cadastrarActionPerformed

    private void btn_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirActionPerformed
        try {
            if(con.isClosed())
            {
                JOptionPane.showMessageDialog(null, "Nao ha conexao com o banco de dados", "Aviso", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            DefaultTableModel model = (DefaultTableModel) tblCurso.getModel();        
            PreparedStatement ps = con.prepareStatement("DELETE FROM curso WHERE codigo=?");
            int SelecionaLinha = tblCurso.getSelectedRow();  
            if(SelecionaLinha < 0){
                JOptionPane.showMessageDialog(null, "Necessario selecionar um item na lista", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            ps.setInt(1, (int) tblCurso.getValueAt(SelecionaLinha, 0));
            int resultado = ps.executeUpdate();
            if(resultado > 0){
                JOptionPane.showMessageDialog(null, "Operacao concluida com sucesso", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Operacao falhou", "Aviso", JOptionPane.ERROR_MESSAGE);
            }
            model.setRowCount(0);
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Operacao falhou (sql)", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Operacao falhou (exception)", "Aviso", JOptionPane.ERROR_MESSAGE);
        }       
        
    }//GEN-LAST:event_btn_excluirActionPerformed

    private void descricaoCursoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descricaoCursoKeyPressed
        
        
    }//GEN-LAST:event_descricaoCursoKeyPressed

    private void ementaCursoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ementaCursoKeyPressed
        
    }//GEN-LAST:event_ementaCursoKeyPressed

    private void btn_cadastrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_cadastrarKeyPressed
      
    }//GEN-LAST:event_btn_cadastrarKeyPressed

    private void exibir_cursoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_exibir_cursoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_exibir_cursoKeyPressed

    private void btn_excluirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_excluirKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_excluirKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            if(con.isClosed())
            {
                JOptionPane.showMessageDialog(null, "Nao ha conexao com o banco de dados", "Aviso", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            DefaultTableModel model = (DefaultTableModel) tblCurso.getModel(); 
            int SelecionaLinha = tblCurso.getSelectedRow(); 
            if(SelecionaLinha < 0){
                JOptionPane.showMessageDialog(null, "Necessario selecionar um item na lista", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            String novaDescricao = JOptionPane.showInputDialog("Editando descricao", tblCurso.getValueAt(SelecionaLinha, 1));
            // Se retornar null significa que janela foi fechada
            if(novaDescricao==null){
                return;
            }
            else if(novaDescricao.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Campo em branco!", "Aviso", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            String novaEmenta = JOptionPane.showInputDialog("Editando ementa", tblCurso.getValueAt(SelecionaLinha, 2));            
            if(novaEmenta==null){
                return;
            }
            else if(novaEmenta.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Campo em branco!", "Aviso", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            PreparedStatement ps = con.prepareStatement("UPDATE curso SET descricao=?, ementa=? WHERE codigo=?");

            ps.setString(1, novaDescricao);
            ps.setString(2, novaEmenta);
            ps.setInt(3, (int) tblCurso.getValueAt(SelecionaLinha, 0));
            int resultado = ps.executeUpdate();
            if(resultado > 0){
                JOptionPane.showMessageDialog(null, "Operacao concluida com sucesso", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Operacao falhou", "Aviso", JOptionPane.ERROR_MESSAGE);
            }
            
            model.setRowCount(0);
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Operacao falhou (sql)", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Operacao falhou (exception)", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCurso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cadastrar;
    private javax.swing.JButton btn_excluir;
    private javax.swing.JTextField descricaoCurso;
    private javax.swing.JTextField ementaCurso;
    private javax.swing.JButton exibir_curso;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCurso;
    // End of variables declaration//GEN-END:variables
}