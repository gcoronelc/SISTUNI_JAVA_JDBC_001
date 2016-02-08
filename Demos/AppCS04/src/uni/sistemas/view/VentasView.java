package uni.sistemas.view;

import java.awt.Frame;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import uni.sistemas.controller.ClienteBLL;
import uni.sistemas.controller.EmpleadoBLL;
import uni.sistemas.controller.ProductoBLL;
import uni.sistemas.controller.VentaBLL;
import uni.sistemas.database.AccesoDB;
import uni.sistemas.entity.ClienteTO;
import uni.sistemas.entity.DetalleTO;
import uni.sistemas.entity.EmpleadoTO;
import uni.sistemas.entity.ProductoTO;
import uni.sistemas.entity.VentaTO;

public class VentasView extends javax.swing.JInternalFrame {

    // variables
    VentaBLL oventa = new VentaBLL();
    ClienteBLL ocli = new ClienteBLL();
    ProductoBLL opro = new ProductoBLL();
    EmpleadoBLL oemp = new EmpleadoBLL();
    List<DetalleTO> lista = new ArrayList<>();

    String[] Documento = {"Factura", "Boleta", "Guia"};

    public VentasView() throws Exception {
        initComponents();
        cargaListas();
        fecha();
        this.setTitle("REGISTRAR VENTAS   Usuario : " + LoginView.usu);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbocliente = new javax.swing.JComboBox();
        cbotipodoc = new javax.swing.JComboBox();
        txtnrodoc = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        txtnro = new javax.swing.JTextField();
        lblfecha = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cboEmpleado = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cboproducto = new javax.swing.JComboBox();
        txtcodigo = new javax.swing.JTextField();
        txtprecio = new javax.swing.JTextField();
        txtcantidad = new javax.swing.JTextField();
        txtmonto = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbdetalle = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtsubtotal = new javax.swing.JTextField();
        txtigv = new javax.swing.JTextField();
        txttotal = new javax.swing.JTextField();
        btnagregardetalle = new javax.swing.JButton();
        btnquitardetalle = new javax.swing.JButton();
        btnregistraventa = new javax.swing.JButton();
        btnimprimir = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setTitle("R E G I S T R A R   V E N T A S");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de Venta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        jLabel1.setText("Cliente");

        jLabel2.setText("Tipo Doc.");

        jLabel3.setText("Nro. Doc");

        jLabel4.setText("Empleado");

        txtnrodoc.setText("01-0001");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Numero"));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtnro, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtnro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblfecha.setText("dd/mm/yyyy");

        jLabel13.setText("Fecha");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbocliente, 0, 202, Short.MAX_VALUE)
                    .addComponent(lblfecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboEmpleado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtnrodoc)
                    .addComponent(cbotipodoc, 0, 74, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(cbocliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbotipodoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(txtnrodoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblfecha)
                            .addComponent(jLabel13)))))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de producto"));

        jLabel5.setText("Producto");

        jLabel6.setText("Precio");

        jLabel7.setText("Cantidad");

        jLabel8.setText("Codigo");

        jLabel9.setText("Monto");

        cboproducto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboproductoItemStateChanged(evt);
            }
        });

        txtprecio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtcantidad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcantidadKeyReleased(evt);
            }
        });

        txtmonto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboproducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txtmonto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Detalle"));

        tbdetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre de Producto", "Precio", "Cantidad", "Importe"
            }
        ));
        jScrollPane1.setViewportView(tbdetalle);
        if (tbdetalle.getColumnModel().getColumnCount() > 0) {
            tbdetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbdetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbdetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
            tbdetalle.getColumnModel().getColumn(3).setPreferredWidth(60);
            tbdetalle.getColumnModel().getColumn(4).setPreferredWidth(60);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel10.setText("SubTotal");

        jLabel11.setText("Igv");

        jLabel12.setText("Total");

        txtsubtotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtigv.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txttotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        btnagregardetalle.setText("Agregar Detalle");
        btnagregardetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregardetalleActionPerformed(evt);
            }
        });

        btnquitardetalle.setText("Quitar Detalle");
        btnquitardetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnquitardetalleActionPerformed(evt);
            }
        });

        btnregistraventa.setText("Registrar Venta");
        btnregistraventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistraventaActionPerformed(evt);
            }
        });

        btnimprimir.setText("Imprimir");
        btnimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimprimirActionPerformed(evt);
            }
        });

        jButton5.setText("Cerrar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtigv, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addGap(2, 2, 2)
                        .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnagregardetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnquitardetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnregistraventa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnimprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtigv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnagregardetalle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnquitardetalle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnregistraventa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnimprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // cerrar
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void cboproductoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboproductoItemStateChanged
        try {
            mostrarProducto();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cboproductoItemStateChanged

    private void txtcantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyReleased
        try {
            calcularMonto();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtcantidadKeyReleased

    private void btnagregardetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregardetalleActionPerformed
        agregarDetalle();
    }//GEN-LAST:event_btnagregardetalleActionPerformed

    private void btnquitardetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnquitardetalleActionPerformed
        quitarDetalle();
    }//GEN-LAST:event_btnquitardetalleActionPerformed

    private void btnregistraventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistraventaActionPerformed
        grabarVenta();
    }//GEN-LAST:event_btnregistraventaActionPerformed

    private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed
        vistaPrevia();
    }//GEN-LAST:event_btnimprimirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregardetalle;
    private javax.swing.JButton btnimprimir;
    private javax.swing.JButton btnquitardetalle;
    private javax.swing.JButton btnregistraventa;
    private javax.swing.JComboBox cboEmpleado;
    private javax.swing.JComboBox cbocliente;
    private javax.swing.JComboBox cboproducto;
    private javax.swing.JComboBox cbotipodoc;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblfecha;
    private javax.swing.JTable tbdetalle;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtigv;
    private javax.swing.JTextField txtmonto;
    private javax.swing.JTextField txtnro;
    private javax.swing.JTextField txtnrodoc;
    private javax.swing.JTextField txtprecio;
    private javax.swing.JTextField txtsubtotal;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
    // variables
    int stk;

    private void cargaListas() throws Exception {
        cbocliente.removeAllItems();
        for (ClienteTO x : ocli.ClienteListar()) {
            cbocliente.addItem(x);
        }

        cboEmpleado.removeAllItems();
        for (EmpleadoTO x : oemp.EmpleadoListar()) {
            cboEmpleado.addItem(x);
        }

        cboproducto.removeAllItems();
        for (ProductoTO x : opro.ProductoListar()) {
            cboproducto.addItem(x);
        }

        for (String x : Documento) {
            cbotipodoc.addItem(x);
        }

    }

    private void fecha() {
        Date hoy = new Date();
        lblfecha.setText(hoy + "");
    }

    private void mostrarProducto() {
        ProductoTO p;
        String cod = cboproducto.getSelectedItem().toString().substring(0, 5);
        try {
            p = opro.ProductoBuscar(cod);
            stk = p.getStock();
            txtcodigo.setText(p.getIdproducto());
            txtprecio.setText(p.getPrecioventa() + "");
            txtcantidad.setText("1");
            txtcantidad.setSelectionStart(0);
            txtcantidad.grabFocus();
            calcularMonto();
        } catch (Exception e) {
        }

    }

    private void calcularMonto() {
        if (!"".equals(txtcantidad.getText())) {
            int cant = Integer.parseInt(txtcantidad.getText());
            if (cant < stk) {
                double pre = Double.parseDouble(txtprecio.getText());
                double monto = pre * cant;
                txtmonto.setText(monto + "");
            } else {
                JOptionPane.showMessageDialog(this, "Solo quedan:" + stk + " unidades en stock");
                txtcantidad.setSelectionStart(0);
                txtcantidad.grabFocus();
            }
        } else {
            txtmonto.setText("");
        }
    }

    private void agregarDetalle() {
        DetalleTO det = new DetalleTO();
        det.setIdproducto(txtcodigo.getText());
        det.setNombre(cboproducto.getSelectedItem().toString().substring(6));
        det.setPrecio(Double.parseDouble(txtprecio.getText()));
        det.setCantidad(Integer.parseInt(txtcantidad.getText()));
        det.setTotal(Double.parseDouble(txtmonto.getText()));
        adicionarDetalle(det);
        listarDetalle(lista);
        TotalVenta();
        NuevoDetalle();
    }

    private void adicionarDetalle(DetalleTO det) {
        lista.add(det);
    }

    private void listarDetalle(List<DetalleTO> lista) {
        DefaultTableModel model = (DefaultTableModel) tbdetalle.getModel();
        model.setRowCount(0);
        for (DetalleTO d : lista) {
            Object[] rowdata = {d.getIdproducto(),
                d.getNombre(),
                d.getPrecio(),
                d.getCantidad(),
                d.getTotal()};
            model.addRow(rowdata);
        }
        tbdetalle.setRowSelectionInterval(0, 0);
    }

    private void TotalVenta() {
        double subtot = 0;
        for (DetalleTO d : lista) {
            subtot += d.getTotal();
        }
        txtsubtotal.setText(subtot + "");
        txtigv.setText(subtot * 0.18 + "");
        txttotal.setText(subtot + subtot * 0.18 + "");
    }

    private void NuevoDetalle() {
        txtmonto.setText("");
        txtcantidad.setText("");
        txtprecio.setText("");
        txtcodigo.setText("");
    }

    private void quitarDetalle() {
        // eliminar fila de la tabla     
        int fila = tbdetalle.getSelectedRow();
        if (fila > -1) {
            lista.remove(fila);
            listarDetalle(lista);
            TotalVenta();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Detalle no tiene item");
        }
    }

    private void grabarVenta() {
        try {
            VentaTO ve = new VentaTO();
            //asignar valores al objeto ve
            ve.setIdcliente(cbocliente.getSelectedItem().toString().substring(0, 5));
            ve.setIdempleado(cboEmpleado.getSelectedItem().toString().substring(0, 5));
            ve.setTipodoc(cbotipodoc.getSelectedItem().toString());
            ve.setNrodoc(txtnrodoc.getText());
            ve.setTotal(Double.parseDouble(txttotal.getText()));
            ve.setDetalle(lista);
            int idfact = oventa.RegistrarVenta(ve);
            txtnro.setText("000" + idfact + "");
            JOptionPane.showMessageDialog(rootPane, "Venta registrada con exito \n Gracias por su compra");
            vistaPrevia();
            nuevaVenta();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }

    private void nuevaVenta() {
        txtnro.setText("");
        txtsubtotal.setText("");
        txtigv.setText("");
        txttotal.setText("");
        lista.clear();
        DefaultTableModel model = (DefaultTableModel) tbdetalle.getModel();
        model.setRowCount(0);
    }

    private void vistaPrevia() {
        Connection cn;
        try {
            cn = AccesoDB.getConnection();
            String ruta = System.getProperty("user.dir") + "/src/uni/sistemas/reportes/facturaventa.jasper";
            Map parametro = new HashMap();
            parametro.put("IDFACT", Integer.parseInt(txtnro.getText()));
            JasperPrint print = JasperFillManager.fillReport(ruta, parametro, cn);
            JasperViewer view = new JasperViewer(print, false);
            view.setTitle("VENTAS");
            view.setExtendedState(Frame.MAXIMIZED_BOTH);
            view.setVisible(true);
        } catch (SQLException | ClassNotFoundException | NumberFormatException | JRException e) {
            JOptionPane.showMessageDialog(null, "No se pudo", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

}
