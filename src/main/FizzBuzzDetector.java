package main;

public class FizzBuzzDetector
{
    /**
     * Changes every third and fifth word in input string to fizz and buzz respectively
     * @param input string, which needs to be changed
     * @return      Result as record-object with changed string and count of changed words
     */
    public Result getOverlappings(String input)
    {
        if (input.length() > 100 || input.length() < 7) return null;

        StringBuilder result = new StringBuilder();
        int indexOfWord = 1;
        int fizzCount = 0;
        int buzzCount = 0;
        int fizzBuzzCount = 0;

        String[] lines = input.split("\n");
        for (String line : lines)
        {
            String[] words = line.split(" ");

            for (int i = 0; i < words.length; i++)
            {
                char lastChar = words[i].charAt(words[i].length() - 1);
                boolean containsSign = !Character.isAlphabetic(lastChar) && !Character.isDigit(lastChar);

                if (indexOfWord % 15 == 0)
                {
                    fizzBuzzCount++;
                    words[i] = "FizzBuzz";
                    if (containsSign) words[i] += lastChar;
                }
                else if (indexOfWord % 3 == 0)
                {
                    fizzCount++;
                    words[i] = "Fizz";
                    if (containsSign) words[i] += lastChar;
                }
                else if (indexOfWord % 5 == 0)
                {
                    buzzCount++;
                    words[i] = "Buzz";
                    if (containsSign) words[i] += lastChar;
                }
                indexOfWord++;
                result.append(words[i]).append(" ");
            }
            result.append("\n");
        }

        int totalCount = fizzCount + buzzCount + fizzBuzzCount;

        return new Result(result.toString(), totalCount);
    }

    private record Result(String result, int count)
    {
        @Override
        public String toString() {
            return "output string:\n" + result + "\ncount: " + count;
        }
    }
}
