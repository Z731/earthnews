package earthnews.worldwind.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

/**
 * Generic Utilities, 
 * in particular the loading of Images from ressources.
 *
 */
public class GraphicsUtils
{
	private static GraphicsUtils	cGraphicsUtils	= new GraphicsUtils();

	private GraphicsUtils()
	{
	}

	public static BufferedImage loadImageFromRessources(String pFileName) throws IOException
	{
		BufferedImage lImage;
		InputStream stream = cGraphicsUtils.getClass().getClassLoader().getResource(pFileName).openStream();

		System.err.print("Loading Image '" + pFileName + "'...");
		lImage = ImageIO.read(stream);
		System.err.println("done, width=" + lImage.getWidth() + ", height=" + lImage.getHeight());
		if ((lImage.getWidth() == 0) || (lImage.getHeight() == 0))
			throw new IOException("Empty image");

		return lImage;
	}

}
