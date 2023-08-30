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
    <title>Instructor</title>
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
        <div class="col">
            <h2 class="mt-3 mb-5">INSTRUCTOR</h2>
            <div class="card">
                <div class="card-header">
                    <div class="row">
                        <div class="col">Listado de clases asignadas</div>
                        <div class="col text-end">
                            <a href="/instructor/view-create_tema" class="btn btn-outline-warning btn-sm">
                                AGREGAR TEMARIO
                            </a>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <table class="table table-striped table-hover datatable" id="datatable">
                        <thead class="table-dark">
                        <th>#</th>
                        <th>Nombre</th>
                        <th>Descripcion</th>
                        <th>Estado</th>
                        <th>Accion</th>
                        </thead>
                        <tbody>
                        <s:forEach items="${clasess}" varStatus="s" var="cla">
                            <tr>
                                <td><s:out value="${s.count}"/></td>
                                <td><s:out value="${cla.name_class}"/></td>
                                <td><s:out value="${cla.description_class}"/></td>
                                <td><s:out value="${cla.status_class}"/></td>
                                <td>
                                    <div class="col">
                                        <form action="/temario/lisI" method="get">
                                            <input hidden name="id" value="${cla.id_clase}">
                                            <button type="submit" class="btn btn-outline-warning btn-sm">
                                                <i data-feather="edit"></i> VER TEMARIOS
                                            </button>
                                        </form>
                                    </div>
                                </td>
                            </tr>
                        </s:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

</div>

<jsp:include page="/layouts/footer.jsp"/>
</body>
</html>
