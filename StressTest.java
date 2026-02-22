public class StressTest{
    public void simulateStackOverflow(int callDepth) {
        System.out.println("Depth: " + callDepth);

        simulateStackOverflow(callDepth + 1);
    }
}
