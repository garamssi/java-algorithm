package garam.week3.thursday.문제1_networkDelayTime;

public class Pair<L, R> {
	L left;
	R right;

	public Pair(L left, R right) {
		this.left = left;
		this.right = right;
	}

	public L getLeft() {
		return this.left;
	}

	public R getRight() {
		return this.right;
	}
}
