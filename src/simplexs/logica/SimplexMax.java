
package simplexs.logica;

public class SimplexMax extends Method {

    
    public SimplexMax(float[][] matriz, float pivote, int filas, int columnas) {
        super(matriz, pivote, filas, columnas);
    }

    @Override
    public String calculate() {
        float[] m = new float[filas-1];
        if(matriz[3][0] < matriz[3][1]){
            //Se elige la fila pivote
            for(int i=0 ; i<m.length ; i++){
                m[i] = matriz[i][5] / matriz[i][0]; 
            }
            // Encuentra la fila pivote
            int fm = Comparator.compareThree(m[0], m[1], m[2]);
            // Asigna el valor del pivote con la intersección entre la columna y fila pivote            
            pivote = matriz[fm][0];
            // Dividimostodos los valores de la fila pivote entre el valor del pivote
            // O la multiplicamos por el reciproco del pivote
            for(int j=0 ; j<columnas ; j++){
                matriz[fm][j] /= pivote;
            }
            //Imprime la matriz con los valores actualizados de la fila de trabajo y el valor pivote.
            text += "Pivote: "+pivote + "\n";
            text += "x1\t|\tx2\t|\tS1\t|\tS2\t|\tS3\t\t|\tConst\n";
            text += "--\t|\t--\t|\t---\t|\t---\t|\t---\t\t||\t-----\n";
            for(int i=0 ; i<filas ; i++){
                for(int j=0 ; j<columnas ; j++){
                    text += matriz[i][j] + "\t|\t";
                }
                text += "\n";
            }
            
            text += "\n\n";
            float g;
            for(int i=0 ; i<filas ; i++){
                //Limpia la primera fila
                if(i != fm){
                    g = matriz[i][0] * -1;
                    for(int j=0 ; j<columnas ; j++){
                        matriz[i][j] += matriz[fm][j] * g;
                    }
                }
            }
            
            text += "\n\n";
            text += "x1\t|\tx2\t|\tS1\t|\tS2\t|\tS3\t\t|\tConst\n";
            text += "--\t|\t--\t|\t---\t|\t---\t|\t---\t\t|\t-----\n";
            for(int i=0 ; i<filas ; i++){
                for(int j=0 ; j<columnas ; j++){
                    text += matriz[i][j] + "\t|\t";
                }
                text += "\n";
            }
            
            text += "\n\n\n";
            m = new float[filas-1];
            for(int i=0 ; i<m.length ; i++){
                m[i] = matriz[i][5] / matriz[i][1]; 
            }
            fm = Comparator.compareThree(m[0], m[1], m[2]);
            pivote = matriz[fm][1];
            text += "Nuevo pivote: "+pivote + "\n";
            for(int j=1 ; j<columnas ; j++){
                matriz[fm][j] /= pivote;
            }
            text += "x1\t|\tx2\t|\tS1\t|\tS2\t|\tS3\t\t|\tConst\n";
            text += "--\t|\t--\t|\t---\t|\t---\t|\t---\t\t||\t-----\n";
            for(int i=0 ; i<filas ; i++){
                for(int j=0 ; j<columnas ; j++){
                    text += matriz[i][j] + "\t|\t";
                }
                text += "\n";
            }
            
            text += "\n\n";
            for(int i=0 ; i<filas ; i++){
                if(i != fm) {
                    g = matriz[i][1] * -1;
                    for(int j=0 ; j<columnas ; j++){
                        matriz[i][j] += matriz[fm][j] * g;
                    }
                }
            }
            
            text += "\n\n";
            text += "x1\t|\tx2\t|\tS1\t|\tS2\t|\tS3\t\t|\tConst\n";
            text += "--\t|\t--\t|\t---\t|\t---\t|\t---\t\t||\t-----\n";
            for(int i=0 ; i<filas ; i++){
                for(int j=0 ; j<columnas ; j++){
                    text += matriz[i][j] + "\t|\t";
                }
                text += "\n";
            }
            text += "\n\n\n";
            text += "La solución óptima es: Z = "+matriz[filas-1][columnas-1] + "\n";
            for(int i=0 ; i<(filas-1) ; i++){
                text += "x"+(i+1)+ "="+matriz[i][5]+", ";
            }
        }
        else {
            for(int i=0 ; i<m.length ; i++){
                m[i] = matriz[i][5] / matriz[i][1]; 
            }
            int fm = Comparator.compareThree(m[0], m[1], m[2]);
            pivote = matriz[fm][1];
            for(int j=0 ; j<columnas ; j++){
                matriz[fm][j] /= pivote;
            }
            text += "Pivote: "+pivote + "\n";
            text += "x1\t|\tx2\t|\tS1\t|\tS2\t|\tS3\t\t|\tConst\n";
            text += "--\t|\t--\t|\t---\t|\t---\t|\t---\t\t||\t-----\n";
            for(int i=0 ; i<filas ; i++){
                for(int j=0 ; j<columnas ; j++){
                    text += matriz[i][j] + "\t|\t";
                }
                text += "\n";
            }
            
            text += "\n\n";
            float g;
            for(int i=0 ; i<filas ; i++){
                g = matriz[i][1] * -1;
                for(int j=0 ; j<columnas ; j++){
                    if(i != fm){
                        matriz[i][j] += matriz[fm][j] * g;
                    }
                }
            }
            
            text += "\n\n";
            text += "x1\t|\tx2\t|\tS1\t|\tS2\t|\tS3\t\t|\tConst\n";
            text += "--\t|\t--\t|\t---\t|\t---\t|\t---\t\t|\t-----\n";
            for(int i=0 ; i<filas ; i++){
                for(int j=0 ; j<columnas ; j++){
                    text += matriz[i][j] + "\t|\t";
                }
                text += "\n";
            }
            
            text += "\n\n\n";
            m = new float[filas-1];
            for(int i=0 ; i<m.length ; i++){
                m[i] = matriz[i][5] / matriz[i][0]; 
            }
            fm = Comparator.compareThree(m[0], m[1], m[2]);
            pivote = matriz[fm][0];
            text += "Nuevo pivote: "+pivote + "\n";
            for(int j=1 ; j<columnas ; j++){
                matriz[fm][j] /= pivote;
            }
            text += "x1\t|\tx2\t|\tS1\t|\tS2\t|\tS3\t\t|\tConst\n";
            text += "--\t|\t--\t|\t---\t|\t---\t|\t---\t\t||\t-----\n";
            for(int i=0 ; i<filas ; i++){
                for(int j=0 ; j<columnas ; j++){
                    text += matriz[i][j] + "\t|\t";
                }
                text += "\n";
            }
            
            text += "\n\n";
            for(int i=0 ; i<filas ; i++){
                if(i != fm) {
                    g = matriz[i][0] * -1;
                    for(int j=0 ; j<columnas ; j++){
                        matriz[i][j] += matriz[fm][j] * g;
                    }
                }
            }
            
            text += "\n\n";
            text += "x1\t|\tx2\t|\tS1\t|\tS2\t|\tS3\t\t|\tConst\n";
            text += "--\t|\t--\t|\t---\t|\t---\t|\t---\t\t||\t-----\n";
            for(int i=0 ; i<filas ; i++){
                for(int j=0 ; j<columnas ; j++){
                    text += matriz[i][j] + "\t|\t";
                }
                text += "\n";
            }
            text += "\n\n\n";
            text += "La solución óptima es: Z = "+matriz[filas-1][columnas-1] + "\n";
            for(int i=0 ; i<(filas-1) ; i++){
                text += "x"+(i+1)+ "="+matriz[i][5]+", ";
            }
        }
        
        return text;
    }
    
    
}
