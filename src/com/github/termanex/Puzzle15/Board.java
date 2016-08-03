package com.github.termanex.Puzzle15;


public class Board {

    private final int DAFAULT_MATRIX_SIZE = 4;

    private int[][] matrix;




    //TODO: Добавить конструктор с параметрами width height
    public Board() {

        init_matrix(DAFAULT_MATRIX_SIZE, DAFAULT_MATRIX_SIZE);

    }

    private void init_matrix(int height, int width) {
        this.matrix = new int[height][width];
        int v = 1;
        for (int y = 0; y < height; y++) {

            for (int x = 0; x < width; x++) {

                this.matrix[y][x] = v;
                v++;
            }
        }
        this.matrix[height - 1][width - 1] = 0;
    }

    private boolean is_free(int y,int x){

        if(y >= 0 && x >= 0) {
            if( y < matrix.length && x < matrix[0].length) {
                if( matrix[y][x] == 0 )
                    return true;
            }
        }

        return false;
    }

    private void swap_values(int sy, int sx, int ey, int ex) {

        int temp = this.matrix[sy][sx];
        this.matrix[sy][sx] = this.matrix[ey][ex];
        this.matrix[ey][ex] = temp;
    }

    public boolean MoveGem(int y, int x){

        //TODO: Сделать исключение
        int gem = matrix[y][x];

        if(gem != 0)
        {
            if(is_free(y,x-1)) {
                swap_values(y,x,y,x-1);
                return true;
            }
            if(is_free(y,x+1)) {
                swap_values(y,x,y,x+1);
                return true;
            }
            if(is_free(y-1,x)) {
                swap_values(y,x,y-1,x);
                return true;
            }
            if(is_free(y+1,x)) {
                swap_values(y + 1, x, y, x);
                return true;
            }
        }
        return false;
    }


    public void Print() {

        int height = this.matrix.length;
        int width = this.matrix[0].length;

        System.out.println("------------");

        for (int y = 0; y < height; y++) {

            for (int x = 0; x < width; x++) {

                System.out.format("%02d ", this.matrix[y][x]);
            }
            System.out.println();
        }

    }
}

