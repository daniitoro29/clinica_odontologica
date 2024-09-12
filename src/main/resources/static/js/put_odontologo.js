window.addEventListener('load', function () {

    document.getElementById("update_odontologo").addEventListener('submit', function (event) {
        event.preventDefault();

        const id = document.querySelector('#id').value;
        const formData = {
            id: document.querySelector('#id').value,
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            matricula: document.querySelector('#matricula').value
        };

        const url = '/odontologos/' + id;
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
                        '<strong></strong> Odontólogo modificado correctamente </div>';

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
