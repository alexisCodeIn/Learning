var teclas = {
  UP: 38,
  DOWN: 40,
  LEFT: 37,
  RIGHT: 39
};

var cuadrito = document.getElementById("area_de_dibujo");
var papel = cuadrito.getContext("2d");
papel.fillStyle = "red";
papel.fillRect(0, 0, cuadrito.width, cuadrito.height);
var x = 151;
var y = 151;

dibujarLinea("yellow", x - 1, y - 1, x + 1, y + 1, 0, 0, papel); //Central Point

document.addEventListener("keydown", dibujarTeclado);
cuadrito.addEventListener("mousedown", dibujarMouse);
cuadrito.addEventListener("mouseup", dibujarMouse);
cuadrito.addEventListener("mousemove", dibujarMouse);

function dibujarLinea(color, x_inicial, y_inicial, x_final, y_final, amplitudDeSombra, colorSombra, lienzo)
{
  lienzo.beginPath();
  lienzo.strokeStyle = color;
  lienzo.lineWidth = 3;
  lienzo.shadowBlur = amplitudDeSombra;
  lienzo.shadowColor = colorSombra;
  lienzo.moveTo(x_inicial, y_inicial);
  lienzo.lineTo(x_final, y_final);
  lienzo.stroke();
  lienzo.closePath();
}

function dibujarMouse(evento)
  {
    if (evento.buttons == 1)
      {
        var colorcito = "white";
        var movimiento = 2;
        var mouse_x = evento.offsetX;
        var mouse_y = evento.offsetY;
        dibujarLinea(colorcito, mouse_x, mouse_y, mouse_x + movimiento, mouse_y + movimiento, 0, 0, papel);
        var coor = "Coordenadas: ("+ mouse_x +","+ mouse_y +")";
        document.getElementById("showCoor").innerHTML = coor; //innerHTML para cambiar contenido en html
      }
        console.log(evento);
  }

  function clearCoor() {
    document.getElementById("showCoor").innerHTML = "";
  }

function dibujarTeclado(evento)
{
  var colorcito = "white";
  var movimiento = 1;

  switch (evento.keyCode)//switch es como if pero para declarar una misma accion en diferentes condiciones

  {
    case teclas.UP:
    dibujarLinea(colorcito, x, y, x, y - movimiento, 0, 0, papel);
    console.log("UP");
    y = y - movimiento;
      break;

    case teclas.DOWN:
    dibujarLinea(colorcito, x, y, x, y + movimiento, 0, 0, papel);
      y = y + movimiento;
      console.log("DOWN");
      break;

    case teclas.LEFT:
    dibujarLinea(colorcito, x, y, x - movimiento, y, 0, 0, papel);
      x = x - movimiento;
      console.log("LEFT");
      break;

    case teclas.RIGHT:
    dibujarLinea(colorcito, x, y, x + movimiento, y, 0, 0, papel);
      x = x + movimiento;
      console.log("RIGHT");
  }
}
