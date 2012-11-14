package ai;

public class Z extends Tetrimino {
	
	public Z(int column, int row) {
		super(column, row);
		bitmasks[2] = 0x3;
		bitmasks[1] = 0x6;
		super.possibleorientations = 1;
	}


}
