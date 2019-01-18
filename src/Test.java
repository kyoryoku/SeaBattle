public class Test {

    public static void main(String[] args){

        Sea mySea = new Sea(10);
        Ship x4h1 = new Ship(4, 1);
        Ship x3h2 = new Ship(3, 0);

        mySea.placeShip(x4h1, 0, 0);
        mySea.placeShip(x3h2, 0, 0);
        mySea.print();
    }

}
