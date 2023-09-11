<%-- 
    Document   : FrmFacturar
    Created on : 1 sep. 2023, 8:35:47 a. m.
    Author     : Progra
--%>
<%@page import="LogicaNegocios.LNDetalleCompra"%>
<%@page import="Entidades.DetalleCompra"%>
<%@page import="Entidades.Administrador" %>
<%@page import="Entidades.FacturaCompra" %>
<%@page import="Entidades.Refaccion" %>

<%@page import="LogicaNegocios.LNAdministrador"%>
<%@page import="LogicaNegocios.LNFacturaCompra"%>
<%@page import="LogicaNegocios.LNRefaccion"%>
<%@page import="java.util.List" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="lib/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="lib/bootstrap-datepicker/css/bootstrap-datepicker3.standalone.min.css" rel="stylesheet" type="text/css"/>
        <link href="lib/DataTables/datatables.min.css" rel="stylesheet" type="text/css"/>
        <link href="lib/fontawesome-free-5.14.0-web/css/all.min.css" rel="stylesheet" type="text/css"/>
           <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <title>Factura de Compra</title>
        
       
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
                <a class="navbar-brand" href="index.html">Taller Mecacnico <i class="fas fa-tasks"></i></a>
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
                <div class="col-10"><h1>Facturacion Compra </h1></div>
            </div>
            <br/><!-- comment -->
            
            
            <form action="CrearFacturaCompra" method="post" id="form_AgregarFactura">
                <div class="form-group float-right"> 
              
                </div>
                 <div class="form-groupl"> 
                    <div class="input-group">
                           <%
                        FacturaCompra facturacompra;
                        LNFacturaCompra logicaF = new LNFacturaCompra();
                        facturacompra =new FacturaCompra();
                    %>
                      <div class="input-group">
                        <label for="txtNumFactura" class="form-control" style="display: none;" > Num Factura </label>
                        <input type="text" id="txtNumFactura" name="txtNumFactura"
                               value="<%=facturacompra.getIdFacturaCompra()%>" readonly class="form-control" style="display: none;"/>
                    </div>
                            <input type="text" id="txtIdAdministrador" name="txtIdAdministrador"
                                   value="<%=facturacompra.getIdAdministrador()%>" readonly class="form-control" style="display: none;"/>
                        
                            <input type="text" id="txtNombreAdministrador" name="txtNombreAdministrador"
                                   value="" readonly class="form-control" placeholder="Selecionar un Encargado"/>
                            
                          <a id="btnBuscar" class="btn btn-primary" data-toggle="modal" data-target="#buscarAdministrador" onclick="mostrarBotonGuardar()">
                            <i class="fas fa-search"></i>
                          </a>
                            
                             <input type="submit" id="btnGuardar" name="Guardar" value="Guardar" class="btn btn-info" style="display: none;"onclick="mostrarDiv()"  />
                    </div>
                        </div><!-- comment -->              
                          </form>     
                    </div>
    </div>
    <footer class="border-top">
        <div class="container">
            &copy; Taller Mecánico Jafet Ulate
        </div>
    </footer>
    
    
    
        <!-- modal buscar cliete -->
        <div class="modal" id="buscarAdministrador" tabindex="1" role="dialog" aria-labelledby="tituloVentana" >
            <div class="modal-dialog" role="document" >
                <div class="modal-content" >
                    <div class="modal-header" >
                        <H5 id="tituloVentana">Buscar Administrador</H5>
                        <button class="close" data-dismiss="modal" arial-label="cerrar" arial-hidden="true"
                                onclick="Limpiar()">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body" >
                        <table id="tablaAdministrador">
                            <thead>
                                <tr>
                                    <th>Codigo</th>
                                    <th>Nombre</th>
                                    <th>Selecionar</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    LNAdministrador logica= new LNAdministrador();
                                    List<Administrador> datosAdministrador;
                                    datosAdministrador=logica.ListarAdministrador_List("");
                                    for(Administrador registroC:datosAdministrador){
                                %>
                                <tr>
                                    <%int codigoC = registroC.getIdAdministrador();
                                    String nombreC = registroC.getNombre();
                                    %>
                                    <td><%=codigoC%></td>
                                    <td><%=nombreC%></td>
                                    <td>
                                        <a href="#" data-dismiss="modal"
                                           onclick="SeleccionarAdministrador('<%=codigoC%>','<%=nombreC%>');">
                                            Seleccionar</a> 
                                    </td>
                                </tr>
                                <%}%>
                            </tbody>
                        </table>
                    </div><!-- fin modal body -->
                    <div class="modal-footer">
                        <button class="btn btn-warning" type="button" data-dismiss="modal" onclick="Limpiar()">
                            Cancelar
                        </button>
                        
                    </div>
                </div><!-- fin modal content -->
            </div><!-- fin modal dialog -->
        </div><!-- fin fin modal -->
         

        <script src="lib/jquery/dist/jquery.min.js" type="text/javascript"></script>
        <script src="lib/bootstrap/dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>
        <script src="lib/bootstrap-datepicker/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
        <script src="lib/DataTables/datatables.min.js" type="text/javascript"></script>
        <script src="lib/DataTables/DataTables-1.10.21/js/dataTables.bootstrap4.min.js" type="text/javascript"></script>
        <script src="lib/bootstrap-datepicker/locales/bootstrap-datepicker.es.min.js" type="text/javascript"></script>
        
        
           <script>
            $(document).ready(function (){
                // mostrar calendario
                $('.datepicker').datepicker({
                    format: 'yyyy-mm-dd',
                    autoclose: true,
                    language:'es'
                });
                $('#tablaAdministrador').dataTable({
                   "lengthMenu":[[5,15,15,-1],[5,10,15,"ALL"]],
                   "language":{
                       "info":"Pagina _PAGE_ de _PAGES_",
                       "infoEmpty":"No hay resgistros",
                       "zeroRecords":"No se encuentran registros",
                       "search":"Buscar",
                       "infoFiltered":"",
                       "lengthMenu":"Mostrar _MENU_Registros",
                       "paginate":{
                           "firts":"Primero",
                           "last":"Ultimo",
                           "next":"siguiente",
                           "previous":"Anterior"
                       }
                       
                   }
                });
                
                        $('#tablaRef').dataTable({
                   "lengthMenu":[[5,10,-1],[5,10,"Todos"]],
                   "language":{
                       "info":"Pagina _PAGE_ de _PAGES_",
                       "infoEmpty":"No hay resgistros",
                       "zeroRecords":"No se encuentran registros",
                       "search":"Buscar",
                       "infoFiltered":"",
                       "lengthMenu":"Mostrar _MENU_Registros",
                       "paginate":{
                           "firts":"Primero",
                           "last":"Ultimo",
                           "next":"siguiente",
                           "previous":"Anterior"
                       }
                       
                   }
                });
                
            });

            
            // seleccionar cliente
            function SeleccionarAdministrador(idAdministrador, nombre){
                $("#txtIdAdministrador").val(idAdministrador);
                $("#txtNombreAdministrador").val(nombre);
            } 
          
            //limpira en selecionar cliente
            function Limpiar(){
                $("#txtIdAdministrador").val("");
                $("#txtNombreAdministrador").val("");
            }
            
            
             // seleccionar cliente
            function SeleccionarRefaccion(idRefaccion, nombre,precio){
                $("#txtIdProducto").val(idRefaccion);
                $("#txtDescripcion").val(nombre);
                $("#txtPrecio").val(precio);
            } 
            
             // mostrar boton de guadar para crear factura
            function mostrarBotonGuardar() {
                var btnGuardar = document.getElementById("btnGuardar");
                btnGuardar.style.display = "block";
 
              }
    </script>
         

<script>
                    // consulta de ajax para agregar sin recargar
                $(document).ready(function() {
                    // Maneja el evento clic del botón "Agregar y Guardar"
                    $("#btnGuardar").click(function(event) {
                        event.preventDefault(); // Evita que se envíe el formulario de manera tradicional

                        // Serializa los datos del formulario
                        var formData = $("#form_AgregarFactura").serialize();

                        // Realiza una solicitud AJAX al servlet
                        $.ajax({
                            type: "POST",
                            url: "CrearFacturaCompra",
                            data: formData,
                            success: function(data) {
                                // Aquí puedes manejar la respuesta del servlet
                                // Por ejemplo, mostrar un mensaje de éxito o realizar otras acciones
                                console.log(data);
                                mostrarDiv();
                            },
                            error: function(xhr, status, error) {
                                // Maneja errores aquí si es necesario
                                console.error(xhr.responseText);
                            }
                        });
                    });

                    // Función para mostrar el div
                    function mostrarDiv() {
                         var btnBuscar = document.getElementById("btnBuscar");
                          btnBuscar.style.display = "none"; // Oculta el botón "Buscar"
                           var btnGuardar = document.getElementById("btnGuardar");//OCULTA EL GUARDAR
                                btnGuardar.style.display = "none";
                                     window.location.href = "frmDetalleCompra.jsp"; 
                    }
                })
     </script>
  
     
     
     
     
                
    </body>
</html>