var d = document.getElementById("Dibujito");
var ancho = d.width;
var lienzo = d.getContext("2d");
var texto = document.getElementById("texto");
var boton_Dibujar = document.getElementById("boton_Dibujar");
var boton_Borrar = document.getElementById("boton_Borrar");

boton_Dibujar.addEventListener("click", dibujoPorClick);
texto.addEventListener("keypress", dibujoPorEnter);
boton_Borrar.addEventListener("click", borrarDibujo);



function dibujarLinea(color, grosor, x_inicial, y_inicial, x_final, y_final, amplitudDeSombra, colorSombra)
{
  lienzo.beginPath();
  lienzo.strokeStyle = color;
  lienzo.lineWidth = grosor;
  lienzo.shadowBlur = amplitudDeSombra;
  lienzo.shadowColor = colorSombra;
  lienzo.moveTo(x_inicial, y_inicial);
  lienzo.lineTo(x_final, y_final);
  lienzo.stroke();
  lienzo.closePath();
}

function dibujoPorEnter(e)
  {
    if (e.key === "Enter") {
      dibujoPorClick()
      console.log(e);
    }
  }


function dibujoPorClick()
  {
    var lineas = parseInt(texto.value);
    var l = 0;
    var colorcito = "#963697";
    var color_borde = "#963697";
    var yi, xf;
    var espacio = ancho / lineas;

    while(l < lineas)
      {
        yi = espacio * l
        xf = espacio * (l + 1);
        dibujarLinea(colorcito, 1, 0, yi, xf, ancho, 0, "rgba(255, 175, 255)");
        l = l + 1; // l++ suma +1 a l
        dibujarLinea(color_borde, 3, 0, 0, 0, ancho, 0, "rgba(81, 133, 30)");
        dibujarLinea(color_borde, 3, 0, ancho, ancho, ancho, 0, "rgba(81, 133, 30)");
      }
  }

function borrarDibujo()
  {
    Dibujito.width=Dibujito.width;
  }false;
