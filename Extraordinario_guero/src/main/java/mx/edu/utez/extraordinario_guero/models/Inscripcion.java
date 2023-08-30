package mx.edu.utez.extraordinario_guero.models;

public class Inscripcion {
    private Long id_inscripcion;
    private User user;
    private Clase clase;
    private Temario temario;

    public Inscripcion() {
    }

    public Inscripcion(Long id_inscripcion, User user, Clase clase, Temario temario) {
        this.id_inscripcion = id_inscripcion;
        this.user = user;
        this.clase = clase;
        this.temario = temario;
    }

    public Long getId_inscripcion() {
        return id_inscripcion;
    }

    public void setId_inscripcion(Long id_inscripcion) {
        this.id_inscripcion = id_inscripcion;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public Temario getTemario() {
        return temario;
    }

    public void setTemario(Temario temario) {
        this.temario = temario;
    }
}
