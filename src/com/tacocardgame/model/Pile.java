class Pile {
    // investigate Stack class (java.util)
    private Stack<Card> cards = new Stack<>();


    public void add(Card card) {
        cards.add(card); // goes "on top" which I means position 0
    }
}