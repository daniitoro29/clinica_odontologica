document.getElementById("search_turno_form").onsubmit = function(e) {
    e.preventDefault();
};

window.addEventListener('load', function () {

    function searchTurnoById(id) {
        const url = `/turnos/${id}`;
        const settings = {
            method: 'GET'
        };

        fetch(url, settings)
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error("No se encontró el turno");
            }
        })
        .then(turno => {
            let turnoResult = document.querySelector('#turno-result');
            turnoResult.innerHTML = `
                <tr>
                    <td>${turno.id}</td>
                    <td>${turno.odontologo.id}</td>
                    <td>${turno.odontologo.nombre}</td>
                    <td>${turno.odontologo.apellido}</td>
                    <td>${turno.odontologo.matricula}</td>
                    <td>${turno.fecha}</td>
                </tr>
            `;
            document.querySelector('#response').style.display = "none";
        })
        .catch(error => {
            let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                             '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                             `<strong>${error.message}</strong> </div>`;

            document.querySelector('#response').innerHTML = errorAlert;
            document.querySelector('#response').style.display = "block";
            document.querySelector('#turno-result').innerHTML = "";
        });
    }

    document.querySelector('#search_turno_form').addEventListener('submit', function(event) {
        event.preventDefault();
        const turnoId = document.querySelector('#turno_id').value;
        searchTurnoById(turnoId);
    });
});
