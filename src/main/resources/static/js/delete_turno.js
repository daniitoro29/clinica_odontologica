document.getElementById("delete_turno_form").onsubmit = function(e) {
    e.preventDefault();

    const turnoId = document.querySelector('#turno_id').value;

    if (!turnoId) {
        alert("Por favor ingrese el ID del turno.");
        return;
    }

    const url = '/turnos/' + turnoId;
    const settings = {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
        }
    };

    fetch(url, settings)
        .then(() => {
            const successAlert = `
                <div class="alert alert-success alert-dismissible">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Éxito!</strong> Turno eliminado.
                </div>
            `;
            document.querySelector('#response').innerHTML = successAlert;
        })
        .catch(error => {
            const errorAlert = `
                <div class="alert alert-danger alert-dismissible">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Error:</strong> ${error.message}
                </div>
            `;
            document.querySelector('#response').innerHTML = errorAlert;
        });
};
