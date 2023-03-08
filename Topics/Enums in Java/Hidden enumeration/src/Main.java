public class Main {

    public static void main(String[] args) {
        int counter = 0;
        for (Secret s : Secret.values()) {
            counter += s.name().startsWith("STAR") ? 1 : 0;
        }
        System.out.println(counter);
    }
}

///* sample enum for inspiration
enum Secret {
    STAR, CRASH, START // ...
}
//*/