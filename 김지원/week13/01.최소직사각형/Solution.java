class Solution {
    public int solution(int[][] sizes) {
        int width = 0;
        int height = 0;
        
        for (int[] size : sizes) {
            if (size[0] < size[1]) {
                rotate(size);
            }
            
            width = Math.max(size[0], width);
            height = Math.max(size[1], height);
        }
        
        return width * height;
    }
    
    private void rotate(int[] size) {
        int temp = size[0];
        size[0] = size[1];
        size[1] = temp;
    }
}