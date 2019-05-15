package starter;

public class StackTrace {

        public static void main(String[] args) throws Exception {
            method1();
        }
        public static String method1() {
            method2();
            StackTraceElement[] StackTrace = Thread.currentThread().getStackTrace();
            System.out.println(StackTrace[2].getMethodName());
            return StackTrace[2].getMethodName();
        }
        public static String method2() {
            method3();
            StackTraceElement[] StackTrace = Thread.currentThread().getStackTrace();
            System.out.println(StackTrace[2].getMethodName());
            return StackTrace[2].getMethodName();
        }
        public static String method3() {
            method4();
            StackTraceElement[] StackTrace = Thread.currentThread().getStackTrace();
            System.out.println(StackTrace[2].getMethodName());
            return StackTrace[2].getMethodName();
        }
        public static String method4() {
            method5();
            StackTraceElement[] StackTrace = Thread.currentThread().getStackTrace();
            System.out.println(StackTrace[2].getMethodName());
            return StackTrace[2].getMethodName();
        }
        public static String method5() {
            {
                StackTraceElement[] StackTrace = Thread.currentThread().getStackTrace();
                System.out.println(StackTrace[2].getMethodName());
                return StackTrace[2].getMethodName();
            }
        }
    }

