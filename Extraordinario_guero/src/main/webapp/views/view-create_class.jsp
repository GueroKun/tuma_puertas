<%--
  Created by IntelliJ IDEA.
  User: Christian
  Date: 29/08/2023
  Time: 01:08 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>REGISTRAR CLASES</title>
  <jsp:include page="/layouts/head.jsp"/>
</head>
<body>

<div class="container-fluid">
  <div class="row">
    <div class="col">
      <div class="card mt-5">
        <div class="card-header">Registro de clases</div>
        <div class="card-body">
          <form id="auto-form" class="needs-validation" novalidate action="/clase/save" method="post">
            <div class="form-group mb-3">
              <div class="row">
                <div class="col">
                  <label for="name_class" class="fw-bold">Nombre: </label>
                  <input type="text" name="name_class" id="name_class" class="form-control"
                         required/>
                  <div class="invalid-feedback">Campo obligatorio</div>
                </div>
                <div class="col">
                  <label for="description_class" class="fw-bold">Descripcion </label>
                  <input type="text" name="description_class" id="description_class" class="form-control"
                         required/>
                  <div class="invalid-feedback">Campo obligatorio</div>
                </div>
                <div class="col">
                  <label class="fw-bold" for="ins">Instructor</label>
                  <select id="ins" name="ins" class="form-select" required>
                    <option value="">Seleccionar...</option>
                    <s:forEach var="ins" items="${instructors}">
                      <option value="${ins.id_user}"><s:out
                              value="${ins.name}"/></option>
                    </s:forEach>
                  </select>
                </div>

              </div>
            </div>
            <div class="form-group mb-3">
              <div class="row">
                <div class="col text-end">
                  <a href="/clases/clase" class="btn btn-outline-danger btn-sm">
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
