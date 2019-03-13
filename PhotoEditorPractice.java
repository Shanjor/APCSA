import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
/**
 * Intro to photo editing
 *
 * @author Shane Jordan
 * @version 11-15-18
 */
public class PhotoEditorPractice 
{
   public static void main(String [] args) throws Exception
   {
        
    }
   
   public static void flipX()
   {
     try
     {
         File input = new File("images/juneau.jpg");
         BufferedImage image = ImageIO.read(input);
         
         int width = image.getWidth();
         int height = image.getHeight();
         
         BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
         
         //System.out.println("The image is " + width + " x " + height + ".");
         
         
         for (int x = 0; x < width; x++)
         {
            for (int y = 0; y < height; y++)
            {
                Color c = new Color(image.getRGB(x, y));
                
                newImage.setRGB(y, height - 1 - x, c.getRGB());
            }
         }
         File output = new File("images/flip3.jpg");
         ImageIO.write(newImage, "jpg", output);
     }
     catch (Exception e)
     {
         System.out.println("Oops: " + e);
     }
    }
    public static void frenchFlag()
   { try
       {
         File input = new File("images/france.jpg");
         BufferedImage image = ImageIO.read(input);
         
         int width = image.getWidth();
         int height = image.getHeight();
         for (int x = 0; x < width / 3; x++)
         {
            for (int y = 0; y < height; y++)
            {
                Color c = new Color(image.getRGB(x, y));
                
                int red = c.getRed();
                int green = c.getGreen();
                int blue = c.getBlue();
                
                int blueScale = (red + green + blue) / 3;
                Color newColor = new Color(0, 0, blueScale);
                
                image.setRGB(x, y, newColor.getRGB());
            }
         }
         for (int x = width / 3; x < 2 * (width / 3); x++)
         {
            for (int y = 0; y < height; y++)
            {
                Color c = new Color(image.getRGB(x, y));
                
                int red = c.getRed();
                int green = c.getGreen();
                int blue = c.getBlue();
                
                if (red + 50 > 255)
                {
                red = 255;
                }
                else
                {
                    red += 50;
                }
                if (green + 50 > 255)
                {
                green = 255;
                }
                else
                {
                    green += 50;
                }
                if (blue + 50 > 255)
                {
                blue = 255;
                }
                else
                {
                    blue += 50;
                }
                Color newColor = new Color(red, green, blue);
                image.setRGB(x, y, newColor.getRGB());
            }
         }
         for (int x = 2 * (width / 3); x < width; x++)
         {
            for (int y = 0; y < height; y++)
            {
                Color c = new Color(image.getRGB(x, y));
                
                int red = c.getRed();
                int green = c.getGreen();
                int blue = c.getBlue();
                
                int redScale = (red + green + blue) / 3;
                Color newColor = new Color(redScale, 0, 0);
                
                image.setRGB(x, y, newColor.getRGB());
            }
         }
         File output = new File("images/france_french.jpg");
         ImageIO.write(image, "jpg", output);
     }
     catch (Exception e)
     {
         System.out.println("Oops: " + e);
     }
 }
 public static void deStijl ()
 {
       try
       {
         File input = new File("images/images.jpg");
         BufferedImage image = ImageIO.read(input);
         
         int width = image.getWidth();
         int height = image.getHeight();
         for (int x = 0; x < (width / 16)* 3; x++)
         {
            for (int y = 0; y < (height / 16)* 4; y++)
            {
                Color c = new Color(image.getRGB(x, y));
                
                int red = c.getRed();
                int green = c.getGreen();
                int blue = c.getBlue();
                
                if (red + 50 > 255)
                {
                red = 255;
                }
                else
                {
                    red += 50;
                }
                if (green + 50 > 255)
                {
                green = 255;
                }
                else
                {
                    green += 50;
                }
                if (blue + 50 > 255)
                {
                blue = 255;
                }
                else
                {
                    blue += 50;
                }
                Color newColor = new Color(red, green, blue);
                image.setRGB(x, y, newColor.getRGB());
                
                System.out.println("hello");
            }
         }
         for (int x = width; x < 3 * (width / 16); x++)
         {
            for (int y = 4 * (height / 16); y < height / 16; y++)
            {
                Color c = new Color(image.getRGB(x, y));
                
                int red = c.getRed();
                int green = c.getGreen();
                int blue = c.getBlue();
                
                if (red - 75 < 0)
                {
                red = 255;
                }
                else
                {
                    red -= 75;
                }
                if (green + 50 > 255)
                {
                green = 255;
                }
                else
                {
                    green -= 75;
                }
                if (blue + 50 > 255)
                {
                blue = 255;
                }
                else
                {
                    blue -= 75;
                }
                Color newColor = new Color(red, green, blue);
                image.setRGB(x, y, newColor.getRGB());
                
                System.out.println("hello");
            }
         }
         for (int x = width; x < 3 * (width / 16); x++)
         {
            for (int y = 5 * (height / 16); y < 6 * (height / 16); y++)
            {
                Color c = new Color(image.getRGB(x, y));
                
                int red = c.getRed();
                int green = c.getGreen();
                int blue = c.getBlue();
                
                if (red + 50 > 255)
                {
                red = 255;
                }
                else
                {
                    red += 50;
                }
                if (green + 50 > 255)
                {
                green = 255;
                }
                else
                {
                    green += 50;
                }
                if (blue + 50 > 255)
                {
                blue = 255;
                }
                else
                {
                    blue += 50;
                }
                Color newColor = new Color(red, green, blue);
                image.setRGB(x, y, newColor.getRGB());
                
                System.out.println("hello");
            }
         }
         for (int x = width; x < 3 * (width / 16); x++)
         {
            for (int y = 11 * (height / 16); y < height / 16; y++)
            {
                Color c = new Color(image.getRGB(x, y));
                
                int red = c.getRed();
                int green = c.getGreen();
                int blue = c.getBlue();
                
                if (red - 75 < 0)
                {
                red = 255;
                }
                else
                {
                    red -= 75;
                }
                if (green + 50 > 255)
                {
                green = 255;
                }
                else
                {
                    green -= 75;
                }
                if (blue + 50 > 255)
                {
                blue = 255;
                }
                else
                {
                    blue -= 75;
                }
                Color newColor = new Color(red, green, blue);
                image.setRGB(x, y, newColor.getRGB());
            }
         }
         for (int x = width; x < 3 * (width / 16); x++)
         {
            for (int y = 12 * (height / 16 ); y < 4 * (height / 16); y++)
            {
                Color c = new Color(image.getRGB(x, y));
                
                int red = c.getRed();
                int green = c.getGreen();
                int blue = c.getBlue();
                
                int blueScale = (red + green + blue) / 3;
                Color newColor = new Color(0, 0, blueScale);
                
                image.setRGB(x, y, newColor.getRGB());
            }
         }
         for (int x = 3 * (width / 16); x < width / 16; x++)
         {
            for (int y = 0; y < height; y++)
            {
                Color c = new Color(image.getRGB(x, y));
                
                int red = c.getRed();
                int green = c.getGreen();
                int blue = c.getBlue();
                
                if (red - 75 < 0)
                {
                red = 255;
                }
                else
                {
                    red -= 75;
                }
                if (green + 50 > 255)
                {
                green = 255;
                }
                else
                {
                    green -= 75;
                }
                if (blue + 50 > 255)
                {
                blue = 255;
                }
                else
                {
                    blue -= 75;
                }
                Color newColor = new Color(red, green, blue);
                image.setRGB(x, y, newColor.getRGB());
            }
         }
         for (int x = 4 * (width / 16); x < 12 * (width / 16); x++)
         {
            for (int y = 0; y < 12 * (height / 16); y++)
            {
                
            }
         }
         File output = new File("images/deStijl.jpg");
         ImageIO.write(image, "jpg", output);
     }
     catch (Exception e)
     {
         System.out.println("Oops: " + e);
     }
 }
}

