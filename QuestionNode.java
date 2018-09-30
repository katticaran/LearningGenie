import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class QuestionNode implements DecisionNode {

	DecisionNode left;
	DecisionNode right;

	String question;
	
	/**
	 * @name: QuestionNode
	 * @param: String, a question
	 * @param: DecisionNode, the left side of this node
	 * @param: DecisionNode, the right side of this node
	 * @return: constructor
	 */
	public QuestionNode(String newQuestion, DecisionNode left, DecisionNode right) {
		this.question = newQuestion;
		this.left = left;
		this.right = right;
	}
	
	/**
	 * @name: QuestionNode
	 * @param: String, a question for the node
	 * @param: Scanner
	 * @return: constructor
	 */
	public QuestionNode(String data, Scanner in) {

		this.question = data.substring(1);
		String nextLine = in.nextLine();
		if (nextLine.startsWith("#")){
			this.left = new QuestionNode(nextLine, in);
		}
		else {
			this.left = new GuessNode(nextLine);
		}

		nextLine = in.nextLine();
		if (nextLine.startsWith("#")){
			this.right = new QuestionNode(nextLine, in);
		}
		else {
			this.right = new GuessNode(nextLine);
		}
	}

	/**
	 * @name: countObjects
	 * @param: none
	 * @return: int, the number of GuessNodes underneath this node;
	 */
	public int countObjects() {
		int ret = 0;
		if (this.left != null) {
			ret += left.countObjects();
		}
		if (this.right != null) {
			ret += right.countObjects();
		}
		return ret;
	}
	
	/**
	 * @name: guess
	 * @param: Scanner
	 * @return: DecisionNode, result of playing the guessing game;
	 */
	public DecisionNode guess(Scanner in) {
		System.out.println(question);
		String answer = in.nextLine().toLowerCase();
		if (answer.equals("yes")) {
			left = left.guess(in);
		} else {
			right = right.guess(in);
		}
		return this;
	}
	/**
	 * @name: write
	 * @param: FileWriter
	 * @return: none
	 */
	public void write(FileWriter out) throws IOException{
		out.write("#" + question + "\n");
		left.write(out);
		right.write(out);
	}

}
