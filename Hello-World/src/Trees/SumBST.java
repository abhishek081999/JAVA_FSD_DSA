/*
Description :
Given a Binary tree, construct a Balanced Binary search tree consisting of sum of each node and its children
(Note: All its children and not immediate children). Output should be postOrder traversal 
of the new Binary search tree.

Example:
Sample Input: 
6
6 10 20 1 51 43
1 10 6 20 43 51
Sample Output:
20 6 51 131 94 36

Sample Input:
5
40 60 30 20 50
50 20 30 60 40
Sample Output:
100 40 200 150 130

In the input, first value 6 is the size of the tree. 
The values in the second line correspond to the inorder traversal of the given binary tree and 
the last line correspond to the pre order traversal of the given binary tree.
Output is the post order traversal of the new binary search tree which is supposed to be constructed with node values separated by spaces.

*/
package Trees;
import java.util.Scanner;
import java.util.Arrays;

public class SumBST {
    static class Node 
    {
        int value;
        Node leftchild, rightchild;
        
        Node(int item) 
        {
            value = item;
            leftchild = rightchild = null;
        }
    }
    
    static class BT 
    {
        static Node root;
        static int preIndex = 0;
        static int index=0;
        
        static Node constructTree(int in[], int pre[], int inStrt, int inEnd) 
        {
            if (inStrt > inEnd) 
            return null;
            
            Node tNode = new Node(pre[preIndex++]);
            
            if (inStrt == inEnd)
            return tNode;
            
            int inIndex = search(in, inStrt, inEnd, tNode.value);
            
            tNode.leftchild = constructTree(in, pre, inStrt, inIndex - 1);
            tNode.rightchild = constructTree(in, pre, inIndex + 1, inEnd);
            
            return tNode;
        }
        
        static int search(int arr[], int strt, int end, int value) 
        {
            int i;
            for (i = strt; i <= end; i++) 
            {
                if (arr[i] == value)
                return i;
            }
            return i;
        }
        
        static int sumBinaryTree(Node node)
        {   
            // Solved by Hardik Bhaavani
            if(node==null){
                return 0;
            }
            node.value += sumBinaryTree(node.leftchild);
            node.value += sumBinaryTree(node.rightchild);
            
            return node.value;
        }
        
        static void printPostorder(Node node)
        {
            if (node == null)
            return;
            
            // first recur on left subtree
            printPostorder(node.leftchild);
            
            // then recur on right subtree
            printPostorder(node.rightchild);
            
            // now deal with the node
            System.out.print(node.value + " ");
        }
        
        static void inOrder(Node node, int array[])
        {
            if (node == null)
            return;
            inOrder(node.leftchild, array);
            array[index++] = node.value;
            inOrder(node.rightchild, array);
            
        }
        
        static Node ArrayToBST(int arr[], int start, int end) {
            // Convert the array representing Binary Tree to Binary Search Tree
            if (start > end) {
                return null;
            }
            int mid = (start + end) / 2;
            Node node = new Node(arr[mid]);
            
            node.leftchild = ArrayToBST(arr, start, mid-1);
            node.rightchild = ArrayToBST(arr,mid+1, end);
            
            return node;
        }
    }
    
    
    public static void main(String args[]) 
    {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int in[] = new int[len];
        int pre[] = new int[len];
        for(int i=0;i<len;i++){
            in[i] = scanner.nextInt();            
        }
        for(int i=0;i<len;i++){
            pre[i] = scanner.nextInt();
        }

        Node root = BT.constructTree(in, pre, 0, len - 1);
        
        BT.sumBinaryTree(root);
        
        int inSumTree[] = new int[len];
        BT.inOrder(root, inSumTree);
        Arrays.sort(inSumTree);
        Node bstRoot = BT.ArrayToBST(inSumTree, 0, len-1);
        BT.printPostorder(bstRoot);

        scanner.close();
    }
}
