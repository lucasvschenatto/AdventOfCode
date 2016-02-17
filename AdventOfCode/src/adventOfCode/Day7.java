package adventOfCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day7 implements Challenge{
	@Override
	public String part1(String input) {
		return String.valueOf(Day7.instantiate(input).signalOf("a"));
	}
	@Override
	public String part2(String input) {
//		return String.valueOf(Day7.instantiate(input).signalOf("a"));
		return "";
	}
	public static final int MASK = (1 << 16) -1;
	private static Day7 instance;
	private List<Wire> wires;
	public static Day7 getInstance(){
		return instance;
	}
	public List<Wire> getWires(){
		return wires;
	}
	public static Day7 instantiate(String circuit){
		 return instance = new Day7(circuit);
	}
	private Day7(String circuit) {
		wires = interpret (circuit);
	}

	public Day7() {
	}
	private List<Wire> interpret(String circuit) {
		List<Wire> wires = new ArrayList<Wire>();
		List<String> sWires = Arrays.asList(circuit.split("\n"));
		for (String wire : sWires) {
			String[] aWire = wire.split(" -> ");
			wires.add(new Wire(aWire[0],aWire[1]));
		}
		return wires;
	}

	public int signalOf(String name) {
		for (Wire wire : wires) {
			if(wire.getName().equals(name))
				return wire.getSignal();
		}
		return 0;
	}
	public class Wire{
		private Source source;
		private String name;
		public Wire(String source, String name){
			this.source = new SourceFactory().create(source);
			this.name = name;
		}
		public String getName() {
			return name;
		}
		public int getSignal() {
			return source.run();
		}
	}
	public class SourceFactory{
		public Source create(String inputs){
			String[] i = inputs.split(" ");
			switch (i.length){
			case 1:
				return new Imply(i[0]);
			case 2:
				return new Not(i[1]);
			case 3:
				switch (i[1]){
				case "LSHIFT":
					return new LShift(i[0],i[2]);
				case "RSHIFT":
					return new RShift(i[0],i[2]);
				case "AND":
					return new And(i[0],i[2]);
				case "OR":
					return new Or(i[0],i[2]);
				}
			default:
				return null;
			}
		}
	}
	public interface Source{
		public int run();
		default int getValue(String input){
			try{
				System.out.println(input);
				return Integer.valueOf(input);}
			catch (NumberFormatException e){
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				for (Wire wire : Day7.getInstance().getWires())
					if(wire.getName().equals(input))
						return wire.getSignal();
			}
			return 0;
		}
	}
	public class Imply implements Source{
		private String input;
		public Imply(String input){
			this.input = input;
		}
		public int run(){
			return getValue(input);
		}
	}
	public class Not implements Source{
		private String input;
		public Not(String input){
			this.input = input;
		}
		public int run(){
			return ~ getValue(input) & MASK;
		}
	}
	public class Or implements Source{
		private String input1, input2;
		public Or(String input1,String input2){
			this.input1 = input1;
			this.input2 = input2;
		}
		public int run(){
			return (getValue(input1)&MASK) | (getValue(input2)&MASK);
		}
	}
	public class And implements Source{
		private String input1, input2;
		public And(String input1,String input2){
			this.input1 = input1;
			this.input2 = input2;
		}
		public int run(){
			return (getValue(input1)&MASK) & (getValue(input2)&MASK);
		}
	}
	public class LShift implements Source{
		private String input1, input2;
		public LShift(String input1,String input2){
			this.input1 = input1;
			this.input2 = input2;
		}
		public int run(){
			return (getValue(input1)&MASK) << (getValue(input2)&MASK);
		}
	}
	public class RShift implements Source{
		private String input1, input2;
		public RShift(String input1,String input2){
			this.input1 = input1;
			this.input2 = input2;
		}
		public int run(){
			return (getValue(input1)&MASK) >> (getValue(input2)&MASK);
		}
	}
}
