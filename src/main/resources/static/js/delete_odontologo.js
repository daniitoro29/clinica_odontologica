window.addEventListener('load', function () {

    document.getElementById("delete_odontologo").addEventListener('submit', function (event) {
        event.preventDefault();

        const id = document.querySelector('#id').value;

        const url = '/odontologos/' + id;
        const settings = {
            method: 'DELETE'
        };

        fetch(url, settings)
            .then(response => {
                if (response.ok) {
                    let successAlert = '<div class="alert alert-success alert-dismissible">' +
                        '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                        '<strong></strong> Odontólogo eliminado </div>';

                    document.querySelector('#delete_response').innerHTML = successAlert;
                    document.querySelector('#delete_response').style.display = "block";
                } else {
                    let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                        '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                        '<strong> Error al eliminar</strong> </div>';

                    document.querySelector('#delete_response').innerHTML = errorAlert;
                    document.querySelector('#delete_response').style.display = "block";
                }
            })
            .catch(error => {
                let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong> Error, intente nuevamente</strong> </div>';

                document.querySelector('#delete_response').innerHTML = errorAlert;
                document.querySelector('#delete_response').style.display = "block";
            });
    });

});
