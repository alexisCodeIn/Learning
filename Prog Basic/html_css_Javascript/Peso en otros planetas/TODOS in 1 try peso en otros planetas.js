var g_tierra = 9.8;
var g_marte = 3.7;
var g_jupiter = 24.8;
var g_mercurio = 3.7;
var g_venus = 8.87;
var g_saturno = 10.44;
var g_neptuno = 11.15;

var peso_usuario = prompt("Calculemos tu peso en todos los planetas del sistema solar \n ¿Cuantos Kilogramos pesas en la tierra?");

peso_usuario_marte = peso_usuario * g_marte / g_tierra
peso_usuario_marte = peso_usuario_marte.toFixed(1)

peso_usuario_jupiter = peso_usuario * g_jupiter / g_tierra
peso_usuario_jupiter = peso_usuario_jupiter.toFixed(1)

peso_usuario_mercurio = peso_usuario * g_mercurio / g_tierra
peso_usuario_mercurio = peso_usuario_mercurio.toFixed(1)

peso_usuario_venus = peso_usuario * g_venus / g_tierra
peso_usuario_venus = peso_usuario_venus.toFixed(1)

peso_usuario_saturno = peso_usuario * g_saturno / g_tierra
peso_usuario_saturno = peso_usuario_saturno.toFixed(1)

peso_usuario_neptuno = peso_usuario * g_neptuno / g_tierra
peso_usuario_neptuno = peso_usuario_neptuno.toFixed(1)


document.write(
  "Tu peso en la tierra es: <strong>" + peso_usuario + "Kg </strong> <br> " +
  "Tu peso en Marte es <strong>" + peso_usuario_marte + "Kg </strong> <br>" +
  "Tu peso en Jupiter es <strong>" + peso_usuario_jupiter + "Kg </strong> <br>" +
  "Tu peso en Mercurio es <strong>" + peso_usuario_mercurio + "Kg </strong> <br>" +
  "Tu peso en Venus es <strong>" + peso_usuario_venus + "Kg </strong> <br>" +
  "Tu peso en Saturno es <strong>" + peso_usuario_saturno + "Kg </strong> <br>" +
  "Tu peso en Neptuno es <strong>" + peso_usuario_neptuno + "Kg </strong> <br>"
  );
