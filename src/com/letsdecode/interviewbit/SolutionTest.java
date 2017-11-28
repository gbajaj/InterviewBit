package com.letsdecode.interviewbit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.letsdecode.interviewbit.Solution.Interval;

public class SolutionTest {

	@Test
	public void test() {
		Solution s = new Solution();
		ArrayList<Interval> intervals = new ArrayList<>();
		intervals.add(s.new Interval(1, 4));
		intervals.add(s.new Interval(2, 5));

		new Solution().insert(intervals, s.new Interval(2, 3));
	}

	@Test
	public void isPalindrome() {
		Solution s = new Solution();
		System.out.println(s.isPalindrome("1a2"));
	}

	@Test
	public void reverseWords() {
		Solution s = new Solution();
		System.out.println(s.reverseWords("1a2"));

	}

	@Test
	public void plusOne() {
		Solution s = new Solution();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(1);
		list.add(9);
		System.out.println(s.plusOne(list));

	}

	// @Test
	// public void repeatedNumber() {
	// Solution solution = new Solution();
	// int a[] = { 310, 164, 385, 493, 296, 369, 405, 421, 24, 187, 98, 109,
	// 245, 324, 464, 438, 467, 526, 19, 39, 206, 128, 380, 119, 129,
	// 85, 131, 510, 132, 40, 332, 275, 51, 528, 412, 525, 4, 259,
	// 356, 258, 90, 66, 153, 223, 414, 89, 410, 227, 291, 314, 358,
	// 204, 340, 436, 7, 188, 325, 538, 182, 141, 408, 198, 42, 337,
	// 214, 509, 349, 79, 116, 428, 53, 91, 326, 333, 33, 415, 165,
	// 271, 183, 244, 330, 392, 123, 522, 437, 420, 362, 331, 286, 84,
	// 130, 163, 145, 483, 190, 482, 115, 16, 496, 418, 267, 240, 175,
	// 65, 276, 154, 173, 355, 315, 504, 101, 260, 458, 274, 413, 497,
	// 15, 213, 398, 473, 284, 456, 397, 309, 344, 5, 402, 229, 347,
	// 236, 254, 140, 472, 391, 336, 535, 533, 25, 429, 475, 441, 352,
	// 434, 26, 45, 75, 257, 57, 46, 442, 536, 209, 411, 146, 432, 34,
	// 118, 346, 23, 512, 71, 480, 107, 321, 126, 52, 407, 393, 515,
	// 217, 195, 294, 86, 502, 72, 517, 455, 281, 495, 230, 108, 295,
	// 424, 426, 460, 524, 452, 181, 185, 208, 180, 47, 303, 520, 36,
	// 200, 530, 12, 67, 445, 492, 419, 372, 105, 59, 306, 317, 379,
	// 150, 63, 363, 248, 505, 167, 152, 404, 516, 316, 433, 70, 439,
	// 390, 9, 133, 298, 232, 95, 157, 176, 215, 172, 224, 169, 127,
	// 106, 8, 537, 135, 255, 313, 375, 241, 506, 253, 312, 11, 448,
	// 139, 263, 2, 112, 21, 304, 297, 334, 278, 162, 142, 343, 328,
	// 280, 69, 311, 486, 457, 285, 219, 499, 226, 329, 521, 374, 489,
	// 76, 231, 193, 447, 431, 148, 444, 371, 256, 211, 365, 339, 56,
	// 459, 350, 58, 269, 242, 249, 30, 43, 113, 177, 476, 364, 465,
	// 3, 96, 484, 99, 147, 501, 270, 425, 49, 487, 55, 373, 377, 400,
	// 422, 477, 282, 423, 272, 384, 399, 498, 323, 238, 144, 83, 44,
	// 327, 158, 386, 287, 409, 216, 196, 277, 307, 235, 401, 466, 32,
	// 22, 299, 471, 81, 378, 265, 137, 288, 159, 283, 268, 395, 387,
	// 13, 292, 490, 6, 122, 417, 243, 239, 203, 31, 293, 82, 485,
	// 381, 202, 197, 273, 403, 446, 383, 77, 60, 435, 102, 361, 205,
	// 481, 353, 474, 301, 94, 125, 184, 367, 20, 151, 222, 237, 17,
	// 290, 523, 468, 156, 266, 149, 443, 289, 394, 513, 28, 519, 191,
	// 507, 518, 478, 251, 396, 532, 416, 440, 247, 35, 234, 308, 37,
	// 302, 341, 1, 121, 138, 279, 469, 10, 233, 74, 61, 124, 78, 220,
	// 194, 494, 252, 88, 110, 189, 18, 261, 48, 38, 41, 114, 318,
	// 479, 406, 360, 97, 454, 68, 136, 503, 451, 100, 178, 160, 186,
	// 514, 322, 210, 73, 212, 103, 54, 354, 500, 225, 450, 335, 305,
	// 170, 462, 228, 348, 199, 262, 143, 111, 155, 92, 319, 345, 491,
	// 192, 14, 166, 207, 171, 338, 168, 250, 27, 389, 368, 117, 351,
	// 201, 179, 221, 529, 93, 87, 104, 134, 357, 359, 50, 430, 531,
	// 488, 470, 449, 342, 320, 134, 64, 62, 246, 511, 527, 388, 453,
	// 264, 463, 370, 120, 508, 376, 461, 174, 382, 427, 161, 80, 29,
	// 300, 366, 218, 534 };
	// ArrayList<Integer> l = new ArrayList<>();
	//
	// for (int i = 0; i < a.length; i++) {
	// l.add(a[i]);
	// }
	// solution.repeatedNumber(l);
	//
	// }
	//
	// @Test
	// public void setZeroes() {
	// Solution solution = new Solution();
	// ArrayList<ArrayList<Integer>> a = new ArrayList<>();
	// ArrayList<Integer> l = new ArrayList<>();
	// l.add(0);
	// l.add(1);
	// a.add(l);
	// l = new ArrayList<>();
	//
	// l.add(1);
	// l.add(1);
	// a.add(l);
	//
	// solution.setZeroes(a);
	// }

	//
	// @Test
	// public void romanToInteger() {
	// Solution solution = new Solution();
	// System.out.println(solution.romanToInteger("xiv"));
	// System.out.println(solution.romanToInteger("x"));
	// System.out.println(solution.romanToInteger("v"));
	// System.out.println(solution.romanToInteger("m"));
	// System.out.println(solution.romanToInteger("c"));
	// System.out.println(solution.romanToInteger("l"));
	//
	// }
	//
	// @Test
	// public void compareVersion() {
	// Solution solution = new Solution();
	// System.out.println(solution.compareVersion("4444371174137455", "5.168"));
	// }
	//

	@Test
	public void countAndSay() {
		Solution solution = new Solution();
		System.out.println(solution.countAndSay(5));
	}

	@Test
	public void merge() {
		Solution solution = new Solution();
		int[] a = { 0 };
		int[] b = { 1 };
		solution.merge(a, 0, b, 1);
	}

	@Test
	public void addOperators() {
		Solution sol = new Solution();
		System.out.println(sol.addOperators("123", 6));
	}

	@Test
	public void isMatch() {
		Solution sol = new Solution();
		System.out.println(sol.isMatch("ab", ".*c"));
	}

}
