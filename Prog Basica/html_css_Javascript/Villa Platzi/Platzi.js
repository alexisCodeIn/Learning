var vp = document.getElementById("villaplatzi");
var papel = vp.getContext("2d");

var fondo =
{
    url: "tile.png",
    cargaOk: false
};

var vaca =
{
    url: "vaca.png",
    cargaOk: false
};
var vacaX = new (Array);
var vacaY = new (Array);

var cerdo =
{
    url: "cerdo.png",
    cargaOk: false
};
var cerdoX = new (Array);
var cerdoY = new (Array);

console.log(cerdoX);

var pollo =
{
    url: "pollo.png",
    cargaOk: false
};
var polloX = new (Array);
var polloY = new (Array);

var lobo =
{
  url: "lobo.png",
  cargaOk: false,
};
var loboX = new Array();
var loboY =  new Array();

var loboOpcionesDeInicio = Math.ceil(Math.random() * (3));

  if(loboOpcionesDeInicio == 1){var loboX = 10; var loboY = 10}
  if(loboOpcionesDeInicio == 2){var loboX = 10; var loboY = 400}
  if(loboOpcionesDeInicio == 3){var loboX = 420; var loboY = 10}

var numeroVacas = aleatorio(1,10);
console.log("No.Vacas = " + numeroVacas);

var numeroCerdos = aleatorio(1,10);
console.log("No.Cerdos = " + numeroCerdos);

var numeroPollos = aleatorio(1,10);
console.log("No.Pollos = " + numeroPollos);

fondo.imagen = new Image();
fondo.imagen.src = fondo.url;
fondo.imagen.addEventListener("load", cargarFondo);

vaca.imagen = new Image();
vaca.imagen.src = vaca.url;
vaca.imagen.addEventListener("load", cargarVaca);

cerdo.imagen = new Image();
cerdo.imagen.src = cerdo.url;
cerdo.imagen.addEventListener("load", cargarCerdo);

pollo.imagen = new Image();
pollo.imagen.src = pollo.url;
pollo.imagen.addEventListener("load", cargarPollo);

lobo.imagen = new Image();
lobo.imagen.src = lobo.url;
lobo.imagen.addEventListener("load", cargarLobo);


function cargarFondo()
{
  fondo.cargaOk = true;
  dibujar();
}

function cargarVaca()
{
  vaca.cargaOk = true;
  mantenerPosicion();
}

function cargarCerdo()
{
  cerdo.cargaOk = true;
  mantenerPosicion();
}

function cargarPollo()
{
  pollo.cargaOk = true;
  mantenerPosicion();
}

function cargarLobo()
{
  lobo.cargaOk = true;
  if (fondo.dibujado == true)
  {
    dibujar();
  }
}

function mantenerPosicion()
{
  if (vaca.cargaOk)
  {
      for (var i = 0; i < numeroVacas; i++)
        {
          var x = aleatorio(1, 6);
          var y = aleatorio(1, 6);
          var x = x * 70;
          var y = y * 70;
          vacaX[i] = x;
          vacaY[i] = y;
        }
  }

  if (cerdo.cargaOk)
    {
    for (var i = 0; i < numeroCerdos; i++)
      {
        var x = aleatorio(1, 6);
        var y = aleatorio(1, 6);
        var x = x * 70;
        var y = y * 70;
        cerdoX[i] = x;
        cerdoY[i] = y;
      }
    }

    if (pollo.cargaOk)
    {
      for (var i = 0; i < numeroPollos; i++)
        {
          var x = aleatorio(1, 6);
          var y = aleatorio(1, 6);
          var x = x * 70;
          var y = y * 70;
          polloX[i] = x;
          polloY[i] = y;        }
      }
      dibujar();
    }

function dibujar (evento)
{
  if (fondo.cargaOk) {
    papel.drawImage(fondo.imagen, 0,0);
    fondo.dibujado = true;
  }

  if (fondo.dibujado == true) {
    for(var i=0; i < numeroVacas; i++){
    papel.drawImage(vaca.imagen, vacaX[i], vacaY[i]);
    vaca.dibujado = true;
    }
  }

   if (fondo.dibujado == true) {
     for (var i = 0; i < numeroCerdos; i++){
       papel.drawImage(cerdo.imagen, cerdoX[i], cerdoY[i]);
       cerdo.dibujado = true;
     }
   }

   if (fondo.dibujado == true){
    for (var i = 0; i < numeroPollos; i++){
    papel.drawImage(pollo.imagen, polloX[i], polloY[i]);
    pollo.dibujado = true;
    }
  }

  if (fondo.dibujado == true){
    papel.drawImage(lobo.imagen, loboX, loboY)
    lobo.dibujado = true
      }
}

document.addEventListener("keydown", moverLobo);

function moverLobo(evento) {
  var movimiento = 10;
  var teclas = {
    UP: 38,
    DOWN: 40,
    LEFT: 37,
    RIGHT: 39
  };

  switch (evento.keyCode) {
    case teclas.UP:
      if (loboY > 0) {
        loboY = loboY - movimiento;
        dibujar();
      }
    break;
    case teclas.DOWN:
      if (loboY < 450) {
        loboY = loboY + movimiento;
        dibujar();
      }
    break;
    case teclas.LEFT:
      if (loboX > 0) {
        loboX = loboX - movimiento;
        dibujar();
      }
    break;
    case teclas.RIGHT:
      if(loboX < 450) {
        loboX = loboX + movimiento;
        dibujar();
      }
    break;
      console.log("Otra tecla : " + evento.key);
    break;
  }
}


function aleatorio (min, max)
{
  var resultado;
  resultado = Math.floor(Math.random() * (max - min + 1)) + min;
  return resultado;
}
