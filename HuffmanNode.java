
public class HuffmanNode {

	private String text;
	private int frequency;
	private HuffmanNode next;
	
	public HuffmanNode()
	{
		text = "";
		frequency = 0;
		next = null;
	}
	public HuffmanNode(String text, int frequency)
	{
		this.text = text;
		this.frequency = frequency;
		
	}
	
	public String getText()
	{
			return text;
			
	}
	public int getFrequency()
	{
		return frequency;
	}
	public HuffmanNode getNext()
	{
			return next;
	}
	public void setFrequency(int initialFreq)
	{
			frequency = initialFreq;
	}
	public void setText(String initialText)
	{
			text = initialText;
	}
	public void setNext(HuffmanNode p)
	{
		next = p;
	}

}
