package ai;

import java.util.LinkedList;

public class O extends Tetrimino {

	public O(int column, int row) {
		super(column, row);
		super.bitmasks[1] = 0x6;
		super.bitmasks[2] = 0x6;
		super.possibleorientations = 0;
	}
}
