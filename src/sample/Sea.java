package sample;

public class Sea {

    int size;       //размер поля
    int[][] point;  //поле
    int totalHP;    //суммарное хп кораблей на поле

    //создаем поле
    Sea(int _size){

        size = _size;
        point = new int[size][size];
        for (int i = 0; i<size; i++){
            for (int j = 0; j<size; j++){

                point[i][j] = 0;
            }
        }
    }

    //расставляем корабли
    void placeShip (Ship _ship, int _x, int _y){

        if (_ship.orientation == 1){
            for (int i = 0; i<_ship.size; i++)
            {
                this.point[_x ][_y + i] = 1;
            }
        } else {
            for (int i = 0; i<_ship.size; i++)
            {
                this.point[_x + i][_y ] = 1;
            }
        }

        totalHP = totalHP + _ship.size;
    }

    //стреляем по ячейке поля
    boolean shoot(){

        if (point[Target.i][Target.j] == 1){
            //попал, вернуть true
            //поставить 2

            point[Target.i][Target.j] = 2;
            totalHP--;
            return true;

        } else {
            //не попал false
            //поставить 3

            point[Target.i][Target.j] = 3;
            return false;
        }

    }

    //печатаем поле на экран для тестов
    public void print (){

        for (int i = 0; i<size; i++){
            String tmp = "";
            for (int j = 0; j<size; j++){
                tmp = tmp + point[i][j] + " ";
            }
            System.out.println(tmp);
        }

        System.out.println(" ");

    }


}