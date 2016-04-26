import java.net.URL;
import java.net.URLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.UnknownHostException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.parser.JSONParser;

public class Server 
{
	private String host;
    private int port;
    private Socket socket;
    private final String DEFAULT_HOST = "localhost";

	public Server() 
	{
		this.host = host;
		this.port = port;
		this.socket = socket;
	}

	public boolean isWerewolf()
	{
		boolean yes = false;
		return yes;
	}

	public void connect(String host, int port) throws IOException
	{
		this.host = host;
		this.port = port;
		socket = new Socket(host, port);
		System.out.println("Game sudah dimulai... V^__^V");

	}

	public JSONObject receiveJSON() throws IOException
	{
		InputStream in = socket.getInputStream();
		ObjectInputStream i = new ObjectInputStream();
		JSONObject line = null;
		try {
			line = (JSONObject) i.readObject();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}

		return line;
	}

	public void sendJSON(JSONObject jsonObj) throws IOException
	{
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("key", new Paper(250,333));

		OutputStream out = socket.getOutputStream();
		ObjectOutputStream o = new ObjectOutputStream(out);
		o.writeObject(jsonObject2);
		out.flush();
	}

	public static void main(String[] args) throws Exception 
	{

	}
}