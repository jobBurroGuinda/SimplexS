/*
    Generar graficos insertando nuevos valores
    Desarrollado por: Harold Cupitra Hernandez
    13/septiembre/2018
 */
package simplexs.logica;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.math.plot.Plot2DPanel;

/**
 *  
 * @author Job
 */
public class Grafica {
    //Datos a tratar en la grafica
    private double[] origenX = {0.0,0.0};
    private double[] origenY = {0.0,0.0};
    
    private double[] r1p1;
    private double[] r1p2;
    private double[] r2p1;
    private double[] r2p2;
    private double[] r3p1;
    private double[] r3p2;
    private ArrayList list;
    
    //Objeto que permite graficar
    private Plot2DPanel plot = new Plot2DPanel();
    
    public Grafica(Coordenada r1c1, Coordenada r1c2, 
                            Coordenada r2c1, Coordenada r2c2,
                            Coordenada r3c1, Coordenada r3c2){
        r1p1 = coordenadaToPunto(r1c1);
        r1p2 = coordenadaToPunto(r1c2);
        r2p1 = coordenadaToPunto(r2c1);
        r2p2 = coordenadaToPunto(r2c2);
        r3p1 = coordenadaToPunto(r3c1);
        r3p2 = coordenadaToPunto(r3c2);
        
        //Agregar datos a la Grafica      
        plot.addScatterPlot("Datos",origenX, origenY);
        //graficar en linea
        plot.addLinePlot("Linea",origenX, origenY);
        
        // Recta de la primera restricción     
        plot.addScatterPlot("Datos",r1p1, r1p2);
        plot.addLinePlot("Linea",r1p1, r1p2);
        // Recta de la segunda restricción     
        plot.addScatterPlot("Datos",r2p1, r2p2);
        plot.addLinePlot("Linea",r2p1, r2p2);
        // Recta de la tercera restricción     
        plot.addScatterPlot("Datos",r3p1, r3p2);
        plot.addLinePlot("Linea",r3p1, r3p2);
        
        //addNewPoint(4.0,3.0);
        //Generar Ventana
        JFrame frame =  new JFrame("Gráfica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.add(construirPanelPrincipal());
        frame.setVisible(true);
        
    }
    
    public void addNewPoint(double x, double y){
        //se envia el nuevo valor junto al arreglo actual
                double[] arrayX = agregarValor(origenX,x);
                double[] arrayY = agregarValor(origenY,y);
                //los arreglos globales obtienen el nuevo arreglo con todos los valores 
                origenX = null;
                origenY = null;
                origenX = arrayX; //asigna los nuevos arreglos a los arreglos globales
                origenY = arrayY;
                /* 3. graficar nuevamente*/
                //plot.removeAllPlots();
                plot.addScatterPlot("Datos",arrayX, arrayY);
                plot.addLinePlot("Linea",arrayX, arrayY);
    }
    
    /* Obtiene como parametros el arreglo actual origenY el valor a agregar en uno nuevo
        retornando este nuevo arreglo para realizar la grafica
    */
    private double[] agregarValor(double valores[], double nuevoValor){
        double newX[] = new double[valores.length+1];//crea un nuevo arreglo
        System.arraycopy(valores, 0, newX, 0, valores.length); //asigna los valores del arregloAntiguo al nuevoArreglo
        newX[newX.length-1] = nuevoValor;//agrega el nuevo valor en la ultima posicion
        return newX;//retorna el nuevo arreglo
    }
    
    
    private double[] coordenadaToPunto(Coordenada c){
        double[] punto = {c.getX(), c.getY()};
        return punto;
    }
 
    
    //Panel principal que trae los otros paneles para generar la interfaz grafica
    //ordena los paneles
    private JPanel construirPanelPrincipal(){
        JPanel pPrincipal = new JPanel();
        pPrincipal.setLayout(new BorderLayout());
        pPrincipal.add(plot,BorderLayout.CENTER);//Se posiciona la grafica en el centro del panel principal
        return pPrincipal;
    }
    
    
}
