<%--
  Created by IntelliJ IDEA.
  User: Christian
  Date: 29/08/2023
  Time: 09:59 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>INSCRIBIRSE</title>
    <jsp:include page="/layouts/head.jsp"/>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div class="col">
            <div class="card mt-5">
                <div class="card-header">INSCRIPCION</div>
                <div class="card-body">
                    <form id="auto-form" class="needs-validation" novalidate action="/user/inscricion-save" method="post">
                        <div class="form-group mb-3">
                            <div class="row">
                                <div class="col">
                                    <label class="fw-bold" for="asig">Clases</label>
                                    <select id="asig" name="asig" class="form-select" required>
                                        <option value="">Seleccionar...</option>
                                        <s:forEach var="asig" items="${asigna}">
                                            <option value="${asig.id_clase}"><s:out
                                                    value="${asig.description_class}"/></option>
                                        </s:forEach>
                                    </select>
                                </div>
                                <div class="col">
                                    <label class="fw-bold" for="tem">Temarios</label>
                                    <select id="tem" name="tem" class="form-select" required>
                                        <option value="">Seleccionar...</option>
                                        <s:forEach var="te" items="${tems}">
                                            <option value="${te.id_temario}"><s:out
                                                    value="${te.description_temario}"/></option>
                                        </s:forEach>
                                    </select>
                                </div>

                            </div>
                        </div>
                        <div class="form-group mb-3">
                            <div class="row">
                                <div class="col text-end">
                                    <a href="/api/user/user" class="btn btn-outline-danger btn-sm">
                                        CANCELAR
                                    </a>
                                    <button type="submit" class="btn btn-outline-success btn-sm">
                                        ACEPTAR
                                    </button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


<jsp:include page="/layouts/footer.jsp"/>
</body>
</html>
