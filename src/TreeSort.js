class Node {
  constructor(data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
}

class Tree {
  constructor(data = null) {
    this.root = data ? new Node(data) : null;
  }

  insertarEnArbol(data) {
    if (!this.root) {
      this.root = new Node(data);
    } else {
      this.#insertarEnArbolRecursivo(data, this.root);
    }
  }

  #insertarEnArbolRecursivo(data, nodo) {
    if (data < nodo.data) {
      if (nodo.left) {
        this.#insertarEnArbolRecursivo(data, nodo.left);
      } else {
        nodo.left = new Node(data);
      }
    } else {
      if (nodo.right) {
        this.#insertarEnArbolRecursivo(data, nodo.right);
      } else {
        nodo.right = new Node(data);
      }
    }
  }
  recorrerEnInorden() {
    const array = [];
    this.#recorrerEnInordenRecursivo(this.root, array);

    return array;
  }
  #recorrerEnInordenRecursivo(nodo, array) {
    if (!nodo) {
      return;
    }
    this.#recorrerEnInordenRecursivo(nodo.left, array);
    array.push(nodo.data);
    this.#recorrerEnInordenRecursivo(nodo.right, array);
  }
  imprimirVertical() {
    const lineas = this.#construirAscii(this.root);
    for (const linea of lineas) {
      console.log(linea);
    }
  }

  #construirAscii(nodo) {
    if (!nodo) return [];

    const nodoStr = String(nodo.data);
    const ancho = nodoStr.length;

    if (!nodo.left && !nodo.right) return [nodoStr];

    const izq = this.#construirAscii(nodo.left);
    const der = this.#construirAscii(nodo.right);

    const alturaIzq = izq.length;
    const alturaDer = der.length;
    const altura = Math.max(alturaIzq, alturaDer);

    const anchoIzq = izq[0]?.length || 0;
    const anchoDer = der[0]?.length || 0;

    while (izq.length < altura) izq.push(" ".repeat(anchoIzq));
    while (der.length < altura) der.push(" ".repeat(anchoDer));

    const primeraLinea = " ".repeat(anchoIzq) + nodoStr + " ".repeat(anchoDer);

    const segundaLinea =
      (nodo.left ? " ".repeat(anchoIzq - 1) + "/" : " ".repeat(anchoIzq)) +
      " ".repeat(ancho) +
      (nodo.right ? "\\" + " ".repeat(anchoDer - 1) : " ".repeat(anchoDer));

    const lineas = [];
    for (let i = 0; i < altura; i++) {
      lineas.push(izq[i] + " ".repeat(ancho) + der[i]);
    }

    return [primeraLinea, segundaLinea, ...lineas];
  }
}

function sleep(ms) {
  return new Promise((resolve) => setTimeout(resolve, ms));
}

async function treeSort(arr) {
  const myTree = new Tree();

  for (let i = 0; i < arr.length; i++) {
    myTree.insertarEnArbol(arr[i]);

    console.log(`${i + 1} Pasada`);
    console.log("------------");
    myTree.imprimirVertical();
    console.log("------------");

    await sleep(50); // espera 1 segundo
  }

  return myTree.recorrerEnInorden();
}

// Para usar async/await necesitamos otra función async:
(async () => {
  const sorted = await treeSort([30, 40, 100, 20, 1, 30, 400000]);
  console.log("Resultado ordenado:", sorted);
})();
