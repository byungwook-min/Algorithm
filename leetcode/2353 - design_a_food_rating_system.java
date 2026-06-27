class FoodRatings {

    private static class Food {
        private final String name;
        private final String cuisine;
        private int rating;

        private Food(String name, String cuisine, int rating) {
            this.name = name;
            this.cuisine = cuisine;
            this.rating = rating;
        }
    }

    private static final Comparator<Food> FOOD_ORDER = Comparator.comparingInt((Food food) -> food.rating)
        .reversed()
        .thenComparing(food -> food.name);

    private final Map<String, Food> foodByName;
    private final Map<String, TreeSet<Food>> foodsByCuisine;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {

        this.foodByName = new HashMap<>();
        this.foodsByCuisine = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            Food food = new Food(
                    foods[i],
                    cuisines[i],
                    ratings[i]
            );

            foodByName.put(food.name, food);

            TreeSet<Food> cuisineFoods =
                    foodsByCuisine.computeIfAbsent(
                            food.cuisine,
                            cuisine -> new TreeSet<>(FOOD_ORDER)
                    );

            cuisineFoods.add(food);
        }
    }

    public void changeRating(String food, int newRating) {
        Food targetFood = foodByName.get(food);
        TreeSet<Food> cuisineFoods = foodsByCuisine.get(targetFood.cuisine);

        cuisineFoods.remove(targetFood);
        targetFood.rating = newRating;
        cuisineFoods.add(targetFood);
    }

    public String highestRated(String cuisine) {
        return foodsByCuisine.get(cuisine).first().name;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
