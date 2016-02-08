
package uni.sistemas.entity;

public class EmpleadoTO {
  // atributos
    private String idempleado;
    private String nombre;
    private String apellido;
    private String email;
    private String usuario;
    private String password;
    // constructor

    public EmpleadoTO() {
    }

    public EmpleadoTO(String idempleado, String nombre, String apellido, String email, String usuario, String password) {
        this.idempleado = idempleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.usuario = usuario;
        this.password = password;
    }
    // metodos get y set

    public String getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(String idempleado) {
        this.idempleado = idempleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return idempleado + " " + nombre + " " + apellido;
    }
    
    
    
}
