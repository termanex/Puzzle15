
import com.github.termanex.Puzzle15.*;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {

		Board board = new Board();



		board.Print();
	    board.MoveGem(2,3);
        board.MoveGem(2,2);
		board.Print();

        Scanner sc = new Scanner(System.in); // создаём объект класса Scanner
        int x , y;


        while(true)
        {
            if(!sc.hasNextInt())
            {
                break;
            }
            x = y = -13;
            board.Print();
            System.out.print("Move gem : ");
            y = sc.nextInt();
            if(sc.hasNextInt())
            {
                x = sc.nextInt();
                board.MoveGem(y,x);
                board.Print();
            }
        }
	}

}
