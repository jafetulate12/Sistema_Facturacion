<%-- 
    Document   : frmDetalleVenta
    Created on : 08-sep-2023, 0:16:18
    Author     : Usuario
--%>

<%@page import="Entidades.Inventario"%>
<%@page import="LogicaNegocios.LNInventario"%>
<%@page import="java.sql.Date"%>
<%@page import="Entidades.Servicios"%>
<%@page import="LogicaNegocios.LNServicios"%>
<%@page import="LogicaNegocios.LNDetalleVenta"%>
<%@page import="Entidades.DetalleVenta"%>
<%@page import="java.util.List"%>
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
        <title>Detalle Venta</title>
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
    <div class="container">
        
        <%
                    DetalleVenta detalleventa;
                    LNDetalleVenta logicaD = new LNDetalleVenta();
                    detalleventa =new DetalleVenta();

    
                %>
        <h1 class="mt-4">Factura de Venta - Taller Mecánico</h1>
        
        <!-- Formulario para Agregar Servicio -->
        <form action="CrearDetalleVentaSer" method="post" id="form_AgregarFacturaVTS" >
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="txtIdServicios">Código de Servicio</label>
                        <input type="text" id="txtIdServicios" name="txtIdServicios" value="<%=detalleventa.getIdServicios()%>" placeholder="Código de servicio" readonly class="form-control" />
                    </div>
                    <div class="form-group">
                        <label for="txtPrecioSer">Precio de Servicio</label>
                        <input type="text" id="txtPrecioSer" name="txtPrecioSer" value="<%=detalleventa.getSubtotal()%>" readonly class="form-control" placeholder="Precio de Servicio" />
                    </div>
                    <a id="btnBuscar_Ser" class="btn btn-primary" data-toggle="modal" data-target="#buscarServicio">
                        <i class="fas fa-search"></i> Buscar Servicio
                    </a>
                </div>
              <div class="col-md-6">
                <input type="submit" id="btnGuardar_detalleVentaSer" name="Guardar_dvS" value="Agregar Servicio" class="btn btn-primary" style="                         display: none;" />
             </div>
            </div>
               
        </form>
        
        <!-- Formulario para Agregar Refacción -->
        <form action="CrearDetalleVenta" method="post" id="form_AgregarFacturaVT">
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="txtIdRefaccion">Código de Refacción</label>
                        <input type="text" id="txtIdRefaccion" name="txtIdRefaccion" value="<%=detalleventa.getIdRefaccion()%>" readonly class="form-control" placeholder="Código de Refacción" />
                    </div>
                    <div class="form-group">
                        <label for="txtNombreRefaccion">Nombre de Refacción</label>
                        <input type="text" id="txtNombreRefaccion" name="txtNombreRefaccion" readonly class="form-control" placeholder="Nombre de Refacción"  />
                    </div>
                    <div class="form-group">
                        <label for="txtPrecioRefaccion">Precio de Refacción</label>
                        <input type="text" id="txtPrecioRefaccion" name="txtPrecioRefaccion" placeholder="Precio de Refacción" readonly class="form-control" />
                    </div>
                    <div class="form-group">
                        <label for="txtCantidadRefaccion">Cantidad de Refacción</label>
                        <input type="text" id="txtCantidadRefaccion" name="txtCantidadRefaccion" value="" readonly class="form-control" placeholder="Cantidad de Refacción"  />
                    </div>
                    <a id="btnBuscar_Ser" class="btn btn-primary" data-toggle="modal" data-target="#buscarInventario">
                        <i class="fas fa-search"></i> Buscar en Inventario
                    </a>
                     <div class="form-group">
                        <label for="txtCantidadVenta">Cantidad de Venta</label>
                        <input type="number" id="txtCantidadVenta" name="txtCantidadVenta" min="1" onchange="calcularSubtotal()" class="form-control" value="<%=detalleventa.getCantidad()%>" >
                    </div>
                    <div class="form-group">
                        <label for="txtSubtotal">Subtotal</label>
                        <input type="text" id="txtSubtotal" name="txtSubtotal" readonly class="form-control"  value="<%=detalleventa.getSubtotal()%>" >
                    </div>
                    <input type="submit" id="btnGuardar_detalleVenta" name="Guardar_dv" value="Guardar Producto" class="btn btn-primary"/>
                </div>
            </div>
                </div>
            </div>
            
        </form>
        
  
        <!-- Tabla de Detalle de Venta -->
        <table class="table">
            <thead>
                <tr id="titulos">
                    <th>Código</th>
                    <th>Id_Factura</th>
                    <th>Id_Refacción</th>
                    <th>Cantidad</th>
                    <th>Id_Servicios</th>
                    <th>SubTotal</th>
                    <th>Opciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    String condicion="";
                    List<DetalleVenta> datos;
                    datos=logicaD.ListarDetalleVenta_list(condicion);
                    double total = 0.0; // Inicializar el total
                    for(DetalleVenta registro:datos){
                %>
                <tr>
                    <% int codigo = registro.getIdDetalleVenta(); %>
                    <td> <%= codigo %> </td>
                    <td> <%= registro.getIdFacturaVenta()%> </td>
                    <td> <%= registro.getIdRefaccion()%> </td>
                    <td> <%= registro.getCantidad()%> </td>
                    <td> <%= registro.getIdServicios()%> </td>
                    <td> <%= registro.getSubtotal()%> </td>
                    <td>
                        <a href="EliminarDetalleVenta?idCliente=<%=codigo%>"> <i class="fas fa-trash-alt" onclick="eliminarDetalle(<%=codigo%>)"></i></a>
                    </td>
                </tr>
                <%
                    total += registro.getSubtotal(); // Sumar al total
                } %>
            </tbody>
        </table>

             <form action="ActualizarFacturaVenta" method="post" >
<!-- Agrega un espacio para mostrar el total -->
<div class="form-group float-right">
<div id="total-container">
    Total: <span id="total-amount"><%= total %></span>
</div>
<!-- Agrega un botón para calcular el total con 13% de impuesto -->
<input type="button"   value="Calcular Con Impuesto" name="calcularimpuesto"  class="btn btn-info" placeholder="Calcular Con Impuesto" onclick="calcularTotalConImpuesto()" />
<input type="text" id="txtfinal" name="txtfinal" value="<% detalleventa.getPrecioFinal();%>"  readonly />
</div>
  <input type="submit" id="btn_CrearFactura_final" name="Guardar_Final" value="Crear Factura" class="btn btn-warning" style="display: none;" onclick="mostrarAlert()" />

</form>
            
    </div><!-- fin container -->    
  
    
    
    
    
   
    
    
     <!-- Modal para buscar Servicio -->
<div class="modal" id="buscarServicio" tabindex="1" role="dialog" aria-labelledby="tituloVentana">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 id="tituloVentana">Buscar Servicio</h5>
                <button class="close" data-dismiss="modal" aria-label="cerrar" aria-hidden="true" onclick="Limpiar_ser()">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <table id="tablaServicios" class="table">
                    <thead>
                        <tr>
                            <th>Codigo</th>
                            <th>Nombre Servicio</th>
                            <th>Fecha Servicio</th>
                            <th>Precio</th>
                            <th>Seleccionar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            LNServicios logica= new LNServicios();
                            List<Servicios> datosAdministrador;
                            datosAdministrador=logica.ListarServicios_List("");
                            for(Servicios registroC:datosAdministrador){
                        %>
                        <tr>
                            <% int codigoC = registroC.getIdServicios();
                            String nombreC = registroC.getNombreServicio();
                            Date fechaC = registroC.getFechaServicio();
                            double PrecioC = registroC.getPrecioServicio();
                            %>
                            <td><%=codigoC%></td>
                            <td><%=nombreC%></td>
                            <td><%=fechaC%></td>
                            <td><%=PrecioC%></td>
                            <td>
                                <a href="#" data-dismiss="modal"
                                   onclick="SeleccionarServicio('<%=codigoC%>','<%=PrecioC%>');">
                                    Seleccionar
                                </a>
                            </td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div><!-- fin modal body -->
            <div class="modal-footer">
                <button class="btn btn-warning" type="button" data-dismiss="modal" onclick="Limpiar_ser()">Cancelar</button>
            </div>
        </div><!-- fin modal content -->
    </div><!-- fin modal dialog -->
</div><!-- fin fin modal -->

    
    
    
    
          <!-- modal buscar cliete -->
        <div class="modal" id="buscarInventario" tabindex="1" role="dialog" aria-labelledby="tituloVentana" >
            <div class="modal-dialog" role="docbuscarServicioument" >
                <div class="modal-content" >
                    <div class="modal-header" >
                        <H5 id="tituloVentana">Buscar en Inventario</H5>
                        <button class="close" data-dismiss="modal" arial-label="cerrar" arial-hidden="true"
                                onclick="Limpiar_ser()">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body" >
                        <table id="tablaRefaccion">
                            <thead>
                                <tr>
                                    <th>Codigo</th>
                                    <th>ID refaccion</th>
                                    <th>Nombre refaccion </th>
                                    <th>Precio </th>
                                    <th> Cantidad</th>
                                    <th>Selecionar</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    LNInventario logica_I= new LNInventario();
                                    List<Inventario> datosInventario;
               
                                    datosInventario=logica_I.ListarClientes_List("");
                                    for(Inventario registroI:datosInventario){
                                %>
                                <tr>
                                    <%int codigoI = registroI.getIdInventario();
                                    int IDRefaccionI = registroI.getIdRefaccion();
                                    String nombreI = registroI.getNombre();
                                    double precioI = registroI.getPrecioUnitario();
                                    int CantidadI = registroI.getCantidad();
                                    %>
                                    <td><%=codigoI%></td>
                                    <td><%=IDRefaccionI%></td>
                                    <td><%=nombreI%></td>
                                    <td><%=precioI%></td>
                                    <td><%=CantidadI%></td>
                                    <td>
                                        <a href="#" data-dismiss="modal"
                                          onclick="SeleccionarRefaccion('<%=IDRefaccionI%>', '<%=nombreI%>', '<%=precioI%>', '<%=CantidadI%>');"> Seleccionar</a> 
                                    </td>
                                </tr>
                                <%}%>
                            </tbody>
                        </table>
                    </div><!-- fin modal body -->
                    <div class="modal-footer">
                        <button class="btn btn-warning" type="button" data-dismiss="modal" onclick="Limpiar_Refaccion()">
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

          function calcularTotales() {
        // Obtener todas las filas de la tabla
        var filas = document.querySelectorAll("table.table tbody tr");
        var sumaSubtotal = 0.0;

        // Iterar a través de las filas de la tabla
        filas.forEach(function (fila) {
            var subtotal = parseFloat(fila.querySelector("td:nth-child(6)").textContent);
            sumaSubtotal += subtotal;
        });

        // Calcular el total sin impuesto y mostrarlo en el campo correspondiente
        var totalSinImpuesto = sumaSubtotal;
        document.getElementById("txtTotal").value = totalSinImpuesto.toFixed(2);

        // Calcular el total con impuesto del 13% y mostrarlo en el campo correspondiente
        var impuesto = sumaSubtotal * 0.13;
        var totalConImpuesto = sumaSubtotal + impuesto;
        document.getElementById("txtTotalConImpuesto").value = totalConImpuesto.toFixed(2);
    }
        
         // seleccionar cliente
            function SeleccionarServicio(idServicio, nombre){
                $("#txtIdServicios").val(idServicio);
                $("#txtPrecioSer").val(nombre);
            } 
        
         
        // seleccionar cliente
            function SeleccionarRefaccion(idRefaccion, nombre,Precio,cantidad){
                $("#txtIdRefaccion").val(idRefaccion);
                $("#txtNombreRefaccion").val(nombre);
                $("#txtPrecioRefaccion").val(Precio);
                $("#txtCantidadRefaccion").val(cantidad);
            }        
        
        
           $('#tablaServicios').dataTable({
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
                
                
                   $('#tablaRefaccion').dataTable({
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
                
                function calcularSubtotal() {
    var precio = parseFloat(document.getElementById("txtPrecioRefaccion").value);
    var cantidad = parseInt(document.getElementById("txtCantidadVenta").value);
    var subtotal = precio * cantidad;
    document.getElementById("txtSubtotal").value = subtotal;
    
    // Verificar si la cantidad es mayor que la disponible
    var cantidadDisponible = parseInt(document.getElementById("txtCantidadRefaccion").value);
    if (cantidad > cantidadDisponible) {
        alert("La cantidad deseada supera la cantidad disponible en el inventario.");
        // Puedes reiniciar el campo de cantidad si lo deseas
        document.getElementById("txtCantidadVenta").value = cantidadDisponible;
        document.getElementById("txtSubtotal").value = precio * cantidadDisponible;
    }
}
                function mostrarAlert() {
    // Mostrar un alert con el mensaje
    alert("Factura Creada");
}
// Función para calcular el total
    function calcularTotal() {
        var cantidad = parseFloat(document.getElementById("txtCantidad").value) || 0; // Obtener la cantidad como número, o 0 si no es válido
        var precio = parseFloat(document.getElementById("txtPrecio").value) || 0; // Obtener el precio como número, o 0 si no es válido
        var total = cantidad * precio; // Calcular el total

        // Actualizar el campo "Total" con el nuevo valor calculado
        document.getElementById("txtTotal").value = total.toFixed(2); // Mostrar el total con dos decimales
    }
    
   function calcularTotalConImpuesto() {
    var totalSinImpuesto = <%= total %>;
    var impuesto = totalSinImpuesto * 0.13; // Calcula el 13% de impuesto
    var totalConImpuesto = totalSinImpuesto + impuesto;
    
    // Obtiene el elemento de campo de texto
    var txtfinal = document.getElementById('txtfinal');
    
    // Establece el valor del campo de texto con el total con impuesto
    txtfinal.value = totalConImpuesto.toFixed(2); // Muestra el total con dos decimales
}



 $(document).ready(function () {
        $("#btnBuscar_Ser").click(function () {
            $("#btnGuardar_detalleVentaSer").show();
        });
    });
    
    
    </script>

       <script>
    // cuando el documento esté listo
    $(document).ready(function(){
        $("#form_AgregarFacturaVTS").validate({
            rules: {
                txtIdServicios: { required: true, maxlength: 50 }
            },
            messages: {
                txtIdServicios: "El campo Id es obligatorio",
            },
            errorElement: 'span'
        });
    });
    
    
    
     // Función para calcular el total con impuesto y mostrar el botón "Crear Factura"
    function calcularTotalConImpuesto() {
        var totalSinImpuesto = <%= total %>;
        var impuesto = totalSinImpuesto * 0.13; // Calcula el 13% de impuesto
        var totalConImpuesto = totalSinImpuesto + impuesto;

        // Obtiene el elemento de campo de texto
        var txtfinal = document.getElementById('txtfinal');

        // Establece el valor del campo de texto con el total con impuesto
        txtfinal.value = totalConImpuesto.toFixed(2); // Muestra el total con dos decimales

        // Muestra el botón "Crear Factura" después de calcular el total con impuesto
        var btnCrearFactura = document.getElementById('btn_CrearFactura_final');
        btnCrearFactura.style.display = 'block';
    }
    
</script>
          

    
    </body>
</html>


