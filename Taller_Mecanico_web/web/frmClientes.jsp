<%-- 
    Document   : frmClientes
    Created on : 04-sep-2023, 15:11:07
    Author     : Usuario
--%>
<%@page import= "Entidades.Cliente"%>
<%@page import= "LogicaNegocios.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="lib/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="lib/fontawesome-free-5.14.0-web/css/all.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
      
        <title>Clientes</title>
    </head>
    <body>
            <style>
    body{
        background-color: #B6B6B6;
background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='1075' height='1075' viewBox='0 0 200 200'%3E%3Cdefs%3E%3ClinearGradient id='a' gradientUnits='userSpaceOnUse' x1='88' y1='88' x2='0' y2='0'%3E%3Cstop offset='0' stop-color='%23785c00'/%3E%3Cstop offset='1' stop-color='%23bd9700'/%3E%3C/linearGradient%3E%3ClinearGradient id='b' gradientUnits='userSpaceOnUse' x1='75' y1='76' x2='168' y2='160'%3E%3Cstop offset='0' stop-color='%23868686'/%3E%3Cstop offset='0.09' stop-color='%23ababab'/%3E%3Cstop offset='0.18' stop-color='%23c4c4c4'/%3E%3Cstop offset='0.31' stop-color='%23d7d7d7'/%3E%3Cstop offset='0.44' stop-color='%23e5e5e5'/%3E%3Cstop offset='0.59' stop-color='%23f1f1f1'/%3E%3Cstop offset='0.75' stop-color='%23f9f9f9'/%3E%3Cstop offset='1' stop-color='%23FFFFFF'/%3E%3C/linearGradient%3E%3Cfilter id='c' x='0' y='0' width='200%25' height='200%25'%3E%3CfeGaussianBlur in='SourceGraphic' stdDeviation='12' /%3E%3C/filter%3E%3C/defs%3E%3Cpolygon fill='url(%23a)' points='0 174 0 0 174 0'/%3E%3Cpath fill='%23000' fill-opacity='.5' filter='url(%23c)' d='M121.8 174C59.2 153.1 0 174 0 174s63.5-73.8 87-94c24.4-20.9 87-80 87-80S107.9 104.4 121.8 174z'/%3E%3Cpath fill='url(%23b)' d='M142.7 142.7C59.2 142.7 0 174 0 174s42-66.3 74.9-99.3S174 0 174 0S142.7 62.6 142.7 142.7z'/%3E%3C/svg%3E");
background-attachment: fixed;
background-repeat: no-repeat;
background-position: top left;
    }
</style>
       <header>
        <nav class="navbar navbar-expand-sm navbar-toggleable-sm navbar-light bg-white border-bottom box-shadow mb-3">
            <div class="container">
                <a class="navbar-brand" href="index.html">Taller Mecanico <i class="fas fa-tasks"></i></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".navbar-collapse" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="navbar-collapse collapse d-sm-inline-flex flex-sm-row-reverse">
                    <ul class="navbar-nav flex-grow-1">
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="index.html">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="frmListarAdministrador.jsp">Encargados</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="frmListarClientes.jsp">Clientes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="frmFacturaCompra.jsp">Facturación de Compra</a>
                        </li>
                         <li class="nav-item">
                            <a class="nav-link text-dark" href="frmFacturaVenta.jsp">Facturación de Venta </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="frmInforme.jsp">Informe de Venta </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
        
        <div class="container">
            <div class="row">
                <div class="col-md-6 mx-auto">
                    <div class="card-header">
                        <h1>Datos del cliente</h1>
                    </div><br>
                    <%
                        String id = request.getParameter("idCrearModificar");
                        int codigo = Integer.parseInt(id);
                        Cliente cliente;
                        LNCliente logica = new LNCliente();
                        if (codigo>0) {
                                cliente= logica.ObtenerCliente("IDCLIENTE="+id);
                            } else{
                            cliente=new Cliente();
                     
                        }
                    %>
                    
                    
                    
                    <form action="CrearModificarCliente" method="post" id="form_AgregarModificar">
                        <div class="form-group">
                            <%if (codigo>0) { %>
                            <!-- si existe lo muestro el codigo -->
                             <label for="txtCodigo" class="control-label" > Codigo </label>
                             <input type="text" id="txtCodigo" name="txtCodigo" value="<%=cliente.getIdCliente()%>" readonly
                                    class="form-control" > 
                            <%}else{%>  
                            <input type="hidden" id="txtCodigo" name="txtCodigo" value="-1" > 
                            <%}%>      
                             
                            
                            <div class="form-group"><!-- comment -->
                                <label for="txtNombre" class="control-label">Nombre</label>
                                <input type="text" id="txtNombre" name="txtNombre"
                                       value="<%=cliente.getNombre()%>" class="form-control">
                            </div>
                            
                             <div class="form-group"><!-- comment -->
                                <label for="txtTelefono" class="control-label">Telefono</label>
                                <input type="text" id="txtTelefono" name="txtTelefono"
                                       value="<%=cliente.getTelefono()%>" class="form-control">
                            </div>
                            
                             <div class="form-group"><!-- comment -->
                                <label for="txtCedula" class="control-label">Cedula</label>
                                <input type="text" id="txtCedula" name="txtCedula"
                                       value="<%=cliente.getCedula()%>" class="form-control">
                            </div>
                            
                             <div class="form-group"><!-- comment -->
                                <label for="txtCorreo" class="control-label">Correo</label>
                                <input type="text" id="txtCorreo" name="txtCorreo"
                                       value="<%=cliente.getCorreo()%>" class="form-control">
                            </div>
                            
                              <div class="form-group"><!-- comment -->
                                  <div class="input-group"> 
                                      <input type="submit" id="btnGuardar" class=" btn btn-primary m3" value="Guardar"/>
                                      <input type="button" id="btnRegresar"  value="Regresar" 
                                             onclick="location.href='frmListarClientes.jsp'" class="btn btn-secondary m3"/>
                                  </div>
                              </div>
                            </div>
                    </form>
                </div>
            </div><!-- row -->
        </div>
                            
      <footer class="border-top">
        <div class="container">
            &copy; Taller Mecánico Jafet Ulate
        </div>
    </footer>
        
        <!-- Para las validaciones -->
         <script src="lib/bootstrap/dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>
         <script src="lib/jquery/dist/jquery.min.js" type="text/javascript"></script>
         <script src="lib/jquery-validation/dist/jquery.validate.min.js" type="text/javascript"></script>
         
         <script>
    // cuando el documento esté listo
    $(document).ready(function(){
        $("#form_AgregarModificar").validate({
            rules: {
                txtNombre: { required: true, maxlength: 50 },
                txtTelefono: { required: true, minlength: 8, maxlength: 11 },
                txtCedula: { required: true, minlength: 8, maxlength: 13 },
                txtCorreo: { required: true, maxlength: 80 }
            },
            messages: {
                txtNombre: "El campo Nombre es obligatorio, máximo 50 letras",
                txtTelefono: "El campo Teléfono es obligatorio, mínimo 8 números máximo 11",
                txtCedula: "El campo Cédula es obligatorio, mínimo 8 números máximo 13",
                txtCorreo: "El campo Correo es obligatorio, máximo 80 letras"
            },
            errorElement: 'span'
        });
    });
</script>
         
    </body>
</html>
