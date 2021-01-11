//Post-order traversal: left,right,root
public class PostOrderTraversal {
    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
         }
         //iterative
           public List<Integer> postorderTraversalIterative(TreeNode root) {
               List<Integer> list = new ArrayList<>();
               if(root==null){
                   return list;
               }
               Stack<TreeNode> st = new Stack<>();
               st.push(root);
               while(!st.isEmpty()){
                   TreeNode curr = st.peek();
                   if(curr.left==null&&curr.right==null){
                       st.pop();
                       list.add(curr.val);
                   }
                   else if(curr.left!=null){
                       st.push(curr.left);
                       curr.left = null;
                   }
                   else if(curr.right!=null){
                       st.push(curr.right);
                       curr.right = null;
                       
                   }
               }
               return list;
           }
           //recursive
           public List<Integer> postorderTraversalRecursive(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            helper(root,list);
            return list;
            }
            public void helper(TreeNode root, List<Integer> list){
                if(root==null){
                    return;
                }
                if(root.left!=null){
                    helper(root.left,list);
                }
                if(root.right!=null){
                    helper(root.right,list);
                }
                list.add(root.val);
            }
}