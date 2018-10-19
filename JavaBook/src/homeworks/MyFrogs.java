package homeworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created: 18.10.2018
 * 
 * @author Georgi Georgiev
 */
public class MyFrogs {
	public static final char LEFT_FROG = '>';
	public static final char RIGHT_FROG = '<';
	public static final char EMPTY = '_';

	public static ArrayList visitedNodes = new ArrayList();
	public static Stack stack = new Stack();

	public static void main(String[] args) {
		// Get user input
		System.out.print("Enter count of frogs for each side: ");
		Scanner input = new Scanner(System.in);
		int frogsInput = input.nextInt();

		// Initialize initial and goal arrays
		char[] state = new char[2 * frogsInput + 1];
		char[] goal = new char[2 * frogsInput + 1];

		// Fill arrays
		for (int i = 0; i < 2 * frogsInput + 1; i++) {
			if (i < frogsInput) {
				state[i] = LEFT_FROG;
				goal[i] = RIGHT_FROG;
			} else if (i > frogsInput) {
				state[i] = RIGHT_FROG;
				goal[i] = LEFT_FROG ;
			} else {
				state[i] = goal[i] = EMPTY;
			}
		}

		stack.push(state.clone());

		resolve(state, goal);

		print();
	}

	/**
	 * @param state - the state array
	 */
	public static int getEmptyPossition(char[] state) {
		for (int i = 0; i < state.length + 1; i++) {
		    if (state[i] == EMPTY) {
		    	return i;
		    }
		}
		return 0;
	}

	/**
	 * @param state - the state array
	 * @param emptyPossition - the empty position
	 * @param possitionOfFrog - the position of frog
	 * @return the state
	 */
	public static char[] swap(char[] state, int emptyPossition, int possitionOfFrog) {
		char[] temp = state.clone();
		state[possitionOfFrog] = state[emptyPossition];
		state[emptyPossition] = temp[possitionOfFrog];
		return state;
	}

	/**
	 * @param state - the state array
	 * @param emptyPossition - the empty position
	 * @param possitionOfFrog - the position of frog
	 * @return the status of node
	 */
	public static boolean isVisited(char[] state, int emptyPossition, int possitionOfFrog) {
		boolean isVisited = false;

		swap(state, emptyPossition, possitionOfFrog);

		if (!visitedNodes.isEmpty()) {
			for (Object visitedNode : visitedNodes) {
				if (Arrays.equals(state, (char[]) visitedNode)) {
					isVisited = true;
				}
			}
		}

		swap(state, emptyPossition, possitionOfFrog);

		return isVisited;
	}

	/**
	 * @param state - the state array
	 * @param goal - the goal array
	 * @return expected array
	 */
	public static boolean resolve(char[] state, char[] goal) {
		int indexOfEmptyPossition = getEmptyPossition(state);

		if (Arrays.equals(state, goal)) {
			return true;
		}

		if (indexOfEmptyPossition >= 2 && state[indexOfEmptyPossition - 2] == LEFT_FROG && !isVisited(state, indexOfEmptyPossition, indexOfEmptyPossition - 2)) {
			swap(state, indexOfEmptyPossition, indexOfEmptyPossition - 2);

			visitedNodes.add(state.clone());
			stack.push(state.clone());

			if (resolve(state, goal)) {
				return true;
			}
		}

		if (indexOfEmptyPossition >= 1 && state[indexOfEmptyPossition - 1] == LEFT_FROG && !isVisited(state, indexOfEmptyPossition, indexOfEmptyPossition - 1)) {
			swap(state, indexOfEmptyPossition, indexOfEmptyPossition - 1);

			visitedNodes.add(state.clone());
			stack.push(state.clone());

			if (resolve(state, goal)) {
				return true;
			}
		}

		if (indexOfEmptyPossition < state.length - 1 && state[indexOfEmptyPossition + 1] == RIGHT_FROG && !isVisited(state, indexOfEmptyPossition, indexOfEmptyPossition + 1)) {
            swap(state, indexOfEmptyPossition, indexOfEmptyPossition + 1);

            visitedNodes.add(state.clone());
            stack.push(state.clone());

            if(resolve(state, goal)){
                return true;
            }
        }

        if (indexOfEmptyPossition < state.length - 2 && state[indexOfEmptyPossition + 2] == RIGHT_FROG && !isVisited(state, indexOfEmptyPossition, indexOfEmptyPossition + 2)) {
            swap(state, indexOfEmptyPossition, indexOfEmptyPossition + 2);

            visitedNodes.add(state.clone());
            stack.push(state.clone());

            if(resolve(state, goal)){
                return true;
            }
        }

		stack.pop();
		makeCopy(state, (char[]) stack.peek());

		return false;
	}

	/**
	 * @param copyTo - the copyTo array
	 * @param copyFrom - the copyFrom array
	 */
	public static void makeCopy(char[] copyTo, char[] copyFrom){
        for (int i = 0; i < copyTo.length; i++) {
            copyTo[i] = copyFrom[i];
        }
    }

	private static void print(){
        // Revert the stack direction
        Stack result = new Stack();
        while(!stack.isEmpty()){
            result.push(stack.pop());
        }

        while (!result.empty()) {
            char[] step = (char[]) result.pop();
            for (int p = 0; p < step.length; p++) {
                if (step[p] == LEFT_FROG) {
                    System.out.print(LEFT_FROG);
                } else if (step[p] == RIGHT_FROG) {
                    System.out.print(RIGHT_FROG);
                } else {
                    System.out.print(EMPTY);
                }
            }
            System.out.println();
        }
    }
}
