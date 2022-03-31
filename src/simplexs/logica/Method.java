
package simplexs.logica;

/**
 *
 * @author ameri
 */
public abstract class Method implements IMethod {
    
    protected String text;
    protected float[][] matriz;
    protected float pivote;
    protected int filas;
    protected int columnas;
    
    public Method(float[][] matriz, float pivote, int filas, int columnas){
        text = "";
        this.matriz = matriz;
        this.columnas = columnas;
        this.filas = filas;
        this.pivote = pivote;
    }

    @Override
    public abstract String calculate();
    
}
