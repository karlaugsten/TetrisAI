package ai;

public class J extends Tetrimino {

	public J(int column, int row){
		super(column, row);
		bitmasks[2] = 0x1;
		bitmasks[1] = 0x7;
		super.possibleorientations = 3;
	}
}
