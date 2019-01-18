public class Sea {

    public int size;       //размер поля
    public int[][] point;  //поле

    public Sea(int _size){

        size = _size;
        point = new int[size][size];

        for (int i = 0; i<size; i++){
            for (int j = 0; j<size; j++){

                point[i][j] = 0;
            }
        }
    }

    public int placeShip (Ship _ship, int _x, int _y){

        if (_ship.orientation == 1){
            for (int i = 0; i<_ship.size; i++)
            {
                this.point[_x ][_y + i] = 1;
            }
        }
        else {
            for (int i = 0; i<_ship.size; i++)
            {
                this.point[_x + i][_y ] = 1;
            }
        }
        return 0;
    }

    public void print (){


        for (int i = 0; i<size; i++){
            String tmp = "";
            for (int j = 0; j<size; j++){
                tmp = tmp + point[i][j] + " ";
            }
            System.out.println(tmp);
        }

    }


}
