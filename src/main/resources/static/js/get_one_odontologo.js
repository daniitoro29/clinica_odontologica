window.addEventListener('load', function () {

    document.getElementById("search_odontologo").addEventListener('submit', function (event) {
        event.preventDefault();

        const id = document.querySelector('#id').value;
        const url = '/odontologos/' + id;

        fetch(url)
            .then(response => {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error("Odontólogo no encontrado");
                }
            })
            .then(data => {
                document.querySelector('#odontologo_nombre').textContent = data.nombre;
                document.querySelector('#odontologo_apellido').textContent = data.apellido;
                document.querySelector('#odontologo_matricula').textContent = data.matricula;

                document.querySelector('#odontologo_info').style.display = "block";
                document.querySelector('#search_response').style.display = "none";
            })
            .catch(error => {
                let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong>' + error.message + '</strong> </div>';

                document.querySelector('#search_response').innerHTML = errorAlert;
                document.querySelector('#search_response').style.display = "block";
                document.querySelector('#odontologo_info').style.display = "none";
            });
    });

});
