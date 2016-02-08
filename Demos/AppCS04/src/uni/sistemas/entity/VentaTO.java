
package uni.sistemas.entity;

import java.util.List;


public class VentaTO {
   //atributos
    private int idventa;
    private String idcliente;
    private String idempleado;
    private String tipodoc;
    private String nrodoc;
    private double total;
    private List<DetalleTO> detalle;
    //constructor

    public VentaTO() {
    }

    public VentaTO(int idventa, String idcliente, String idempleado, String tipodoc, String nrodoc, double total, List<DetalleTO> detalle) {
        this.idventa = idventa;
        this.idcliente = idcliente;
        this.idempleado = idempleado;
        this.tipodoc = tipodoc;
        this.nrodoc = nrodoc;
        this.total = total;
        this.detalle = detalle;
    }
    // metodos get y set

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public String getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(String idcliente) {
        this.idcliente = idcliente;
    }

    public String getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(String idempleado) {
        this.idempleado = idempleado;
    }

    public String getTipodoc() {
        return tipodoc;
    }

    public void setTipodoc(String tipodoc) {
        this.tipodoc = tipodoc;
    }

    public String getNrodoc() {
        return nrodoc;
    }

    public void setNrodoc(String nrodoc) {
        this.nrodoc = nrodoc;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<DetalleTO> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<DetalleTO> detalle) {
        this.detalle = detalle;
    }
    
    
}
