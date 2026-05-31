import java.util.Scanner;

public class TicTacToeGame
{
    public static void showBoard(char[][] board)
    {
        System.out.println();
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                System.out.print(" " + board[i][j] + " ");

                if (j < 2)
                {
                    System.out.print("|");
                }
            }

            System.out.println();

            if (i < 2)
            {
                System.out.println("---+---+---");
            }
        }

        System.out.println();
    }

    public static void placeMark(char[][] board, char player, int row, int col)
    {
        board[row][col] = player;
    }

    public static boolean hasWon(char[][] board, char player)
    {
        for (int i = 0; i < 3; i++)
        {
            if (board[i][0] == player &&
                    board[i][1] == player &&
                    board[i][2] == player)
            {
                return true;
            }

            if (board[0][i] == player &&
                    board[1][i] == player &&
                    board[2][i] == player)
            {
                return true;
            }
        }

        if (board[0][0] == player &&
                board[1][1] == player &&
                board[2][2] == player)
        {
            return true;
        }

        if (board[0][2] == player &&
                board[1][1] == player &&
                board[2][0] == player)
        {
            return true;
        }

        return false;
    }

    public static boolean boardFilled(char[][] board)
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (board[i][j] == ' ')
                {
                    return false;
                }
            }
        }

        return true;
    }

    public static void clearBoard(char[][] board)
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                board[i][j] = ' ';
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        char[][] board =
                {
                        {' ', ' ', ' '},
                        {' ', ' ', ' '},
                        {' ', ' ', ' '}
                };

        char userChoice;

        System.out.println("Tic Tac Toe Game");

        do
        {
            clearBoard(board);

            char activePlayer = 'X';

            while (true)
            {
                showBoard(board);

                System.out.println("Player " + activePlayer + "'s Turn");

                System.out.print("Enter row number (0-2): ");
                int row = sc.nextInt();

                System.out.print("Enter column number (0-2): ");
                int col = sc.nextInt();

                if (row < 0 || row > 2 || col < 0 || col > 2)
                {
                    System.out.println("Invalid position! Please try again.");
                    continue;
                }

                if (board[row][col] != ' ')
                {
                    System.out.println("Cell already occupied! Please try again.");
                    continue;
                }

                placeMark(board, activePlayer, row, col);

                if (hasWon(board, activePlayer))
                {
                    showBoard(board);

                    System.out.println("Congratulations! Player " +
                            activePlayer +
                            " wins the game.");

                    break;
                }

                if (boardFilled(board))
                {
                    showBoard(board);

                    System.out.println("Match Drawn!");

                    break;
                }

                if (activePlayer == 'X')
                {
                    activePlayer = 'O';
                }
                else
                {
                    activePlayer = 'X';
                }
            }

            System.out.print("Do you want to play again? (Y/N): ");
            userChoice = sc.next().toUpperCase().charAt(0);

        }
        while (userChoice == 'Y');

        System.out.println("Thank you for playing Tic Tac Toe Game!");

        sc.close();
    }
}