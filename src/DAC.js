console.log(potenciacion(2,8));
console.log(potenciacionDivideAndConquer(2,8))

function potenciacion(base,exponente){
  if(exponente == 0){
    return 1;
  }
  return base * potenciacion(base,exponente-1);
}


function potenciacionDivideAndConquer(base,exponente){
  if(exponente == 0){
    return 1;
  }
  let mitad = potenciacionDivideAndConquer(base,Math.floor(exponente/2));
  if(exponente % 2 == 0){
     return mitad * mitad;
  }
  else{
    return base * mitad * mitad;
  }
}

function sumOfArray(array){
  let length = array.length;
  if(length == 0){
    return 0;
  }
  return sumOfArrayRecursive(array, 0, array.length-1)
  
}

function sumOfArrayRecursive(array,min,max){
  if(min == max){
    return array[max];
  }else if(max<min){
    return 0;
  }
  
  let mid = Math.floor((min+max)/2);
  let left = sumOfArrayRecursive(array,min,mid-1);
  let right = sumOfArrayRecursive(array,mid+1,max);
  
  return array[mid] + left + right;
}

function minMax(array){
  if(array.length == 0){
    return [];
  }
  const myAns = [array[0],array[0]];
  
  const minMaxRecursive  = function(array,min,max){
    if(min>max){
      return;
    }
    let mid = Math.floor((min+max)/2);
    if(array[mid]>myAns[1]){
      myAns[1] = array[mid];
    }
    else if(array[mid]<myAns[0]){
      myAns[0] = array[mid];
    }
    minMaxRecursive(array,min,mid-1);
    minMaxRecursive(array,mid+1,max);
  }
  minMaxRecursive(array,0,array.length-1);
  return myAns;
}

