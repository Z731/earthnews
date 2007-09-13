package earthnews.localserver;

import java.io.File;
import org.mortbay.http.HttpContext;
import org.mortbay.http.HttpServer;
import org.mortbay.http.SocketListener;
import org.mortbay.http.handler.ResourceHandler;

/**
 * Web Server serving feed files for offline mode.
 *
 */
public class FeedServer
{
	private HttpServer	server;
	private String			mFeedsFolder	= "./offlinefeeds/";

	public FeedServer()
	{
		super();
		server = new HttpServer();
		SocketListener listener = new SocketListener();
		listener.setPort(8080);
		server.addListener(listener);

		HttpContext context = new HttpContext();
		context.setContextPath("/");
		context.setResourceBase(mFeedsFolder);
		context.addHandler(new ResourceHandler());
		server.addContext(context);
	}

	public boolean start()
	{
		try
		{
			server.start();
			return true;
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

	public boolean stop()
	{
		try
		{
			server.stop();
			return true;
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

	File[] getListOfFeeds()
	{
		File mFeedFolderFile = new File(mFeedsFolder);
		File[] mFeedFilesArray = mFeedFolderFile.listFiles();
		return mFeedFilesArray;
	}

}
