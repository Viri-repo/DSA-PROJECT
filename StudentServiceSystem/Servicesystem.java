  import java.util.Scanner;


public class Main {

    // =========================================================
    // STUDENT CLASS
    // =========================================================
    static class Student {
        int studentNumber;
        String name;
        String serviceType;
        int serviceTime;

        Student(int studentNumber, String name,
                String serviceType, int serviceTime) {

            this.studentNumber = studentNumber;
            this.name = name;
            this.serviceType = serviceType;
            this.serviceTime = serviceTime;
        }

        public String toString() {
            return studentNumber + " | " + name + " | "
                    + serviceType + " | " + serviceTime + " minutes";
        }
    }


    // =========================================================
    // QUEUE
    // =========================================================
    static class StudentQueue {

        Student[] queue;
        int front;
        int rear;
        int size;

        StudentQueue(int capacity) {
            queue = new Student[capacity];
            front = 0;
            rear = -1;
            size = 0;
        }

        // ENQUEUE
        void enqueue(Student student) {

            if (size == queue.length) {
                System.out.println("Queue is full.");
                return;
            }

            rear = (rear + 1) % queue.length;
            queue[rear] = student;
            size++;

            System.out.println(student.name + " added to the waiting queue.");
        }

        // DEQUEUE
        Student dequeue() {

            if (size == 0) {
                System.out.println("Queue is empty.");
                return null;
            }

            Student student = queue[front];

            queue[front] = null;
            front = (front + 1) % queue.length;
            size--;

            return student;
        }

        // DISPLAY QUEUE
        void displayQueue() {

            if (size == 0) {
                System.out.println("No students are waiting.");
                return;
            }

            System.out.println();
            System.out.println("Students waiting:");

            for (int i = 0; i < size; i++) {

                int index = (front + i) % queue.length;

                System.out.println(
                        (i + 1) + ". " + queue[index]
                );
            }
        }

        boolean isEmpty() {
            return size == 0;
        }
    }


    // =========================================================
    // LINKED LIST
    // =========================================================
    static class StudentLinkedList {

        static class Node {
            Student student;
            Node next;

            Node(Student student) {
                this.student = student;
                this.next = null;
            }
        }

        Node head;

        // INSERT AT END
        void insertStudent(Student student) {

            Node newNode = new Node(student);

            if (head == null) {
                head = newNode;
                System.out.println("Student record added.");
                return;
            }

            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;

            System.out.println("Student record added.");
        }

        // SEARCH
        Student searchStudent(int studentNumber) {

            Node current = head;

            while (current != null) {

                if (current.student.studentNumber == studentNumber) {
                    return current.student;
                }

                current = current.next;
            }

            return null;
        }

        // DELETE
        void deleteStudent(int studentNumber) {

            if (head == null) {
                System.out.println("The list is empty.");
                return;
            }

            if (head.student.studentNumber == studentNumber) {
                head = head.next;
                System.out.println("Student record deleted.");
                return;
            }

            Node current = head;

            while (current.next != null) {

                if (current.next.student.studentNumber
                        == studentNumber) {

                    current.next = current.next.next;

                    System.out.println("Student record deleted.");
                    return;
                }

                current = current.next;
            }

            System.out.println("Student record not found.");
        }

        // DISPLAY / TRAVERSAL
        void displayStudents() {

            if (head == null) {
                System.out.println("No student records.");
                return;
            }

            Node current = head;
            int position = 1;

            while (current != null) {

                System.out.println(
                        position + ". " + current.student
                );

                current = current.next;
                position++;
            }
        }
    }


    // =========================================================
    // ARRAY STATISTICS
    // =========================================================
    static void displayStatistics(int[] serviceTimes) {

        int total = 0;
        int highest = serviceTimes[0];
        int lowest = serviceTimes[0];
        int greaterThan10 = 0;

        for (int i = 0; i < serviceTimes.length; i++) {

            total = total + serviceTimes[i];

            if (serviceTimes[i] > highest) {
                highest = serviceTimes[i];
            }

            if (serviceTimes[i] < lowest) {
                lowest = serviceTimes[i];
            }

            if (serviceTimes[i] > 10) {
                greaterThan10++;
            }
        }

        double average =
                (double) total / serviceTimes.length;

        System.out.println();
        System.out.println("DAILY SERVICE STATISTICS");
        System.out.println("-------------------------");
        System.out.println("Total students: " + serviceTimes.length);
        System.out.println("Total service time: " + total + " minutes");
        System.out.println("Average service time: " + average + " minutes");
        System.out.println("Highest service time: " + highest + " minutes");
        System.out.println("Lowest service time: " + lowest + " minutes");
        System.out.println("Number above 10 minutes: " + greaterThan10);
    }


    // =========================================================
    // SELECTION SORT
    // =========================================================
    static void selectionSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {

                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }


    // =========================================================
    // INSERTION SORT
    // =========================================================
    static void insertionSort(int[] array) {

        for (int i = 1; i < array.length; i++) {

            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {

                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }
    }


    // =========================================================
    // MERGE SORT
    // =========================================================
    static void mergeSort(int[] array, int left, int right) {

        if (left < right) {

            int middle = (left + right) / 2;

            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            merge(array, left, middle, right);
        }
    }

    static void merge(int[] array, int left,
                      int middle, int right) {

        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }

        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[middle + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < n1 && j < n2) {

            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            }
            else {
                array[k] = rightArray[j];
                j++;
            }

            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }


    // =========================================================
    // QUICK SORT
    // =========================================================
    static void quickSort(int[] array, int low, int high) {

        if (low < high) {

            int pivotPosition =
                    partition(array, low, high);

            quickSort(array, low, pivotPosition - 1);
            quickSort(array, pivotPosition + 1, high);
        }
    }

    static int partition(int[] array, int low, int high) {

        int pivot = array[high];

        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (array[j] <= pivot) {

                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }


    // =========================================================
    // DISPLAY ARRAY
    // =========================================================
    static void displayArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
    }


    // =========================================================
    // COPY ARRAY
    // =========================================================
    static int[] copyArray(int[] original) {

        int[] copy = new int[original.length];

        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i];
        }

        return copy;
    }


    // =========================================================
    // PART C - SIMPLE SORTING EXPERIMENT
    // =========================================================
    static void runExperiment() {

        int[] sizes = {20, 50, 100, 500};

        System.out.println();
        System.out.println("SORTING EXPERIMENT");
        System.out.println("==================");

        for (int s = 0; s < sizes.length; s++) {

            int size = sizes[s];

            int[] original = new int[size];

            // Generate values programmatically
            for (int i = 0; i < size; i++) {
                original[i] = (i * 37 + 13) % 1000;
            }

            int[] selection = copyArray(original);
            int[] insertion = copyArray(original);
            int[] merge = copyArray(original);
            int[] quick = copyArray(original);

            long start;
            long end;

            // Selection Sort
            start = System.nanoTime();

            selectionSort(selection);

            end = System.nanoTime();

            long selectionTime = end - start;


            // Insertion Sort
            start = System.nanoTime();

            insertionSort(insertion);

            end = System.nanoTime();

            long insertionTime = end - start;


            // Merge Sort
            start = System.nanoTime();

            mergeSort(merge, 0, merge.length - 1);

            end = System.nanoTime();

            long mergeTime = end - start;


            // Quick Sort
            start = System.nanoTime();

            quickSort(quick, 0, quick.length - 1);

            end = System.nanoTime();

            long quickTime = end - start;


            System.out.println();
            System.out.println("Input size: " + size);

            System.out.println(
                    "Selection Sort Time: "
                    + selectionTime + " ns"
            );

            System.out.println(
                    "Insertion Sort Time: "
                    + insertionTime + " ns"
            );

            System.out.println(
                    "Merge Sort Time: "
                    + mergeTime + " ns"
            );

            System.out.println(
                    "Quick Sort Time: "
                    + quickTime + " ns"
            );
        }
    }


    // =========================================================
    // MAIN PROGRAM - PART D
    // =========================================================
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        StudentQueue queue =
                new StudentQueue(20);

        StudentLinkedList records =
                new StudentLinkedList();


        // Official students supplied in the project
        Student maria =
                new Student(
                        221045678,
                        "Maria",
                        "Registration",
                        12
                );

        Student tomas =
                new Student(
                        222034512,
                        "Tomas",
                        "Student Card",
                        5
                );

        Student ndapewa =
                new Student(
                        223041876,
                        "Ndapewa",
                        "Fees",
                        8
                );

        Student simon =
                new Student(
                        221067341,
                        "Simon",
                        "Documents",
                        4
                );


        // Service-time array from the project
        int[] serviceTimes = {12, 5, 8, 4};


        int choice = 0;


        while (choice != 11) {

            System.out.println();
            System.out.println("======================================");
            System.out.println("       CAMPUS SERVICE CENTRE");
            System.out.println("======================================");
            System.out.println("1. Add student to waiting queue");
            System.out.println("2. Serve next student");
            System.out.println("3. Display waiting students");
            System.out.println("4. Add student service record");
            System.out.println("5. Display student service records");
            System.out.println("6. Search for student record");
            System.out.println("7. Remove student record");
            System.out.println("8. Display daily statistics");
            System.out.println("9. Sort service times");
            System.out.println("10. Run sorting experiment");
            System.out.println("11. Exit");
            System.out.println("======================================");
            System.out.print("Select option: ");

            choice = input.nextInt();


            // =================================================
            // OPTION 1 - ENQUEUE
            // =================================================
            if (choice == 1) {

                System.out.println();
                System.out.println("Select student:");
                System.out.println("1. Maria");
                System.out.println("2. Tomas");
                System.out.println("3. Ndapewa");
                System.out.println("4. Simon");
                System.out.print("Enter choice: ");

                int studentChoice =
                        input.nextInt();

                if (studentChoice == 1) {
                    queue.enqueue(maria);
                }
                else if (studentChoice == 2) {
                    queue.enqueue(tomas);
                }
                else if (studentChoice == 3) {
                    queue.enqueue(ndapewa);
                }
                else if (studentChoice == 4) {
                    queue.enqueue(simon);
                }
                else {
                    System.out.println("Invalid choice.");
                }
            }


            // =================================================
            // OPTION 2 - DEQUEUE
            // =================================================
            else if (choice == 2) {

                Student served =
                        queue.dequeue();

                if (served != null) {

                    System.out.println();
                    System.out.println("Student served:");
                    System.out.println(served);
                }
            }


            // =================================================
            // OPTION 3 - DISPLAY QUEUE
            // =================================================
            else if (choice == 3) {

                queue.displayQueue();
            }


            // =================================================
            // OPTION 4 - LINKED LIST INSERTION
            // =================================================
            else if (choice == 4) {

                System.out.println();
                System.out.println("Select student:");
                System.out.println("1. Maria");
                System.out.println("2. Tomas");
                System.out.println("3. Ndapewa");
                System.out.println("4. Simon");
                System.out.print("Enter choice: ");

                int studentChoice =
                        input.nextInt();

                if (studentChoice == 1) {
                    records.insertStudent(maria);
                }
                else if (studentChoice == 2) {
                    records.insertStudent(tomas);
                }
                else if (studentChoice == 3) {
                    records.insertStudent(ndapewa);
                }
                else if (studentChoice == 4) {
                    records.insertStudent(simon);
                }
                else {
                    System.out.println("Invalid choice.");
                }
            }


            // =================================================
            // OPTION 5 - LINKED LIST DISPLAY
            // =================================================
            else if (choice == 5) {

                System.out.println();
                System.out.println("STUDENT SERVICE RECORDS");
                System.out.println("-----------------------");

                records.displayStudents();
            }


            // =================================================
            // OPTION 6 - SEARCH
            // =================================================
            else if (choice == 6) {

                System.out.print(
                        "Enter student number to search: "
                );

                int number =
                        input.nextInt();

                Student found =
                        records.searchStudent(number);

                if (found != null) {

                    System.out.println();
                    System.out.println("Student found:");
                    System.out.println(found);
                }
                else {
                    System.out.println(
                            "Student record not found."
                    );
                }
            }


            // =================================================
            // OPTION 7 - DELETE
            // =================================================
            else if (choice == 7) {

                System.out.print(
                        "Enter student number to remove: "
                );

                int number =
                        input.nextInt();

                records.deleteStudent(number);
            }


            // =================================================
            // OPTION 8 - ARRAY STATISTICS
            // =================================================
            else if (choice == 8) {

                displayStatistics(serviceTimes);
            }


            // =================================================
            // OPTION 9 - SORT SERVICE TIMES
            // =================================================
            else if (choice == 9) {

                System.out.println();
                System.out.println(
                        "Original service times:"
                );

                displayArray(serviceTimes);


                int[] selection =
                        copyArray(serviceTimes);

                selectionSort(selection);

                System.out.println(
                        "Selection Sort:"
                );

                displayArray(selection);


                int[] insertion =
                        copyArray(serviceTimes);

                insertionSort(insertion);

                System.out.println(
                        "Insertion Sort:"
                );

                displayArray(insertion);


                int[] merge =
                        copyArray(serviceTimes);

                mergeSort(
                        merge,
                        0,
                        merge.length - 1
                );

                System.out.println(
                        "Merge Sort:"
                );

                displayArray(merge);


                int[] quick =
                        copyArray(serviceTimes);

                quickSort(
                        quick,
                        0,
                        quick.length - 1
                );

                System.out.println(
                        "Quick Sort:"
                );

                displayArray(quick);
            }


            // =================================================
            // OPTION 10 - PART C
            // =================================================
            else if (choice == 10) {

                runExperiment();
            }


            // =================================================
            // OPTION 11 - EXIT
            // =================================================
            else if (choice == 11) {

                System.out.println();
                System.out.println(
                        "Thank you. Program ended."
                );
            }


            else {

                System.out.println(
                        "Invalid option. Please select 1-11."
                );
            }
        }

        input.close();
      }
   } 