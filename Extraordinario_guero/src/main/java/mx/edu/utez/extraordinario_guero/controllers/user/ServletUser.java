package mx.edu.utez.extraordinario_guero.controllers.user;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mx.edu.utez.extraordinario_guero.models.*;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


@WebServlet(name = "ServletUser",
        urlPatterns = {
                "/api/auth",
                "/api/auth/login",
                "/api/auth/logout",
                "/api/user/admin",
                "/api/user/user",
                "/api/user/instructor",
                "/user/registre",
                "/user/user-save",

        })
public class ServletUser extends HttpServlet {
    private String action, redirect = "/users/user";
   private HttpSession session;
    private String username, password, roleId;

    private String name, lastname, curp, birthday;
    private String claId, temId;
    private Role role;
    private User user;

    private Clase clase;
    private Temario temario;
    private Inscripcion inscripcion;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        action = req.getServletPath();
        switch (action) {

            case "/api/auth/login":
                redirect = "/index.jsp";
                break;
            case "/api/auth/logout":
                session = req.getSession();
                session.invalidate();
                redirect = "/index.jsp";
                break;
            case "/api/user/admin":
                req.setAttribute("users", new DaoInstructor().findAll());
                req.setAttribute("clasess", new DaoClase().findAll());
                redirect = "/views/admin-view.jsp";
                break;
            case "/api/user/user":
                req.setAttribute("clasess", new DaoClase().findAll());
                redirect = "/views/user-view.jsp";
                break;
            case "/api/user/instructor":
                req.setAttribute("clasess", new DaoClase().findAll());
                req.setAttribute("temarios", new DaoTemario().findAllTemas());
                redirect = "/views/instructor-view.jsp";
                break;
            case "/user/registre":
                redirect = "/views/view-registre.jsp";
                break;
        }
        req.getRequestDispatcher(redirect)
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        action = req.getServletPath();
        switch (action) {
            case "/api/auth":
                username = req.getParameter("username");
                password = req.getParameter("password");
                try {
                    User user = new DaoUser().loadUserByUsernameAndPassword(username, password);
                    if (user != null) {
                        session = req.getSession();
                        session.setAttribute("user", user);
                        switch (user.getRole().getRole()) {
                            case "ADMIN_ROLE":
                                redirect = "/api/user/admin";
                                break;
                            case "USER_ROLE":
                                redirect = "/api/user/user";
                                break;
                            case "INSTRUCTOR_ROLE":
                                redirect = "/api/user/instructor";
                                break;
                        }
                    } else {
                        throw new Exception("Credentials mismatch");
                    }
                } catch (Exception e) {
                    redirect = "/api/user/login?result=false&message=" + URLEncoder
                            .encode("Usuario y/o contraseña incorrecta",
                                    StandardCharsets.UTF_8);
                }
                break;

            case "/user/user-save":
                name = req.getParameter("name");
                lastname = req.getParameter("lastname");
                curp = req.getParameter("curp");
                birthday = req.getParameter("birthday");
                username = req.getParameter("username");
                password = req.getParameter("password");
                user = new User(0L, name, lastname, curp, birthday, username, password, "ACTIVO", role);
                boolean result =new DaoUser().save(user);
                if (result)
                    redirect = "/api/auth/login?result= " + true + "&message=" + URLEncoder.encode("Usuario registrado.", StandardCharsets.UTF_8);
                else
                    redirect = "/api/auth/login?result= " + false + "&message=" + URLEncoder.encode("¡Error! Acción no realizada correctamente.", StandardCharsets.UTF_8);
                break;

            case "/user/inscricion-save":
                claId = req.getParameter("asig");
                temId = req.getParameter("tem");
                clase = new Clase();
                clase.setId_clase(claId != null ? Long.parseLong(claId) : 0L);
                temario = new Temario();
                temario.setId_temario(temId != null ? Long.parseLong(temId) : 0L);
                user = new User();
                inscripcion = new Inscripcion(0L, user, clase, temario);
                boolean result2 = new DaoUser().saveIncripcion(user);
                if (result2)
                    redirect = "/clases/clase?result= " + true + "&message=" + URLEncoder.encode("Clase registrada.", StandardCharsets.UTF_8);
                else
                    redirect = "/clases/clase?result= " + false + "&message=" + URLEncoder.encode("¡Error! Acción no realizada correctamente.", StandardCharsets.UTF_8);
                break;

        }
        resp.sendRedirect(req.getContextPath()
                + redirect);
    }
}
