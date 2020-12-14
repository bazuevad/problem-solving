/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode answer;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root,  p,  q).commonManager;
    }
    
    public OrgInfo helper(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return new OrgInfo(null,0);
        }
        int sum = 0;
            OrgInfo left = helper(root.left,p,q);
            if(left.commonManager!=null){
                return left;
            }
            sum+=left.reportEmpl;
            OrgInfo right = helper(root.right,p,q);
            if(right.commonManager!=null){
                return right;
            }
            sum+=right.reportEmpl;
        if(root.val==p.val||root.val==q.val){
            sum++;
        }
        if(sum==2){
            return new OrgInfo(root,2);
        }
        return new OrgInfo(null,sum);
        
    }
    class OrgInfo{
        TreeNode commonManager;
        int reportEmpl;
        public OrgInfo(TreeNode a, int b){
            this.commonManager =a;
            this.reportEmpl = b;
        }
    }
}