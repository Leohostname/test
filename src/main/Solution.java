package main;

public class Solution
{
    public static void main(String[] args)
    {
        FizzBuzzDetector fizzBuzzDetector = new FizzBuzzDetector();

        String line = """
                Mary had a little lamb
                Little lamb, little lamb
                Mary had a little lamb
                It's fleece was white as snow""";

        System.out.println(fizzBuzzDetector.getOverlappings(line));
    }
}
