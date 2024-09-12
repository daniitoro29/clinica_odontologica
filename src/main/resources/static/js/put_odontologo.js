window.addEventListener('load', function () {

    // Función para manejar la modificación de un odontólogo
    document.getElementById("update_odontologo").addEventListener('submit', function (event) {
        event.preventDefault();

        // Obtener el ID y los nuevos datos del formulario
        const id = document.querySelector('#id').value;
        const formData = {
            id: document.querySelector('#id').value,
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            matricula: document.querySelector('#matricula').value
        };

        // Construir la URL para la solicitud PUT
        const url = '/odontologos/' + id;
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        };

        // Realizar la solicitud PUT con fetch
        fetch(url, settings)
            .then(response => {
                if (response.ok) {
                    // Mostrar mensaje de éxito si la respuesta es correcta
                    let successAlert = '<div class="alert alert-success alert-dismissible">' +
                        '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                        '<strong></strong> Odontólogo modificado correctamente </div>';

                    document.querySelector('#update_response').innerHTML = successAlert;
                    document.querySelector('#update_response').style.display = "block";
                } else {
                    // Mostrar mensaje de error si la respuesta no es correcta
                    let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                        '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                        '<strong> Error al modificar</strong> </div>';

                    document.querySelector('#update_response').innerHTML = errorAlert;
                    document.querySelector('#update_response').style.display = "block";
                }
            })
            .catch(error => {
                // Mostrar mensaje de error si ocurre un problema con la solicitud
                let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong> Error, intente nuevamente</strong> </div>';

                document.querySelector('#update_response').innerHTML = errorAlert;
                document.querySelector('#update_response').style.display = "block";
            });
    });

});
