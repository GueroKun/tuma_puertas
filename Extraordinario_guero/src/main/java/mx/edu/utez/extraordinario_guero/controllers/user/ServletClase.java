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

@WebServlet(name = "ServletClase",
        urlPatterns = {
                "/clase/save",
                "/clases/clase",
                "/clase/view-create"
        })
public class ServletClase extends HttpServlet {
    private String action, redirect = "/clases/clase";
    private HttpSession session;

    private String name_class, description_class, insId;

    private User user;
    private Clase clase;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        action = req.getServletPath();
        switch (action) {
            case "/clases/clase":
                req.setAttribute("users", new DaoInstructor().findAll());
                req.setAttribute("clasess", new DaoClase().findAll());
                redirect = "/views/admin-view.jsp";
                break;

            case "/clase/view-create":
                req.setAttribute("instructors", new DaoUser().findAllInstructors());
                redirect = "/views/view-create_class.jsp";
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
            case "/clase/save":
                name_class = req.getParameter("name_class");
                description_class = req.getParameter("description_class");
                insId = req.getParameter("ins");
                user = new User();
                user.setId_user(insId != null ? Long.parseLong(insId) : 0L);
                clase = new Clase(0L, "ACTIVO", name_class, description_class, user);
                boolean result = new DaoClase().save(clase);
                if (result)
                    redirect = "/clases/clase?result= " + true + "&message=" + URLEncoder.encode("Clase registrada.", StandardCharsets.UTF_8);
                else
                    redirect = "/clases/clase?result= " + false + "&message=" + URLEncoder.encode("¡Error! Acción no realizada correctamente.", StandardCharsets.UTF_8);
                break;
        }
        resp.sendRedirect(req.getContextPath()
                + redirect);
    }
}
