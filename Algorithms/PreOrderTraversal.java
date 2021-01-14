public class PreOrderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        List<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        st.push(root);
        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            list.add(curr.val);
            if(curr.right!=null){
                st.push(curr.right);
            }
            if(curr.left!=null){
                st.push(curr.left);
            }
        }
        return list;
    }
}