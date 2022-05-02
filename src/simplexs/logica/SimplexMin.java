
package simplexs.logica;

/**
 *
 * @author ameri
 */
public class SimplexMin extends Method {
    
    MsSimplexMin[] ms;
    
    public SimplexMin(float[][] matriz, MsSimplexMin[] ms, float pivote, int filas, int columnas) {
        super(matriz, pivote, filas, columnas);
        this.ms = ms;
    }
    
    @Override
    public String calculate(){
        float[] div = new float[filas]; // divisiones
        int colPivote;
        if(ms[0].getM() > ms[1].getM()){
            colPivote = 0; // la primer columna de la matriz
        }
        else {
            colPivote = 1; // la segunda columna de la matriz
        }
        //Se elige la fila pivote
        for(int i=0 ; i<div.length ; i++){
            // el valor de la última columna entre el valor de la columna pivote
            div[i] = matriz[i][columnas-1] / matriz[i][colPivote]; 
        }
        // Encuentra la fila pivote
        int filPivote = Comparator.compareThree(div[0], div[1], div[2]);
        pivote = matriz[filPivote][colPivote];
        // Dividimostodos los valores de la fila pivote entre el valor del pivote
        // O la multiplicamos por el reciproco del pivote
        for(int j=0 ; j<columnas ; j++){
            matriz[filPivote][j] /= pivote;
        }
        //Imprime la matriz con los valores actualizados de la fila de trabajo y el valor pivote.
        //text += "Pivote: "+pivote + "\n";
        imprimirResultados();
        float g;
        for(int i=0 ; i<filas ; i++){
        //Limpia la primera fila
            if(i != filPivote){
                g = matriz[i][colPivote] * -1;
                for(int j=0 ; j<columnas ; j++){
                    matriz[i][j] += matriz[filPivote][j] * g;
                }
            }
        }
        // Realizamos el mismo proceso, pero ahora con las Ms
        float gm = ms[colPivote].getM() * -1;
        float gnum = ms[colPivote].getNum() * -1;
        for(int j=0 ; j<columnas ; j++){
            ms[j].setM(ms[j].getM()+matriz[filPivote][j] * gm);
            ms[j].setNum(ms[j].getNum()+matriz[filPivote][j] * gnum);
        }
        
        imprimirResultados();
        
        Burbuja b = new Burbuja();
        float[] arrayMS = new float[columnas];
        for(int i=0 ; i<columnas ; i++){
            arrayMS[i] = ms[i].getM();
        }
        // Obtenemos la pocision de nuestra nueva columna pivote
        int newColPivote = b.getMayorValidoSegundaIteracion(arrayMS, colPivote);
        
        // Volvemos a repetir el mismo proceso, pero ahora para la segunda variable
        
        //Se elige la fila pivote
        for(int i=0 ; i<div.length ; i++){
            // el valor de la última columna entre el valor de la columna pivote
            div[i] = matriz[i][columnas-1] / matriz[i][newColPivote]; 
        }
        // Encuentra la fila pivote
         filPivote = Comparator.compareThree(div[0], div[1], div[2]);
        pivote = matriz[filPivote][newColPivote];
        // Dividimostodos los valores de la fila pivote entre el valor del pivote
        // O la multiplicamos por el reciproco del pivote
        for(int j=0 ; j<columnas ; j++){
            matriz[filPivote][j] /= pivote;
        }
        //Imprime la matriz con los valores actualizados de la fila de trabajo y el valor pivote.
        //text += "Pivote: "+pivote + "\n";
        imprimirResultados();
        for(int i=0 ; i<filas ; i++){
        //Limpia la primera fila
            if(i != filPivote){
                g = matriz[i][newColPivote] * -1;
                for(int j=0 ; j<columnas ; j++){
                    matriz[i][j] += matriz[filPivote][j] * g;
                }
            }
        }
        // Realizamos el mismo proceso, pero ahora con las Ms
         gm = ms[newColPivote].getM() * -1;
         gnum = ms[newColPivote].getNum() * -1;
        for(int j=0 ; j<columnas ; j++){
            ms[j].setM(ms[j].getM()+matriz[filPivote][j] * gm);
            ms[j].setNum(ms[j].getNum()+matriz[filPivote][j] * gnum);
        }
        
        imprimirResultados();
        
        
        for(int i=0 ; i<columnas ; i++){
            arrayMS[i] = ms[i].getM();
        }
        // Obtenemos la pocision de nuestra nueva columna pivote
        newColPivote = b.getMayorValidoTerceraIteracion(arrayMS, colPivote, newColPivote);
        
        // Volvemos a repetir el mismo proceso, pero ahora para la segunda variable
        
        //Se elige la fila pivote
        for(int i=0 ; i<div.length ; i++){
            // el valor de la última columna entre el valor de la columna pivote
            div[i] = matriz[i][columnas-1] / matriz[i][newColPivote]; 
        }
        // Encuentra la fila pivote
         filPivote = Comparator.compareThree(div[0], div[1], div[2]);
        pivote = matriz[filPivote][newColPivote];
        // Dividimostodos los valores de la fila pivote entre el valor del pivote
        // O la multiplicamos por el reciproco del pivote
        for(int j=0 ; j<columnas ; j++){
            matriz[filPivote][j] /= pivote;
        }
        //Imprime la matriz con los valores actualizados de la fila de trabajo y el valor pivote.
        //text += "Pivote: "+pivote + "\n";
        imprimirResultados();
        for(int i=0 ; i<filas ; i++){
        //Limpia la primera fila
            if(i != filPivote){
                g = matriz[i][newColPivote] * -1;
                for(int j=0 ; j<columnas ; j++){
                    matriz[i][j] += matriz[filPivote][j] * g;
                }
            }
        }
        // Realizamos el mismo proceso, pero ahora con las Ms
         gm = ms[newColPivote].getM() * -1;
         gnum = ms[newColPivote].getNum() * -1;
        for(int j=0 ; j<columnas ; j++){
            ms[j].setM(ms[j].getM()+matriz[filPivote][j] * gm);
            ms[j].setNum(ms[j].getNum()+matriz[filPivote][j] * gnum);
        }
        
        imprimirResultados();
        
        text += "\n\n\n";
        text += "La solución óptima Z=" + ms[columnas-1].getNum();
        
        
        return text;
    }
    
    
    
    public void imprimirResultados(){
        if(!text.isEmpty()){
            text += "\n\n\n";
        }
        text += "x1\t|\tx2\t|\tS1\t|\tS2\t|\tS3\t|\tA1\t|\tA2\t|\tA3\t||\tConst\n";
        text += "--\t|\t--\t|\t---\t|\t---\t|\t---\t|\t---\t|\t---\t|\t---\t||\t-----\n";
        for(int i=0 ; i<filas ; i++){
            for(int j=0 ; j<columnas ; j++){
               text += matriz[i][j] + "\t|\t";
            }
            text += "\n";
        }
        text += "\n";
        for(int i=0; i<columnas ; i++){
            if(ms[i].getM() == -1){
                text += "-M";
                if(ms[i].getNum()!=0){
                    if(ms[i].getNum()>0){
                        text += "+";
                    }
                    text += ms[i].getNum();
                }
            } else if(ms[i].getM() == 1){
                text += "M";
                if(ms[i].getNum()!=0){
                    if(ms[i].getNum()>0){
                        text += "+";
                    }
                    text += ms[i].getNum();
                }
            } else if(ms[i].getM() == 0) {
                if(ms[i].getNum()!=0){
                    if(ms[i].getNum()>0){
                        text += "+";
                    }
                    text += ms[i].getNum();
                }
                else{
                    text += "0";
                }
            } else {
                text += ms[i].getM()+"M";
                if(ms[i].getNum()!=0){
                    if(ms[i].getNum()>0){
                        text += "+";
                    }
                    text += ms[i].getNum();
                }
            }
            if(i < columnas-1) {
                text += "\t|\t";
            }
        }
    }
    
}
