class Solution {
    public int solution(int[][] sizes) {
        int width = 0;
        int length = 0;
        
        for (int[] size : sizes) {
            if (size[0] < size[1]) {
                rotate(size);
            }
            
            width = Math.max(size[0], width);
            length = Math.max(size[1], length);
        }
        
        return width * length;
    }
    
    private void rotate(int[] size) {
        int temp = size[0];
        size[0] = size[1];
        size[1] = temp;
    }
}