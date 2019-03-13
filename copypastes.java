
blue

Color c = new Color(image.getRGB(x, y));
                
                int red = c.getRed();
                int green = c.getGreen();
                int blue = c.getBlue();
                
                int blueScale = (red + green + blue) / 3;
                Color newColor = new Color(0, 0, blueScale);
                
                image.setRGB(x, y, newColor.getRGB());
                
yellow

Color c = new Color(image.getRGB(x, y));
                
                int red = c.getRed();
                int green = c.getGreen();
                int blue = c.getBlue();
                
                int yellowScale = (red + green + blue) / 3;
                Color newColor = new Color(yellowScale, yellowScale, 0);
                
                image.setRGB(x, y, newColor.getRGB());
                
red

Color c = new Color(image.getRGB(x, y));
                
                int red = c.getRed();
                int green = c.getGreen();
                int blue = c.getBlue();
                
                int redScale = (red + green + blue) / 3;
                Color newColor = new Color(redScale, 0, 0);
                
                image.setRGB(x, y, newColor.getRGB());
                
black

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
  
 white
  
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