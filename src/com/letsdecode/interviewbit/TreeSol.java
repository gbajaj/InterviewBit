package com.letsdecode.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.TreeSet;

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

	public int maxDepth(TreeNode a) {
	    if (a == null ) return 0;
	    
	    return 1+ Math.max(maxDepth(a.left), maxDepth(a.right));
	    
	}
	
	public ArrayList<Integer> postorderTraversal(TreeNode a) {
	    ArrayList<Integer> ret = new ArrayList<Integer>();
	    
	    if (a == null)  {
	        return ret;
	    }
	    
	    Stack<TreeNode>s = new Stack<>();
	    TreeNode cur = a;
	    TreeNode right = null;
	    while (cur != null || s.isEmpty() == false) {
	        if (cur != null) {
	            s.push(cur);
	            cur = cur.left;
	        } else {
	            cur = s.peek();
	            cur = cur.right;
	            if (cur == null || cur == right) {
	                right = s.pop();
	                ret.add(right.val);
	                cur = null;
	            }
	        }
	    }
	    return ret;
	}
	
	public ArrayList<Integer> preorderTraversal(TreeNode a) {
	    ArrayList<Integer> ret = new ArrayList<Integer>();
	    if (a == null)  {
	        return ret;
	    }
	    Stack<TreeNode> s = new Stack<>();
	    TreeNode cur = a;
	    while (cur != null || s.isEmpty() == false) {
	        if (cur != null) {
	            ret.add(cur.val);
	            s.push(cur);
	            cur = cur.left;
	        } else {
	            cur = s.pop().right;
	        }
	    }
	    
	    return ret;
	}
	
	public int minDepth(TreeNode a) {
	    if (a == null ) return 0;
	    if (a.left == null) {
            return 1 + minDepth(a.right);
        } else if (a.right == null) {
            return 1 + minDepth(a.left);
        }
	    return 1+ Math.min(minDepth(a.left), minDepth(a.right));
	}
	
	public int isSymmetric(TreeNode a) {
	    if (a == null) return 1;
	    return _isSymmetric(a.left, a.right);
	}

	public int _isSymmetric(TreeNode a, TreeNode b) {
	    if (a == null && b == null) return 1;
	    if (a == null || b == null) return 0;
	    if (a.val == b.val) {
	        if (_isSymmetric(a.left, b.right) ==1 && 
	        _isSymmetric(a.right, b.left) == 1) {
	            return 1;
	        }
	        return 0;
	    }
	    return 0;
	}
	
	public int kthsmallest(TreeNode root, int k) {
        int a [] = {k};
         return kthsmallest(root, a);
    }
    
    public int kthsmallest(TreeNode root, int a[]) {
        if (root == null) return -1;    
        int ret = kthsmallest(root.left, a);
        if (ret != -1) return ret;
        if (a[0] == 1) return root.val;
            a[0]--;
        
        return kthsmallest(root.right, a);
    
    }
    
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        
        return root;
        
    }
}
