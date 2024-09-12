window.addEventListener('load', function () {

    // Función para manejar la eliminación de un odontólogo
    document.getElementById("delete_odontologo").addEventListener('submit', function (event) {
        event.preventDefault();

        // Obtener el ID del odontólogo desde el formulario
        const id = document.querySelector('#id').value;

        // Construir la URL para la solicitud DELETE
        const url = '/odontologos/' + id;
        const settings = {
            method: 'DELETE'
        };

        // Realizar la solicitud DELETE con fetch
        fetch(url, settings)
            .then(response => {
                if (response.ok) {
                    // Mostrar mensaje de éxito si la respuesta es correcta
                    let successAlert = '<div class="alert alert-success alert-dismissible">' +
                        '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                        '<strong></strong> Odontólogo eliminado </div>';

                    document.querySelector('#delete_response').innerHTML = successAlert;
                    document.querySelector('#delete_response').style.display = "block";
                } else {
                    // Mostrar mensaje de error si la respuesta no es correcta
                    let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                        '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                        '<strong> Error al eliminar</strong> </div>';

                    document.querySelector('#delete_response').innerHTML = errorAlert;
                    document.querySelector('#delete_response').style.display = "block";
                }
            })
            .catch(error => {
                // Mostrar mensaje de error si ocurre un problema con la solicitud
                let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong> Error, intente nuevamente</strong> </div>';

                document.querySelector('#delete_response').innerHTML = errorAlert;
                document.querySelector('#delete_response').style.display = "block";
            });
    });

});
