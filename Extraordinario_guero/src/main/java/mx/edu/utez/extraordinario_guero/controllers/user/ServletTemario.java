package mx.edu.utez.extraordinario_guero.controllers.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.edu.utez.extraordinario_guero.models.*;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


@WebServlet(name = "ServletTemario",
        urlPatterns = {
                "/temarios/save",
                "/temarios/temario",
                "/temario/lisU",
                "/temario/lisI",
                "/temario/view-create_inscribirse"
        })
public class ServletTemario extends HttpServlet {
    private String action, redirect =  "/temarios/temario";
    private String description_temario, temaID, id_lis;
    private Clase clase;
    private Temario temario;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        action = req.getServletPath();
        switch (action) {
            case  "/temarios/temario":
                req.setAttribute("clasess", new DaoClase().findAll());
                redirect = "/views/instructor-view.jsp";
                break;

            case "/temario/lisU":
                id_lis = req.getParameter("id");
                req.setAttribute("list", new DaoTemario().findAllTemarios(Long.parseLong(id_lis)));
                redirect = "/views/lis-temarios-user.jsp";
                break;

            case "/temario/lisI":
                id_lis = req.getParameter("id");
                req.setAttribute("list", new DaoTemario().findAllTemarios(Long.parseLong(id_lis)));
                redirect = "/views/lis-temarios-instructor.jsp";
                break;

            case "/temario/view-create_inscribirse":
                req.setAttribute("asigna", new DaoClase().findAllClass());
                req.setAttribute("tems", new DaoTemario().findAllTemas());
                redirect = "/views/inscribirse.jsp";
                break;
        }
        req.getRequestDispatcher(redirect).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        action = req.getServletPath();
        switch (action) {
            case "/temarios/save":
                description_temario = req.getParameter("description_temario");
                temaID = req.getParameter("asignatura");
                clase = new Clase();
                clase.setId_clase(temaID != null ? Long.parseLong(temaID) : 0L);
                temario = new Temario(0L, description_temario, clase);
                boolean result = new DaoTemario().save(temario);
                if (result)
                    redirect = "/temarios/temario?result= " + true + "&message=" + URLEncoder.encode("Temario registrado correctamente.", StandardCharsets.UTF_8);
                else
                    redirect = "/temarios/temario?result= " + false + "&message=" + URLEncoder.encode("¡Error! Acción no realizada correctamente.", StandardCharsets.UTF_8);
                break;
        }
        resp.sendRedirect(req.getContextPath()
                + redirect);
    }
    }
