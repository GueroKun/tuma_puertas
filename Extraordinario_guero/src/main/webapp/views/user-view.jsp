<%--
  Created by IntelliJ IDEA.
  User: Christian
  Date: 29/08/2023
  Time: 09:51 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Usuario</title>
    <jsp:include page="/layouts/head.jsp"/>
</head>
<body>
<nav class="navbar bg-dark border-bottom border-body" data-bs-theme="dark">
    <div class="container-fluid">
        <span class="navbar-brand mb-0 h1">Bienvenido "${user.username}"</span>
        <form action="/api/auth/logout">
            <button class="btn btn-success">Cerrar sesión</button>
        </form>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="col text-center mt-5">
            <h2>USUARIO</h2>
            <p>${user.name} ${user.lastname}</p>
            <div class="card">
                <div class="card-header">
                    <div class="row">
                        <div class="col">Listado de clases disponibles</div>
                        <div class="col text-end">
                            <a href="/temario/view-create_inscribirse" class="btn btn-outline-success btn-sm">
                                INSCRIBIRSE A UNA CLASE
                            </a>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <table class="table table-stripped">
                        <thead>
                        <th>#</th>
                        <th>Nombre de la clase</th>
                        <th>Instructor</th>
                        <th>Estado</th>
                        <th>Acciones</th>
                        </thead>
                        <tbody>
                        <s:forEach var="inscrip" items="${clasess}" varStatus="s">
                            <tr>
                                <td>
                                    <s:out value="${s.count}"/>
                                </td>
                                <td>
                                    <s:out value="${inscrip.name_class}"/>
                                </td>
                                <td>
                                    <s:out value="${inscrip.user.name}"/>
                                </td>
                                <td>
                                    <s:out value="${inscrip.status_class}"/>
                                </td>
                                <td>
                                <div class="col">
                                    <form action="/temario/lisU" method="get">
                                        <input hidden name="id" value="${inscrip.id_clase}">
                                        <button type="submit" class="btn btn-outline-warning btn-sm">
                                            <i data-feather="edit"></i> VER TEMARIOS
                                        </button>
                                    </form>
                                </div>
                                </td>
                            </tr>
                        </s:forEach>


                        <tr>
                            <td colspan="6">
                                Sin registros
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>


<jsp:include page="/layouts/footer.jsp"/>
</body>
</html>
