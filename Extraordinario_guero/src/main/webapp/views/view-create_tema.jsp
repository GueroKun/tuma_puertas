<%--
  Created by IntelliJ IDEA.
  User: Christian
  Date: 29/08/2023
  Time: 06:07 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>REGISTRAR TEMARIOS</title>
    <jsp:include page="/layouts/head.jsp"/>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div class="col">
            <div class="card mt-5">
                <div class="card-header">Registro de temarios</div>
                <div class="card-body">
                    <form id="auto-form" class="needs-validation" novalidate action="/temarios/save" method="post">
                        <div class="form-group mb-3">
                            <div class="row">
                                <div class="col">
                                    <label for="description_temario" class="fw-bold">Descripcion </label>
                                    <input type="text" name="description_temario" id="description_temario" class="form-control"
                                           required/>
                                    <div class="invalid-feedback">Campo obligatorio</div>
                                </div>
                                <div class="col">
                                    <label class="fw-bold" for="asignatura">Clases</label>
                                    <select id="asignatura" name="asignatura" class="form-select" required>
                                        <option value="">Seleccionar...</option>
                                        <s:forEach var="asignatura" items="${clasesita}">
                                            <option value="${asignatura.id_clase}"><s:out
                                                    value="${asignatura.name_class}"/></option>
                                        </s:forEach>
                                    </select>
                                </div>

                            </div>
                        </div>
                        <div class="form-group mb-3">
                            <div class="row">
                                <div class="col text-end">
                                    <a href="/temarios/temario" class="btn btn-outline-danger btn-sm">
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
