package ai;

public class L extends Tetrimino {

	public L(int column, int row){
		super(column, row);
		bitmasks[2] = 0x4;
		bitmasks[1] = 0x7;
		super.possibleorientations = 3;
	}
	
}
