package noticiaseafitadmin.view;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import lib.helpers.SwingHelper;
import noticiaseafitadmin.ctrl.NewsCtrl;
import noticiaseafitadmin.model.News;

/**
 *
 * @author Rodrigo
 */
public class FNoticiasEAFIT extends javax.swing.JFrame {

    private DefaultListModel<News> model;
    private NewsCtrl ctrl;

    /**
     * Creates new form FNoticiasEAFIT
     */
    public FNoticiasEAFIT() {
        ctrl = NewsCtrl.getInstance();
        model = new DefaultListModel<>();
        initComponents();
        setLocationByPlatform(true);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listNews = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        bOpenNews = new javax.swing.JButton();
        bCreateNews = new javax.swing.JButton();
        bSearchNews = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Noticias EAFIT 1.0a");

        lTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTitle.setText("Administrador de Noticias EAFIT");

        listNews.setModel(model);
        listNews.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listNews.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listNewsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listNews);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        bOpenNews.setText("Abrir Noticia");
        bOpenNews.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOpenNewsActionPerformed(evt);
            }
        });
        jPanel1.add(bOpenNews);

        bCreateNews.setText("Crear Noticia");
        bCreateNews.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCreateNewsActionPerformed(evt);
            }
        });
        jPanel1.add(bCreateNews);

        bSearchNews.setText("Listar Noticias");
        bSearchNews.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSearchNewsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
                    .addComponent(bSearchNews, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bSearchNews)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bSearchNewsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSearchNewsActionPerformed
        try {
            News[] news = ctrl.getNews();
            model.removeAllElements();
            for (News n : news) {
                model.addElement(n);
            }
        } catch (Exception ex) {
            Logger.getLogger(FNoticiasEAFIT.class.getName()).log(Level.SEVERE, null, ex);
            SwingHelper.errorMessage(this, ex.getMessage());
        }
    }//GEN-LAST:event_bSearchNewsActionPerformed

    private void bOpenNewsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOpenNewsActionPerformed
        if (listNews.getSelectedIndex() >= 0){
            News n = (News)listNews.getSelectedValue();
            DNoticia noticia = new DNoticia(this, n);
            noticia.setVisible(true);
        }else{
            SwingHelper.errorMessage(this, "Seleccione una noticia en la lista");
        }
    }//GEN-LAST:event_bOpenNewsActionPerformed

    private void bCreateNewsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCreateNewsActionPerformed
        DNoticia noticia = new DNoticia(this);
        noticia.setVisible(true);
    }//GEN-LAST:event_bCreateNewsActionPerformed

    private void listNewsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listNewsMouseClicked
        if (evt.getClickCount() == 2){
            bOpenNews.doClick();
        }
    }//GEN-LAST:event_listNewsMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCreateNews;
    private javax.swing.JButton bOpenNews;
    private javax.swing.JButton bSearchNews;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lTitle;
    private javax.swing.JList listNews;
    // End of variables declaration//GEN-END:variables
}