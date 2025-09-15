
/**
 * Neo debe localizar al Agente Smith en los registros de la Matrix. Los datos
 * están organizados en una matriz de enteros sin elementos repetidos, donde
 * cada fila está ordenada de menor a mayor, y cada columna también está
 * ordenada de menor a mayor.
 *
 * Esta clase implementa un algoritmo de división y conquista recursivo para
 * buscar un valor objetivo en una matriz N×N ordenada por filas y columnas en
 * tiempo menor a O(n^2).
 *
 * @author COMPLETAR
 * @version 1.0
 */
public class Neo {

    /**
     * Busca al Agente Smith en la matriz de datos de Matrix usando divide y
     * vencerás recursivo. La matriz debe estar ordenada: cada fila creciente y cada
     * columna creciente.
     *
     * @param matrizDatos matriz ordenada que representa los registros de Matrix
     * @param codigoSmith código único del Agente Smith a buscar
     * @return array de 2 posiciones [fila, columna] donde está Smith, o [-1, -1] si
     *         no se encuentra
     */
    public int[] buscarAgenteSmith(int[][] matrizDatos, int codigoSmith) {
        //Matriz nula
        if(matrizDatos == null || matrizDatos.length == 0){
            return new int[] {-1,-1};
        }
        int n = matrizDatos.length;
        //Fuera de rango
        if(codigoSmith<matrizDatos[0][0] || codigoSmith>matrizDatos[n-1][n-1]){
            return new int[]{-1,-1};
        }

        //Me posiciono en la esquina superior derecha, todo a mi izquiera es menor, todo por debajo es mayor.

        int hor = n-1;
        int ver = 0;

        //Recorro la matriz de forma escalonada

        while(hor>=0 && ver<n){
            int valorActual = matrizDatos[ver][hor];

            //Realizo la comparacion, e incremento o decremento los punteros segun sea necesario.

            if(valorActual == codigoSmith){
                return new int[]{ver,hor}; // Devuelvo las coordenadas si encuentro al agente smith
            }
            else if(valorActual>codigoSmith){
                hor--;
            }
            else{
                ver++;
            }
        }
        // Devuelvo {-1,1} si no lo encuentro
        return new int[]{-1,-1};
    }
}
