package problem2;

public interface LuckyTicket {

    boolean isLucky(String number);

    long countLucky(long min, long max);

    /*
    * Method work
    * except functionality with leading nulls
    * */
    long countLucky(String min, String max);

}
