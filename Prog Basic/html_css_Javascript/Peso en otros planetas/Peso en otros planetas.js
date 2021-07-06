var g_tierra = 9.8;
var g_marte = 3.7;
var g_jupiter = 24.8;
var g_mercurio = 3.7;
var g_venus = 8.87;
var g_saturno = 10.44;
var g_neptuno = 11.15;


var Planeta_Elegido = prompt("Elige el numero del planeta en el que te quieres pesar \n 1 = Marte \n 2 = Jupiter \n 3 = Mercurio \n 4 = Venus \n 5 = Saturno \n 6 = Neptuno");
var peso_usuario = prompt ("¿Cuanto Kg Pesas?");

if (Planeta_Elegido==1)
{
  peso_final = peso_usuario * g_marte / g_tierra
  n_planeta = "Marte "
}
if (Planeta_Elegido==2)
{
  peso_final = peso_usuario * g_jupiter / g_tierra
  n_planeta = "Jupiter "
}
if (Planeta_Elegido==3)
{
  peso_final = peso_usuario * g_mercurio / g_tierra
  n_planeta = "Mercurio "
}
if (Planeta_Elegido==4)
{
  peso_final = peso_usuario * g_venus / g_tierra
  n_planeta = "Venus "
}
if (Planeta_Elegido==5)
{
  peso_final = peso_usuario * g_saturno / g_tierra
  n_planeta = "Saturno "
}
if (Planeta_Elegido==6)
{
  peso_final = peso_usuario * g_neptuno / g_tierra
  n_planeta = "Neptuno "
}

//peso_final = parseInt(peso_final)
peso_final = peso_final.toFixed(2)
document.write("Tu peso en " + n_planeta + "es: <strong> " + peso_final + "Kg </strong>");
