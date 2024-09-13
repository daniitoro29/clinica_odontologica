document.getElementById("add_new_turno").onsubmit = function(e) {
    e.preventDefault();
};

window.addEventListener('load', function () {

    const formulario = document.querySelector('#add_new_turno');

    formulario.addEventListener('submit', function (event) {

        const formData = {
            odontologo: {
                id: document.querySelector('#odontologo_id').value,
                nombre: document.querySelector('#odontologo_nombre').value,
                apellido: document.querySelector('#odontologo_apellido').value,
                matricula: document.querySelector('#odontologo_matricula').value
            },
            paciente: {
                id: document.querySelector('#paciente_id').value,
                nombre: document.querySelector('#paciente_nombre').value,
                apellido: document.querySelector('#paciente_apellido').value,
                dni: document.querySelector('#paciente_dni').value
            },
            fecha: document.querySelector('#fecha').value
        };

        const url = '/turnos';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        };

        fetch(url, settings)
        .then(response => response.json())
        .then(data => {
            let successAlert = '<div class="alert alert-success alert-dismissible">' +
                '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                '<strong></strong> Turno agregado correctamente</div>';

            document.querySelector('#response').innerHTML = successAlert;
            document.querySelector('#response').style.display = "block";
            resetUploadForm();

        })
        .catch(error => {
            let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                '<strong>Error, intente nuevamente</strong> </div>';

            document.querySelector('#response').innerHTML = errorAlert;
            document.querySelector('#response').style.display = "block";
            resetUploadForm();
        });
    });

    function resetUploadForm() {
        document.querySelector('#odontologo_id').value = "";
        document.querySelector('#odontologo_nombre').value = "";
        document.querySelector('#odontologo_apellido').value = "";
        document.querySelector('#odontologo_matricula').value = "";
        document.querySelector('#paciente_id').value = "";
        document.querySelector('#paciente_nombre').value = "";
        document.querySelector('#paciente_apellido').value = "";
        document.querySelector('#paciente_dni').value = "";
        document.querySelector('#fecha').value = "";
    }

    (function() {
        let pathname = window.location.pathname;
        if (pathname === "/") {
            document.querySelector(".nav .nav-item a:first").classList.add("active");
        } else if (pathname == "turnoList.html") {
            document.querySelector(".nav .nav-item a:last").classList.add("active");
        }
    })();
});
