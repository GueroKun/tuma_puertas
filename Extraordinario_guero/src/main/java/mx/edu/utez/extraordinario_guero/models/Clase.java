package mx.edu.utez.extraordinario_guero.models;

public class Clase {
    private Long id_clase;
    private String status_class;
    private String name_class;
    private String description_class;
    private User user;

    public Clase() {
    }

    public Clase(Long id_clase, String status_class, String name_class, String description_class, User user) {
        this.id_clase = id_clase;
        this.status_class = status_class;
        this.name_class = name_class;
        this.description_class = description_class;
        this.user = user;
    }

    public Long getId_clase() {
        return id_clase;
    }

    public void setId_clase(Long id_clase) {
        this.id_clase = id_clase;
    }

    public String getStatus_class() {
        return status_class;
    }

    public void setStatus_class(String status_class) {
        this.status_class = status_class;
    }

    public String getName_class() {
        return name_class;
    }

    public void setName_class(String name_class) {
        this.name_class = name_class;
    }

    public String getDescription_class() {
        return description_class;
    }

    public void setDescription_class(String description_class) {
        this.description_class = description_class;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
