class Point {
    private int x,y;

    public Point () {
        System.out.println("Point created");
    }

    public Point (int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("Point created");
    }

    public void Set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int GetX() {
        return this.x;
    }

    public int GetY() {
        return this.y;
    }

}