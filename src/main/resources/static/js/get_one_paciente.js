window.addEventListener('load', function () {
    document.getElementById("search_paciente").addEventListener('submit', function (event) {
        event.preventDefault();

        const id = document.querySelector('#id').value;
        const url = '/pacientes/' + id;

        fetch(url)
            .then(response => {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error("Paciente no encontrado");
                }
            })
            .then(data => {
                document.querySelector('#paciente_nombre').textContent = data.nombre;
                document.querySelector('#paciente_apellido').textContent = data.apellido;
                document.querySelector('#paciente_documento').textContent = data.documento;

                document.querySelector('#paciente_info').style.display = "block";
                document.querySelector('#search_response').style.display = "none";
            })
            .catch(error => {
                let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong>' + error.message + '</strong> </div>';

                document.querySelector('#search_response').innerHTML = errorAlert;
                document.querySelector('#search_response').style.display = "block";
                document.querySelector('#paciente_info').style.display = "none";
            });
    });
});
