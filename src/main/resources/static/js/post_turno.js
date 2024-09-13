document.getElementById("add_new_turno").onsubmit = function(e) {
    e.preventDefault();
};

window.addEventListener('load', function () {

    const formulario = document.querySelector('#add_new_turno');

    formulario.addEventListener('submit', function (event) {

        const formData = {
            odontologo: {
                id: document.querySelector('#odontologo_id').value,
            },
/*            paciente: {
                id: document.querySelector('#paciente_id').value,
            },*/
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
        .then(response => {
            if (!response.ok) {
                return response.json().then(errorData => {
                    throw new Error(errorData.message || 'Error desconocido');
                });
            }
            return response.json();
        })
        .then(data => {
            let successAlert = '<div class="alert alert-success alert-dismissible">' +
                '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                '<strong></strong> Turno agregado correctamente</div>';

            document.querySelector('#response').innerHTML = successAlert;
            document.querySelector('#response').style.display = "block";
        })
        .catch(error => {
            let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                '<strong>Por favor verifique los datos ingresados.:</strong></div>';

            document.querySelector('#response').innerHTML = errorAlert;
            document.querySelector('#response').style.display = "block";
        });
    });


    (function() {
        let pathname = window.location.pathname;
        if (pathname === "/") {
            document.querySelector(".nav .nav-item a:first").classList.add("active");
        } else if (pathname == "turnoList.html") {
            document.querySelector(".nav .nav-item a:last").classList.add("active");
        }
    })();
});
