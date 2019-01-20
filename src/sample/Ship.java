package sample;

class Ship {

    int size;         //размер корабля: 4, 3, 2, 1
    int orientation;  //0 - вертикальный, 1 - горизонтальный

    Ship(int _size, char _c){

        size = _size;

        if (_c == 'h' || _c == 'H' ) {
            //HORIZONTAL
            orientation = 1;
        } else {
            //VERTICAL
            orientation = 0;
        }


    }


}