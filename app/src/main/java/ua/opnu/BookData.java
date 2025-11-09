package ua.opnu;

public class BookData implements Comparable<BookData> {
    private String title;
    private String author;
    private int reviews;
    private double total;

    public BookData(String title, String author,
                    int reviews, double total) {
        this.title = title;
        this.author = author;
        this.reviews = reviews;
        this.total = total;
    }

    private double getRating() {
        return reviews > 0 ? total / reviews : 0.0;
    }

    @Override
    public int compareTo(BookData second) {
        double firstRating = this.getRating();
        double secondRating = second.getRating();

        int comparedRating = Double.compare(secondRating, firstRating);

        if (comparedRating != 0) {
            return comparedRating;
        } else {
            return this.title.compareTo(second.title);
        }
    }

    @Override
    public String toString() {
        return String.format("BookData{title='%s', author='%s', rating=%.2f}",
                title, author, getRating());
    }
}
