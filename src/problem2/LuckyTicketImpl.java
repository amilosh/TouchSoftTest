package problem2;

public class LuckyTicketImpl implements LuckyTicket {

    @Override
    public boolean isLucky(String number) {
        if (number.length() %2 != 0) {
            return false;
        } else {
            int size = number.length()/2;

            String first = number.substring(0, size);
            String second = number.substring(size);

            long firstInt = Long.parseLong(first);
            long secondInt = Long.parseLong(second);

            int firstSum = sumNumeralsInNumber(firstInt);
            int secondSum = sumNumeralsInNumber(secondInt);


            if (firstSum == secondSum) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public long countLucky(long min, long max) {
        if ((int) Math.log10(min)+1 == 12 && (int) Math.log10(min)+1 == 12) {
            long sum = 0;
            for (long i = min; i <= max ; i++) {
                if (isLucky(Long.toString(i))) {
                    sum++;
                }
            }
            return sum;
        } else {
            System.out.println("Ticket number has not 12 digits.");
            return 0L;
        }
    }

    @Override
    public long countLucky(String min, String max) {
        // maximum number of digits in Long
        int rank = 17;

        long minBeginLong = 0l;
        long minEndLong = 0l;

        long maxBeginLong = 0l;
        long maxEndLong = 0l;

        // separate long string to two numbers
        if (min.length() > rank) {
            String minBegin = min.substring(0, min.length()-rank);
            String minEnd = min.substring(min.length()-rank);
            minBeginLong = (long) Long.parseLong(minBegin);
            minEndLong = (long) Long.parseLong(minEnd);
        } else {
            minEndLong = Long.parseLong(min);
        }

        if (max.length() > rank) {
            String maxBegin = max.substring(0, max.length()-rank);
            String maxEnd = max.substring(max.length()-rank);
            maxBeginLong = (long) Long.parseLong(maxBegin);
            maxEndLong = (long) Long.parseLong(maxEnd);
        } else {
            maxEndLong = Long.parseLong(max);
        }

        long countLuckyTicket = 0;


        /* если оба числа на старте меньше rank
         * if number of digits in two numbers (min and max) less than rank
          * */
        if (minBeginLong == 0L && maxBeginLong == 0L) {
            for (long i = minEndLong; i <= maxEndLong; i++) {
                StringBuilder ticket = new StringBuilder();
                ticket.append(Long.toString(i));
                if (isLucky(ticket.toString())) {
                    System.out.println(ticket + " - Lucky Ticket");
                    countLuckyTicket++;
            }
            }
        }
        /* if number of digits in two numbers (min and max) not less than rank
         */
        else {
            for (long i = minBeginLong; i <= maxBeginLong; i++) {
                if ((i == minBeginLong) && (i == maxBeginLong)) {
                    for (long j = minEndLong; j <= maxEndLong; j++) {
                        StringBuilder first = new StringBuilder();
                        StringBuilder second = new StringBuilder();
                        if (i != 0L) {
                            first.append(Long.toString(i));
                            second.append(numberOfNull(j, rank).append(Long.toString(j)).toString());
                        } else {
                            first.append("");
                            second.append(Long.toString(j));
                        }

                        StringBuilder ticket = first.append(second);
                        if (isLucky(ticket.toString())) {
                            System.out.println(ticket + " - Lucky Ticket");
                            countLuckyTicket++;
                        }
                    }
                } else
                if (i == minBeginLong) {
                    for (long j = minEndLong; j <= (Math.pow(10, rank)-1); j++) {
                        StringBuilder first = new StringBuilder();
                        StringBuilder second = new StringBuilder();
                        if (i != 0L) {
                            first.append(Long.toString(i));
                            second.append(numberOfNull(j, rank).append(Long.toString(j)).toString());
                        } else {
                            first.append("");
                            second.append(Long.toString(j));
                        }

                        StringBuilder ticket = first.append(second);
                        if (isLucky(ticket.toString())) {
                            System.out.println(ticket + " - Lucky Ticket");
                            countLuckyTicket++;
                        }
                    }
                } else if ((i > minBeginLong) && (i != maxBeginLong)) {
                    for (long j = 0L; j < (Math.pow(10, rank)-1); j++) {
                        String first = Long.toString(i);

                        String second = numberOfNull(j, rank).append(Long.toString(j)).toString();
                        String ticket = first.concat(second);
                        if (isLucky(ticket)) {
                            System.out.println(ticket + " - Lucky Ticket");
                            countLuckyTicket++;
                        }
                    }
                } else if ((i > minBeginLong) && (i == maxBeginLong)) {
                    for (long j = 0L; j <= maxEndLong; j++) {
                        String first = Long.toString(i);

                        String second = numberOfNull(j, rank).append(Long.toString(j)).toString();
                        String ticket = first.concat(second);
                        if (isLucky(ticket)) {
                            System.out.println(ticket + " - Lucky Ticket");
                            countLuckyTicket++;
                        }
                    }
                }
            }
        }
        return countLuckyTicket;
    }

    public int sumNumeralsInNumber(long number) {
        int sum = 0;
        while (number != 0 ){
            sum += (number % 10);
            number /= 10;
        }
        return sum;
    }

    /* метод, который считает, сколько нулей надо подставить перед последней цифрой */
    private StringBuilder numberOfNull(long j, int rank) {
        Long m = j;
        int numberOfNull = rank - (int) m.toString().length();
        StringBuilder builder = new StringBuilder();
        for (int k = 0; k < numberOfNull; k++) {
            builder.append("0");
        }
        return builder;
    }
}
