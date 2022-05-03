
package simplexs.logica;

/**
 *
 * @author ameri
 */
public class MethodGra implements IMethod {

    // x de la función objetivo
    private float x1, x2;
    // r = restriccion}
    // r1 = restriccion 1
    private float r1x1, r1x2;
    // r2 = restriccion 2
    private float r2x1, r2x2;
    // r3 = restriccion 3
    private float r3x1, r3x2;
    // d = resultados de igualaciones
    private float d1, d2, d3;
    private String text;

    public MethodGra(float x1, float x2, float r1x1, 
            float r1x2, float r2x1, float r2x2, float r3x1,
            float r3x2, float d1, float d2, float d3, String text) {
        this.x1 = x1;
        this.x2 = x2;
        this.r1x1 = r1x1;
        this.r1x2 = r1x2;
        this.r2x1 = r2x1;
        this.r2x2 = r2x2;
        this.r3x1 = r3x1;
        this.r3x2 = r3x2;
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
    }
    
    
    
    @Override
    public String calculate() {
        text = "Restricción 1:\n";
        // r1c1 = coorenada restriccion1 1
        Coordenada r1c1 = new Coordenada(r1x1 * 0, d1 / r1x2);
        text += "\tCoordenada 1: (" + r1c1.getX() + ", " + r1c1.getY() + ")\n";
        //float r1c1;
        Coordenada r1c2 = new Coordenada(d1/r1x1, r1x2 *0);
        text += "\tCoordenada 2: (" + r1c2.getX() + ", " + r1c2.getY() + ")";
        text += "\n\n";
        text += "Restricción 2:\n";
        //r2c1 = restriccion 2 cordenada 1
        Coordenada r2c1 = new Coordenada(r2x1 * 0, d2/r2x2);
        text += "\tCoordenada 1: (" + r2c1.getX() + ", " + r2c1.getY() + ")\n";
        //r2c2 = restriccion 2 coordenada 2
        Coordenada r2c2 = new Coordenada(d2/r2x1, r2x2*0);
        text += "\tCoordenada 2: (" + r2c2.getX() + ", " + r2c2.getY() + ")";
        text += "\n\n";
        text += "Restricción 3:\n";
        //r3c1 = restriccion 3 cordenada 1
        Coordenada r3c1 = new Coordenada(r3x1*0, d3/r3x2);
        text += "\tCoordenada 1: (" + r3c1.getX() + ", " + r3c1.getY() + ")\n";
        //r3c2 = restriccion 3 cordenada 2
        Coordenada r3c2 = new Coordenada(d3/r3x1, r3x2*0);
        text += "\tCoordenada 2: (" + r3c2.getX() + ", " + r3c2.getY() + ")";
        
        Grafica grafica =  new Grafica(r1c1, r1c2, r2c1, r2c2, r3c1, r3c2);
        
        return text;
    }
    
}
