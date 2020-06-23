/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greedycoloringgraph;

/**
 *
 * @author AtlantisSeeker
 */
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
 
public class JungLearning {
    
    ArrayList<String> berwarna = new ArrayList<String>();  
    
  public static void main(String[] args) {
    ArrayList<String> berwarna = new ArrayList<String>();  
    berwarna.add("1");
    berwarna.add("2");
    berwarna.add("3");
    
    DirectedSparseGraph<String, String> g = new DirectedSparseGraph<String, String>();
    g.addVertex("0");
    g.addVertex("1");
    g.addVertex("2");
    g.addEdge("Edge1", "0", "1");
    g.addEdge("Edge2", "1", "2");
    g.addEdge("Edge3", "2", "0");
    VisualizationViewer<String, String> vv =
      new VisualizationViewer<String, String>(
        new CircleLayout<String, String>(g), new Dimension(400,400));
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
    @Override public void paintVertex(RenderContext<String, String> rc,
        Layout<String, String> layout, String vertex) {
      GraphicsDecorator graphicsContext = rc.getGraphicsContext();
      Point2D center = layout.transform(vertex);
      Shape shape = null;
      Color color = null;
      if(vertex.equals("0")) {
        shape = new Ellipse2D.Double(center.getX()-10, center.getY()-10, 20, 20);
        color = new Color(127, 127, 0);
      } else if(vertex.equals("1")) {
        shape = new Ellipse2D.Double(center.getX()-10, center.getY()-10, 20, 20);
        color = new Color(127, 0, 127);
      } else if(vertex.equals("2")) {
        shape = new Ellipse2D.Double(center.getX()-10, center.getY()-10, 20, 20);
        color = new Color(0, 127, 127);
      }
      graphicsContext.setPaint(color);
      graphicsContext.fill(shape);
    }
  }
}
