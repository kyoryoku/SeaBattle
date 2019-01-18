public class Test {

    public static void main(String[] args){

        Sea mySea = new Sea(10);

        Ship x4h = new Ship(2, 0);
        mySea.placeShip(x4h, 4, 3);
        mySea.print();
    }

}
