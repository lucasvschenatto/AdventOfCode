package adventOfCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import adventOfCode.day7.*;
import adventOfCode.submit.Challenge;

public class Day7 implements Challenge{

	private static Day7 instance;
	private List<Wire> wires;

	public static Day7 getInstance() {
		return instance;
	}

	public List<Wire> getWires() {
		return wires;
	}

	public static Day7 instantiate(String circuit) {
		return instance = new Day7(circuit);
	}

	private Day7(String circuit) {
		wires = interpret(circuit);
	}

	public Day7() {
	}

	private List<Wire> interpret(String circuit) {
		List<Wire> wires = new ArrayList<Wire>();
		List<String> sWires = Arrays.asList(circuit.split("\n"));
		for (String wire : sWires) {
			String[] aWire = wire.split(" -> ");
			wires.add(new Wire(aWire[0], aWire[1]));
		}
		return wires;
	}

	public int signalOf(String name) {
		for (Wire wire : wires) {
			if (wire.getName().equals(name))
				return wire.getSignal();
		}
		return 0;
	}

	public void overrideSignal(String wire, int signal) {
		for (Wire w : wires) {
			if (w.getName().equals(wire))
				w.setSignal(signal);
		}
	}

	public void eraseSignals() {
		for (Wire wire : wires) {
			wire.setSignal(0);
		}
	}

	@Override
	public String part1(String input) {
		return String.valueOf(Day7.instantiate(input).signalOf("a"));
	}
	@Override
	public String part2(String input) {
		Day7 d = Day7.instantiate(input);
		int firstA = d.signalOf("a");
		d.eraseSignals();
		d.overrideSignal("b", firstA);
		return String.valueOf(d.signalOf("a"));
	}
}
