public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution(4);
		System.out.println(solution.firstBadVersion(5) + " expected 4");
		solution = new Solution(3);
		System.out.println(solution.firstBadVersion(7) + " expected 3");
		solution = new Solution(8);
		System.out.println(solution.firstBadVersion(10) + " expected 8");
		solution = new Solution(1);
		System.out.println(solution.firstBadVersion(2) + " expected 1");
	}

	static class Solution extends VersionControl {
		public Solution(int target) {
			super(target);
		}

		public int firstBadVersion(int n) {
			long goodVersion = 1;
			long badVersion = n;

			while (goodVersion < badVersion) {
				long avg = (goodVersion + badVersion) / 2;
				if (isBadVersion((int) avg)) {
					if (badVersion == avg && isBadVersion((int) badVersion - 1))
						return (int) badVersion - 1;
					else
						badVersion = avg;
				} else {
					goodVersion = goodVersion == avg ? goodVersion + 1 : avg;
				}
			}
			return (int)badVersion;
		}
	}

	static class VersionControl {
		int target;

		public VersionControl(int target) {
			this.target = target;
		}

		boolean isBadVersion(int version){
			return version >= target;
		}
	}
}