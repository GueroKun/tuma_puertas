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
    <title>Administrador</title>
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
            <h2>ADMINISTRADOR</h2>
            <p>xd</p>
            <div class="card">
                <div class="card-header">
                    <div class="row">
                        <div class="col">Listado de instructores</div>
                        <div class="col">
                            <a href="/instructor/view-create" class="btn btn-outline-success btn-sm">
                                REGISTRAR INSTRUCTOR
                            </a>
                        </div>
                        <div class="col text-end">
                            <a href="/clase/view-create" class="btn btn-outline-success btn-sm">
                                REGISTRAR CLASE
                            </a>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <table class="table table-stripped">
                        <thead>
                        <th>#</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Curp</th>
                        <th>Fecha de nacimiento</th>
                        <th>Estado</th>
                        </thead>
                        <tbody>
                        <s:forEach var="instructor" items="${users}" varStatus="s">
                            <tr>
                                <td>
                                    <s:out value="${s.count}"/>
                                </td>
                                <td>
                                    <s:out value="${instructor.name}"/>
                                </td>
                                <td>
                                    <s:out value="${instructor.lastname}"/>
                                </td>
                                <td>
                                    <s:out value="${instructor.curp}"/>
                                </td>
                                <td>
                                    <s:out value="${instructor.birthday}"/>
                                </td>
                                <td>
                                    <s:out value="${instructor.status}"/>
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

            <br>
            <br>

            <div class="card">
                <div class="card-header">
                    <div class="row">
                        <div class="col">Listado de clases asignadas</div>
                    </div>
                </div>
                <div class="card-body">
                    <table class="table table-stripped">
                        <thead class="table-dark">
                        <th>#</th>
                        <th>Nombre</th>
                        <th>Descripcion</th>
                        <th>Estado</th>
                        <th>Instructor</th>

                        </thead>
                        <tbody>
                        <s:forEach items="${clasess}" varStatus="s" var="cla">
                            <tr>
                                <td><s:out value="${s.count}"/></td>
                                <td><s:out value="${cla.name_class}"/></td>
                                <td><s:out value="${cla.description_class}"/></td>
                                <td><s:out value="${cla.status_class}"/></td>
                                <td><s:out value="${cla.user.name}"/></td>
                            </tr>
                        </s:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>





<jsp:include page="/layouts/footer.jsp"/>
</body>
</html>
