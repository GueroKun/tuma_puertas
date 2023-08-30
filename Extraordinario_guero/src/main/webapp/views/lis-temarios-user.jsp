<%--
  Created by IntelliJ IDEA.
  User: Christian
  Date: 29/08/2023
  Time: 09:43 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>TEMARIOS</title>
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
<br><br>
<div class="container">
    <div class="row">
        <div class="col">
            <div class="card">
                <div class="card-header">
                    <div class="row">
                        <div class="col text-center">Listado de temarios de la clase</div>
                    </div>
                </div>
                <div class="card-body">
                    <table class="table table-striped table-hover datatable" id="datatable">
                        <thead class="table-dark">
                        <th>#</th>
                        <th>Descripcion</th>
                        </thead>
                        <tbody>
                        <s:forEach items="${list}" varStatus="s" var="li">
                            <tr>
                                <td><s:out value="${s.count}"/></td>
                                <td><s:out value="${li.description_temario}"/></td>
                            </tr>
                        </s:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <div class="col text-end">
        <a href="/api/user/user" class="btn btn-outline-danger btn-sm">
            REGRESAR
        </a>
    </div>
</div>

<jsp:include page="/layouts/footer.jsp"/>

</body>
</html>
