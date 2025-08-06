public TreeNode lowestCommonAncestor(TreeNod*e root, TreeNode* p, TreeNode* q) {
        if(root == null) return null;
        int currVal = root->val;

        if(currVal < p->val && currVal < q->val){
            return lowestCommonAncestor(root->right,p,q);
        }
        if(currVal > p->val && currVal > q->val){
            return lowestCommonAncestor(root->left,p,q);
        }

        return root;
    }