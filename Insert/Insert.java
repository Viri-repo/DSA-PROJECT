public class Insert {

    public static int insertionSort(int[] array) {

        int comparisons = 0;

        for (int i = 1; i < array.length; i++) {

            int key = array[i];

            int j = i - 1;

            while (j >= 0) {

                comparisons++;

                if (array[j] > key) {

                    array[j + 1] = array[j];

                    j--;

                } else {

                    break;
                }
            }

            array[j + 1] = key;
        }

        return comparisons;
    }

    public static void main(String[] args) {

        int[] array = {64, 25, 12, 22, 11};

        System.out.println("Original array:");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();

        int comparisons = insertionSort(array);

        System.out.println("Comparisons: " + comparisons);

        System.out.println("Sorted array:");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
    }
}