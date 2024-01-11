package garam.week2.tuesday.문제1_maximumDepthOfBinaryTree;

class Pair<L, R> {
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
