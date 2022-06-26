/*Шахматную доску размером NxN обойти конём так, 
чтобы фигура в каждой клетке была строго один раз. */

public class chess_knight {
    static int[][] chessBoard;
    static int[][] mooveRecord;
    static int mooveCount;

    public static void main(String[] args) {
        chessBoard = new int[8][8];
        mooveRecord = new int[][] { { -2, -1 }, { -2, 1 }, { -1, -2 }, { -1, 2 }, { 2, -1 }, { 2, 1 }, { 1, -2 },
                { 1, 2 } };
        mooveCount = chessBoard.length * chessBoard[0].length;

        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[i].length; j++) {
                if (nextMoove(i,j,0)) {
                    for (int a = 0; a < chessBoard.length; a++){
                        for( int b = 0; b < chessBoard[a].length; b ++){
                            System.out.print(chessBoard[a][b] + " ");
                            
                        }
                        System.out.println();
                    }
                    return;
                }
                
            }
        }
        System.out.println("Решений нет");
        
    }

    public static boolean nextMoove(int a, int b, int number) {
        chessBoard[a][b] = number;
        if (number == mooveCount)
            return true;
        for (int i = 0; i < mooveRecord.length; i++) {
            int a1 = a + mooveRecord[i][0];
            int b1 = b + mooveRecord[i][1];
            if (boundsCheck(a1, b1) && nextMoove(a1, b1, number + 1)) {
                return true;
            }
        }
        chessBoard[a][b] = 0;
        return false;
    }

    public static boolean boundsCheck(int a, int b) {
        return a >= 0 && b >= 0 && a < chessBoard.length && b < chessBoard[a].length && chessBoard[a][b] == 0;
    }

}
