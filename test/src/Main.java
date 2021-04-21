import java.util.Scanner;

class node{
    char data;
    node left, right;
    public node(char data){
        this.data = data;
    }
}

class tree{
    node root;

    public void createnode(char data, char L, char R){
        if(root == null) {
            root = new node(data);
            if (L != '.')
                root.left = new node(L);
            if (R != '.')
                root.right = new node(R);
        }
        else{
            searchnode(root, data, L, R);
        }
    }

    public void searchnode(node root, char data, char L,  char R){
        if(root == null) {
            return;
        }
        else if(root.data == data){
            if (L != '.')
                root.left = new node(L);
            if (R != '.')
                root.right = new node(R);
        }
        else{
            searchnode(root.left, data, L, R);
            searchnode(root.right, data, L, R);
        }
    }

    public void preorder(node t){
        System.out.print(t.data);
        if(t.left != null)
            preorder(t.left);
        if(t.right != null)
            preorder(t.right);
    }

    public void inorder(node t){
        if(t.left != null)
            inorder(t.left);
        System.out.print(t.data);
        if(t.right != null)
            inorder(t.right);
    }

    public void lastorder(node t){
        if(t.left != null)
            lastorder(t.left);
        if(t.right != null)
            lastorder(t.right);
        System.out.print(t.data);
    }
}

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        tree tt = new tree();
        for(int i=0; i<num; i++){
            String temp = sc.nextLine();
            char p = temp.charAt(0);
            char l = temp.charAt(2);
            char r = temp.charAt(4);

            tt.createnode(p, l, r);
        }

        tt.preorder(tt.root);
        System.out.println();
        tt.inorder(tt.root);
        System.out.println();
        tt.lastorder(tt.root);
    }
}
