<%--
  Created by IntelliJ IDEA.
  User: Christian
  Date: 29/08/2023
  Time: 11:14 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrar Usuario</title>
  <jsp:include page="/layouts/head.jsp"/>
</head>
<body style="background-color: #6e7881">

<div class="container-fluid vh-100">
  <div class="row">
    <div class="col">
      <div class="card position-absolute top-50 start-50 translate-middle" style="width: 25rem; border-color: #002F5D;">
        <div class="card-header" style=" background-color:  #002F5D; text-align: center">
          <h4 style="color: white"> Registro de usuario</h4>
        </div>
        <div class="card-body text-center">
          <form id="loginForm" action="/user/user-save" class="needs-validation"
                novalidate method="post">
            <div class="form-floating mb-3">
              <input type="date" class="form-control" name="birthday" id="birthday"
                     placeholder="name@example.com" required>
              <label for="birthday">Fecha de nacimiento</label>
              <div class="invalid-feedback text-start">
                Campo obligatorio
              </div>
            </div>
            <div class="form-floating mb-3">
              <input type="text" class="form-control" name="curp" id="curp"
                     placeholder="JIJIJA" required>
              <label for="curp">Curp</label>
              <div class="invalid-feedback text-start">
                Campo obligatorio
              </div>
            </div>
            <div class="form-floating mb-3">
              <input type="text" class="form-control" name="lastname" id="lastname"
                     placeholder="Insano" required>
              <label for="lastname">Apellido</label>
              <div class="invalid-feedback text-start">
                Campo obligatorio
              </div>
            </div>
            <div class="form-floating mb-3">
              <input type="text" class="form-control" name="name" id="name"
                     placeholder="Tilin" required>
              <label for="name">Nombre</label>
              <div class="invalid-feedback text-start">
                Campo obligatorio
              </div>
            </div>
            <div class="form-floating mb-3">
              <input type="text" class="form-control" name="username" id="username"
                     placeholder="name@example.com" required>
              <label for="username">Correo electrónico</label>
              <div class="invalid-feedback text-start">
                Campo obligatorio
              </div>
            </div>
            <div class="form-floating mb-3">
              <input type="password" name="password" class="form-control" id="password"
                     placeholder="Password" required>
              <label for="password">Contraseña</label>
              <div class="invalid-feedback text-start">
                Campo obligatorio
              </div>
              <div>
                <a href="/api/auth/login">¿Ya tienes una cuenta?</a>
              </div>
            </div>
            <div class="form-group mb-3">
              <button id="login" class="btn btn-success w-100" type="submit">
                <i data-feather="log-in"></i> REGISTRAR
              </button>
              <p></p>
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
