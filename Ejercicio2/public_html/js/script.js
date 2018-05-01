
$(document).ready(function() {
    var error = 0;
    
    $.ajax({
        method: "POST",
        url: "http://187.188.122.85:8091/NutriNET/Cliente",
        timeout: 3000,
        data: {Nombre: "Edgar", Apellidos: "Arredondo Basurto", Nombre_Usuario: "earredondo", Correo_Electronico: "earredondo@hotmail.com", Contraseña: "qwerty"},
        success: function(respuesta){
            alert(respuesta);
        },
        error: function(request, status, err) {
            if (status == "timeout") {
                if(error == 0){
                    error = 1;
                    alert('No hay respuesta del servidor.');
                }   
            } else {
                alert("Error: " + request + status + err);
            }
        }
    });

    $.ajax({
        method: "GET",
        url: "http://187.188.122.85:8091/NutriNET/Cliente",
        timeout: 3000,
        success: function(resultado){
            $.each(resultado, function(i, obj) {
                $("#clientes-tabla").find('tbody')
                    .append($('<tr>')
                        .append($('<td>')
                            .append(obj.ID
                            )
                        )
                        .append($('<td>')
                            .append(obj.Nombre
                            )
                        )
                        .append($('<td>')
                            .append(obj.Apellidos
                            )
                        )
                        .append($('<td>')
                            .append(obj.Nombre_Usuario
                            )
                        )
                        .append($('<td>')
                            .append(obj.Correo_Electronico
                            )
                        )
                        .append($('<td>')
                            .append(obj.Contraseña
                            )
                        )
                    );
            });
        },
        error: function(request, status, err) {
            if (status == "timeout") {
                if(error == 0){
                    error = 1;
                    alert('No hay respuesta del servidor.');
                }
            } else {
                alert("Error: " + request + status + err);
            }
        } 
    });
    
    $.ajax({
        method: "PUT",
        url: "http://187.188.122.85:8091/NutriNET/Cliente/59",
        timeout: 3000,
        data: {Edad: "39", Estatura: "1.80", Peso: "60", GEB: "1500"},
        success: function(resultado){
            alert(resultado);
        },
        error: function(request, status, err) {
            if (status == "timeout") {
                if(error == 0){
                    error = 1;
                    alert('No hay respuesta del servidor.');
                }
            } else {
                alert("Error: " + request + status + err);
            }
        } 
    });
    
});