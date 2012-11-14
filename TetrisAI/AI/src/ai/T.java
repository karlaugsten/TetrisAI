package ai;

public class T extends Tetrimino {

	public T(int column, int row){
		super(column, row);
		bitmasks[2] = 0x2;
		bitmasks[1] = 0x7;
		super.possibleorientations = 3;
	}
	
}
