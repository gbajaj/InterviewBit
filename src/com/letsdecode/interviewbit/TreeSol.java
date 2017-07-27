package com.letsdecode.interviewbit;

import java.util.ArrayList;
import java.util.Stack;

public class TreeSol {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	};

	ArrayList<Integer> ret = new ArrayList<Integer>();

	/**
	 * Pre Work
	 * 
	 * @param a
	 * @return
	 */
	public ArrayList<Integer> inorderTraversal(TreeNode a) {
		if (a == null)
			return ret;
		Stack<TreeNode> s = new Stack<>();
		TreeNode cur = a;
		while (cur != null || s.isEmpty() == false) {
			if (cur != null) {
				s.push(cur);
				cur = cur.left;
			} else {
				cur = s.pop();
				ret.add(cur.val);
				cur = cur.right;
			}
		}
		return ret;
	}

	/**
	 * Pre Work
	 * 
	 * @param a
	 * @return
	 */
	public int isBalanced(TreeNode a) {
		int ret = _isBalanced(a);
		if (ret == -1) {
			return 0;
		}
		return 1;
	}

	public int _isBalanced(TreeNode a) {
		if (a == null)
			return 0;
		int left = _isBalanced(a.left);
		if (left == -1) {
			return -1;
		}
		int right = _isBalanced(a.right);
		if (right == -1) {
			return -1;
		}

		if (Math.abs(left - right) > 1) {
			return -1;
		}

		return 1 + Math.max(left, right);
	}

}
