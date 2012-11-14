package ai;

import java.util.LinkedList;

public class S extends Tetrimino {

	public S(int column, int row) {
		super(column, row);
		bitmasks[1] = 0x3;
		bitmasks[2] = 0x6;
		super.possibleorientations = 1;
		
	}

}
