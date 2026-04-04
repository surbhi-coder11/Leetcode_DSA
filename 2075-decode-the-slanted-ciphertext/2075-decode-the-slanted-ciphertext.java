class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();
        int cols = n / rows;
        StringBuilder sb = new StringBuilder();
        
        // Each diagonal starts at the top row (row 0) at different columns
        for (int startCol = 0; startCol < cols; startCol++) {
            int r = 0;
            int c = startCol;
            
            // Move diagonally down-right: (r, c) -> (r+1, c+1)
            while (r < rows && c < cols) {
                int index = r * cols + c;
                sb.append(encodedText.charAt(index));
                r++;
                c++;
            }
        }
        
        // Remove trailing spaces as per problem requirements
        int i = sb.length() - 1;
        while (i >= 0 && sb.charAt(i) == ' ') {
            i--;
        }
        
        return sb.substring(0, i + 1);
    }
}