//INICIAMOS DPS DEL HTML
window.onload = function(){

    //creamos los arrays
    var arrayPosition = new Array(document.querySelector("#x"), document.querySelector("#y"), 
                                 document.querySelector("#z"), document.querySelector("#w"));

    var rndIPos = parseInt(getRandomArbitrary(0, 3));

    var rndITema = parseInt(getRandomArbitrary(0, 2));
    //nos aseguramos de que los temas sean distintos
    do{
      var rndTema = parseInt(getRandomArbitrary(0, 2));
    }while(rndITema == rndTema);

    var rndMal = parseInt(getRandomArbitrary(0, 4));
    var rndOk = parseInt(getRandomArbitrary(0, 4));
    var rndOKtmp = 0;

    var temaMal = getTema(rndITema);
    var temaOK = getTema(rndTema);
      
    var mal = temaMal[rndMal];
    //colocamos el incorrecto
    arrayPosition[rndIPos].innerHTML = mal;

    //rellenamos las demas posiciones
    for(var i = 0; i < arrayPosition.length; i++){
      if(i != rndIPos){
        if(rndOKtmp != rndOk){
          var bien = temaOK[rndOk];
          arrayPosition[i].innerHTML = bien;         
        }//fin if
      }//fin if
      //CUANDO SE SALTA LA POSICION INCORRECTA, ENTONCES YA NO SE CONTROLA QUE NO SE REPITA
      //actualizamos el valor del random
      rndOKtmp = rndOk;
      do{
        rndOk = parseInt(getRandomArbitrary(0, 4));
      }while(rndOKtmp == rndOk);
    }//fin for
    
    //PINTA EL ARRAY PERO PASA DEL HTML
    //pintamos el array de posiciones
    //arrayPosition.forEach(function(element){
      //document.write(element);
    //});

    //comprobamos el resultado
    var btnEnvio = document.querySelector("#ok");
    var respuestaUsu = document.querySelector("#solucion");

    btnEnvio.onclick = function(event) { 
      if(respuestaUsu == null){
        alert('Introduce algo por favor.')
        //NO SE COMPARAN BIEN LOS DOS STRING
      }else if(mal.valueOf() == respuestaUsu.valueOf()){
          alert('Eres persona.');
        }else{
          alert('Eres marciano.');
        }
      }

  }//fin onload
  
  //funcion para generar un numero rando
  function getRandomArbitrary(min, max) {
    return Math.random() * (max - min) + min;
  }

  //indicamos el tema incorrecto aleatoriamente
  function getTema(rndTema){
    if(rndTema == 0){
        return  arrayAnimal = new Array("perro ", "gato ", "elefante ", "tortuga ", "unicornio ");
      }else if(rndTema == 1){
        return  arrayColor = new Array("amarillo ", "verde ", "rosa ", "azul ", "negro ");
      }else {
        return  arrayObjetos = new Array("mesa ", "silla ", "armario ", "cama ", "estanteria ");
      }
  }
