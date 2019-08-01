package wilburhsu.CodingInterview;

public class _59_SymmetricalBinaryTree {
    boolean isSymmetrical(TreeNode pRoot){
        if(pRoot == null){
            return true;
        }
        return isSymmetrical(pRoot.left,pRoot.right);
    }

    boolean isSymmetrical(TreeNode left,TreeNode right){
        if(left == null && right == null)
            return true;
        if(left == null || right == null)
            return false;
        if(left.val != right.val)
            return false;

        return isSymmetrical(left.left,right.right)
                && isSymmetrical(left.right,right.left);
    }

}
