class StudentNode<T> {

    T data;
    StudentNode<T> next;

    StudentNode(T data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList<T> {

    private StudentNode<T> head;

    public void insertAtBeginning(T data) {
        StudentNode<T> newNode = new StudentNode<>(data);

        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(T data) {
        StudentNode<T> newNode = new StudentNode<>(data);

        if (head == null) {
            head = newNode;
            return;
        }

        StudentNode<T> current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public void insertAtPosition(T data, int position) {

        if (position <= 1) {
            insertAtBeginning(data);
            return;
        }

        StudentNode<T> newNode = new StudentNode<>(data);
        StudentNode<T> current = head;

        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Invalid position.");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    public boolean deleteAtPosition(int position) {

        if (head == null || position < 1) {
            return false;
        }

        if (position == 1) {
            head = head.next;
            return true;
        }

        StudentNode<T> current = head;

        for (int i = 1; i < position - 1 && current.next != null; i++) {
            current = current.next;
        }

        if (current.next == null) {
            return false;
        }

        current.next = current.next.next;
        return true;
    }

    public T search(T data) {

        StudentNode<T> current = head;

        while (current != null) {

            if (current.data.equals(data)) {
                return current.data;
            }

            current = current.next;
        }

        return null;
    }

    public void display() {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        StudentNode<T> current = head;

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}

public class Studentrecords {

    public static void main(String[] args) {

        LinkedList<String> students = new LinkedList<>();

        students.insertAtEnd("John");
        students.insertAtEnd("Peter");
        students.insertAtEnd("Mary");

        System.out.println("Student Records:");
        students.display();

        System.out.println("\nAfter inserting James at position 2:");
        students.insertAtPosition("James", 2);
        students.display();

        System.out.println("\nSearching for Mary:");
        String result = students.search("Mary");

        if (result != null) {
            System.out.println("Student found: " + result);
        } else {
            System.out.println("Student not found.");
        }

        System.out.println("\nAfter deleting position 3:");
        students.deleteAtPosition(3);
        students.display();
    }
}