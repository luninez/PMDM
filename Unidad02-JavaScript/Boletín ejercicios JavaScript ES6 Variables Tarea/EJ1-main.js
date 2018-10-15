//INICIAMOS DPS DEL HTML
window.onload = function(){

  //guardamos el aleatorio generado
  var rnd1 = parseInt(getRandomArbitrary(1,10));
  var rnd2 = parseInt(getRandomArbitrary(0,1));
  var rnd3 = parseInt(getRandomArbitrary(1,10));

  //pintamos el num1 aleatorio en html
  var num1 = document.querySelector("#x");
  num1.innerHTML = rnd1;

  //1. pintamos el op correspondiente
  //2. calculamos la operacion
  var operador = document.querySelector("#op");
  operador.innerHTML = rnd2;
  var result;

 //comprobamos que op es
//function getOperador(rnd2){
  if(rnd2 == 0){
    operador.innerHTML = "+";
     result = getSumar(rnd1, rnd3);
  }else{
    operador.innerHTML = "-";
     result = getRestar(rnd1, rnd3);
  }
//}

  //pintamos el num2 aleatorio en html
  var num2 = this.document.querySelector("#y");
  num2.innerHTML = rnd3;

  //comprobamos el resultado
  var btnEnvio = document.querySelector("#ok");
  var respuestaUsu = document.querySelector("#solucion");

  btnEnvio.onclick = function(event) { 
      console.log("usuario "+respuestaUsu.value);
      console.log("resultado " + result);
    if(result == null){
      alert('Introduce algo por favor.')
    }else{
      if(result == parseInt(respuestaUsu.value)){
        alert('Eres persona.');
      }else{
        alert('Eres marciano.');
      }
    }
  }
}//fin onload

//funcion para generar un numero rando
function getRandomArbitrary(min, max) {
  return Math.random() * (max - min) + min;
}

//funcion para sumar dos numeros
function getSumar(num1, num2){
return num1 + num2;
}

//funcion para restar dos numeros
function getRestar(num1, num2){
return num1 - num2;
}