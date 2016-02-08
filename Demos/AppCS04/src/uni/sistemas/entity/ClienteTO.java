
package uni.sistemas.entity;

public class ClienteTO {
  //atributos
    private String idcliente;
    private String nombre;
    private String direccion;
    private String ruc;
    private String telefono;
    //constructor

    public ClienteTO() {
    }

    public ClienteTO(String idcliente, String nombre, String direccion, String ruc, String telefono) {
        this.idcliente = idcliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ruc = ruc;
        this.telefono = telefono;
    }
    // metodos get y set

    public String getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(String idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    //metodo toString

    @Override
    public String toString() {
        return idcliente + " " + nombre;
    }
    
            
}
