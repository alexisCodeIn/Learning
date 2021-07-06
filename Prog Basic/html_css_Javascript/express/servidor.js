var express = require("express");
var app = express();

app.get("/", inicio);
app.get("/cursos", cursos);

function inicio(req, res){
  res.send("Hello World GENIAAAAL");
}

function cursos(req, res){
  res.send("Estos son los cursos");
}

app.listen(8989);
