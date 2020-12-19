
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    //Amacımız Bir Dosyada Veri Okumak...
    
    public static void main(String[] args) {
        
        FileInputStream fis = null;
        
        File file = new File("hllbr.txt");
        

          
 
        try {
            
            fis = new FileInputStream(file);
            
            
            try {
                
            //Dosyayı okumak için yaptığımız işlemler ==

             
            //Okunan değer byte olduğu için bizim bunu char olarak tanımmlamamız gerekiyor
            
            //buradaki read() metodu bize bir adet byte dönüyor 
            
          /*  System.out.println("reading characther : " +(char)(fis.read()));
            System.out.println("reading characther : " +(char)(fis.read()));//okuma işlemini bir karakter ilerletiyoruz.
            System.out.println("reading characther : " +(char)(fis.read()));//3.karakter
            System.out.println("reading characther : " +(char)(fis.read()));//4.karakter okundu*/
            
            
           //İstediğimiz indexi okumak için bir yöntemimiz bir fonksiyonumuz bulunuyor == 
           
           fis.skip(5);//direkt olarak dosyamız bu noktadan okunmaya başlayacak  
           
          // System.out.println("Okunan Karakter = "+(char)(fis.read()));
           /*
           
           üst satırlardaki okuma işlemini kapatmadığımız çin 5. karakterimiz olan p den değil "programlama" kelimesindeki 2. r yi 5. referans oalrak gördü ve okumaya bu noktadan başladık ....
           Bütün Dosyayı okumak için bir döngü kurabiliriz...
           
           */
           int deger ;
           
           //Tüm Dosyayı okuyacağımız için bir adet String oluşturutoyoruz  
           
           String a = "" ;
           
          /* while((deger = fis.read()) !=-1){
               
               a += (char)(deger);*/
               
               //a Stringine her bir değerimizi atamak istediğimizi söylüruz eğer bu noktada okunacak değer kalmadığında değer ifademiz -1 olduğunda döngüden çıkmamız gerekiyor...koşul sağlanmış oluyor
            int say = 0;
            while((deger = fis.read()) != -1){
                
                a+=(char) deger ;
                
                say++;
                if(say==11){
                    break;
                }
   
           }
            
                System.out.println("Dosyanın 5. değerinden itibaren 11 karakter : " +a);
            
               // System.out.println("Dosya İçeriği : "+a);
           
            } catch (IOException ex) {
                
                System.out.println("Dosya okuma Aşamasında hata meydana geldi.\n"
                + "Lütfen dosya okuma işlemi yapılan Kod bloklarını kontrol ediniz..");
                
            }

        } catch (FileNotFoundException ex) {
            
            System.out.println("Dosya Bulunamadı Lütfen dosyanızı Kontrol ediniz...");
            
            System.out.println("File Not Found Exception hatası meydana geldi....\n"
                + "LÜTFEN KOD BLOKLARINI KONTROL EDİNİZ.");
            
        }finally{
            
            try {
                
                if(fis != null){//fis yapısındaki dosya değer atanmamış durumda değilse diyerek yapıyı koruma altına alıyoruz Kodumuzu Güvenli hale getiriyoruz...
                
                fis.close();//Arka Planda belleği yormamak amacıyla bu işlemi yapıyoruz
               
                //mutlaka kapatmak istediğimiz için finally blok içerisinde konumlandırdık.

                }
               
            } catch (IOException ex) {
                
                System.out.println("Dosya kapatma işlemi sırasında bir hata meydana geldi.");
            }
        }
    }
    
}
