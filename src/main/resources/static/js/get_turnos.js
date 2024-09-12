window.addEventListener('load', function () {

    function getTurnos() {
        const url = '/turnos';
        const settings = {
            method: 'GET'
        };

        fetch(url, settings)
        .then(response => response.json())
        .then(data => {
            let turnosTable = document.querySelector('#turnos-list');
            turnosTable.innerHTML = '';

            data.forEach(turno => {
                let turnoRow = `
                    <tr>
                        <td>${turno.id}</td>
                        <td>${turno.odontologo.id}</td>
                        <td>${turno.odontologo.nombre}</td>
                        <td>${turno.odontologo.apellido}</td>
                        <td>${turno.odontologo.matricula}</td>
                        <td>${turno.fecha}</td>
                    </tr>
                `;
                turnosTable.innerHTML += turnoRow;
            });
        })
        .catch(error => {
            let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                             '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                             '<strong>Error al obtener los turnos, intente nuevamente</strong> </div>'

            document.querySelector('#response').innerHTML = errorAlert;
            document.querySelector('#response').style.display = "block";
        });
    }

    getTurnos();

});
