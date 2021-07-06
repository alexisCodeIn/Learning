var texto = document.getElementById("texto");
var retirar = document.getElementById("retirar");
var reiniciar = document.getElementById("reiniciar");
var resultado = document.getElementById("resultado");
var cajeroDinero = document.getElementById("cajeroDinero");
var cajeroDinTot = document.getElementById("totalDineroCajero");

texto.addEventListener("keypress", retiroPorEnter);
retirar.addEventListener("click", start);
reiniciar.addEventListener("click", cajaReiniciar);

var dinero;
var div;
var papeles;
var entregado = [];
var caja = [];
var cajaTotales = [0];
var billetesNo;

var billetesCantidad = {
  cien: 100,
  cincuenta: 100,
  veinte: 50,
  diez: 100,
  cinco: 150,
  uno: 1000
}


class Billetes{
  constructor(valor, cantidad, id)
  {
    this.valor = valor;
    this.cantidad = cantidad;
    this.id = id;
  }
}

function dineroMeterCajero(){
caja.push(new Billetes(100, billetesCantidad.cien, 1));
caja.push(new Billetes(50, billetesCantidad.cincuenta, 2));
caja.push(new Billetes(20, billetesCantidad.veinte, 3));
caja.push(new Billetes(10, billetesCantidad.diez, 4));
caja.push(new Billetes(5, billetesCantidad.cinco, 5));
caja.push(new Billetes(1, billetesCantidad.uno, 6));
}

dineroMeterCajero();
contarTotal();
dineroMostrarCajero();

function entregadoVaciar(){
  entregado.push(new Billetes(100, 0, 1));
  entregado.push(new Billetes(50, 0, 2));
  entregado.push(new Billetes(20, 0, 3));
  entregado.push(new Billetes(10, 0, 4));
  entregado.push(new Billetes(5, 0, 5));
  entregado.push(new Billetes(1, 0, 6));
}

function dineroMostrarCajero(){
  cajeroDinero.innerHTML = "";
  var i = 0;
  for(x of caja){
    cajaTotales.push(x.cantidad * x.valor);
  }
  for(x of caja)
  {
    i = i + 1;
    cajeroDinero.innerHTML += x.cantidad + " Billetes de $" + x.valor + " = " + cajaTotales[i] + "<br>";
  }
}

function contarTotal()
{
  dineroTotalCajero = 0;
  for(var tot of caja)
  {
    dineroTotalCajero = dineroTotalCajero + tot.valor * tot.cantidad;
  }
  console.log(dineroTotalCajero);
  cajeroDinTot.innerHTML = "<strong>Total: </strong> $" + dineroTotalCajero;
}

function retiroPorEnter(e){
  if (e.key === "Enter") {
    start()
  }
}

function actualizar(){
    dineroMostrarCajero(); contarTotal();
}

function start(){
  entregado.splice(0);
  entregadoVaciar();
  var dinero = parseInt(texto.value);
  if (dinero <= dineroTotalCajero){
  for (var b of caja)
    {
      if(dinero > 0)
    {
      div = Math.floor(dinero / b.valor);
      if(div > b.cantidad)
      {
        papeles = b.cantidad
      }
      else
      {
        papeles = div;
      }
      entregado.splice(b.id-1,1, new Billetes(b.valor, papeles,b.id));
      caja.splice((b.id-1),1,new Billetes(b.valor, b.cantidad - papeles,b.id));
      dinero = dinero - (b.valor * papeles);
    }
  }

  if(dinero > 0)
  {
    resultado.innerHTML = "No tengo suficiente dinero"
  }
  else
  {
    hecho.innerHTML = "";
    hecho.innerHTML += "Haz retirado: <br>";
    resultado.innerHTML = "";
    for(var e of entregado)
    {
      if(e.cantidad > 0)
      {
        resultado.innerHTML += e.cantidad + " billetes de $ " + e.valor + "<br><hr>";
      }
    }
  }
  actualizar();
}
else{
  resultado.innerHTML = "Solo tengo disponible $" + dineroTotalCajero;
}
}

function cajaReiniciar(e){
  hecho.innerHTML = "";
  resultado.innerHTML = "";
  cajeroDinero.innerHTML = "";
  for (b of caja){
  caja.splice((b.id-1),6);
  }
  dineroMeterCajero();
  contarTotal();
  dineroMostrarCajero();
  console.log("reiniciar");
  console.log(caja);
}
