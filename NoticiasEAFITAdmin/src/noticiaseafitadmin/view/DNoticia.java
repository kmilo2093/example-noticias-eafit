package noticiaseafitadmin.view;

import java.util.logging.Level;
import java.util.logging.Logger;
import lib.helpers.SwingHelper;
import noticiaseafitadmin.ctrl.NewsCtrl;
import noticiaseafitadmin.model.News;

public class DNoticia extends javax.swing.JDialog {

    private News news;

    public DNoticia(java.awt.Frame parent) {
        this(parent, null);
    }

    public DNoticia(java.awt.Frame parent, News news) {
        super(parent, true);
        setLocationRelativeTo(parent);
        this.news = news;
        initComponents();
        setData();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lTitulo = new javax.swing.JLabel();
        tTitle = new javax.swing.JTextField();
        lResumen = new javax.swing.JLabel();
        tBrief = new javax.swing.JTextField();
        lContenido = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tContent = new javax.swing.JTextArea();
        lFecha = new javax.swing.JLabel();
        tDate = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        bGuardar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Noticia Detalle");

        lTitulo.setText("Titulo:");

        lResumen.setText("Resumen:");

        lContenido.setText("Contenido:");

        tContent.setColumns(20);
        tContent.setLineWrap(true);
        tContent.setRows(5);
        jScrollPane1.setViewportView(tContent);

        lFecha.setText("Fecha:");

        tDate.setEditable(false);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        bGuardar.setText("Guardar");
        bGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(bGuardar);

        bCancelar.setText("Salir");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(bCancelar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lTitulo)
                            .addComponent(lResumen))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tBrief)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tTitle)
                                .addGap(18, 18, 18)
                                .addComponent(lFecha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tDate, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lContenido)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lTitulo)
                    .addComponent(tTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lFecha)
                    .addComponent(tDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lResumen)
                    .addComponent(tBrief, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lContenido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
        try {
            NewsCtrl.getInstance().create(getNews());
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(DNoticia.class.getName()).log(Level.SEVERE, null, ex);
            SwingHelper.errorMessage(this, ex.getMessage());
        }
    }//GEN-LAST:event_bGuardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bGuardar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lContenido;
    private javax.swing.JLabel lFecha;
    private javax.swing.JLabel lResumen;
    private javax.swing.JLabel lTitulo;
    private javax.swing.JTextField tBrief;
    private javax.swing.JTextArea tContent;
    private javax.swing.JTextField tDate;
    private javax.swing.JTextField tTitle;
    // End of variables declaration//GEN-END:variables

    private void setData() {
        if (news != null) {
            tTitle.setText(news.getTitle());
            tDate.setText(news.getDate());
            tBrief.setText(news.getBrief());
            tContent.setText(news.getContent());
            tTitle.setEditable(false);
            tDate.setEditable(false);
            tBrief.setEditable(false);
            tContent.setEditable(false);
            bGuardar.setEnabled(false);
        }
    }

    private News getNews() {
        return new News(
                0,
                tTitle.getText(),
                tBrief.getText(),
                tContent.getText(),
                tDate.getText());
    }
}
