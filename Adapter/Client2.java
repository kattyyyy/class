public class Client2 {
    public static void main(String[] args) {
    Dengen d;
    d = new AcAdapter();
    int denatsu = d.kyuuden();
    System.out.println( denatsu + "V で給電されています" );
    }
   }
   interface Dengen { // Target
    public int kyuuden();
   }
   class JapaneseConsent { // Adaptee
    public int power() {
    return 100;
    }
   }
   class AcAdapter extends JapaneseConsent
 implements Dengen { // Adapter
 public int kyuuden() {
 return (int)(power() * 0.16);
 }
}
