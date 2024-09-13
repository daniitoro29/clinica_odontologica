window.addEventListener('load', function () {
    (function() {
        const url = '/pacientes';
        const settings = {
            method: 'GET'
        };

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                const table = document.getElementById("pacienteTable");
                const tbody = table.querySelector("tbody");
                tbody.innerHTML = '';

                data.forEach(paciente => {
                    const pacienteRow = tbody.insertRow();
                    pacienteRow.id = 'tr_' + paciente.id;

                    pacienteRow.innerHTML = `<td class="td_id">${paciente.id}</td>
                                             <td class="td_nombre">${paciente.nombre.toUpperCase()}</td>
                                             <td class="td_apellido">${paciente.apellido.toUpperCase()}</td>
                                             <td class="td_documento">${paciente.dni ? paciente.dni : 'N/A'}</td>
                                             <td>
                                                 <button class="btn btn-primary" onclick="editPaciente(${paciente.id})">Modificar</button>
                                                 <button class="btn btn-danger" onclick="deletePaciente(${paciente.id})">Eliminar</button>
                                             </td>`;
                });
            })
            .catch(error => {
                console.error('Error fetching pacientes:', error);
            });
    })();

    window.editPaciente = function(id) {
        fetch('/pacientes/' + id)
            .then(response => response.json())
            .then(data => {
                document.getElementById('paciente_id').value = data.id;
                document.getElementById('paciente_nombre_updating').value = data.nombre;
                document.getElementById('paciente_apellido_updating').value = data.apellido;
                document.getElementById('paciente_documento_updating').value = data.documento;
                document.getElementById('div_paciente_updating').style.display = 'block';
            })
            .catch(error => {
                console.error('Error fetching paciente:', error);
            });
    };

    window.deletePaciente = function(id) {
        if (confirm('¿Estás seguro de que deseas eliminar este paciente?')) {
            fetch('/pacientes/' + id, { method: 'DELETE' })
                .then(response => {
                    if (response.ok) {
                        document.getElementById('tr_' + id).remove();
                        alert('Paciente eliminado exitosamente');
                    } else {
                        alert('Error al eliminar el paciente');
                    }
                })
                .catch(error => {
                    console.error('Error deleting paciente:', error);
                });
        }
    };
});
