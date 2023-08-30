package mx.edu.utez.extraordinario_guero.models;

public class User {
    private Long id_user;

    private String name;
    private String lastname;
    private String curp;
    private String birthday;
    private String username;
    private String password;
    private String status;
    private Role role;

    public User() {
    }

    public User(Long id_user, String name, String lastname, String curp, String birthday, String username, String password, String status, Role role) {
        this.id_user = id_user;
        this.name = name;
        this.lastname = lastname;
        this.curp = curp;
        this.birthday = birthday;
        this.username = username;
        this.password = password;
        this.status = status;
        this.role = role;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
