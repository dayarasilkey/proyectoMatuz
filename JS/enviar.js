$(document).ready(function() {
  $('#agregar').on('click', function() {
      let datos = {
        id_usuario: $('#id_usuario').val(),
        nombre: $('#nombre').val(),
        apellido: $('#apellido').val(),
        numdocumento: $('#numdocumento').val(),
        direccion: ($('#direccion').val()),
        telefono: $('#telefono').val(),
        email: $('#email').val(),
        contraseña: $('#contraseña').val()
      };

      let cod=$('#id_rol').val()
    
      var datosEnvio = JSON.stringify(datos);
      console.log(datosEnvio);
    
      $.ajax({
        url: 'http://localhost:8080/agregarUsuario/'+cod,
        type: 'POST',
        data: datosEnvio,
        contentType: 'application/json',
        dataType: 'json',
        success: function(respuesta) {
          alert(respuesta);
        },
        error: function(xhr, status, error) {
          console.error('Error al agregar el cliente');
        }
    });
  });
})