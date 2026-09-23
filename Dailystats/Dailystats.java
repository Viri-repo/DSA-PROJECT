public class Dailystats {

    public static void displayStatistics(int[] serviceTimes) {

        if (serviceTimes.length == 0) {
            System.out.println("No service records.");
            return;
        }

        int totalStudents = serviceTimes.length;
        int totalTime = 0;
        int highest = serviceTimes[0];
        int lowest = serviceTimes[0];
        int longerThan10 = 0;

        for (int i = 0; i < serviceTimes.length; i++) {

            totalTime += serviceTimes[i];

            if (serviceTimes[i] > highest) {
                highest = serviceTimes[i];
            }

            if (serviceTimes[i] < lowest) {
                lowest = serviceTimes[i];
            }

            if (serviceTimes[i] > 10) {
                longerThan10++;
            }
        }

        double average = (double) totalTime / totalStudents;

        System.out.println("Total students served: " + totalStudents);
        System.out.println("Total service time: " + totalTime + " minutes");
        System.out.println("Average service time: " + average + " minutes");
        System.out.println("Highest service time: " + highest + " minutes");
        System.out.println("Lowest service time: " + lowest + " minutes");
        System.out.println("Services longer than 10 minutes: " + longerThan10);
    }

    public static void main(String[] args) {

        int[] serviceTimes = {12, 5, 8, 4, 10, 7};

        displayStatistics(serviceTimes);
    }
}