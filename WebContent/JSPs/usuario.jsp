<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<!--===============================================================================================-->
	<link rel="icon" type="image/png" href="images/icons/favicon.ico" />
	<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css"
		href="vendor/bootstrap/css/bootstrap.min.css">
		<!--===============================================================================================-->
		<link rel="stylesheet" type="text/css"
			href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
			<!--===============================================================================================-->
			<link rel="stylesheet" type="text/css"
				href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
				<!--===============================================================================================-->
				<link rel="stylesheet" type="text/css"
					href="vendor/animate/animate.css">
					<!--===============================================================================================-->
					<link rel="stylesheet" type="text/css"
						href="vendor/css-hamburgers/hamburgers.min.css">
						<!--===============================================================================================-->
						<link rel="stylesheet" type="text/css"
							href="vendor/animsition/css/animsition.min.css">
							<!--===============================================================================================-->
							<link rel="stylesheet" type="text/css"
								href="vendor/select2/select2.min.css">
								<!--===============================================================================================-->
								<link rel="stylesheet" type="text/css"
									href="vendor/daterangepicker/daterangepicker.css">
									<!--===============================================================================================-->
									<link rel="stylesheet" type="text/css"
										href="/JPADAOProyecto1/css/usuario/util.css">
										<link rel="stylesheet" type="text/css"
											href="/JPADAOProyecto1/css/usuario/main.css">

											<link rel="stylesheet" type="text/css"
												href="/JPADAOProyecto1/css/usuario/tabla.css">
												<link rel="stylesheet" type="text/css"
													href="/JPADAOProyecto1/css/usuario/menu.css">
<script>
function numeros(){

	var z = document.getElementById("tel_numero").value;
	if(!/^[0-9]+$/.test(z)){
	    alert("Porfavor ingresa solo caracteres numericos para tu numero(Permitidos: 0-9)");
	    document.getElementById("tel_numero").value="";
	  }
}
function soloLetras(e) {
    key = e.keyCode || e.which;
    tecla = String.fromCharCode(key).toLowerCase();
    letras = " áéíóúabcdefghijklmnñopqrstuvwxyz";
    especiales = [8, 37, 39, 46];

    tecla_especial = false
    for(var i in especiales) {
        if(key == especiales[i]) {
            tecla_especial = true;
            break;
        }
    }

    if(letras.indexOf(tecla) == -1 && !tecla_especial)
        return false;
}

</script>
													<!--===============================================================================================-->
													<title>Usuario</title>
</head>
<body>
	<c:set var="p1" value="${requestScope['usuario']}" />
	<c:set var="t1" value="${requestScope['telefono']}" />
	<header> </header>

	<header id="header"> <nav class="links" style="--items: 5;">
	<a href="/JPADAOProyecto1/index.html"">Home</a> <a href="#">${p1.nombre}</a> <a href="#">${p1.apellido}</a>
	<a href="mailto:${p1.correo}">Enviar correo a : ${p1.correo}</a> <a
		href="/JPADAOProyecto1/LogoutServlet">Logout</a> <span class="line"></span> </nav> </header>

	<form action="" id="usuario"></form>

	<!-- FORMULARIO PARA  AGREGAR TELEFONOS   -->

	<form action="/JPADAOProyecto1/TelefonoController" method="get" id="telefono">
		<div class="limiter">

			<div class="container-login100">
				TUS DATOS<br> Id: ${p1.cedula}<br> Nombre: ${p1.nombre}<br>
							Apellido: ${p1.apellido}<br> Correo: ${p1.correo}<br>
									<div class="wrap-login100">
										<div class="login100-form-title"
											style="background-image: url(/JPADAOProyecto1/img/bg-02.jpg);">
											<span class="login100-form-title-1"> Agregar Telefono
											</span>
										</div>

										<form class="login100-form validate-form">
											<div class="wrap-input100 validate-input m-b-26"
												data-validate="Username is required">
												<span class="label-input100">Numero</span> 
												<input class="input100" type="text" id="tel_numero" name="tel_numero" minlength="9" maxlength="10" onkeyup="return numeros(this)" placeholder="Ingresa el numero"> <span
													class="focus-input100"></span>
											</div>

											<div class="wrap-input100 validate-input m-b-18"
												data-validate="Password is required">
												<span class="label-input100">Tipo</span> <input
													class="input100" onkeypress="return soloLetras(event)" type="text" name="tel_tipo"
													placeholder="Ingresa el tipo"> <span
													class="focus-input100"></span>
											</div>

											<div class="wrap-input100 validate-input m-b-18"
												data-validate="Password is required">
												<span class="label-input100">Operadora</span> <input
													class="input100" onkeypress="return soloLetras(event)" type="text" name="tel_operadora"
													placeholder="Ingresa la operadora"> <span
													class="focus-input100"></span>
											</div>
											<p>
												<input type="hidden" value="${p1.cedula}" name="usu_usuario" />
											</p>
											<p>
												<input type="hidden" value="${p1.correo}" name="usu_correo" />
											</p>
											<p>
												<input type="hidden" value="${p1.contrasena}"
													name="usu_contrasena" />
											</p>


											<div class="flex-sb-m w-full p-b-30">
												<div class="contact100-form-checkbox">
													
												</div>

												<div>
													
												</div>
											</div>

											<div class="container-login100-form-btn">
												<input class="login100-form-btn" type="submit"
													value="Agregar Telefono"> 
													<input class="login100-form-btn" type="reset" value="Cancelar">
											</div>
										</form>
									</div>
			</div>
		</div>

		<!--===============================================================================================-->
		<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
		<!--===============================================================================================-->
		<script src="vendor/animsition/js/animsition.min.js"></script>
		<!--===============================================================================================-->
		<script src="vendor/bootstrap/js/popper.js"></script>
		<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
		<!--===============================================================================================-->
		<script src="vendor/select2/select2.min.js"></script>
		<!--===============================================================================================-->
		<script src="vendor/daterangepicker/moment.min.js"></script>
		<script src="vendor/daterangepicker/daterangepicker.js"></script>
		<!--===============================================================================================-->
		<script src="vendor/countdowntime/countdowntime.js"></script>
		<!--===============================================================================================-->
		<script src="js/main.js"></script>



	</form>



	<!-- formulario para listar telefonos -->
<!--  -->
	<br><br><br>

				<h1>
					<span class="blue">&lt;</span>Mis<span class="blue">&gt;</span> <span
						class="yellow">telefonos</pan>
				</h1>
				<h2>
					Estos son tus..<a href="" target="_blank"> Numeros Registrados</a>
				</h2>

				<table class="container">
					<thead>
						<tr>
							<th><h1>Numero</h1></th>
							<th><h1>Tipo</h1></th>
							<th><h1>Operadora</h1></th>
							<th><h1>Lamar</h1></th>
							<th><h1>Modificar</h1></th>
							<th><h1>Eliminar</h1></th>
						</tr>
					</thead>
					<c:forEach items="${telefono}" var="telefono">

						<tr>
							<td><input type="text" name="tnumero"
								value="${telefono.numero}" /></td>
							<td><input type="text" name="ttipo" value="${telefono.tipo}" /></td>
							<td><input type="text" name="toperadora"
								value="${telefono.operadora}" /></td>
							<td><a href="tel:${telefono.numero}"><i
									class="fa fa-mobile-phone" style="font-size: 48px; color: red"></i></a></td>
							<td><h3>
									<a
										href="/JPADAOProyecto1/ActualizarTelefono?codigo=${telefono.codigo}&numero=${telefono.numero}&tipo=${telefono.tipo}&operadora=${telefono.operadora}&correo=${p1.correo}&contrasena=${p1.contrasena}">Modiicar</a>
								</h3></td>
							<td><h3>
									<a
										href="EliminarTelefono?codigo=${telefono.codigo}&correo=${p1.correo}&contrasena=${p1.contrasena}&cedula=${p1.cedula}">Eliminar</a>
								</h3></td>

						</tr>

					</c:forEach>
					<tbody>

					</tbody>
				</table>
</body>
</html>