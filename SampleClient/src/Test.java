import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class Test {

	public static void main(String[] args) {
		String url="http://localhost:2017/SampleProvider/rest/test/best";
		Client c=Client.create();
		WebResource wr=c.resource(url);
		wr=wr.queryParam("sfee","22.3");
		wr=wr.queryParam("sname","AAA");
		wr=wr.queryParam("sid","99");
		ClientResponse cr=wr.get(ClientResponse.class);
		String m=cr.getEntity(String.class);
		System.out.println(m);
		System.out.println(cr.getStatus());
		System.out.println(cr.getStatusInfo());

	}

}
