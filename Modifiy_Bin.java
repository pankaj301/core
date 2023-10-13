// Java code to modify binary tree for 
// traversal using only right pointer 
class GFG
{

// A binary tree node has data, 
// left child and right child 
static class Node 
{ 
	int data; 
	Node left; 
	Node right; 
}; 

// function that allocates a new node 
// with the given data and null left 
// and right pointers. 
static Node newNode(int data) 
{ 
	Node node = new Node(); 
	node.data = data; 
	node.left = null; 
	node.right = null; 
	return (node); 
} 

// Function to modify tree 
static Node modifytree( Node root) 
{ 
	Node right = root.right; 
	Node rightMost = root; 

	// if the left tree exists 
	if (root.left != null) 
	{ 

		// get the right-most of the 
		// original left subtree 
		rightMost = modifytree(root.left); 

		// set root right to left subtree 
		root.right = root.left; 
		root.left = null; 
	} 

	// if the right subtree does 
	// not exists we are done! 
	if (right == null) 
		return rightMost; 

	// set right pointer of right-most 
	// of the original left subtree 
	rightMost.right = right; 

	// modify the rightsubtree 
	rightMost = modifytree(right); 
	return rightMost; 
} 

// printing using right pointer only 
static void printpre( Node root) 
{ 
	while (root != null) 
	{ 
		System.out.print( root.data + " "); 
		root = root.right; 
	} 
} 

// Driver cde 
public static void main(String args[]) 
{ 
	/* Constructed binary tree is 
		10 
		/ \ 
	8 2 
	/ \ 
	3 5 */
	Node root = newNode(10); 
	root.left = newNode(8); 
	root.right = newNode(2); 
	root.left.left = newNode(3); 
	root.left.right = newNode(5); 

	modifytree(root); 
	printpre(root); 
}
} 

// This code is contributed by Pankaj Gupta
