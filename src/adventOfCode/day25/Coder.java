package adventOfCode.day25;

public abstract class Coder {
	private long firstCode;
	public Coder(long firstCode) {
		this.firstCode = firstCode;
	}

	protected abstract long nextCode(long code);

	public long getCode(long row, long col) {
		long code = firstCode;
		long r = 1;
		long c = 1;
		long maxR = 1;
		while(r!=row || c != col){
			if(r==1){
				r = ++maxR;
				c = 1;
			}
			else{
				r--;
				c++;
			}
			code = nextCode(code);
		}
		return code;
	}
}
