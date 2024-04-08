package A형대비;

public class 핀볼 {
	static int N,max;
	static int[][] board;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static class ball {
		int row, col, point, dir;

		public ball(int row, int col, int point, int dir) {
			this.row = row;
			this.col = col;
			this.point = point;
			this.dir = dir;
		}
	}

	static int changedir1(int i) {
		switch (i) {
		case 0:
			return 2;
		case 1:
			return 3;
		case 2:
			return 1;
		case 3:
			return 0;
		default:
			return -1;
		}
	}
	static int changedir2(int i) {
		switch (i) {
		case 0:
			return 1;
		case 1:
			return 3;
		case 2:
			return 0;
		case 3:
			return 2;
		default:
			return -1;
		}
	}
	static int changedir3(int i) {
		switch (i) {
		case 0:
			return 3;
		case 1:
			return 2;
		case 2:
			return 0;
		case 3:
			return 1;
		default:
			return -1;
		}
	}
	static int changedir4(int i) {
		switch (i) {
		case 0:
			return 2;
		case 1:
			return 0;
		case 2:
			return 3;
		case 3:
			return 1;
		default:
			return -1;
		}
	}
	static int changedir5(int i) {
		switch (i) {
		case 0:
			return 2;
		case 1:
			return 3;
		case 2:
			return 0;
		case 3:
			return 1;
		default:
			return -1;
		}
	}

	static void pinball(int srow, int scol) {
		for (int i = 0; i < 4; i++) {
			ball b = new ball(srow,scol , 0, i);
			int nr = srow;
			int nc = scol;
			while(nr!=srow || nc!=scol) {
				nr+=dr[b.dir];
				nc+=dc[b.dir];
				if(nr==0)
			if(nr==srow && nc==scol) {
				max = Math.max(max, b.point);
				return;
			}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
