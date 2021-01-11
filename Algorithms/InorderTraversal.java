//Inorder traversal: left, root,right
public class InorderTraversal {
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
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        Stack<TreeNode> st =  new Stack<>();
        st.push(root);
        TreeNode curr = root.left;
        while(!st.isEmpty()){
            while(curr!=null){
                st.push(curr);
                curr = curr.left;
            }
            TreeNode next = st.pop();
            list.add(next.val);
            if(next.right!=null){
                st.push(next.right);
                curr = next.right.left;
            }
        }
        return list;
    }

}