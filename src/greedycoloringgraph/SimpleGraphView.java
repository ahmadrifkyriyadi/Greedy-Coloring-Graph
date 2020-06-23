/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greedycoloringgraph;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import javax.swing.JFrame;
import org.apache.commons.collections15.Transformer;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.visualization.RenderContext;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.renderers.Renderer;
import edu.uci.ics.jung.visualization.transform.shape.GraphicsDecorator;
import java.util.ArrayList;

/**
 *
 * @author AtlantisSeeker
 */

public class SimpleGraphView {
    public static void main(String[] args) {
        DirectedSparseGraph<String, String> g = new DirectedSparseGraph<String, String>();
        g.addVertex("Square");
        g.addVertex("Rectangle");
        g.addVertex("Circle");
        g.addEdge("Edge1", "Square", "Rectangle");
        g.addEdge("Edge2", "Square", "Circle");
        g.addEdge("Edge3", "Circle", "Square");
        VisualizationViewer<String, String> vv = new VisualizationViewer<String, String>(new CircleLayout<String, String>(g), new Dimension(400,400));
        Transformer<String, String> transformer = new Transformer<String, String>() {
          @Override public String transform(String arg0) { return arg0; }
        };
        vv.getRenderContext().setVertexLabelTransformer(transformer);
        transformer = new Transformer<String, String>() {
          @Override public String transform(String arg0) { return arg0; }
        };
        vv.getRenderContext().setEdgeLabelTransformer(transformer);
        vv.getRenderer().setVertexRenderer(new MyRenderer());

        // The following code adds capability for mouse picking of vertices/edges. Vertices can even be moved!
        final DefaultModalGraphMouse<String,Number> graphMouse = new DefaultModalGraphMouse<String,Number>();
        vv.setGraphMouse(graphMouse);
        graphMouse.setMode(ModalGraphMouse.Mode.PICKING);

        JFrame frame = new JFrame();
        frame.getContentPane().add(vv);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
 
    static class MyRenderer implements Renderer.Vertex<String, String> {
        
        public void paintVertex(RenderContext<String, String> rc, Layout<String, String> layout, String vertex) {
            GraphicsDecorator graphicsContext = rc.getGraphicsContext();
            Point2D center = layout.transform(vertex);
            ArrayList<String> berwarna = new ArrayList<String>();
            berwarna.add("Biru");
            berwarna.add("Merah");
            berwarna.add("Merah");
            Shape shape = null;
            Color color = null;
            if(berwarna.get(0).equalsIgnoreCase("merah")) {
                shape = new Ellipse2D.Double(center.getX()-10, center.getY()-10, 20, 20);
                color = Color.red;
            } else if(vertex.equals("Rectangle")) {
                shape = new Ellipse2D.Double(center.getX()-10, center.getY()-10, 20, 20);
                color = Color.LIGHT_GRAY;
            } else if(vertex.equals("Circle")) {
                shape = new Ellipse2D.Double(center.getX()-10, center.getY()-10, 20, 20);
                color = Color.YELLOW;
            }
            graphicsContext.setPaint(color);
            graphicsContext.fill(shape);
        }
    }
}