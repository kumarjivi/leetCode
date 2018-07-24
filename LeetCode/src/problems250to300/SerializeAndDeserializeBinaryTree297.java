package problems250to300;

/***
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in the
 * same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. There is no
 * restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and
 * this string can be deserialized to the original tree structure.
 * 
 * @author jivi
 *
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class SerializeAndDeserializeBinaryTree297 {

	int index = 0;
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) {
			return null;
		} else {
			StringBuilder sb = new StringBuilder();
			serHelper(sb, root);
			return sb.toString();
		}
	}

	private void serHelper(StringBuilder sb, TreeNode root) {
		if (root != null) {
			sb.append(root.val + ",");
			serHelper(sb, root.left);
			serHelper(sb, root.right);
		} else {
			sb.append("null,");
		}
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		index = 0;//no state is stored between subsequent call to 'deserialize'
		if (data == null) {
			return null;
		}
		data = data.substring(0, data.length() - 1);
		String[] words = data.split(",");
		return desHelper(words);
	}

	private TreeNode desHelper(String[] words) {
		if (index >= words.length) {
			return null;
		} else {
			String val = words[index];
			if ("null".equals(val)) {
				return null;
			} else {
				TreeNode node = new TreeNode(Integer.parseInt(val));
				index++;
				node.left = desHelper(words);
				index++;
				node.right = desHelper(words);
				// index++;
				return node;
			}
		}
	}
}
