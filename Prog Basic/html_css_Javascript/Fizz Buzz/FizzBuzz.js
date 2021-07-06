//Numeros del 1 al 100. Si es / 3 Fizz; Si es / 5 Buzz; Si ambos Fizz Buzz.
var limite = 100;
var i = 1;
var div_1 = 3;
var div_2 = 5;

for ( i; i <= limite; i++)
{
  if(esDivisible(i,div_1))
  {
    document.write("Fizz");
    divisible = true;
  }
  if (esDivisible(i,div_2))
  {
    document.write("Buzz");
  }
  if (!esDivisible(i,div_1) && !esDivisible(i,div_2))
  {
    document.write(i);
  }
    document.write("<br>");
}

function esDivisible(num,divisor)
{
  if(num % divisor == 0)
    {
      return true;
    }
  else
    {
      return false;
    }
}
