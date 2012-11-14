package ai;

import java.util.LinkedList;

public class I extends Tetrimino {

	public I(int column, int row) {
		super(column, row);
		super.bitmasks[1] = 0xF;
		super.possibleorientations = 1;
		
	}

}
