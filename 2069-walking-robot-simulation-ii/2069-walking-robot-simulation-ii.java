class Robot {
    private int width, height;
    private int pos = 0;
    private int total;
    private boolean moved = false;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        // The total unique positions on the perimeter
        this.total = 2 * (width + height) - 4;
    }

    public void step(int num) {
        moved = true;
        // Using modulo ensures we stay on the perimeter
        pos = (pos + num) % total;
    }

    public int[] getPos() {
        if (pos < width) {
            return new int[]{pos, 0};
        } else if (pos < width + height - 1) {
            return new int[]{width - 1, pos - (width - 1)};
        } else if (pos < 2 * width + height - 2) {
            return new int[]{width - 1 - (pos - (width + height - 2)), height - 1};
        } else {
            return new int[]{0, height - 1 - (pos - (2 * width + height - 3))};
        }
    }

    public String getDir() {
        // Handle the specific "South" case for (0,0) after movement
        if (pos == 0 && moved) return "South";
        if (pos == 0) return "East";
        
        // Correct boundary ranges for directions
        if (pos < width) return "East";
        if (pos < width + height - 1) return "North";
        if (pos < 2 * width + height - 2) return "West";
        return "South";
    }
}