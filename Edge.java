
public class Edge {

	protected String vertex;
	protected int weight;
	protected Edge next;
	protected String direction;
	
	public Edge()
	{
		vertex = "";
		weight = 0;
	}
	public Edge(String vertex)
	{
		this.vertex = vertex;
	}
	
	public Edge(String vertex, int weight)
	{
		this.vertex = vertex;
		this.weight = weight;
	}
	public Edge(int weight,String vertex,  String direction)
	{
		this.weight = weight;
		this.vertex = vertex;
		this.direction = direction;
	}

}





