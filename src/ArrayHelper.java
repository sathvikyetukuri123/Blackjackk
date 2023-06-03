
    import java.util.*;
    //Sathvik Y per.2
    public class ArrayHelper {
        public static int[] addEnd(int[] a, int b) {
            int c = a.length;
            int New[] = new int[c + 1];

            for (int i = 0; i < c; i++) {
                New[i] = a[i];
            }
            New[c] = b;
            return New;

        }

        public static int[] removeEnd(int[] a) {
            int n = a.length;
            int subtract[] = new int[n - 1];

            for (int i = 0; i < n - 1; i++) {
                subtract[i] = a[i];
            }
            return subtract;
        }

        public static int[] addMiddle(int[] a, int b, int c) {
            int n = a.length;
            int[] middle = new int[n + 1];

            for (int i = 0; i < c; i++) {
                middle[i] = a[i];
            }

            middle[c] = b;
            for (int i = c; i < n; i++) {
                middle[i + 1] = a[i];
            }

            return middle;
        }

        public static int[] removeMiddle(int[] a, int c) {
            int n = a.length;
            int[] New = new int[n - 1];
            for (int i = 0; i < c; i++) {
                New[i] = a[i];
            }
            for (int i = c + 1; i < n; i++) {
                New[i - 1] = a[i];
            }
            return New;
        }

        public static int[] replace(int[] a, int b, int c) {
            int n = a.length;
            int[] New = new int[n];
            for (int i = 0; i < n; i++) {
                if (i == c)
                    New[i] = b;

                else
                    New[i] = a[i];

            }
            return New;
        }

        public static void display(int[] a) {
            for (int i:a) {
                System.out.print(i+"  ");
            }
        }

        public static int[] addElement(int[] a, int b) {
            int n = a.length;
            int newArray[] = new int[n + 1];

            for (int i = 0; i < n; i++) {
                newArray[i] = a[i];
            }
            newArray[n] = b;
            return newArray;

        }

        public static int[] addElement(int[] a, int b, int c) {
            int n = a.length;
            int[] middle = new int[n + 1];

            for (int i = 0; i < c; i++) {
                middle[i] = a[i];
            }

            middle[c] = b;
            for (int i = c; i < n; i++) {
                middle[i + 1] = a[i];
            }

            return middle;
        }

        public static int[] removeElement(int[] a) {
            int n = a.length;
            int subtract[] = new int[n - 1];

            for (int i = 0; i < n - 1; i++) {
                subtract[i] = a[i];
            }
            return subtract;
        }

        public static int[] removeElement(int[] a, int loc) {
            int n = a.length;
            int[] New = new int[n - 1];
            for (int i = 0; i < loc; i++) {
                New[i] = a[i];
            }
            for (int i = loc + 1; i < n; i++) {
                New[i - 1] = a[i];
            }
            return New;
        }


        public static void reverseArray(int[] a) {
            int n = a.length;
            int[] New = new int[n];
            int b = n;
            for (int i = 0; i < n; i++) {
                New[b - 1] = a[i];
                b = b - 1;
            }
            for (int i = 0; i < n; i++) {
                System.out.println(New[i]);
            }

        }

        public static boolean existsInArray(int[] a, int b) {
            for (int i : a) {
                if (i == b) {
                    return true;

                }
            }
            return false;
        }

        public static int numberOf(int[] a, int b) {
            int x = 0;
            for (int i : a) {
                if (i == b) {
                    x++;
                }
            }
            return x;
        }
    }

