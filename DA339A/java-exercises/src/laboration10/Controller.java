package laboration10;
 
import java.io.File;
 
import javax.swing.JOptionPane;
 
public class Controller {
    private ImageViewer viewer;
     
    public Controller(ImageViewer inViewer){
        this.viewer = inViewer;
    }
     
    public void newImage(String filePath){
        int lastDot = filePath.lastIndexOf('.');
        String suffix = filePath.substring(lastDot + 1);
        suffix.toLowerCase();
        File f = new File(filePath);
         
        if(f.exists()){
            if(suffix.equals("jpg") || suffix.equals("gif") || suffix.equals("png")){
                viewer.showImage(filePath);
            }
            else{
                JOptionPane.showMessageDialog(null, "Felaktig filtyp: " + suffix);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Filen existerar inte :(");
        }
    }
     
    public void eraseImage(){
        viewer.noImage();
    }
}




















