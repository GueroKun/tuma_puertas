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
import java.util.List;

@WebServlet(name = "ServletInstrucotr",
        urlPatterns = {
                "/instructor/view-create",
                "/instructor/save",
                "/instructor/instructor",
                "/instructor/view-create_tema"

        })
public class ServletInstructor extends HttpServlet {
    private String action, redirect = "/instructor/instructor";

    private String  username, password;

    private String name, lastname, curp, birthday;

    private Role role;

    private User user;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        action = req.getServletPath();
        switch (action) {
            case "/instructor/instructor":
                req.setAttribute("users", new DaoInstructor().findAll());
                redirect = "/views/admin-view.jsp";
                break;

            case "/instructor/view-create":
                redirect = "/views/view-create.jsp";
                break;

            case  "/instructor/view-create_tema":
                req.setAttribute("clasesita", new DaoClase().findAllClass());
                redirect = "/views/view-create_tema.jsp";
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
            case "/instructor/save":
                name = req.getParameter("name");
                lastname = req.getParameter("lastname");
                curp = req.getParameter("curp");
                birthday = req.getParameter("birthday");
                username = req.getParameter("username");
                password = req.getParameter("password");
                user = new User(0L, name, lastname, curp, birthday, username, password, "ACTIVO", role);
                boolean result =new DaoInstructor().save(user);
                if (result)
                    redirect = "/instructor/instructor?result= " + true + "&message=" + URLEncoder.encode(" Instructor registrado correctameente.", StandardCharsets.UTF_8);
                else
                    redirect = "/instructor/instructor?result= " + false + "&message=" + URLEncoder.encode("¡Error! Acción no realizada correctamente.", StandardCharsets.UTF_8);
                break;



        }
        resp.sendRedirect(req.getContextPath()
                + redirect);
    }
    }
