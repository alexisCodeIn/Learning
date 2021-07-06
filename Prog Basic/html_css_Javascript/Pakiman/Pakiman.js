var imagenes = [];
imagenes["Cauchin"] = "vaca.png";
imagenes["Pocacho"] = "pollo.png";
imagenes["Tocinauro"] = "cerdo.png";

var coleccion = [];
coleccion.push(new Pakiman("Cauchin", 100, 30));
coleccion.push(new Pakiman("Pocacho", 80, 50));
coleccion.push(new Pakiman("Tocinauro", 120, 40));

for(var pakimanes of coleccion)
{
  pakimanes.mostrar();
}

console.log(coleccion);
