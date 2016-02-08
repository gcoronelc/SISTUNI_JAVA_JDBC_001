
package uni.sistemas.entity;

public class ProductoTO {
  // atributos
    private String idproducto;
    private String nombre;
    private int idlinea;
    private double preciocompra;
    private double precioventa;
    private int stock;
    // constructor

    public ProductoTO() {
    }

    public ProductoTO(String idproducto, String nombre, int idlinea, double preciocompra, double precioventa, int stock) {
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.idlinea = idlinea;
        this.preciocompra = preciocompra;
        this.precioventa = precioventa;
        this.stock = stock;
    }
    // metodos get y set

    public String getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(String idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdlinea() {
        return idlinea;
    }

    public void setIdlinea(int idlinea) {
        this.idlinea = idlinea;
    }

    public double getPreciocompra() {
        return preciocompra;
    }

    public void setPreciocompra(double preciocompra) {
        this.preciocompra = preciocompra;
    }

    public double getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(double precioventa) {
        this.precioventa = precioventa;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
}
