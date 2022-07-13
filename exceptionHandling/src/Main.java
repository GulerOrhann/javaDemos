public class Main {
    public static void main(String[] args){
         try{
             int[] sayilar=new int[]{1,2,3};
             System.out.println(sayilar[5]);
         }catch(IndexOutOfBoundsException exception){
             System.out.println(exception );
        }
         finally {
             System.out.println("Ben her turlu calisirim");
         }
    }
}
