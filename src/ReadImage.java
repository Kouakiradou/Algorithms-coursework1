import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class ReadImage
{
    public int[][] readImage(String file) throws IOException
    {
        File imageFile = new File(file);
        BufferedImage img = ImageIO.read(imageFile);
        int width = img.getWidth();
        int height = img.getHeight();
     //   System.out.print(" "+width+" "+ height);
        int[][] imgArr = new int[height][width];

        for(int i = 0; i < width; i++)   // Algorithm of creating grey scale image is completely copied online,
        {                                 // from https://www.tutorialspoint.com/java_dip/grayscale_conversion.htm
            for(int j = 0; j < height; j++)
            {
                Color c = new Color(img.getRGB(i, j));
                int red = (int)(c.getRed() * 0.299);
                int green = (int)(c.getGreen() * 0.587);
                int blue = (int)(c.getBlue() *0.114);
                Color newColor = new Color(red+green+blue, red+green+blue,red+green+blue);
                img.setRGB(i , j, newColor.getRGB());
                imgArr[j][i] = red + green + blue;
            }
        }

   //     File output = new File("grayscale.png");
      //  ImageIO.write(img, "png", output);
        return imgArr;
    }
}
