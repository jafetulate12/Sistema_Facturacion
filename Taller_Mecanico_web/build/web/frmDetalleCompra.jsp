<%--
    Document   : frmDetalleCompra
    Created on : 07-sep-2023, 20:56:17
    Author     : Usuario
--%>

<%@page import="Entidades.Refaccion"%>
<%@page import="LogicaNegocios.LNRefaccion"%>
<%@page import="LogicaNegocios.LNDetalleCompra"%>
<%@page import="Entidades.DetalleCompra"%>
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
    <title>Detalle Compra</title>
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
        <h1 class="mt-4">Factura de Compra - Taller Mecánico</h1>
        <form action="CrearDetalleCompra" method="post" id="form_AgregarDetalle">
        <div class="form-group">
            <div class="input-group">
                <%
                    DetalleCompra detallecompra;
                    LNDetalleCompra logicaD = new LNDetalleCompra();
                    detallecompra =new DetalleCompra();
                %>
                <!-- Campo de texto donde mostrar el resultado -->
                <input type="number" id="txtIdProducto" name="txtIdProducto" value="<%detallecompra.getIdRefaccion();%>" readonly="" class="form-control"/>
                <input type="text" id="txtDescripcion" name="txtDescripcion" value="" readonly="" class="form-control" placeholder="Seleccionar un Producto"/>
                <a id="btnBuscarPro" class="btn btn-success" data-toggle="modal" data-target="#buscarProducto">
                    <i class="fas fa-search"></i>
                </a>
                <input type="number" id="txtCantidad" name="txtCantidad" value=" <%detallecompra.getCantidad();%>" class="form-control" placeholder="Cantidad" oninput="calcularTotal()"/>
                <input type="number" id="txtPrecio" name="txtPrecio" value="true" readonly class="form-control" placeholder="Precio"/>
                <input type="number" id="txtTotal" name="txtTotal" value="<%detallecompra.getSubtotal();%>"  class="form-control" placeholder="Total"/>
            </div>
        </div>
        <br/>
        <div class="form-group">
            <input type="submit" id="btnGuardar_detalle" name="Guardar_d" value="Guardar Producto" class="btn btn-primary" onclick="agregarDetalle()"/>
        </div>
        <table class="table">
            <thead>
                <tr id="titulos">
                    <th>Código</th>
                    <th>Id_Factura</th>
                    <th>Id_Refaccion</th>
                    <th>Cantidad</th>
                    <th>SubTotal</th>
                    <th>Opciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    String condicion="";
                    List<DetalleCompra> datos;
                    datos=logicaD.ListarDetalleCompra_list(condicion);
                    double total = 0.0; // Inicializar el total
                    for(DetalleCompra registro:datos){
                %>
                <tr> 
                    <% int codigo = registro.getIdDetalleCompra(); %>
                    <td> <%= codigo %> </td>
                    <td> <%= registro.getIdFacturaCompra()%> </td>
                    <td> <%= registro.getIdRefaccion()%> </td>
                    <td> <%= registro.getCantidad()%> </td>
                    <td> <%= registro.getSubtotal()%> </td>
                    <td> 
                        <a href="EliminarDetalleCompra?idCliente=<%=codigo%>"> <i class="fas fa-trash-alt" onclick="eliminarDetalle(<%=codigo%>)"></i></a>
                    </td>
                </tr>
                <% 
                    total += registro.getSubtotal(); // Sumar al total
                } %>
            </tbody>
        </table>
    </form>
    
    <form action="ActualizarFacturaCompra" method="post" >
        <!-- Agrega un espacio para mostrar el total -->
        <div class="form-group float-right">
            <div id="total-container">
                Total: <span id="total-amount"><%= total %></span>
            </div>
            <!-- Agrega un botón para calcular el total con 13% de impuesto -->
       <input type="button" value="Calcular Con Impuesto" name="calcularimpuesto" class="btn btn-info" placeholder="Calcular Con Impuesto" onclick="calcularTotalConImpuesto(); mostrarBotonCrearFactura();" />
            <input type="text" id="txtfinal" name="txtfinal" value="<% detallecompra.getPrecioFinal();%>"  readonly />
        </div>
        <input type="submit" id="btn_CrearFactura_final" name="Guardar_Final" value="Crear Factura" class="btn btn-warning" style="display: none;" onclick="mostrarAlert()" />
    </form>
    </div>
    <footer class="border-top">
        <div class="container">
            &copy; Taller Mecánico Jafet Ulate
        </div>
    </footer>
    
    <!-- modal buscar producto -->
    <div class="modal" id="buscarProducto" tabindex="1" role="dialog" aria-labelledby="tituloVentana">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <H5 id="tituloVentana">Buscar Productos</H5>
                    <button class="close" data-dismiss="modal" arial-label="cerrar" arial-hidden="true" onclick="Limpiar()">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <table id="tablaRef">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Codigo</th>
                                <th>Nombre</th>
                                <th>Precio</th>
                                <th>Seleccionar</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                LNRefaccion logica_r= new LNRefaccion();
                                List<Refaccion> datorefaccion;
                                datorefaccion=logica_r.ListarRefaccion_List("");
                                for(Refaccion registroC:datorefaccion){
                            %>
                            <tr>
                                <%int IdC = registroC.getIdRefaccion();
                                String CodigoC = registroC.getCodigo();
                                String NombreC = registroC.getNombre();
                                double PrecioC = registroC.getPrecio();
                                %>
                                <td><%=IdC%></td>
                                <td><%=CodigoC%></td>
                                <td><%=NombreC%></td>
                                <td><%=PrecioC%></td>
                                <td>
                                    <a href="#" data-dismiss="modal" onclick="SeleccionarRefaccion('<%=IdC%>','<%=NombreC%>','<%=PrecioC%>');">
                                        Seleccionar
                                    </a> 
                                </td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
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
    </script>
    <script>
        // seleccionar producto
        function SeleccionarRefaccion(idRefaccion, nombre,precio){
            $("#txtIdProducto").val(idRefaccion);
            $("#txtDescripcion").val(nombre);
            $("#txtPrecio").val(precio);
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

    // Llama a la función para mostrar el botón "Crear Factura"
    mostrarBotonCrearFactura();
}
    
        function mostrarAlert() {
            // Mostrar un alert con el mensaje
            alert("Factura Creada");
        }
        
         // Función para hacer visible el botón "Crear Factura"
    function mostrarBotonCrearFactura() {
        var btnCrearFactura = document.getElementById('btn_CrearFactura_final');
        btnCrearFactura.style.display = 'block';
    }
    
    
    
    </script>
</body>
</html>
