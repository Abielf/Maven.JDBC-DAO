package daos;

import java.util.List;

public class App implements Runnable{
    public void run(){}

    public static void main(String[] args) {
        StoneDao gogogo= new StoneDao();
        StoneDTO newCar= new StoneDTO("Wayne Tech", "Batmobile","Black",000);
        gogogo.update(newCar,4);

        List goList=gogogo.findAll();
    }
}
