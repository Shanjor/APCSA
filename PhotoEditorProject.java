import java.util.Scanner;
import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
/**
 * Edits photos hey
 *
 * @author (Jonathan Hewings, Bianca Rodriguez, Jasmine Ma, Shane Jordan)
 * @version (11/27/18)
 */
public class PhotoEditorProject
{
    public static BufferedImage image; 
    public static Scanner kb = new Scanner (System.in);
    
    public static int height = 0;
    public static int width = 0;
    public static void main (String [] args){}
    
    public static void mainMenu ()
    {
        Scanner strings = new Scanner (System.in);
        System.out.println("Type in the image you want to load:");
        String imageLoad = kb.nextLine();
        
        try
        {
            File input = new  File("images/" + imageLoad + ".jpg");
            image = ImageIO.read(input);
        }
        catch (Exception e)
        {
            System.out.println("Oops:" + e);
        }
        
        boolean editing = true;
        
        while (editing) {
                getDimensions();
                System.out.println("The image is " + width + " x " + height + ".");
                
                System.out.println("What modification would you like to make?");
                System.out.println("1 - Stretch your image horizontally"); //bianca
                System.out.println("2 - Darken"); //shane
                System.out.println("3 - Lighten"); //jonathan
                System.out.println("4 - Change the green value"); //bianca
                System.out.println("5 - Crop Right off"); //jasmine
                System.out.println("6 - Crop Left off"); //nobody
                System.out.println("7 - Crop Bottom off"); //shane
                System.out.println("8 - Crop Top off"); //jonathan
                System.out.println("9 - Change the red value"); //shane
                System.out.println("10 - Random"); //nobody
                System.out.println("11 - Modify Blue"); //jasmine
                System.out.println("12 - Done!");
                int editChoice = kb.nextInt(); 
                
                getDimensions();
                
                switch (editChoice)
                {
                    case 1: 
                        stretchedImage();
                        break;
                    case 2: 
                        darken();
                        break;
                    case 3:
                        lighten();
                        break;
                    case 4:
                        modifiedGreen();
                        break;
                    case 5:
                        cropRightOfImage();
                        break;
                    case 6:
                        cropLeftOfImage();
                        break;
                    case 7:
                        cropBottomOfImage();
                        break;
                    case 8:
                        cropTopOfImage();
                        break;
                    case 9:
                        redValueChanger();
                        break;
                    case 10:
                        random();
                        break;
                    case 11:
                        modBlue();
                        break;
                    case 12:
                        editing = false;
                        break;
                    default: 
                        System.out.print("Invalid answer. Try again."); 
                }
            }
     
        
        System.out.println("Please enter the new name of the file that you would like to be saved: ");
        String imageSave = strings.nextLine();
        
        try {
            File output = new File("images/" + imageSave + ".jpg");
            ImageIO.write(image, "jpg", output);
        }
        catch (Exception e) {
            System.out.println("Oops:" + e);
        }
        
        System.out.println("Congratulations, your photo is now edited!");
    }
    public static void getDimensions()
    {
        width = image.getWidth();
        height = image.getHeight();
    }
    public static void stretchedImage()
    {
            System.out.println("You chose to stretch your image horizontally.");
            
            BufferedImage newImage = new BufferedImage(width * 2, height, BufferedImage.TYPE_INT_RGB);
            
            System.out.println("");
                for (int x = 0; x < width; x++)
                 {
                    for (int y = 0; y < height; y++)
                    {
                        Color c = new Color(image.getRGB(x, y));

                        newImage.setRGB(x * 2, y, c.getRGB());
                        newImage.setRGB(x * 2 + 1, y, c.getRGB());
                    }
             }
            
            image = newImage;

    }
    public static void modBlue ()
    {
            System.out.println("You have selected Modify Blue Filter. Between, 1-255, how much blue value do you want on the left side of your image?");
            
            int hueValue = kb.nextInt();
            System.out.println("Modify Blue filter has been applied to the left side of your image");
            if (hueValue > 255)
            {
                System.out.println("Please select a number between 0 and 255");
                hueValue = kb.nextInt();
            }
            
            if (hueValue < 0)
            {
                System.out.println("Please select a number between 0 and 255");
                hueValue = kb.nextInt();
            }
        
      
            for (int x = 0; x< width/2; x++)
            {
                for (int y = 0; y<height; y++)
                {
                    Color c = new Color(image.getRGB(x, y));
                    
                    int red = c.getRed();
                    int green = c.getGreen();
                    int blue = c.getBlue();
                    
                    Color newColor = new Color(red, green, hueValue);
                    
                    image.setRGB(x, y, newColor.getRGB());
                    
                }
            }

    }
    public static void lighten()
    {
        System.out.println("You chose to lighten your photo.");
        System.out.println("How light do you want your photo to be?");
        System.out.println("1- A little bit lighter.");
        System.out.println("2- More than a little bit lighter.");
        System.out.println("3- More than more than a little bit lighter.");
        int choice = kb.nextInt();
        int lightness = 0;
        
        switch(choice)
        {
               case 1:
               lightness = 50;
               break;
        
               case 2:
               lightness = 75;
               break;
        
               case 3:
               lightness = 100;
               break;
        
               default:
               System.out.println("Dumbass.");
               break;
        }
            
        for (int x = 0; x < width; x++)
        {
            for(int y = 0; y < height; y++)
            {
                Color c = new Color(image.getRGB(x,y));
                
                int red = c.getRed();
                int green = c.getGreen();
                int blue = c.getBlue();
                
                if (red + lightness < 255)
                {
                    red += lightness;
                }
                else
                {
                    red = 255;
                }
                if (green + lightness < 255)
                {
                    green += lightness;
                }
                else
                {
                    green = 255;
                }
                if(blue + lightness < 255)
                {
                    blue += lightness;
                }
                else
                {
                    blue = 255;
                }
           
                
                
                Color newColor = new Color(red, green, blue);
                
                image.setRGB(x,y, newColor.getRGB());
            }
        }
        }
    public static void cropTopOfImage()
    {
        System.out.println("\nCropping off the top...\n");
        
        BufferedImage newImage = new BufferedImage(width, height / 2, BufferedImage.TYPE_INT_RGB);
        
        for (int x = 0; x < width; x++)
         {
            for (int y = 0; y < height / 2; y++)
            {
                Color c = new Color(image.getRGB(x, (y + (height / 2))));
                
                newImage.setRGB(x, y, c.getRGB());
            }
         }
        
        image = newImage;

    }
    public static void modifiedGreen()
    {
            System.out.println("From 0 - 255, how much green would you like on the image?");
            int hue = kb.nextInt(); 
            
            if (hue > 255)
            {
                System.out.println("Number out of bounds. Try again."); 
                    hue = kb.nextInt(); 
                }
            if (hue < 0)
            {
                System.out.println("Number out of bounds. Try again."); 
                    hue = kb.nextInt(); 
                }
            
            for (int x = 0; x < width; x++)
            {
                for (int y = 0; y < height / 2; y++)
                {
                     Color c = new Color(image.getRGB(x, y));
                     
                     int red = c.getRed();
                     int green = c.getGreen();
                     int blue = c.getBlue();

                     Color newColor = new Color(red, hue, blue);
                     
                     image.setRGB(x, y, newColor.getRGB());
                }
            }

    }
    public static void cropBottomOfImage ()
    {
        System.out.println("\nCropping off the bottom...\n");
        
        BufferedImage newImage = new BufferedImage(width, height / 2, BufferedImage.TYPE_INT_RGB);
        
        for (int x = 0; x < width; x++)
        {
            for (int y = 0; y < height / 2; y++)
            {
                Color c = new Color(image.getRGB(x, y));
                
                newImage.setRGB(x, y, c.getRGB());
            }
        }
        
        image = newImage;
        
    }
     public static void darken()
    {
        boolean darkening = true;
        System.out.println("By how much would you like to darken your image?");
        
        int darken = 0;
        
        while (darkening) {    
            System.out.println("1 - Slightly Darker");
            System.out.println("2 - Medium Darker");
            System.out.println("3 - Lots darker");
            int choice = kb.nextInt();
            switch (choice)
            {
                case 1:
                    darken = 50;
                    darkening = false;
                    break;
                case 2:
                    darken = 75;
                    darkening = false;
                    break;
                case 3:
                    darken = 100;
                    darkening = false;
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }
        }
        for (int x = 0; x < width; x++)
         {
            for (int y = 0; y < height; y++)
            {
                    Color c = new Color(image.getRGB(x, y));
                            
                    int red = c.getRed();
                    int green = c.getGreen();
                    int blue = c.getBlue();
                    
                    if (red - darken < 0)
                        {
                            red = 0;
                        }
                    else
                        {
                            red -= darken;
                        }
                    if (green - darken < 0)
                        {
                            green = 0;
                        }
                    else
                        {
                            green -= darken;
                        }
                    if (blue - darken < 0)
                        {
                            blue = 0;
                        }
                    else
                        {
                            blue -= darken;
                        }
                    Color newColor = new Color(red, green, blue);
                    image.setRGB(x, y, newColor.getRGB());
            }
         }
    }
     public static void cropRightOfImage()
    {
        System.out.println("\nCropping off the right...\n");
        
        BufferedImage newImage = new BufferedImage(width / 2, height, BufferedImage.TYPE_INT_RGB);
        
        for (int x = 0; x < width / 2; x++)
         {
            for (int y = 0; y < height; y++)
            {
                Color c = new Color(image.getRGB((x + (width / 2)), y));
                
                newImage.setRGB(x, y, c.getRGB());
            }
         }
        
        image = newImage;

    }
     public static void cropLeftOfImage()
    {
        System.out.println("\nCropping off the left...\n");
        
        BufferedImage newImage = new BufferedImage(width / 2, height, BufferedImage.TYPE_INT_RGB);
        
        for (int x = 0; x < width / 2; x++)
        {
            for (int y = 0; y < height; y++)
            {
                Color c = new Color(image.getRGB(x, y));
                
                newImage.setRGB(x, y, c.getRGB());
            }
        }
        
        image = newImage;

    }
    public static void redValueChanger()
    {
        boolean changing = true;
        
        while (changing) {
            System.out.println("Would you like to change the red values to be more:");
            System.out.println("1 - Green");
            System.out.println("2 - Blue");
            int blueChanger = kb.nextInt();
            switch (blueChanger) {
                case 1:
                for (int x = 0; x < width; x++)
                 {
                    for (int y = 0; y < height; y++)
                    {
                            Color c = new Color(image.getRGB(x, y));
                                    
                            int red = c.getRed();
                            int green = c.getGreen();
                            int blue = c.getBlue();
                            
                            if (red > green + blue)
                            {
                                if (red - 100 > 0)
                                red -= 100;
                                else
                                red = 0;
                                if (green + 75 >= 255)
                                    {
                                        green = 255;
                                    }
                                else
                                    {
                                        green += 75;
                                    }
                            }
                            
                            Color newColor = new Color(red, green, blue);
                            image.setRGB(x, y, newColor.getRGB());
                    }
                 }
                changing = false;
                break;
                case 2:
                for (int x = 0; x < width; x++)
                 {
                    for (int y = 0; y < height; y++)
                    {
                            Color c = new Color(image.getRGB(x, y));
                                    
                            int red = c.getRed();
                            int green = c.getGreen();
                            int blue = c.getBlue();
                            
                            if (red > green + blue)
                            {
                                if (red - 100 > 0)
                                red -= 100;
                                else
                                red = 0;
                                if (blue + 75 >= 255)
                                    {
                                        blue = 255;
                                    }
                                else
                                    {
                                        blue += 75;
                                    }
                            }
                            
                            Color newColor = new Color(red, green, blue);
                            image.setRGB(x, y, newColor.getRGB());
                    }
                 }
                changing = false;
                break;
                default:
                System.out.println("Don't try and break Java!");
                break;
            }
        }
    }
    public static void random ()
    {
        System.out.println("RANDOM!!!!!! \n"); 
        int randomMethod = (int)(Math.random()*10 + 1);
        switch (randomMethod)
        {
            case 1:
            lighten();
            break;
            case 2:
            darken();
            break;
            case 3:
            redValueChanger();
            break;
            case 4:
            cropTopOfImage();
            break;
            case 5:
            cropBottomOfImage();
            break;
            case 6:
            cropLeftOfImage();
            break;
            case 7:
            cropRightOfImage();
            break;
            case 8:
            modBlue();
            break;
            case 9:
            modifiedGreen();
            break;
            case 10:
            stretchedImage();
            break;
            default:
            break;
        }
    }
}


