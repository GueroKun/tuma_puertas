<%--
  Created by IntelliJ IDEA.
  User: Christian
  Date: 29/08/2023
  Time: 10:59 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>REGISTRAR INSTRUCTORES</title>
    <jsp:include page="/layouts/head.jsp"/>
</head>
<body>


<div class="container-fluid">
    <div class="row">
        <div class="col">
            <div class="card mt-5">
                <div class="card-header">Registro de instructores</div>
                <div class="card-body">
                    <form id="auto-form" class="needs-validation" novalidate action="/instructor/save" method="post">
                        <div class="form-group mb-3">
                            <div class="row">
                                <div class="col">
                                    <label for="name" class="fw-bold">Nombre: </label>
                                    <input type="text" name="name" id="name" class="form-control"
                                           required/>
                                    <div class="invalid-feedback">Campo obligatorio</div>
                                </div>
                                <div class="col">
                                    <label for="lastname" class="fw-bold">Apellido </label>
                                    <input type="text" name="lastname" id="lastname" class="form-control"
                                           required/>
                                    <div class="invalid-feedback">Campo obligatorio</div>
                                </div>
                                <div class="col">
                                    <label for="curp" class="fw-bold">Curp </label>
                                    <input type="text" name="curp" id="curp" class="form-control"
                                           required/>
                                    <div class="invalid-feedback">Campo obligatorio</div>
                                </div>
                                <div class="col">
                                    <label for="birthday" class="fw-bold">Fecha de nacimiento: </label>
                                    <input type="date" name="birthday" id="birthday" class="form-control"
                                           required/>
                                    <div class="invalid-feedback">Campo obligatorio</div>
                                </div>
                                <div class="col">
                                    <label for="username" class="fw-bold">Usuario: </label>
                                    <input type="text" name="username" id="username" class="form-control"
                                           required/>
                                    <div class="invalid-feedback">Campo obligatorio</div>
                                </div>
                                <div class="col">
                                    <label for="password" class="fw-bold">Contraseña: </label>
                                    <input type="text" name="password" id="password" class="form-control"
                                           required/>
                                    <div class="invalid-feedback">Campo obligatorio</div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group mb-3">
                            <div class="row">
                                <div class="col text-end">
                                    <a href="/instructor/instructor" class="btn btn-outline-danger btn-sm">
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
