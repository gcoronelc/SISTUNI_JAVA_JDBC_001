package pe.egcc.masterapp.view;

import javax.swing.JInternalFrame;
import pe.egcc.masterapp.domain.EmpleadoBean;
import pe.egcc.masterapp.util.Memoria;

/**
 *
 * @author Gustavo Coronel
 */
public class FormularioMDI extends javax.swing.JFrame {

  public FormularioMDI() {
    initComponents();
    establecerTitulo();
    this.setExtendedState(MAXIMIZED_BOTH);
  }

  private void establecerTitulo() {
    EmpleadoBean bean = (EmpleadoBean) Memoria.get("usuario");
    String titulo = "Master app";
    titulo += "[Usuario: " + bean.getUsuario() + "]";
    this.setTitle(titulo);
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        menuArchivoSalir = new javax.swing.JMenuItem();
        menuProcesos = new javax.swing.JMenu();
        menuProcesosDeposito = new javax.swing.JMenuItem();
        menuTablas = new javax.swing.JMenu();
        menuTablasCliente = new javax.swing.JMenuItem();
        menuTablasEmpleado = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EUREKA");

        menuArchivo.setMnemonic('f');
        menuArchivo.setText("Archivo");

        menuArchivoSalir.setMnemonic('x');
        menuArchivoSalir.setText("Salir");
        menuArchivoSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuArchivoSalirActionPerformed(evt);
            }
        });
        menuArchivo.add(menuArchivoSalir);

        menuBar.add(menuArchivo);

        menuProcesos.setText("Procesos");

        menuProcesosDeposito.setText("Registrar depósito");
        menuProcesosDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuProcesosDepositoActionPerformed(evt);
            }
        });
        menuProcesos.add(menuProcesosDeposito);

        menuBar.add(menuProcesos);

        menuTablas.setText("Tablas");

        menuTablasCliente.setText("Clientes");
        menuTablasCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTablasClienteActionPerformed(evt);
            }
        });
        menuTablas.add(menuTablasCliente);

        menuTablasEmpleado.setText("Empleados");
        menuTablasEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTablasEmpleadoActionPerformed(evt);
            }
        });
        menuTablas.add(menuTablasEmpleado);

        menuBar.add(menuTablas);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuArchivoSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuArchivoSalirActionPerformed
      System.exit(0);
    }//GEN-LAST:event_menuArchivoSalirActionPerformed

  private void menuProcesosDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuProcesosDepositoActionPerformed
    cargarFormulario(DepositoView.class);
  }//GEN-LAST:event_menuProcesosDepositoActionPerformed

  private void menuTablasClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTablasClienteActionPerformed
    cargarFormulario(MantClientesView.class);
  }//GEN-LAST:event_menuTablasClienteActionPerformed

    private void menuTablasEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTablasEmpleadoActionPerformed
       cargarFormulario(MantEmpleadoView.class);
    }//GEN-LAST:event_menuTablasEmpleadoActionPerformed

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
      java.util.logging.Logger.getLogger(FormularioMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(FormularioMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(FormularioMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(FormularioMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new FormularioMDI().setVisible(true);
      }
    });
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenuItem menuArchivoSalir;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuProcesos;
    private javax.swing.JMenuItem menuProcesosDeposito;
    private javax.swing.JMenu menuTablas;
    private javax.swing.JMenuItem menuTablasCliente;
    private javax.swing.JMenuItem menuTablasEmpleado;
    // End of variables declaration//GEN-END:variables

  private void cargarFormulario(Class<?> aClass) {
    try {
      // Variable
      JInternalFrame view = null;
      // Verificar si ya existe
      for (JInternalFrame bean : desktopPane.getAllFrames()) {
        if (aClass.isInstance(bean)) {
          view = bean;
          break;
        }
      }
      // Si NO lo encuentra lo creamos
      if (view == null) {
        view = (JInternalFrame) Class.forName(aClass.getName()).newInstance();
        desktopPane.add(view);
      }
      // Se debe activar el formulario
      view.setVisible(true);
      view.setSelected(true);
    } catch (Exception e) {
    }
  }
}
