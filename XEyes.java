import java.awt.Graphics;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.ArrayList;


/*
 * XEyes: 
 * This is the main class of the xeyes project.  To run, create an instance
 * of this class.
 */

public class XEyes extends JPanel implements MouseListener, MouseMotionListener {
    private int xClick = -9999;
    private int yClick = -9999;

    private String fileName = "einstein.jpg";

    private JFrame myFrame;
    private ImageIcon myPic;
    
    // Each eye gets an instance variable.
    private Eye eye_1;
    private ArrayList<Eye>eyes = new ArrayList<>();
    private Eye eye_2;
    

    // Constructor: this loads the image "einstein.jpg" in the "images" directory 
    // within the project
    public XEyes() {
        //A String passed into the JFrame constructor will be used as the title of the JFrame window
        myFrame = new JFrame("XEyes");
        myFrame.add(this);
        
        constructImage(fileName);

        // these eyes fit right on Einstein's head.  
        eye_1 = new Eye(269, 290, 49, 37);
        eye_2 = new Eye(372, 290, 49, 37);
        addMouseListener(this);
        addMouseMotionListener(this);
        myFrame.setVisible(true);
        }

        
    // convert the image so that it can be drawn in a JPanel
    private void constructImage(String fileName) {
        File imageFile = new File("./images/" + fileName);
        // an ImageIcon is a class that contains an image and knows how to draw itself
        myPic = new ImageIcon (imageFile.toString());
        // sets the size of the window based on the picture loaded. 
        myFrame.setSize(myPic.getIconWidth(), myPic.getIconHeight() );
    }
           
          
    public void paintComponent(Graphics g) {
  
        g.drawImage(myPic.getImage(), 0, 0, this);
        for(int i = 0; i<eyes.size();i++){
            eyes.get(i).draw(g);
        }
        eye_1.draw(g);
        eye_2.draw(g);
        if(xClick != -9999 && yClick != -9999){
        eye_1.lazerEyes(xClick, yClick, g);
        eye_2.lazerEyes(xClick, yClick, g);
        eye_1.inEye(xClick, yClick, g);
        eye_2.inEye(xClick, yClick, g);
        }
        
    }
    
    // move the pupil when the mouse is clicked
    public void mouseClicked (MouseEvent event, Graphics g) {
    }

    public void mouseDragged(MouseEvent event){
		eye_1.movePupil(event.getX(), event.getY());
        eye_2.movePupil(event.getX(), event.getY());

        this.xClick = event.getX();
		this.yClick = event.getY();
		
        repaint();
	}
    public void mouseMoved (MouseEvent event){
        for(int i = 0; i<eyes.size();i++){
            eyes.get(i).movePupil(event.getX(), event.getY());
        }

    }
    public void mouseReleased (MouseEvent event) {
    }
    
    public void mousePressed (MouseEvent event) {
        Eye neweye = new Eye(event.getX(),event.getY(),49,37);
        neweye.movePupil(event.getX(), event.getY());
        eyes.add(neweye);
        repaint();

    }
    
    public void mouseEntered (MouseEvent event) {
    }
    
    public void mouseExited (MouseEvent event) {
    }


    public static void main(String[] args) {
        new XEyes();
    }
    
} // end class