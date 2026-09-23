public class Selection {

    public static int selectionSort(int[] array) {

        int comparisons = 0;
        int swaps = 0;

        for (int i = 0; i < array.length - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {

                comparisons++;

                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {

                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;

                swaps++;
            }
        }

        System.out.println("Comparisons: " + comparisons);
        System.out.println("Swaps: " + swaps);

        return comparisons;
    }

    public static void main(String[] args) {

        int[] array = {64, 25, 12, 22, 11};

        System.out.println("Original array:");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();

        selectionSort(array);

        System.out.println("Sorted array:");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
    }
}