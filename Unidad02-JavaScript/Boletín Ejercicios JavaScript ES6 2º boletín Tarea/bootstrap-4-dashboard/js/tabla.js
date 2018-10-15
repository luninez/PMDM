$(document).ready(function(){

    //AÑADIR FILA
    $("#add").click(function(){
        ('#tabla tr:last').after('<tr><td>Cuatro</td></tr>');
    });
    
    //ELIMINAR FILA
    function deleteAlum(i) {
        document.getElementsByTagName("table")[0].setAttribute("", "tableid");
        document.getElementById("tableid").deleteRow(i);
    }

    //EDITAR ALUMNO
    $(document).on("click","#edit",function(){
        let tdNombre = $(this).closest("tr").find("td").first(); //.html('<input type="text" value=""/>');
        let tdApellidos = $(this).closest("tr").find("td:nth-child(2)");
        let tdClase = $(this).closest("tr").find("td:nth-child(3)");
        
        tdNombre.html(`<input id="input-nombre" type="text" value="${tdNombre.text()}" />`);
        tdApellidos.html(`<input id="input-apellidos" type="text" value="${tdApellidos.text()}" />`);
        tdClase.html(`<input id="input-clase" type="text" value="${tdClase.text()}" />`);

        // OCulto el botón Editar y añado el botón guardar
        $(this).parent().find("#edit").css("display","none");// lo ocultamos
        $(this).parent().append('<button id="btn-guardar-alumno" class="btn btn-primary">Guardar</button>');//añadimos guardar

    });

    //cambiamos el boton guardar
    $(document).on("click", "#btn-guardar-alumno", function () {
        let nombre = $("#input-nombre").val();
        let apellidos = $("#input-apellidos").val();
        let clase = $("#input-clase").val();

        $(this).closest("tr").find("td:nth-child(1)").html(nombre);
        $(this).closest("tr").find("td:nth-child(2)").html(apellidos);
        $(this).closest("tr").find("td:nth-child(3)").html(clase);

        // Restauro el botón Editar
        $(this).parent().find('.btn-editar-alumno').css("display","block");

        // Elimino el botón guardar
        $(this).remove();
    });

});
