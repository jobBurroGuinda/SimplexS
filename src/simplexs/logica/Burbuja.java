
package simplexs.logica;

public class Burbuja {
    
    private long tiempo_inicio;
    private long tiempo_final;
    private long tiempo_total;

    public Burbuja() {
        this.tiempo_final = 0;
        this.tiempo_inicio = 0;
        this.tiempo_total = 0;
    }
    
    
    
    public float[] ordenar(float[] datos){
        this.tiempo_inicio = System.currentTimeMillis();
        float temp;
        for (int i = 1; i < datos.length;i++)
            for(int j=0; j < datos.length-1;j++){
                // preguntamos
                if(datos[j]>datos[j+1]){
                    temp = datos[j];
                    datos[j]=datos[j+1];
                    datos[j+1] = temp;
                }
            }
       this.tiempo_final = System.currentTimeMillis();
       this.tiempo_total = this.tiempo_final-this.tiempo_inicio;
       return datos;
    }
    
    
    public int getMayorValidoSegundaIteracion(float[] datos, int colPivoteUsado){
        float[] datoOrdenados = ordenar(datos.clone());
        int posicionMayor = -1;
        int posicionOriginalConst = datos.length-1;
        // Si el valor de la pocision mayor del array ordenado, es diferente al valor de la posicion de las constantes del array original
        // Y además, es diferente al valor de la posicion de la  columna anteriormente usada como pivote...
        // Entonces la posicion mayor será el valor mayor absoluto encontrado
        if(datoOrdenados[datos.length-1] != datos[posicionOriginalConst]  &&  datoOrdenados[datos.length-1] != datos[colPivoteUsado]){
            for(int i=0 ; i<datos.length ; i++){
                if(datoOrdenados[datoOrdenados.length-1] == datos[i]){
                    posicionMayor = i;
                    break;
                }
            }
        }
        else if(datoOrdenados[datos.length-1] == datos[posicionOriginalConst] || datoOrdenados[datos.length-1] == datos[colPivoteUsado]){
            for(int i=0 ; i<datos.length ; i++){
                // Esta vez se le restan dos pocisiones, porque el mayor absoluto no será válido porque es la pocision de las constantes
                // O es la pocision de la columna anteirormente usada como pivote, que su valor podría ser cero, pero más vale estar prevenidos
                if(datoOrdenados[datoOrdenados.length-2] == datos[i]){
                    posicionMayor = i;
                    break;
                }
            }
        }
        return posicionMayor;
    }
    
    public int getMayorValidoTerceraIteracion(float[] datos, int colPivoteUsado1, int colPivoteUsado2){
        float[] datoOrdenados = ordenar(datos.clone());
        int posicionMayor = -1;
        int posicionOriginalConst = datos.length-1;
        // Si el valor de la pocision mayor del array ordenado, es diferente al valor de la posicion de las constantes del array original
        // Y además, es diferente al valor de la posicion de la  columna anteriormente usada como pivote...
        // Entonces la posicion mayor será el valor mayor absoluto encontrado
        if(datoOrdenados[datos.length-1] != datos[posicionOriginalConst]  &&  datoOrdenados[datos.length-1] != datos[colPivoteUsado1]  &&  datoOrdenados[datos.length-1] != datos[colPivoteUsado2]){
            for(int i=0 ; i<datos.length ; i++){
                if(datoOrdenados[datoOrdenados.length-1] == datos[i]){
                    posicionMayor = i;
                    break;
                }
            }
        }
        else if(datoOrdenados[datos.length-1] == datos[posicionOriginalConst] || datoOrdenados[datos.length-1] == datos[colPivoteUsado1]){
            for(int i=0 ; i<datos.length ; i++){
                // Esta vez se le restan dos pocisiones, porque el mayor absoluto no será válido porque es la pocision de las constantes
                // O es la pocision de la columna anteirormente usada como pivote, que su valor podría ser cero, pero más vale estar prevenidos
                if(datoOrdenados[datoOrdenados.length-2] == datos[i]){
                    posicionMayor = i;
                    break;
                }
            }
        } 
        else if(datoOrdenados[datos.length-1] == datos[colPivoteUsado2]){
            for(int i=0 ; i<datos.length ; i++){
                // Esta vez se le restan tres pocisiones
                if(datoOrdenados[datoOrdenados.length-3] == datos[i]){
                    posicionMayor = i;
                    break;
                }
            }
        }
        
        return posicionMayor;
    }
    

    
    public long getTiempo_total() {
        return tiempo_total;
    }
    
    
}
