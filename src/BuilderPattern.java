public class BuilderPattern {

    private final int sodium;
    private final int fat;
    private final int carbo;

    public int getSodium() {
        return sodium;
    }

    public int getFat() {
        return fat;
    }

    public int getCarbo() {
        return carbo;
    }

    static class Builder {
        private int sodium;
        private int fat;
        private int carbo;

        public Builder sodium(int s) {
            this.sodium = s;
            return this;
        }

        public Builder fat(int f) {
            this.fat = f;
            return this;
        }

        public Builder carbo(int c) {
            this.carbo = c;
            return this;
        }

        public BuilderPattern build() {
            return new BuilderPattern(this);
        }
    }

    private BuilderPattern(Builder b) {
        this.sodium = b.sodium;
        this.fat = b.fat;
        this.carbo = b.carbo;
    }


    public static void main(String[] args) {
        BuilderPattern nutritionalFacts = new Builder()
                .carbo(1)
                .build();

        System.out.println(nutritionalFacts.getCarbo() );
    }
}
