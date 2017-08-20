package adventOfCode.day7;

public class Wire{
	private Source source;
	private String name;
	private int signal;
	public Wire(String source, String name){
		this.source = new SourceFactory().create(source);
		this.name = name;
	}
	public void setSignal(int signal) {
		this.signal = signal;
	}
	public String getName() {
		return name;
	}
	public int getSignal() {
		if (signal == 0)
			 signal = source.run();
		return signal;
	}
}