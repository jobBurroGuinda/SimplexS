
package simplexs.logica;

/**
 *
 * @author ameri
 */
public class Comparator {
    
    //Comparador para elegir fila pivote
    public static int compareThree(float n1, float n2, float n3){
        int menor = 0;
        if(n1 < n2) {
            if(n1 < n3){
                if(n1>0){
                    menor = 0;
                }
                else{
                    menor = 1;
                }
            }
            else{
                if(n3 < n2){
                    if(n3>0){
                        menor = 2;
                    }else{
                        menor = 1;
                    }
                }
                else {
                    if(n2>0){
                        menor = 1;
                    }else {
                        menor = 2;
                    }
                }
            }
        }else {
            if(n2 < n3) {
                if(n2>0){
                        menor = 1;
                    }else {
                        menor = 2;
                    }
            }
            else {
                if(n3>0){
                        menor = 2;
                    }else{
                        menor = 1;
                    }
            }
        }
        return menor;
    }
    
}
