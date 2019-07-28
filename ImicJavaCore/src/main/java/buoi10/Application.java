package buoi10;

public class Application {
    int bal = 10;
    public synchronized void checkBalance(){
        for (int i=0;i<10; i++){
            if (bal <=0) {
                System.out.println("Your balance run out of money");
                break;
            }
            System.out.println("Loop "+ i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bal--;
        }
    }
    public static void main(String[] args) {

        final Application app = new Application();
        Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    app.checkBalance ();
                }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                app.checkBalance();
            }
        });

        t1.start();
        t2.start();
    }
}
