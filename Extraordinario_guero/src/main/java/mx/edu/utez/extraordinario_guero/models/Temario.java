package mx.edu.utez.extraordinario_guero.models;

public class Temario {
    private Long id_temario;
    private String description_temario;
    private Clase clase;

    public Temario() {
    }

    public Temario(Long id_temario, String description_temario, Clase clase) {
        this.id_temario = id_temario;
        this.description_temario = description_temario;
        this.clase = clase;
    }

    public Long getId_temario() {
        return id_temario;
    }

    public void setId_temario(Long id_temario) {
        this.id_temario = id_temario;
    }

    public String getDescription_temario() {
        return description_temario;
    }

    public void setDescription_temario(String description_temario) {
        this.description_temario = description_temario;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }
}
