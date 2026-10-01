class Solution {

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        String[] phone = {
            "", "", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"
        };

        backtrack(digits, 0, new StringBuilder(), result, phone);

        return result;
    }

    private void backtrack(
        String digits,
        int index,
        StringBuilder current,
        List<String> result,
        String[] phone
    ) {

        // Base case
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get letters for current digit
        String letters = phone[digits.charAt(index) - '0'];

        // Try every possible letter
        for (char letter : letters.toCharArray()) {

            // CHOOSE
            current.append(letter);

            // EXPLORE
            backtrack(
                digits,
                index + 1,
                current,
                result,
                phone
            );

            // UNDO
            current.deleteCharAt(current.length() - 1);
        }
    }
}