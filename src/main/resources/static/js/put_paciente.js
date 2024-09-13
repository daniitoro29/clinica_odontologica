window.addEventListener('load', function () {
    document.getElementById("update_paciente_form").addEventListener('submit', function (event) {
        event.preventDefault();

        const id = document.querySelector('#paciente_id').value;
        const formData = {
            nombre: document.querySelector('#paciente_nombre_updating').value,
            apellido: document.querySelector('#paciente_apellido_updating').value,
            documento: document.querySelector('#paciente_documento_updating').value
        };

        const url = '/pacientes/' + id;
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        };

        fetch(url, settings)
            .then(response => {
                if (response.ok) {
                    let successAlert = '<div class="alert alert-success alert-dismissible">' +
                        '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                        '<strong></strong> Paciente modificado correctamente </div>';

                    document.querySelector('#update_response').innerHTML = successAlert;
                    document.querySelector('#update_response').style.display = "block";
                } else {
                    let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                        '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                        '<strong> Error al modificar</strong> </div>';

                    document.querySelector('#update_response').innerHTML = errorAlert;
                    document.querySelector('#update_response').style.display = "block";
                }
            })
            .catch(error => {
                let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong> Error, intente nuevamente</strong> </div>';

                document.querySelector('#update_response').innerHTML = errorAlert;
                document.querySelector('#update_response').style.display = "block";
            });
    });
});
