
package simplexs.logica;

/**
 *
 * @author ameri
 */
public class MethodGra implements IMethod {

    private float x1, x2;
    private String text;
    
    public MethodGra(float x1, float x2){
        this.x1 = x1;
        this.x2 = x2;
    }
    
    @Override
    public String calculate() {
        return text;
    }
    
}
