import java.util.*;

public class Chess {
	
	static Scanner reader = new Scanner(System.in);

	private static final int BoradRows=8;
	private static final int BoradCol=8;
	
	public char[][] board;
	public int row,col; //current bishop indicators.
	public int rowcheck,colcheck; //moving indexes to find other bishops in diagonal lines.
	public boolean inrange = true; //assigned to check if inserted values are in matrix range.
	public boolean nocross = true; //assigned to check if bishop do not threat other bishops

	
	public Chess() {
		board= initBorad();
	}
	
	public static void main(String[] args) {
		
		System.out.println("Welcom to cherss game!");
		Chess chess=new Chess();
		chess.printBorad();
		System.out.println("Enter row and col for two bishops:");
		for (int i=1; i<=2; i++) { 
			chess.setRow(reader.nextInt());
			chess.setCol(reader.nextInt());
			int row=chess.getRow();
			int col=chess.getCol();
			if (0<=row && row<chess.getBoard().length && 0<=col && col<chess.getBoard().length) {
				
				
			} //make sure user's input are in matrix bounds.

			
		}
		
		
		
		
		
	}
	//intilaze the board at the start of the game;
	public char[][] initBorad(){
		char [][] board = new char [BoradRows][BoradCol];
		for (int row=0; row<board.length; row++) { //define board
			for (int col=0; col<board.length; col++) {
				board[row][col]='-';
			}
		}


		return board;
	}
	//func to printint the board
	public void printBorad(){
		if(this.board!=null) {
			System.out.print("  "); //12 lines for initial board presentation to user.
			for (int i = 0; i < board.length; i++)
				System.out.print(i+" ");
			System.out.println();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (j == 0)
					System.out.print(i+" ");
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		}
	}
	public boolean netCheck(){
		while (0<=rowcheck && rowcheck<board.length && 0<=colcheck && colcheck<board.length) //check bottom right diagonal line for bishops.
		{
			if ((rowcheck != row || colcheck != col) && board[rowcheck][colcheck]== 'B') //search other squares for bishops.
				nocross = false;
			rowcheck++; colcheck++;
		}
		return nocross;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public char[][] getBoard() {
		return board;
	}

	public void setBoard(char[][] board) {
		this.board = board;
	}
	
	
	
}


//	public static void main(String[] args) {
//		
//		System.out.println("Welcome! Please choose an option:");
//		int prog=999;//initialize program indicator
//		while(prog!=0) { //runs as long as user wont choose to end program with "0". 
//			System.out.println("0. End Program\n"+"1. Find and Replace\n"+"2. Play a Game");
//			prog=reader.nextInt();
//			
//			switch (prog) 
//			{
//				case 0:	//terminate program
//					break;
//					
//					
//				case 1: //"Find and Replace"
//					System.out.println("Please enter a sentence:");
//					String string;
//					do{
//					string = reader.nextLine();
//					} while (string.length() == 0);
//					
//					System.out.print("Find: ");
//					String find;
//					do{
//					find = reader.nextLine();
//					} while (find.length() == 0);
//					
//					System.out.print("And replace with: ");
//					String replace = reader.nextLine(); //not in a loop to allow user to replace segment with nothing.
//					
//					String newstring="";
//					
//					int index=0;
//					while(index<string.length()) { //loop runs on all string characters.
//						if(index+find.length()<=string.length()&&string.substring(index,index+find.length()).equals(find)) { //prevent out of bound scenario and checks for asked segment in current range.
//							newstring +=replace;
//							index +=find.length();
//							}
//						else { //if the asked segment wasn't found in current range.
//							newstring +=string.charAt(index);
//							index++;	
//							}
//						}
//					System.out.println("Your new sentence is: "+ newstring);
//				
//					break; //end find and replace
//					
//				case 2: //"play a game"
//					char [][] board = new char [5][5];
//					for (int row=0; row<board.length; row++) { //define board
//						for (int col=0; col<board.length; col++) {
//							board[row][col]='-';
//						}
//					}
//					System.out.print("  "); //12 lines for initial board presentation to user.
//					for (int i = 0; i < board.length; i++)
//					System.out.print(i+" ");
//					System.out.println();
//					for (int i = 0; i < board.length; i++) {
//						for (int j = 0; j < board[i].length; j++) {
//							if (j == 0) 
//								System.out.print(i+" ");
//							System.out.print(board[i][j]+" ");
//							}
//						System.out.println();
//						}
//					
//					System.out.println("Enter row and col for three bishops:");
//					
//					boolean inrange = true; //assigned to check if inserted values are in matrix range.
//					boolean nocross = true; //assigned to check if bishop do not threat other bishops 
//					int row,col; //current bishop indicators.
//					int rowcheck,colcheck; //moving indexes to find other bishops in diagonal lines.
//					
//					for (int i=1; i<=3; i++) { //3 iterations for 3 bishops.
//						row = reader.nextInt();
//						col = reader.nextInt();
//						if (0<=row && row<board.length && 0<=col && col<board.length) //make sure user's input are in matrix bounds.
//						{
//							board [row][col] ='B';
//							rowcheck = row;
//							colcheck = col;
//							while (0<=rowcheck && rowcheck<board.length && 0<=colcheck && colcheck<board.length) //check bottom right diagonal line for bishops.
//							{
//								if ((rowcheck != row || colcheck != col) && board[rowcheck][colcheck]== 'B') //search other squares for bishops. 
//									nocross = false;
//								rowcheck++; colcheck++;
//							}
//							
//							rowcheck = row; colcheck = col; //reset check index to current bishop's square.
//							while (0<=rowcheck && rowcheck<board.length && 0<=colcheck && colcheck<board.length) //check bottom left diagonal line for bishops.
//							{
//								if ((rowcheck != row || colcheck != col) && board[rowcheck][colcheck]== 'B') //search other squares for bishops. 
//									nocross = false;
//								rowcheck++; colcheck--;
//							}
//							
//							rowcheck = row; colcheck = col; //reset check index to current bishop's square.
//							while (0<=rowcheck && rowcheck<board.length && 0<=colcheck && colcheck<board.length) //check top right diagonal line for bishops.
//							{
//								if ((rowcheck != row || colcheck != col) && board[rowcheck][colcheck]== 'B') //search other squares for bishops. 
//									nocross = false;
//								rowcheck--; colcheck++;
//							}
//							
//							rowcheck = row; colcheck = col; //reset check index to current bishop's square.
//							while (0<=rowcheck && rowcheck<board.length && 0<=colcheck && colcheck<board.length) //check top left diagonal line for bishops.
//							{
//								if ((rowcheck != row || colcheck != col) && board[rowcheck][colcheck]== 'B') //search other squares for bishops. 
//									nocross = false;
//								rowcheck--; colcheck--;
//							}
//						}
//						else {
//							inrange = false;
//						}
//					}
//					
//					if (inrange == true && nocross == true) //bishops are all in range and valid.
//					{ 
//						System.out.print("  "); //12 lines for board presentation to user.
//						for (int i = 0; i < board.length; i++)
//						System.out.print(i+" ");
//						System.out.println();
//						for (int i = 0; i < board.length; i++) {
//							for (int j = 0; j < board[i].length; j++) {
//								if (j == 0) 
//									System.out.print(i+" ");
//								System.out.print(board[i][j]+" ");
//								}
//							System.out.println();
//							}
//						System.out.println("Those are valid positions for the bishops.");
//					}
//					if (inrange == true && nocross == false) //bishops are all in range but not valid.
//					{	
//						System.out.print("  "); //12 lines for board presentation to user.
//						for (int i = 0; i < board.length; i++)
//						System.out.print(i+" ");
//						System.out.println();
//						for (int i = 0; i < board.length; i++){
//							for (int j = 0; j < board[i].length; j++) 
//							{
//								if (j == 0) 
//									System.out.print(i+" ");
//								System.out.print(board[i][j]+" ");
//							}
//							System.out.println();
//						}
//							System.out.println("Those are NOT valid positions for the bishops.");
//						
//					}
//					if (inrange == false) //one or more bishops are not in range.
//					{
//						System.out.println("Invalid array index.");
//					}
//					
//					break; //end play a game
//				
//				default:  //for any "prog" argument other than 0,1,2
//					System.out.println("Invalid input!");
//				}
//			}
//		System.out.println("See you!");
//		}
//}