public class Client {
    public static void main(String[] args) {
    Dengen d;
   
    d = new JapaneseConsent();
    int denatsu = d.kyuuden();
    System.out.println( denatsu + "V で給電されています" );
    }
   }
   interface Dengen {
    public int kyuuden();
   }
   class JapaneseConsent implements Dengen {
    @Override
    public int kyuuden() {
    return 100;
    }
   }

   class Hatsudenki16V implements Dengen{
    @Override
    public int kyuuden() {
    return 16;
    }
   }
   