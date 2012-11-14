package ai;

import java.util.LinkedList;

public class S extends Tetrimino {

	public S(int orientation, int column, int row) {
		super(orientation, column, row);
		super.offsets = new LinkedList<Position>();
		super.possibleorientations = 0;
		super.offsets.add(new Position(0,0));
		if(orientation == 0){
			super.offsets.add(new Position(0,1));
			super.offsets.add(new Position(-1,1));
			super.offsets.add(new Position(1,0));
		}else if(orientation == 1){
			super.offsets.add(new Position(1,1));
			super.offsets.add(new Position(0,-1));
			super.offsets.add(new Position(1,0));
		}
	}

}
